package com.spring.transaction;

import com.spring.transaction.dto.FlightBookingAcknowledgement;
import com.spring.transaction.dto.FlightBookingRequest;
import com.spring.transaction.sarvice.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class TransactionApplication {
	@Autowired
	private FlightBookingService  service;

	@PostMapping("/bookFlightTicket")
	public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request){
		return service.bookFlightTicket(request);
	}
	@GetMapping("/bookFlightTicket")
	public String bookFlightTicket(){
		return "TransactionApplication OK";
	}
	public static void main(String[] args) {
		SpringApplication.run(TransactionApplication.class, args);
	}

}
