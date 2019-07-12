package com.kodilla.travelagency.service.complaint;

import com.kodilla.travelagency.core.complaint.Complaint;
import com.kodilla.travelagency.dao.complaint.ComplaintDAO;
import com.kodilla.travelagency.exceptions.ComplaintNotFoundException;
import com.kodilla.travelagency.service.trip.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService {
    @Autowired
    private ComplaintDAO dao;
    
    @Autowired
    private TripService tripService;

    public List<Complaint> getAllComplaints() {
        return dao.findAll();
    }

    public Complaint saveOrUpdateComplaint(Complaint complaint) {
        return dao.save(complaint);
    }

    public Complaint findComplaintById(Long ComplaintId) throws ComplaintNotFoundException {
        return dao.findById(ComplaintId).orElseThrow(ComplaintNotFoundException::new);
    }

    public void deleteComplaint(Long ComplaintId) throws ComplaintNotFoundException {
        dao.deleteComplaintById(ComplaintId).orElseThrow(ComplaintNotFoundException::new);
    }
}
