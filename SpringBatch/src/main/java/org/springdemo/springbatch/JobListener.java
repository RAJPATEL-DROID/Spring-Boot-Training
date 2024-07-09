package org.springdemo.springbatch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("Before Starting the Job ");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("After Job Ended : " + jobExecution.getJobInstance().getJobName());
    }
}

