package com.netcracker.fapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PriorityViewModel {

    private Long id;
    private String priority;

    public PriorityViewModel() {
    }

    public PriorityViewModel(Long id, String priority) {
        this.id = id;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "PriorityViewModel{" +
                "id=" + id +
                ", priority='" + priority + '\'' +
                '}';
    }
}
