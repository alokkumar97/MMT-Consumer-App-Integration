package com.MMT.MakeMyTrip.Service;

import com.MMT.MakeMyTrip.Request.MMTPassenger;
import com.MMT.MakeMyTrip.Response.MMTTicket;

public interface BookingService {

	
	public MMTTicket bookticket(MMTPassenger passenger);
	public MMTTicket getticket(Integer ticketNumber);
	
}
