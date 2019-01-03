package com.renguangli.quartz.bean;

public class JobDetail {

    private String schedName;

    private String jobName;

    private String jobGroup;

    private String description;

    private String jobClassName;

    private String jobState;

    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJobClassName() {
        return jobClassName;
    }

    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName;
    }

    public String getJobState() {
        return jobState;
    }

    public void setJobState(String jobState) {
        this.jobState = jobState;
    }


    @Override
    public String toString() {
        return "JobDetail{" +
                "schedName='" + schedName + '\'' +
                ", jobName='" + jobName + '\'' +
                ", jobGroup='" + jobGroup + '\'' +
                ", description='" + description + '\'' +
                ", jobClassName='" + jobClassName + '\'' +
                ", jobState='" + jobState + '\'' +
                '}';
    }
}