package com.grofers.demo;

import com.grofers.domain.Candidate;
import com.grofers.domain.Interviewer;
import com.grofers.domain.Skill;
import com.grofers.domain.Slot;
import com.grofers.repository.CandidateRepository;
import com.grofers.repository.InterviewerRepository;
import com.grofers.repository.SkillRepository;
import com.grofers.repository.SlotRepository;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DemoDataGenerator {

    @Inject
    SkillRepository skillRepository;

    @Inject
    InterviewerRepository interviewerRepository;

    @Inject
    CandidateRepository candidateRepository;

    @Inject
    SlotRepository slotRepository;

    @Transactional
    public void generateData(@Observes StartupEvent startupEvent){
        List<Skill> skills = new ArrayList<>(10);

        skills.add(new Skill("Problem Solving"));
        skills.add(new Skill("API Design"));
        skills.add(new Skill("Managerial"));
        skills.add(new Skill("DDD Skill"));
        skillRepository.persist(skills);

        // Slots
        List<Slot> slots = new ArrayList<>(10);
        slots.add(new Slot());
        slots.add(new Slot());
        slots.add(new Slot());
        slots.add(new Slot());
        slots.add(new Slot());
        slots.add(new Slot());
        slots.add(new Slot());
        slots.add(new Slot());

        slotRepository.persist(slots);

        List<Slot> slots1 = new ArrayList<>();
        slots1.add(slots.get(0));
        slots1.add(slots.get(1));
        slots1.add(slots.get(2));

        List<Slot> slots2 = new ArrayList<>();
        slots2.add(slots.get(2));
        slots2.add(slots.get(3));
        slots2.add(slots.get(4));

        List<Slot> slots3 = new ArrayList<>();
        slots3.add(slots.get(1));
        slots3.add(slots.get(4));
        slots3.add(slots.get(5));
        // Sample Interviewers

        List<Interviewer> interviewers = new ArrayList<>(10);

        Interviewer adit = new Interviewer("Stewart Churchill");
        Interviewer aI = new Interviewer("Una Glover");
        Interviewer bI = new Interviewer("Julian Parr");
        List<Skill> aditSkills = new ArrayList<>();
        aditSkills.add(skills.get(0));
        adit.setSkillSet(aditSkills);
        adit.setPreferredSlots(slots1);
        aI.setPreferredSlots(slots1);
        bI.setPreferredSlots(slots2);

        List<Skill> aSkill = new ArrayList<>();
        aSkill.add(skills.get(1));
        aI.setSkillSet(aSkill);
        bI.setSkillSet(aditSkills);


        interviewers.add(adit);
        interviewers.add(aI);
        interviewers.add(bI);

        interviewerRepository.persist(interviewers);


        // Sample Candidates

        List<Candidate> candidates = new ArrayList<>();

        Candidate aCandidate = new Candidate("Kevin Brown", aditSkills);

        aCandidate.setPreferredSlots(slots1);

        Candidate bCandidate = new Candidate("Ryan Mathis", aSkill);
        bCandidate.setPreferredSlots(slots2);

        Candidate cCandidate = new Candidate("Peter Smith", aditSkills);
        cCandidate.setPreferredSlots(slots3);

        candidates.add(aCandidate);
        candidates.add(bCandidate);
        candidates.add(cCandidate);

        candidateRepository.persist(candidates);



    }


}
