package com.kodilla.travelagency.controller.complaint;

import com.kodilla.travelagency.api.complaint.ComplaintDTO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@Transactional
@RequestMapping("v1/travel/complaints")
public class ComplaintsController {
    @GetMapping(value = "getComplaints")
    public List<ComplaintDTO> getComplaints() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getComplaint/{complaintId}")
    public ComplaintDTO getComplaint(@PathVariable Long complaintId) {
        return new ComplaintDTO();
    }

    @PostMapping(value = "saveComplaint", consumes = APPLICATION_JSON_VALUE)
    public ComplaintDTO saveComplaint(@RequestBody ComplaintDTO complaintDTO) {
        return complaintDTO;
    }

    @PutMapping(value = "updateComplaint", consumes = APPLICATION_JSON_VALUE)
    public ComplaintDTO updateComplaint(@RequestBody ComplaintDTO complaintDTO) {
        return complaintDTO;
    }

    @DeleteMapping(value = "deleteComplaint/{complaintId}")
    public void deleteComplaint(@PathVariable Long complaintId) {

    }
}
