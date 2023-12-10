package com.org.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDto {

	private String passengerName;

	private String fromLoaction;

	private String destinationLoc;

	private Integer noOfPassenegers;

	private Double price;

}
