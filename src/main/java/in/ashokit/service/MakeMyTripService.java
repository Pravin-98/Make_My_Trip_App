package in.ashokit.service;

import in.ashokit.binding.Passanger;
import in.ashokit.binding.Ticket;

public interface MakeMyTripService {

	public Ticket bookTicket(Passanger passanger);
	
	public Ticket getTicket(Integer ticketNum);
}
