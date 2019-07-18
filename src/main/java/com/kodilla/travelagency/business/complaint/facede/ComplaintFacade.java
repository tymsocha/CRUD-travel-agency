package com.kodilla.travelagency.business.complaint.facede;

import com.kodilla.travelagency.business.complaint.api.ComplaintDTO;
import com.kodilla.travelagency.business.complaint.mapper.ComplaintMapper;
import com.kodilla.travelagency.business.complaint.service.ComplaintService;
import com.kodilla.travelagency.exceptions.ComplaintNotFoundException;
import com.kodilla.travelagency.exceptions.TripNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ComplaintFacade {
    @Autowired
    private ComplaintService service;

    @Autowired
    private ComplaintMapper mapper;

    public List<ComplaintDTO> getComplaints() {
        return mapper.mapComplaintListToComplaintDTOList(service.getAllComplaints());
    }

    public ComplaintDTO getComplaint(Long complaintId) throws ComplaintNotFoundException {
        return mapper.mapComplaintToComplaintDTO(service.findComplaintById(complaintId));
    }

    public ComplaintDTO addComplaint(ComplaintDTO complaintDTO) {
        return mapper.mapComplaintToComplaintDTO(service.saveOrUpdateComplaint(mapper.mapComplaintDTOToComplaint(complaintDTO)));
    }

    public ComplaintDTO updateComplaint(ComplaintDTO complaintDTO) {
        return mapper.mapComplaintToComplaintDTO(service.saveOrUpdateComplaint(mapper.mapComplaintDTOToComplaint(complaintDTO)));
    }

    public void deleteHotel(Long complaintId) {
        service.deleteComplaint(complaintId);
    }

    public ComplaintDTO getComplaintsByTrip(Long tripId) throws ComplaintNotFoundException, TripNotFoundException {
        return mapper.mapComplaintToComplaintDTO(service.findComplaintByTrip(tripId));
    }
}
