package com.grofers.solver;

import com.grofers.domain.Candidate;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;

public class ScheduleConstraintProvider implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[]{
                noMissingSkill(constraintFactory)
        };
    }


    Constraint noMissingSkill(ConstraintFactory constraintFactory){
        return constraintFactory
                .from(Candidate.class)
                .filter(candidate -> candidate.getMissingSkillSet() > 0)
                .penalize("missing skills",
                        HardSoftScore.ONE_HARD);

    }
}
