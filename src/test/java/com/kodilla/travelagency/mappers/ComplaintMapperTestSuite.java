package com.kodilla.travelagency.mappers;

import com.kodilla.travelagency.business.complaint.api.ComplaintDTO;
import com.kodilla.travelagency.business.complaint.domain.Complaint;
import com.kodilla.travelagency.business.complaint.mapper.ComplaintMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ComplaintMapperTestSuite {
    @Autowired
    private ComplaintMapper mapper;

    @Test
    public void mapComplaintToDTO() {
        //Given
        Complaint complaint = new Complaint(1L, "Hotel", "Wrong room", true, null);
        //When
        ComplaintDTO complaintDTO = mapper.mapComplaintToComplaintDTO(complaint);
        //Then
        assertEquals("Hotel", complaintDTO.getComplaintTitle());
        assertEquals("Wrong room", complaintDTO.getComplaintContent());
    }

    @Test
    public void mapComplaintDTOToComplaint() {
        //Given
        ComplaintDTO complaintDTO = new ComplaintDTO(1L, "Hotel", "Wrong room", true, null);
        //When
        Complaint complaint = mapper.mapComplaintDTOToComplaint(complaintDTO);
        //Then
        assertEquals("Hotel", complaint.getComplaintTitle());
        assertEquals("Wrong room", complaint.getComplaintContent());
    }

    @Test
    public void mapComplaintListToDTOList() {
        //Given
        Complaint complaint = new Complaint(1L, "Hotel", "Wrong room", true, null);
        Complaint complaint1 = new Complaint(2L, "Car", "Wrong car", true, null);
        Complaint complaint2 = new Complaint(3L, "Flight", "Wrong seat", true, null);
        List<Complaint> complaints = new ArrayList<>();
        complaints.add(complaint);
        complaints.add(complaint1);
        complaints.add(complaint2);
        //When
        List<ComplaintDTO> complaintDTOS = mapper.mapComplaintListToComplaintDTOList(complaints);
        //Then
        assertEquals(3, complaintDTOS.size());
    }

    @Test
    public void mapComplaintDTOListToComplaintList() {
        //Given
        ComplaintDTO complaint = new ComplaintDTO(1L, "Hotel", "Wrong room", true, null);
        ComplaintDTO complaint1 = new ComplaintDTO(2L, "Car", "Wrong car", true, null);
        ComplaintDTO complaint2 = new ComplaintDTO(3L, "Flight", "Wrong seat", true, null);
        List<ComplaintDTO> complaintDTOS = new ArrayList<>();
        complaintDTOS.add(complaint);
        complaintDTOS.add(complaint1);
        complaintDTOS.add(complaint2);
        //When
        List<Complaint> complaints = mapper.mapComplaintDTOListToComplaintList(complaintDTOS);
        //Then
        assertEquals(3, complaints.size());
    }
}
