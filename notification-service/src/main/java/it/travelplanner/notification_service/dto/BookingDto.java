package it.travelplanner.notification_service.dto;

import java.time.LocalDateTime;

import it.travelplanner.notification_service.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

	private Long id;
	
	private String customerName;
	
	private String customerEmail;
	
	private String destination;
	
	private Status status;
	
	private LocalDateTime createdAt;
}
