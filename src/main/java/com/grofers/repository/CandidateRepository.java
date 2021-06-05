package com.grofers.repository;

import com.grofers.domain.Candidate;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CandidateRepository implements PanacheRepository<Candidate> {
}
