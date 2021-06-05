package com.grofers.demo;

import com.grofers.domain.Candidate;
import com.grofers.domain.Interviewer;
import com.grofers.domain.Skill;
import com.grofers.repository.CandidateRepository;
import com.grofers.repository.InterviewerRepository;
import com.grofers.repository.SkillRepository;
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


    @Transactional
    public void generateData(@Observes StartupEvent startupEvent){
        List<Skill> skills = new ArrayList<>(10);

        skills.add(new Skill("AAA Skill"));
        skills.add(new Skill("BBB Skill"));
        skills.add(new Skill("CCC Skill"));
        skills.add(new Skill("DDD Skill"));
        skillRepository.persist(skills);

        // Sample Interviewers

        List<Interviewer> interviewers = new ArrayList<>(10);

        Interviewer adit = new Interviewer("AAA");
        Interviewer aI = new Interviewer("BBB");
        Interviewer bI = new Interviewer("CCC");
        List<Skill> aditSkills = new ArrayList<>();
        aditSkills.add(skills.get(0));
        adit.setSkillSet(aditSkills);

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

        candidates.add(new Candidate("a", aditSkills));
        candidates.add(new Candidate("b", aSkill));
        candidates.add(new Candidate("c", aditSkills));


        candidateRepository.persist(candidates);



    }


}
