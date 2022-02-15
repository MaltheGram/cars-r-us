package kea.sem3.jwtdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kea.sem3.jwtdemo.dto.ReservationRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;

    @Column (name = "reservationDate")
    @CreationTimestamp
    private LocalDateTime reservationDate;

    @Column (name = "rentalDate")
    @CreationTimestamp
    private LocalDateTime rentalDate;

    @JsonIgnore
    @ManyToOne
    private Car car;

    @JsonIgnore
    @ManyToOne
    private Member member;


    public Reservation(Car car,Long id, LocalDateTime reservationDate, LocalDateTime rentalDate) {
        this.car = car;
        this.id = id;
        this.reservationDate = reservationDate;
        this.rentalDate = rentalDate;
    }

    public Reservation(ReservationRequest body, Car car) {
        this.reservationDate = body.getReservationDate();
        this.rentalDate = body.getRentalDate();
        this.car = car;
    }
}
