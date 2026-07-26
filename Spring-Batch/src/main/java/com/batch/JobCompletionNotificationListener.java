package com.batch;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.job.JobExecution;
import org.springframework.stereotype.Component;


@Component
public class JobCompletionNotificationListener {

    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            System.out.println("JOB FINISHED! Data inserted into DB.");
        }
    }
}