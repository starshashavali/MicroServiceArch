package com.org.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.org.dto.PassengerDto;
import com.org.dto.TicketReq;
import com.org.exception.IdnotFoundException;
import com.org.service.IYatraService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class YatraServiceImpl implements IYatraService {

	private Map<Integer, TicketReq> ticket = new HashMap<Integer, TicketReq>();

	private Integer ticketId = 1115001;

	@Override
	public TicketReq bookTicket(PassengerDto passengerReq) {
		log.info("Request to bookTicket::"+passengerReq);
		TicketReq ticketReq = new TicketReq();
		ticketReq.setTicketId(ticketId);
		ticketReq.setPassengerName(passengerReq.getPassengerName());
		ticketReq.setFromLoaction(passengerReq.getFromLoaction());
		ticketReq.setDestinationLoc(passengerReq.getDestinationLoc());
		ticketReq.setNoOfPassenegers(passengerReq.getNoOfPassenegers());
		ticketReq.setTicketStatus("Ticket Booked successfully...");
		ticketReq.setPrice(passengerReq.getPrice());
		ticketReq.setTotalPrice(passengerReq.getPrice() * passengerReq.getNoOfPassenegers());
		ticket.put(ticketId, ticketReq);
		ticketId++;

		return ticketReq;
	}

	@Override
	public TicketReq getTicket(Integer id) {
		log.info("Request to getTicket::"+id);

		if (!ticket.containsKey(id)) {
			log.error("Request to getTicket::"+id);

			throw new IdnotFoundException("IdNotFound::" + ticketId);

		}
		return ticket.get(id);
	}

	@Override
	public List<TicketReq> getAllTicketDto() {
		log.info("request to getallTickets::");
		return new ArrayList<>(ticket.values()) ;
	}

}
