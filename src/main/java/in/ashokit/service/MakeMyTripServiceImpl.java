package in.ashokit.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.ashokit.binding.Passanger;
import in.ashokit.binding.Ticket;
import in.ashokit.constant.Constant;

@Service
public class MakeMyTripServiceImpl implements MakeMyTripService {

	@Override
	public Ticket bookTicket(Passanger passanger) {
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Ticket> responseEntity = restTemplate.postForEntity(Constant.BOOK_TICKET_URL, passanger, Ticket.class);
		Ticket ticket = responseEntity.getBody();
		
		return ticket;
	}

	@Override
	public Ticket getTicket(Integer ticketNum) {
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Ticket> responseEntity = restTemplate.getForEntity(Constant.GET_TICKET_URL, Ticket.class,ticketNum);
		Ticket ticket = responseEntity.getBody();
		
		return ticket;
	}

}
