package com.grofers.api;

import com.grofers.domain.Interviewer;
import com.grofers.repository.InterviewerRepository;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;

import javax.ws.rs.Path;

@ResourceProperties(path = "interviewers")
public interface InterviewerResource extends PanacheRepositoryResource<InterviewerRepository, Interviewer, Long> {
}
