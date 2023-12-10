package com.org.service;

import com.org.dto.PassengerDto;
import com.org.dto.TicketReq;

import java.util.List;

public interface IYatraService {

	public TicketReq bookTicket(PassengerDto passengerReq);

	public TicketReq getTicket(Integer id);

	public List<TicketReq> getAllTicketDto();

}
