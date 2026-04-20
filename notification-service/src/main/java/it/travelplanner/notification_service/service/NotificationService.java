package it.travelplanner.notification_service.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import it.travelplanner.notification_service.dto.BookingDto;
import it.travelplanner.notification_service.dto.NotificationRequest;
import it.travelplanner.notification_service.entity.Notification;
import it.travelplanner.notification_service.entity.EmailStatus;
import it.travelplanner.notification_service.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationService {
	
	private final JavaMailSender mailSender;
	
	private final NotificationRepository nRepository;
	
	@RabbitListener(queues = "booking-notification")
	public void receiveMessage(NotificationRequest nRequest) {
		sendNotification(nRequest.booking(), nRequest.subject());
	}
	
	public String sendNotification(BookingDto booking, String subject) {
		String customer = booking.getCustomerEmail();
		String destination = booking.getDestination();
		String content="";
		SimpleMailMessage message = new SimpleMailMessage();
		switch(subject) {
		case "Booking created":
			content = "Dear customer, your booking to " + destination + " has been confirmed.";
			break;
		}
		message.setTo(customer);
		message.setSubject(subject);
		message.setText(content);
		mailSender.send(message);
		saveNotification(customer, subject, content);
		return "Email sent";
	}
	
	public void saveNotification(String email, String subject, String content) {
		Notification notification = new Notification();
		notification.setCustomerEmail(email);
		notification.setSubject(subject);
		notification.setContent(content);
		notification.setStatus(EmailStatus.SENT);
		nRepository.save(notification);
	}

}
