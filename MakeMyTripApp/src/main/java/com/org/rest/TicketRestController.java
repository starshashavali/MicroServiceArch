package com.org.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.dto.PassengerDto;
import com.org.feign.YatraFeignClient;

@RestController
@RequestMapping("/mmy/api")
public class TicketRestController {
	@Autowired
	private YatraFeignClient yatraFeignClient;
	
	
	@PostMapping("/save")
	public ResponseEntity<?> saveTicket(@RequestBody PassengerDto dto){
		return yatraFeignClient.bookTicket(dto);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getTicket(@PathVariable Integer id){
		return yatraFeignClient.getTicketDtls(id);
		
	}
	
	@GetMapping("/allTicket")
	public ResponseEntity<?> getAllTickets(){
		return yatraFeignClient.getAllTickets();
		
	}
	

}
