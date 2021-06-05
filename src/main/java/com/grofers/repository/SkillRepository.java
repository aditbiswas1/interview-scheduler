package com.grofers.repository;

import com.grofers.domain.Skill;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SkillRepository implements PanacheRepository<Skill> {
}
