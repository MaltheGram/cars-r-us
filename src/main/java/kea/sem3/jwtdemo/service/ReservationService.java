package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.ReservationRequest;
import kea.sem3.jwtdemo.dto.ReservationResponse;
import kea.sem3.jwtdemo.entity.Car;
import kea.sem3.jwtdemo.entity.Reservation;
import kea.sem3.jwtdemo.error.Client4xxException;
import kea.sem3.jwtdemo.repositories.CarRepository;
import kea.sem3.jwtdemo.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    ReservationRepository reservationRepository;
    CarRepository carRepository;


    public ReservationService(ReservationRepository reservationRepository, CarRepository carRepository){
        this.reservationRepository = reservationRepository;
        this.carRepository = carRepository;
    }

    public List<Reservation> getAllReservations(){

        return reservationRepository.findAll();
    }

    public ReservationResponse getReservation(Long id) throws Exception{
        return new ReservationResponse(reservationRepository.findById(id).orElseThrow(()-> new Client4xxException("No car reservation id: " + id)));
    }






}
