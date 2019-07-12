package com.kodilla.travelagency.dao.complaint;

import com.kodilla.travelagency.core.complaint.Complaint;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ComplaintDAO extends CrudRepository<Complaint, Long> {
    @Override
    List<Complaint> findAll();

    @Override
    Complaint save(Complaint complaint);

    Optional<Complaint> findById(Long id);

    Optional<Complaint> deleteComplaintById(Long id);

    @Override
    void deleteAll();

    @Override
    long count();
}
