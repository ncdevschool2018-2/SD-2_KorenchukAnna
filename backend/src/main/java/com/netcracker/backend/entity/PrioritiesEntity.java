package com.netcracker.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "priorities", schema = "management", catalog = "")
public class PrioritiesEntity {
    private long id;
    private String priority;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "priority", nullable = false, length = 45)
    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrioritiesEntity that = (PrioritiesEntity) o;
        return id == that.id &&
                Objects.equals(priority, that.priority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, priority);
    }
}
