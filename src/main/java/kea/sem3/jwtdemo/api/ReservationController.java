package kea.sem3.jwtdemo.api;


import kea.sem3.jwtdemo.dto.ReservationRequest;
import kea.sem3.jwtdemo.dto.ReservationResponse;
import kea.sem3.jwtdemo.entity.Reservation;
import kea.sem3.jwtdemo.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getAllReservations(){

        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public ReservationResponse getReservation(
            @PathVariable Long id) throws Exception {

        return reservationService.getReservation(id);
    }




}


