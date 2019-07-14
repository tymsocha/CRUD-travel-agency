package com.kodilla.travelagency.business.complaint.controller;

import com.kodilla.travelagency.business.complaint.service.ComplaintService;
import com.kodilla.travelagency.business.complaint.api.ComplaintDTO;
import com.kodilla.travelagency.business.complaint.mapper.ComplaintMapper;
import com.kodilla.travelagency.exceptions.ComplaintNotFoundException;
import com.kodilla.travelagency.exceptions.TripNotFoundException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@Transactional
@RequestMapping("v1/travel/complaints")
public class ComplaintsController {
    @Autowired
    private ComplaintService service;

    @Autowired
    private ComplaintMapper mapper;

    @ApiOperation(value = "Get All Complaints")
    @GetMapping(value = "getAll")
    public List<ComplaintDTO> getComplaints() {
        return mapper.mapComplaintListToComplaintDTOList(service.getAllComplaints());
    }

    @ApiOperation(value = "Get Complaint By Id")
    @GetMapping(value = "get/{complaintId}")
    public ComplaintDTO getComplaint(@PathVariable Long complaintId) throws ComplaintNotFoundException {
        return mapper.mapComplaintToComplaintDTO(service.findComplaintById(complaintId));
    }

    @ApiOperation(value = "Add Complaint to Base")
    @PostMapping(value = "add", consumes = APPLICATION_JSON_VALUE)
    public ComplaintDTO addComplaint(@RequestBody ComplaintDTO complaintDTO) {
        return mapper.mapComplaintToComplaintDTO(service.saveOrUpdateComplaint(mapper.mapComplaintDTOToComplaint(complaintDTO)));
    }

    @ApiOperation(value = "Update Complaint Details")
    @PutMapping(value = "update", consumes = APPLICATION_JSON_VALUE)
    public ComplaintDTO updateComplaint(@RequestBody ComplaintDTO complaintDTO) {
        return mapper.mapComplaintToComplaintDTO(service.saveOrUpdateComplaint(mapper.mapComplaintDTOToComplaint(complaintDTO)));
    }

    @ApiOperation(value = "Delete Complaint")
    @DeleteMapping(value = "delete/{complaintId}")
    public void deleteHotel(@PathVariable Long complaintId) throws ComplaintNotFoundException {
        service.deleteComplaint(complaintId);
    }

    @ApiOperation(value = "Get All Complaints")
    @GetMapping(value = "getAll/trip/{tripId}")
    public ComplaintDTO getComplaintsByTrip(@PathVariable Long tripId) throws ComplaintNotFoundException, TripNotFoundException {
        return mapper.mapComplaintToComplaintDTO(service.findComplaintByTrip(tripId));
    }
}
