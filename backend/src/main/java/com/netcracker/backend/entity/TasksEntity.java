package com.netcracker.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "tasks", schema = "management", catalog = "")
public class TasksEntity {
    private long id;
    private String taskName;
    private String taskCode;
    private String description;
    private String projectCode;
    private Date dueDate;
    private Date updated;
    private Date created;
    private Integer estimation;
    private StatusEntity status;
    private PrioritiesEntity priority;
    private UsersEntity reporter;
    private UsersEntity assignee;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "task_code")
    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    @Basic
    @Column(name = "task_name")
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "project_code")
    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    @Basic
    @Column(name = "due_date")
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Basic
    @Column(name = "updated")
    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Basic
    @Column(name = "created")
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Basic
    @Column(name = "estimation")
    public Integer getEstimation() {
        return estimation;
    }

    public void setEstimation(Integer estimation) {
        this.estimation = estimation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TasksEntity that = (TasksEntity) o;
        return id == that.id &&
                Objects.equals(taskCode, that.taskCode) &&
                Objects.equals(taskName, that.taskName) &&
                Objects.equals(description, that.description) &&
                Objects.equals(projectCode, that.projectCode) &&
                Objects.equals(dueDate, that.dueDate) &&
                Objects.equals(updated, that.updated) &&
                Objects.equals(created, that.created) &&
                Objects.equals(estimation, that.estimation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskCode, taskName, description, projectCode, dueDate, updated, created, estimation);
    }

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "priority_id", referencedColumnName = "id", nullable = false)
    public PrioritiesEntity getPriority() {
        return priority;
    }

    public void setPriority(PrioritiesEntity priority) {
        this.priority = priority;
    }

    @ManyToOne
    @JoinColumn(name = "reporter_id", referencedColumnName = "id", nullable = false)
    public UsersEntity getReporter() {
        return reporter;
    }

    public void setReporter(UsersEntity reporter) {
        this.reporter = reporter;
    }

    @ManyToOne
    @JoinColumn(name = "assignee_id", referencedColumnName = "id", nullable = false)
    public UsersEntity getAssignee() {
        return assignee;
    }

    public void setAssignee(UsersEntity assignee) {
        this.assignee = assignee;
    }
}
