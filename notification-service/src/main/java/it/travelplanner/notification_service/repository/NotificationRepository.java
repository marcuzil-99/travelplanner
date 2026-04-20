package it.travelplanner.notification_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.travelplanner.notification_service.entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
