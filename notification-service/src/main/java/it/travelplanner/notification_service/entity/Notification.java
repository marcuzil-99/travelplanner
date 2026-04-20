package it.travelplanner.notification_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 50)
	private String customerEmail;
	
	@Column(nullable = false, length = 50)
	private String subject;
	
	@Column(nullable = false, length = 50)
	private String content;
	
	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private EmailStatus status;
	
	

}
