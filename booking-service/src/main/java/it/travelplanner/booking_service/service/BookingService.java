package it.travelplanner.booking_service.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.travelplanner.booking_service.dto.BookingRequest;
import it.travelplanner.booking_service.dto.BookingResponse;
import it.travelplanner.booking_service.entity.Booking;
import it.travelplanner.booking_service.repository.BookingRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    public List<BookingResponse> getBookings(String customerEmail) {
        List<Booking> allCustomerBookings = bookingRepository.findAllByCustomerEmail(customerEmail);
        List<BookingResponse> responses = new ArrayList<>();

        for (Booking booking : allCustomerBookings) {
            responses.add(toResponse(booking));
        }

        return responses;
    }

    public BookingResponse createBooking(BookingRequest bookingDto) {
        Booking booking = new Booking();
        booking.setCustomerName(bookingDto.customerName());
        booking.setCustomerEmail(bookingDto.customerEmail());
        booking.setDestination(bookingDto.destination());
        booking.setCreatedAt(LocalDateTime.now());

        Booking savedBooking = bookingRepository.save(booking);
        return toResponse(savedBooking);
    }

    public BookingResponse updateBooking(Long id, BookingRequest bookingDto) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking not found with id: " + id));

        booking.setCustomerName(bookingDto.customerName());
        booking.setCustomerEmail(bookingDto.customerEmail());
        booking.setDestination(bookingDto.destination());

        Booking savedBooking = bookingRepository.save(booking);
        return toResponse(savedBooking);
    }

    public BookingResponse deleteBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking not found with id: " + id));

        BookingResponse response = toResponse(booking);
        bookingRepository.delete(booking);
        return response;
    }

    private BookingResponse toResponse(Booking booking) {
        return new BookingResponse(
                booking.getId(),
                booking.getCustomerName(),
                booking.getCustomerEmail(),
                booking.getDestination(),
                booking.getStatus().name()
        );
    }
}