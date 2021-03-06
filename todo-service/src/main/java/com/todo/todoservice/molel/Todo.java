package com.todo.todoservice.molel;

import jdk.jfr.Timestamp;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String type;
    @Temporal(TemporalType.TIMESTAMP)
    private Date time_Stamp;
    private String disription;

    public Todo(String name, String type, String disription) {
        this.name = name;
        this.type = type;
        this.time_Stamp = new Date();
        this.disription = disription;
    }

    public Todo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTime_Stamp() {
        return time_Stamp;
    }

    public void setTime_Stamp(Date time_Stamp) {
        this.time_Stamp = time_Stamp;
    }

    public String getDisription() {
        return disription;
    }

    public void setDisription(String disription) {
        this.disription = disription;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", time_Stamp=" + time_Stamp +
                ", disription='" + disription + '\'' +
                '}';
    }
}
