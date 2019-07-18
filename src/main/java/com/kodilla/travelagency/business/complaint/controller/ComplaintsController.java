package com.kodilla.travelagency.business.complaint.controller;

import com.kodilla.travelagency.business.complaint.facede.ComplaintFacade;
import com.kodilla.travelagency.business.complaint.api.ComplaintDTO;
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
    private ComplaintFacade facade;

    @ApiOperation(value = "Get All Complaints")
    @GetMapping(value = "getAll")
    public List<ComplaintDTO> getComplaints() {
        return facade.getComplaints();
    }

    @ApiOperation(value = "Get Complaint By Id")
    @GetMapping(value = "get/{complaintId}")
    public ComplaintDTO getComplaint(@PathVariable Long complaintId) throws ComplaintNotFoundException {
        return facade.getComplaint(complaintId);
    }

    @ApiOperation(value = "Add Complaint to Base")
    @PostMapping(value = "add", consumes = APPLICATION_JSON_VALUE)
    public ComplaintDTO addComplaint(@RequestBody ComplaintDTO complaintDTO) {
        return facade.addComplaint(complaintDTO);
    }

    @ApiOperation(value = "Update Complaint Details")
    @PutMapping(value = "update", consumes = APPLICATION_JSON_VALUE)
    public ComplaintDTO updateComplaint(@RequestBody ComplaintDTO complaintDTO) {
        return facade.updateComplaint(complaintDTO);
    }

    @ApiOperation(value = "Delete Complaint")
    @DeleteMapping(value = "delete/{complaintId}")
    public void deleteHotel(@PathVariable Long complaintId) {
        facade.deleteComplaint(complaintId);
    }

    @ApiOperation(value = "Get All Complaints")
    @GetMapping(value = "getAll/trip/{tripId}")
    public ComplaintDTO getComplaintsByTrip(@PathVariable Long tripId) throws ComplaintNotFoundException, TripNotFoundException {
        return facade.getComplaintsByTrip(tripId);
    }
}
