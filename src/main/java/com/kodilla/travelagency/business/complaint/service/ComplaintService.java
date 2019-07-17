package com.kodilla.travelagency.business.complaint.service;

import com.kodilla.travelagency.business.complaint.dao.ComplaintDAO;
import com.kodilla.travelagency.business.complaint.domain.Complaint;
import com.kodilla.travelagency.business.trip.domain.Trip;
import com.kodilla.travelagency.exceptions.ComplaintNotFoundException;
import com.kodilla.travelagency.exceptions.TripNotFoundException;
import com.kodilla.travelagency.business.trip.service.TripService;
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

    public void deleteComplaint(Long ComplaintId) {
        dao.delete(ComplaintId);
    }

    public Complaint findComplaintByTrip(Long tripId) throws TripNotFoundException, ComplaintNotFoundException {
        Trip trip = tripService.findTripById(tripId);
        return dao.findByTrip(trip).orElseThrow(ComplaintNotFoundException::new);
    }
}
