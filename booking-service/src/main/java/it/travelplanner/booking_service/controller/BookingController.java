package it.travelplanner.booking_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import it.travelplanner.booking_service.dto.BookingRequest;
import it.travelplanner.booking_service.dto.BookingResponse;
import it.travelplanner.booking_service.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<BookingResponse> getAllBookings(@RequestParam String customerEmail) {
        return bookingService.getBookings(customerEmail);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookingResponse createBooking(@Valid @RequestBody BookingRequest bookingRequest) {
        return bookingService.createBooking(bookingRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BookingResponse updateBooking(@PathVariable Long id, @Valid @RequestBody BookingRequest bookingRequest) {
        return bookingService.updateBooking(id, bookingRequest);
    }

    @DeleteMapping("/{id}")
    public BookingResponse deleteBooking(@PathVariable Long id) {
        return bookingService.deleteBooking(id);
    }
}