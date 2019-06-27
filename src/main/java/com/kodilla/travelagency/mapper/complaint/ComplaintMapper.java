package com.kodilla.travelagency.mapper.complaint;

import com.kodilla.travelagency.core.complaint.Complaint;
import com.kodilla.travelagency.dto.complaint.ComplaintDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ComplaintMapper {
    public Complaint mapComplaintDTOToComplaint(ComplaintDTO complaintDTO) {
        return Complaint.builder()
                .id(complaintDTO.getId())
                .complaintTitle(complaintDTO.getComplaintTitle())
                .complaintContent(complaintDTO.getComplaintContent())
                .isResolved(complaintDTO.getIsResolved())
                .trip(complaintDTO.getTrip())
                .build();
    }

    public ComplaintDTO mapComplaintDTOToComplaint(Complaint complaint) {
        return ComplaintDTO.builder()
                .id(complaint.getId())
                .complaintTitle(complaint.getComplaintTitle())
                .complaintContent(complaint.getComplaintContent())
                .isResolved(complaint.getIsResolved())
                .trip(complaint.getTrip())
                .build();
    }

    public List<Complaint> mapComplaintDTOListToComplaintList(List<ComplaintDTO> complaintDTOList) {
        return complaintDTOList.stream().map(complaintDTO -> Complaint.builder()
                    .id(complaintDTO.getId())
                    .complaintTitle(complaintDTO.getComplaintTitle())
                    .complaintContent(complaintDTO.getComplaintContent())
                    .isResolved(complaintDTO.getIsResolved())
                    .trip(complaintDTO.getTrip())
                    .build())
                .collect(Collectors.toList());
    }

    public List<ComplaintDTO> mapComplaintListToComplaintDTOList(List<Complaint> complaintList) {
        return complaintList.stream().map(complaint -> ComplaintDTO.builder()
                    .id(complaint.getId())
                    .complaintTitle(complaint.getComplaintTitle())
                    .complaintContent(complaint.getComplaintContent())
                    .isResolved(complaint.getIsResolved())
                    .trip(complaint.getTrip())
                    .build())
                .collect(Collectors.toList());
    }
}
