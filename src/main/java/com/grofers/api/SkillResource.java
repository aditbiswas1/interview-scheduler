package com.grofers.api;

import com.grofers.domain.Skill;
import com.grofers.repository.SkillRepository;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(path = "skills")
public interface SkillResource extends PanacheRepositoryResource<SkillRepository, Skill, Long> {
}
