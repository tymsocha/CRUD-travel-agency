package com.kodilla.travelagency.business.complaint.dao;

import com.kodilla.travelagency.business.complaint.domain.Complaint;
import com.kodilla.travelagency.business.trip.domain.Trip;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ComplaintDAO extends CrudRepository<Complaint, Long> {
    @Override
    List<Complaint> findAll();

    @Override
    Complaint save(Complaint complaint);

    Optional<Complaint> findById(Long id);

    @Override
    void delete(Long complaintId);

    @Override
    void deleteAll();

    @Override
    long count();

    Optional<Complaint> findByTrip(Trip trip);
}
