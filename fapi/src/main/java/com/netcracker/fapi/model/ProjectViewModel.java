package com.netcracker.fapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectViewModel {

      private long id;
      private String code;
      private String summary;
      private UserViewModel author;

    public ProjectViewModel() {
    }

    public ProjectViewModel(long id, String code, String summary, UserViewModel author) {
        this.id = id;
        this.code = code;
        this.summary = summary;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public UserViewModel getAuthor() {
        return author;
    }

    public void setAuthor(UserViewModel author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "ProjectViewModel{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", summary='" + summary + '\'' +
                ", author=" + author +
                '}';
    }
}
