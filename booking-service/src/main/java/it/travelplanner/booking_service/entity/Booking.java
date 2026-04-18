package it.travelplanner.booking_service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bookings")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String customerName;
	
	@Column(nullable = false, length = 100, unique = true)
	private String customerEmail;
	
	@Column(nullable = false, length = 100)
	private String destination;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Status status = Status.CREATED;
	
	@Column(nullable = false)
	private LocalDateTime createdAt;
	
}
