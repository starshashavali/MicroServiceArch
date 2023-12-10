package com.org.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketReq {

	private Integer ticketId;

	private String passengerName;

	private String FromLoaction;

	private String destinationLoc;

	private Integer noOfPassenegers;

	private Double price;

	private Double totalPrice;

	private String ticketStatus;

}
