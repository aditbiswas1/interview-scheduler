package com.grofers.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.optaplanner.core.api.domain.lookup.PlanningId;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Interviewer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PlanningId
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Skill> skillSet;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Slot> preferredSlots;

    public Interviewer() {
    }

    public Interviewer(String name) {
        this.name = name;
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

    public List<Skill> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(List<Skill> skillSet) {
        this.skillSet = skillSet;
    }

    @Override
    public String toString() {
        return "Interviewer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", skillSet=" + skillSet +
                '}';
    }

    public List<Slot> getPreferredSlots() {
        return preferredSlots;
    }

    public void setPreferredSlots(List<Slot> preferredSlots) {
        this.preferredSlots = preferredSlots;
    }
}
