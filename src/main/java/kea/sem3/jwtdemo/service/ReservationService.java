package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.ReservationRequest;
import kea.sem3.jwtdemo.dto.ReservationResponse;
import kea.sem3.jwtdemo.entity.Car;
import kea.sem3.jwtdemo.entity.Reservation;
import kea.sem3.jwtdemo.error.Client4xxException;
import kea.sem3.jwtdemo.repositories.CarRepository;
import kea.sem3.jwtdemo.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    ReservationRepository reservationRepository;
    CarRepository carRepository;

    public ReservationService(ReservationRepository reservationRepository, CarRepository carRepository){
        this.reservationRepository = reservationRepository;
        this.carRepository = carRepository;
    }

    public ReservationResponse makeReservation(ReservationRequest body, Car car){
        if (carRepository.existsById(car.getId())){
            throw new Client4xxException("Car with id: " + car.getId() + " already exists!");
        }
        Reservation newReservation = reservationRepository.save(new Reservation(body,car));
        return new ReservationResponse(newReservation);
    }




}
