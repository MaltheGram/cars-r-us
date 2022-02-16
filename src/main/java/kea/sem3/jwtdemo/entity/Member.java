package kea.sem3.jwtdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kea.sem3.jwtdemo.dto.MemberRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "member")
@DiscriminatorValue("MEMBER")

public class Member extends BaseUser{
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "zip")
    private int zip;
    @Column(name = "ranking")
    private int ranking;
    @Column(name = "approved")
    private Boolean isApproved;

    @Column(name="created")
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @Column(name = "edited")
    @UpdateTimestamp
    private LocalDateTime dateEdited;

    @JsonIgnore
    @OneToMany(mappedBy = "reservedTo")
    @Getter(AccessLevel.NONE)
    private Set<Reservation> reservations = new HashSet<>();

    // Fix this method
    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }


    public Member(){}

    public Member(String username, String email, String password, String firstName, String lastName) {
        super(username, email, password);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Member(String username, String email, String password, String firstName, String lastName, String street, String city, int zip) {
        super(username, email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
        ranking = 5; // Initial ranking
        isApproved = false;
    }
    public Member(MemberRequest body) {
        //Just call the constructor above
        this(body.getUsername(),body.getEmail(),body.getPassword(),body.getFirstName(),body.getLastName(),body.getStreet(),body.getCity(),body.getZip());
    }
}
