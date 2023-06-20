package com.MMT.MakeMyTrip.ServiceImpl;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.MMT.MakeMyTrip.Request.MMTPassenger;
import com.MMT.MakeMyTrip.Response.MMTTicket;
import com.MMT.MakeMyTrip.Service.BookingService;

@Service

public class BookingServiceImpl implements BookingService {

	org.slf4j.Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);
	
	public String BOOK_TICKET ="http://15.206.164.91:8080/book";
	public String GET_TICKET ="http://15.206.164.91:8080/getticket/{ticketNum}";
	
	@Override
	public MMTTicket bookticket(MMTPassenger passenger) {
		logger.info("Post Method started using WebClient");
		// By using WebClient with Web Reactive Starter Dependency
		WebClient webClient = WebClient.create();
		MMTTicket mmtTicket = webClient.post()
																	.uri(BOOK_TICKET)
																	.body(BodyInserters.fromValue(passenger))
																	.retrieve()
																	.bodyToMono(MMTTicket.class)
																	.block();
		logger.info("Save Passenger Object with '"+mmtTicket.getTicketNum()+"' Ticket Number.");
		return mmtTicket;	
		
		/*
		 * RestTemplate rt = new RestTemplate(); ResponseEntity<MMTTicket>
		 * responseEntity = rt.postForEntity(BOOK_TICKET, passenger, MMTTicket.class);
		 * MMTTicket ticket = responseEntity.getBody(); return ticket;
		 */
	}

	@Override
	public MMTTicket getticket(Integer ticketNumber) {
		// By using WebClient
		WebClient webClient = WebClient.create();
		logger.info("Get Method started using WebClient");
		MMTTicket mmtTicket = webClient.get()
																	.uri(GET_TICKET, ticketNumber)
																	.retrieve()
																	.bodyToMono(MMTTicket.class)
																	.block();
		logger.info("Return Passenger Object of '"+mmtTicket.getTicketNum()+"' Ticket Number.");
		return mmtTicket;	
		
		// By Rest Template
		/*
		 * RestTemplate rt = new RestTemplate(); ResponseEntity<MMTTicket>
		 * responseEntity = rt.getForEntity(GET_TICKET, MMTTicket.class, ticketNumber);
		 * MMTTicket ticket = responseEntity.getBody(); return ticket;
		 */
	}

}
