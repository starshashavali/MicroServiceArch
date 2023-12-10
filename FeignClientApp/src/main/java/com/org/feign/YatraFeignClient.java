package com.org.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.org.dto.PassengerDto;

@FeignClient(name = "YATRAAPI")
public interface YatraFeignClient {

	@PostMapping("/ticket/api/save")
	public ResponseEntity<?> bookTicket(@RequestBody PassengerDto passeneger);

	@GetMapping("/ticket/api/{ticketId}")
	public ResponseEntity<?> getTicketDtls(@PathVariable Integer ticketId);

	@GetMapping("/ticket/api/allTickets")
	public ResponseEntity<?> getAllTickets();
}
