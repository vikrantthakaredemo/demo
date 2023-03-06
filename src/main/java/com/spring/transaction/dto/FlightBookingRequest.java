package com.spring.transaction.dto;

import com.spring.transaction.entity.PasengerInfo;
import com.spring.transaction.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {
    private PasengerInfo pasengerInfo;
    private PaymentInfo paymentInfo;
}
