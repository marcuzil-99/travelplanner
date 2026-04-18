package it.travelplanner.booking_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.travelplanner.booking_service.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
	
	public List<Booking> findAllByCustomerEmail(String email);
	
}
