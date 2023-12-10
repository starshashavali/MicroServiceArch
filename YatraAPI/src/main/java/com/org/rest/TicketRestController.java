package com.org.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.dto.PassengerDto;
import com.org.dto.TicketReq;
import com.org.service.IYatraService;

@RestController
@RequestMapping("/ticket/api")
public class TicketRestController {

	@Autowired
	private IYatraService yatraService;

	@PostMapping("/save")
	public ResponseEntity<?> bookTicket(@RequestBody PassengerDto passeneger) {
		TicketReq ticket = yatraService.bookTicket(passeneger);
		return ResponseEntity.status(HttpStatus.CREATED).body(ticket);
	}

	@GetMapping("/{ticketId}")
	public ResponseEntity<?> getTicketDtls(@PathVariable Integer ticketId) {
		TicketReq ticket = yatraService.getTicket(ticketId);
		return ResponseEntity.status(HttpStatus.OK).body(ticket);
	}

	@GetMapping("/allTickets")
	public ResponseEntity<?> getAllTickets() {
		List<TicketReq> ticketDtos = yatraService.getAllTicketDto();
		return ResponseEntity.status(HttpStatus.OK).body(ticketDtos);
	}
}
