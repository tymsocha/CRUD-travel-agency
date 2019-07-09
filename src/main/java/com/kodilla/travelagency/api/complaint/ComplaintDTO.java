package com.kodilla.travelagency.api.complaint;

import com.kodilla.travelagency.core.trip.Trip;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComplaintDTO {
    private Long id;

    private Trip trip;

    private String complaintTitle;

    private String complaintContent;

    private Boolean isResolved;
}
