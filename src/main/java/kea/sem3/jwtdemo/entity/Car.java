package kea.sem3.jwtdemo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import kea.sem3.jwtdemo.dto.CarRequest;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "car")
public class Car {

    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "pricePrDay")
    private double pricePrDay;
    @Column(name = "bestDiscount")
    private double bestDiscount;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="created")
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @Column(name = "edited")
    @UpdateTimestamp
    private LocalDateTime dateEdited;

    @JsonIgnore
    // If problems related to "transactional", then use EAGER
    @OneToMany(mappedBy = "reservedCar", fetch = FetchType.EAGER)
    // Removes the Getter & Setter for this
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private Set<Reservation> reservations = new HashSet<>();

    public void addReservation(Reservation reservation){
        reservations.add(reservation);

    }

    public Car(String brand, String model, int pricePrDay, double bestDiscount) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
        this.bestDiscount = bestDiscount;
    }

    public Car(CarRequest body) {
        this.brand = body.getBrand();
        this.model = body.getModel();
        this.pricePrDay = body.getPricePrDay();
        this.bestDiscount = body.getBestDiscount();
    }


    @Override
    public String toString(){
        return "Car brand: " + brand + "\nCar model: " + model + "\nPrice pr. day: " + pricePrDay;
    }
}
