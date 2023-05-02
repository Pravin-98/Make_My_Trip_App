package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ashokit.binding.Passanger;
import in.ashokit.binding.Ticket;
import in.ashokit.service.MakeMyTripService;

@Controller
public class MakeMyTripController {

	@Autowired
	private MakeMyTripService mmtService;
	
	@GetMapping("/")
	public String laod(Model model) {
		
		model.addAttribute("passanger", new Passanger());
		
		return "bookTicket";
	}
	
	@PostMapping("/book-ticket")
	public String bookTicket(@ModelAttribute("passanger") Passanger passanger, Model model) {
		System.out.println(passanger);
		Ticket ticket = mmtService.bookTicket(passanger);
		model.addAttribute("msg1", "Ticket Booked Successfully");
		model.addAttribute("msg2", "Ticket Number :"+ ticket.getTicketNum());
		return "bookTicket";
	}
	
	
	@GetMapping("/ticket")
	public String load(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "view-ticket";
	}
	
	@GetMapping("/get-ticket")
	public String  getTicket(@RequestParam("ticketNumber") Integer ticketNumber,Model model) {
		System.out.println(ticketNumber);
		Ticket ticket = mmtService.getTicket(ticketNumber);
		model.addAttribute("ticket", ticket);
		return "view-ticket";
	}
}
