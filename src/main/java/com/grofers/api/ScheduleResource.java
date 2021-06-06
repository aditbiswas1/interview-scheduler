package com.grofers.api;

import com.grofers.domain.Candidate;
import com.grofers.domain.Interviewer;
import com.grofers.domain.Schedule;
import com.grofers.repository.CandidateRepository;
import com.grofers.repository.InterviewerRepository;
import com.grofers.repository.SlotRepository;
import org.optaplanner.core.api.score.ScoreManager;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.SolverManager;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("schedule")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ScheduleResource {

    public static final Long SINGLETON_SCHEDULE_ID = 1L;

    @Inject
    CandidateRepository candidateRepository;

    @Inject
    InterviewerRepository interviewerRepository;

    @Inject
    SlotRepository slotRepository;

    @Inject
    SolverManager <Schedule, Long> solverManager;

    @Inject
    ScoreManager <Schedule, HardSoftScore> scoreManager;



    @GET
    public Schedule getSchedule(){
        Schedule solution = findById(SINGLETON_SCHEDULE_ID);
        scoreManager.updateScore(solution);
        System.out.println(scoreManager.explainScore(solution));
        return solution;
    }


    @POST
    public void solve(){
        solverManager.solveAndListen(SINGLETON_SCHEDULE_ID, this::findById, this::save);
    }

    @Transactional
    protected Schedule findById(Long id){
        return new Schedule(
                interviewerRepository.listAll(),
                slotRepository.listAll(),
                candidateRepository.listAll()
        );
    }

    @Transactional
    protected void save(Schedule schedule){
        System.out.println(schedule.toString());
        for (Candidate candidate : schedule.getCandidates()){
            Interviewer x = candidate.getInterviewer();
            Candidate attachedCandidate = candidateRepository.findById(candidate.getId());
            attachedCandidate.setFinalSlot(candidate.getFinalSlot());
            attachedCandidate.setInterviewer(candidate.getInterviewer());
        }
    }
}
