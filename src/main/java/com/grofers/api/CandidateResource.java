package com.grofers.api;

import com.grofers.domain.Candidate;
import com.grofers.repository.CandidateRepository;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(path = "candidates")
public interface CandidateResource extends PanacheRepositoryResource<CandidateRepository, Candidate, Long> {
}
