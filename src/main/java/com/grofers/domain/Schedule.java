package com.grofers.domain;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.SolverStatus;

import java.util.List;

@PlanningSolution
public class Schedule {

    @ProblemFactCollectionProperty
    @ValueRangeProvider(id="interviewerRange")
    private List<Interviewer> interviewers;

    @ProblemFactCollectionProperty
    @ValueRangeProvider(id="slotsRange")
    private List<Slot> slots;

    @PlanningEntityCollectionProperty
    private List<Candidate> candidates;



    @PlanningScore
    private HardSoftScore score;

    private SolverStatus solverStatus;

    public Schedule() {
    }

    public Schedule(List<Interviewer> interviewers, List<Slot> slots, List<Candidate> candidates) {
        this.interviewers = interviewers;
        this.slots = slots;
        this.candidates = candidates;
    }

    public List<Interviewer> getInterviewers() {
        return interviewers;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public HardSoftScore getScore() {
        return score;
    }

    public SolverStatus getSolverStatus() {
        return solverStatus;
    }

    public void setSolverStatus(SolverStatus solverStatus) {
        this.solverStatus = solverStatus;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "interviewers=" + interviewers +
                ", candidates=" + candidates +
                ", score=" + score +
                '}';
    }
}
