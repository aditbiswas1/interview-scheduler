package com.grofers.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
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
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Skill> skillList;

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

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", skillList=" + skillList +
                ", interviewer=" + interviewer +
                '}';
    }
}
