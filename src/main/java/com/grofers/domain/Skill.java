package com.grofers.domain;

import org.optaplanner.core.api.domain.lookup.PlanningId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Skill {

    @PlanningId
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    public Skill() {
    }

    public Skill(String name) {
        this.name = name;
    }

    public Skill(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                '}';
    }
}
