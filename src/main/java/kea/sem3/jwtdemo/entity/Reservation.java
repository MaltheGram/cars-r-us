package kea.sem3.jwtdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Reservation {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;

    @Column (name = "reservationDate")
    @CreationTimestamp
    private LocalDateTime reservationDate;

    @Column (name = "rentalDate")
    private LocalDate rentalDate;

    @JsonIgnore
    @ManyToOne
    private Car reservedCar;

    @JsonIgnore
    @ManyToOne
    private Member reservedTo;

    public Reservation(LocalDate rentalDate, Car reservedCar, Member member){
        this.rentalDate = rentalDate;
        this.reservedCar = reservedCar;
        this.reservedTo = member;
        reservedCar.addReservation(this);
        reservedTo.addReservation(this);

    }
}
