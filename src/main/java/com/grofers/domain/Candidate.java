package com.grofers.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import javax.persistence.*;
import java.util.List;

@PlanningEntity
@Entity
public class Candidate {

    @PlanningId
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Skill> skillList;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Slot> preferredSlots;

    @PlanningVariable(valueRangeProviderRefs = "slotsRange")
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.JOIN)
    private Slot finalSlot;

    @PlanningVariable(valueRangeProviderRefs = "interviewerRange")
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.JOIN)
    private Interviewer interviewer;


    public Candidate() {
    }

    public Candidate(String name, List<Skill> skillList) {
        this.name = name;
        this.skillList = skillList;
    }

    public Candidate(Long id, String name, List<Skill> skillList, Interviewer interviewer) {
        this.id = id;
        this.name = name;
        this.skillList = skillList;
        this.interviewer = interviewer;
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

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public Interviewer getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(Interviewer interviewer) {
        this.interviewer = interviewer;
    }

    public int getMissingSkillSet(){
        if (interviewer == null){
            return skillList.size();
        }
        int count = 0;
        for(Skill skill: skillList){
            if (!interviewer.getSkillSet().contains(skill)){
                count += 1;
            }
        }
        return count;
    }

    public int getAgreeAbleSlot(){
        if (finalSlot == null || interviewer == null){
            return 1;
        }

        if (preferredSlots.contains(finalSlot) && interviewer.getPreferredSlots().contains(finalSlot)){
            return 0;
        }
        return 1;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", skillList=" + skillList +
                ", interviewer=" + interviewer +
                '}';
    }

    public List<Slot> getPreferredSlots() {
        return preferredSlots;
    }

    public void setPreferredSlots(List<Slot> preferredSlots) {
        this.preferredSlots = preferredSlots;
    }

    public Slot getFinalSlot() {
        return finalSlot;
    }

    public void setFinalSlot(Slot finalSlot) {
        this.finalSlot = finalSlot;
    }
}
