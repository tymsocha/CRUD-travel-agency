package com.kodilla.travelagency.core.complaint;

import com.kodilla.travelagency.core.trip.Trip;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity(name = "complaints")
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @Column(name = "title")
    private String complaintTitle;

    @Column(name = "content")
    private String complaintContent;

    @Column(name = "is_resolved")
    private Boolean isResolved;
}
