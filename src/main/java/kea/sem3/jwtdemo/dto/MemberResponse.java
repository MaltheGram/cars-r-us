package kea.sem3.jwtdemo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import kea.sem3.jwtdemo.entity.Member;
import kea.sem3.jwtdemo.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberResponse {
    String username;
    String email;
    String firstName;
    String lastName;
    String street;
    String city;
    int zip;
    List<String> roleNames;

    //Only meant for admins
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    LocalDateTime created;
    @UpdateTimestamp
    LocalDateTime edited;
    Boolean isApproved; //Make sure you understand why we use Boolean and not boolean
    //Number between 0 and 10, ranking the customer
    int ranking; //Make sure you understand why we use Byte and not byte

    //Meant to be used as response when new users are created
    public MemberResponse(String username, LocalDateTime created, List<Role> roleList){
        this.created = created;
        this.roleNames = roleList.stream().map(role->role.toString()).collect(Collectors.toList());
        this.username = username;
    }

    //All Details
    public MemberResponse(Member member, boolean isAdmin){
        this.username = member.getUsername();
        this.email = member.getEmail();
        this.firstName = member.getFirstName();
        this.lastName = member.getLastName();
        this.street = member.getStreet();
        this.city = member.getCity();
        this.zip = member.getZip();
        if(isAdmin){
            this.created = member.getDateCreated();
            this.edited = member.getDateEdited();
            this.isApproved = member.getIsApproved();
            this.ranking = member.getRanking();
        }
    }




}