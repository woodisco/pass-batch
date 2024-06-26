package com.fastcampus.pass.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Properties;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.explore.JobExplorer;

@Getter
@Setter
@ToString
public class JobLauncherRequest {
    private String name;
    private Properties jobParameters;

    public JobParameters getJobParameters() {
        return new JobParametersBuilder((JobExplorer) this.jobParameters).toJobParameters();
    }
}
