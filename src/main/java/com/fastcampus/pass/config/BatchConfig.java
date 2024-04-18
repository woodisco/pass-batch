package com.fastcampus.pass.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

@EnableBatchProcessing
@Configuration
public class BatchConfig {
    @Bean
    public Job passJob(JobRepository jobRepository, Step passStep) {
        return new JobBuilder("passJob", jobRepository)
                .start(passStep)
                .build();
    }

    @Bean
    public Step passStep(final JobRepository jobRepository,
                         final Tasklet passTasklet,
                         final PlatformTransactionManager platformTransactionManager) {
        return new StepBuilder("passStep", jobRepository)
                .tasklet(passTasklet, platformTransactionManager)
                .build();
    }

    @Bean
    public Tasklet passTasklet() {
        return ((contribution, chunkContext) -> {
            System.out.println("======Execute PassStep======");  // 성공이면 출력
            return RepeatStatus.FINISHED;
        });
    }
}