package com.grofers.repository;

import com.grofers.domain.Slot;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SlotRepository implements PanacheRepository<Slot> {
}
