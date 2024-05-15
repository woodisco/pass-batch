package com.fastcampus.pass.job.pass;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class AddPassesJopConfig {

    private final AddPassesTasklet addPassesTasklet;

    public AddPassesJopConfig(AddPassesTasklet addPassesTasklet) {
        this.addPassesTasklet = addPassesTasklet;
    }

    @Bean
    public Job addPassesJob(JobRepository jobRepository, Step addPassesStep) {
        return new JobBuilder("addPassesJob", jobRepository)
                .start(addPassesStep)
                .build();
    }

    @Bean
    @Primary
    public Step addPassesStep(JobRepository jobRepository,
                              PlatformTransactionManager transactionManager,
                              @Qualifier("addPassesTasklet") Tasklet tasklet) {
        return new StepBuilder("addPassesStep", jobRepository)
                .tasklet(tasklet, transactionManager)
                .build();
    }
}