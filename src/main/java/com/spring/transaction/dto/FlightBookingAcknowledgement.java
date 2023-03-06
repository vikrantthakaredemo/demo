package com.spring.transaction.dto;

import com.spring.transaction.entity.PasengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingAcknowledgement {
    private  String status;
    private double totalFare;
    private String pnrNo;
    private PasengerInfo pasengerInfo;
}
