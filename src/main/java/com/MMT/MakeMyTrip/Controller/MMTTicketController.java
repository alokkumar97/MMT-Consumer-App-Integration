package com.MMT.MakeMyTrip.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MMT.MakeMyTrip.Request.MMTPassenger;
import com.MMT.MakeMyTrip.Response.MMTTicket;
import com.MMT.MakeMyTrip.Service.BookingService;

@RestController
public class MMTTicketController {

	@Autowired
	private BookingService service;
	
	@PostMapping("/book")
	public ResponseEntity<MMTTicket> bookTicket(@RequestBody MMTPassenger passenger){
		MMTTicket bookticket = service.bookticket(passenger);
		return new ResponseEntity<MMTTicket>(bookticket, HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{ticketNumber}")
	public ResponseEntity<MMTTicket> getTicket(@PathVariable Integer ticketNumber){
		MMTTicket getticket = service.getticket(ticketNumber);
		return new ResponseEntity<MMTTicket>(getticket, HttpStatus.OK);
	}
	
	
}
