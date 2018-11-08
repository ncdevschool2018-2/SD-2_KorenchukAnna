package com.netcracker.fapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskViewModel {

    private long id;
    private String taskname;
    private String description;
    private String taskCode;
    private String projectCode;
    private String created;
    private String updated;
    private String dueDate;
    private double estimation;
    private PriorityViewModel priority;
    private StatusViewModel status;
    private UserViewModel reporter;
    private UserViewModel assignee;

    public TaskViewModel() {
    }

    public TaskViewModel(long id, String taskname, String description, String taskCode, String projectCode, String created, String updated, String dueDate, double estimation, PriorityViewModel priority, StatusViewModel status, UserViewModel reporter, UserViewModel assignee) {
        this.id = id;
        this.taskname = taskname;
        this.description = description;
        this.taskCode = taskCode;
        this.projectCode = projectCode;
        this.created = created;
        this.updated = updated;
        this.dueDate = dueDate;
        this.estimation = estimation;
        this.priority = priority;
        this.status = status;
        this.reporter = reporter;
        this.assignee = assignee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
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
                ", taskname='" + taskname + '\'' +
                ", description='" + description + '\'' +
                ", taskCode='" + taskCode + '\'' +
                ", projectCode='" + projectCode + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", dueDate=" + dueDate +
                ", estimation=" + estimation +
                ", priority=" + priority +
                ", status=" + status +
                ", reporter=" + reporter +
                ", assignee=" + assignee +
                '}';
    }
}
