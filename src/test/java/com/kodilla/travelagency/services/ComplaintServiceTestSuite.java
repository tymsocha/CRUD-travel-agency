package com.kodilla.travelagency.services;

import com.kodilla.travelagency.business.complaint.dao.ComplaintDAO;
import com.kodilla.travelagency.business.complaint.domain.Complaint;
import com.kodilla.travelagency.business.complaint.service.ComplaintService;
import com.kodilla.travelagency.exceptions.ComplaintNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ComplaintServiceTestSuite {
    @Autowired
    private ComplaintService service;

    @Autowired
    private ComplaintDAO dao;

    @Test
    public void shouldGetAllComplaints() {
        //Given
        Complaint complaint = Complaint.builder().complaintTitle("Hotel").build();
        Complaint complaint1 = Complaint.builder().complaintTitle("Air").build();
        Complaint complaint2 = Complaint.builder().complaintTitle("Car").build();
        dao.save(complaint);
        dao.save(complaint1);
        dao.save(complaint2);
        //When
        List<Complaint> complaints = service.getAllComplaints();
        //Then
        assertEquals(3, complaints.size());
        //CleanUp
        dao.delete(complaint);
        dao.delete(complaint1);
        dao.delete(complaint2);
    }

    @Test
    public void shouldFindComplaintById() {
        //Given
        Complaint complaint = Complaint.builder().complaintTitle("Hotel").isResolved(true).build();
        Complaint savedComplaint = dao.save(complaint);
        //When and then
        try {
            Complaint foundComplaint = service.findComplaintById(savedComplaint.getId());
            assertTrue(foundComplaint.getIsResolved());
            assertEquals("Hotel", foundComplaint.getComplaintTitle());
        } catch (ComplaintNotFoundException e) {
            e.printStackTrace();
        }
        //Clean Up
        dao.delete(savedComplaint);
    }

    @Test
    public void shouldDeleteComplaint() {
        //Given
        Complaint complaint = Complaint.builder().complaintTitle("Hotel").isResolved(true).build();
        Complaint savedComplaint = dao.save(complaint);
        //When
        service.deleteComplaint(savedComplaint.getId());
        List<Complaint> complaints = service.getAllComplaints();
        //Then
        assertEquals(0, complaints.size());
    }
}
