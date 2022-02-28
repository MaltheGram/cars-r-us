package kea.sem3.jwtdemo.api;

import kea.sem3.jwtdemo.dto.MemberRequest;
import kea.sem3.jwtdemo.dto.MemberResponse;
import kea.sem3.jwtdemo.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/members")
public class MemberController {
    MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getAllMembers() {
        return ResponseEntity.ok(memberService.getMembers());
    }

    @GetMapping("/{username}")
    public MemberResponse getMembersFromUserName(@PathVariable String username) {
        return (memberService.getMemberByUserName(username));
    }

    @PostMapping()
    public MemberResponse AddMember(@RequestBody MemberRequest body) {
        return memberService.addMember(body);
    }
f
   @PutMapping("/{userName}")
   public MemberResponse editMember(@RequestBody MemberRequest body, @PathVariable String userName){
        return memberService.editMember(body,userName,true);
   }

   @PatchMapping("/{userName}&{firstName}&{lastName}")
   public void editNames(@PathVariable String userName, @PathVariable String firstName, @PathVariable String lastName) throws Exception{
        memberService.updateNames(userName,firstName,lastName);
   }

   @DeleteMapping("/{userName}")
   public void deleteMember(@PathVariable String userName){
        memberService.deleteMember(userName);
   }




}

