package com.spring.transaction.sarvice;

import com.spring.transaction.dto.FlightBookingAcknowledgement;
import com.spring.transaction.dto.FlightBookingRequest;
import com.spring.transaction.entity.PasengerInfo;
import com.spring.transaction.entity.PaymentInfo;
import com.spring.transaction.repository.PassengerInfoRepository;
import com.spring.transaction.repository.PaymentInfoRepository;
import com.spring.transaction.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class FlightBookingService {
    @Autowired
    private PassengerInfoRepository passengerInfoRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;
    @Transactional//(readOnly = false,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest flightBookingRequest){
        FlightBookingAcknowledgement acknowledgement=null;
        PasengerInfo pasengerInfo=flightBookingRequest.getPasengerInfo();
        pasengerInfo=passengerInfoRepository.save(pasengerInfo);

        PaymentInfo paymentInfo=flightBookingRequest.getPaymentInfo();

        PaymentUtils.checkCreditLimit(paymentInfo.getAccountNo(),pasengerInfo.getFare());
        paymentInfo.setPassengerId(pasengerInfo.getPId());
        paymentInfo.setAccount(pasengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);
        return new FlightBookingAcknowledgement("SUCCESS",pasengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0],pasengerInfo);
    }
}
