package com.MMT.MakeMyTrip.Response;

import lombok.Data;

@Data
public class MMTTicket {

	
	private Integer ticketNum;
	private Double cost;
	private String status;	
	private String name;
	private String from;
	private String to;
	private String doj;
	private Integer trainNum;
}
