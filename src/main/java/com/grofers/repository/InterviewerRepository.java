package com.grofers.repository;

import com.grofers.domain.Interviewer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InterviewerRepository implements PanacheRepository<Interviewer> {
}
