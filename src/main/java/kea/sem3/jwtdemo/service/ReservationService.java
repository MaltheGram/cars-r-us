package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.ReservationRequest;
import kea.sem3.jwtdemo.dto.ReservationResponse;
import kea.sem3.jwtdemo.entity.Car;
import kea.sem3.jwtdemo.entity.Reservation;
import kea.sem3.jwtdemo.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    public ReservationResponse makeReservation(ReservationRequest body, Car car){
        Reservation newReservation = reservationRepository.save(new Reservation(body,car));
        return new ReservationResponse(newReservation);
    }




}
