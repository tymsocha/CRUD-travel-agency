package com.kodilla.travelagency.business.complaint.api;

import com.kodilla.travelagency.business.trip.domain.Trip;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComplaintDTO {
    private Long id;

    private String complaintTitle;

    private String complaintContent;

    private Boolean isResolved;

    private Trip trip;
}
