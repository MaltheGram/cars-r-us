package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.CarRequest;
import kea.sem3.jwtdemo.dto.MemberRequest;
import kea.sem3.jwtdemo.dto.MemberResponse;
import kea.sem3.jwtdemo.entity.Member;
import kea.sem3.jwtdemo.entity.Role;
import kea.sem3.jwtdemo.error.Client4xxException;
import kea.sem3.jwtdemo.repositories.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberResponse> getMembers() {
        List<Member> members = memberRepository.findAll();
        return members.stream().map(member -> new MemberResponse(member,false)).collect(Collectors.toList());
    }

    public MemberResponse getMemberByUserName(String username) {
        Member member = memberRepository.findById(username).orElseThrow(() -> new Client4xxException("User not found", HttpStatus.NOT_FOUND));
        return new MemberResponse(member,false);
    }

    public MemberResponse addMember(MemberRequest body) {

        while (body.getUsername().equals(" ")){
            if (memberRepository.existsById((body.getUsername()))) {
                throw new Client4xxException(body.getUsername() +  " is taken. Please try again");
            }
        }
        /*if (memberRepository.emailExist(body.getEmail())) {
            throw new Client4xxException("Provided email is taken");
        }
         */
        Member member = new Member(body);
        member.addRole(Role.USER);
        member = memberRepository.save(member);
        return new MemberResponse(member.getUsername(), member.getDateCreated(), member.getRoles());
    }

    public MemberResponse editMember(MemberRequest body, String userName, boolean isAdmin){
        Member memberToEdit = memberRepository.findById(userName).orElseThrow(() -> new Client4xxException("No member with name: " + userName));
        memberToEdit.setUsername(body.getUsername());
        memberToEdit.setEmail(body.getEmail());
        memberToEdit.setFirstName(body.getFirstName());
        memberToEdit.setLastName(body.getLastName());
        memberToEdit.setStreet(body.getStreet());
        memberToEdit.setCity(body.getCity());
        memberToEdit.setZip(body.getZip());
        // The ranking doesn't change atm. Wonder why? Must debug.
        memberToEdit.setRanking(body.getRanking());
        memberToEdit.setDateEdited(LocalDateTime.now());
        memberToEdit.setPassword(body.getPassword());

        return new MemberResponse(memberToEdit,false);
    }
    // Service for PATCH method updating first & last name
    // userName is our id
    public void updateNames(String userName, String firstName, String lastName){
        Member member = memberRepository.findById(userName).orElseThrow(() -> new Client4xxException("User name: " + userName + " doesn't exist in the database" ));
        member.setFirstName(firstName);
        member.setLastName(lastName);
        memberRepository.save(member);
    }
    public void deleteMember(String userName){
        memberRepository.deleteById(userName);
    }

}
