package com.netcracker.fapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskViewModel {

    private long id;
    private String taskName;
    private String taskCode;
    private String description;
    private String projectCode;
    private String dueDate;
    private String updated;
    private String created;
    private double estimation;
    private StatusViewModel status;
    private PriorityViewModel priority;
    private UserViewModel reporter;
    private UserViewModel assignee;

    public TaskViewModel() {
    }

    public TaskViewModel(long id, String taskName, String taskCode, String description, String projectCode, String dueDate, String updated, String created, double estimation, StatusViewModel status, PriorityViewModel priority, UserViewModel reporter, UserViewModel assignee) {
        this.id = id;
        this.taskName = taskName;
        this.taskCode = taskCode;
        this.description = description;
        this.projectCode = projectCode;
        this.dueDate = dueDate;
        this.updated = updated;
        this.created = created;
        this.estimation = estimation;
        this.status = status;
        this.priority = priority;
        this.reporter = reporter;
        this.assignee = assignee;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String  getCreated() {
        return created;
    }

    public void setCreated(String  created) {
        this.created = created;
    }

    public String  getUpdated() {
        return updated;
    }

    public void setUpdated(String  updated) {
        this.updated = updated;
    }

    public String  getDueDate() {
        return dueDate;
    }

    public void setDueDate(String  dueDate) {
        this.dueDate = dueDate;
    }

    public double getEstimation() {
        return estimation;
    }

    public void setEstimation(double estimation) {
        this.estimation = estimation;
    }

    public PriorityViewModel getPriority() {
        return priority;
    }

    public void setPriority(PriorityViewModel priority) {
        this.priority = priority;
    }

    public StatusViewModel getStatus() {
        return status;
    }

    public void setStatus(StatusViewModel status) {
        this.status = status;
    }

    public UserViewModel getReporter() {
        return reporter;
    }

    public void setReporter(UserViewModel reporter) {
        this.reporter = reporter;
    }

    public UserViewModel getAssignee() {
        return assignee;
    }

    public void setAssignee(UserViewModel assignee) {
        this.assignee = assignee;
    }


    @Override
    public String toString() {
        return "TaskViewModel{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskCode='" + taskCode + '\'' +
                ", description='" + description + '\'' +
                ", projectCode='" + projectCode + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", updated='" + updated + '\'' +
                ", created='" + created + '\'' +
                ", estimation=" + estimation +
                ", status=" + status +
                ", priority=" + priority +
                ", reporter=" + reporter +
                ", assignee=" + assignee +
                '}';
    }
}
