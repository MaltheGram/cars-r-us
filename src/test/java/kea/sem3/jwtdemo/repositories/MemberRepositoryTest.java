package kea.sem3.jwtdemo.repositories;

import kea.sem3.jwtdemo.entity.Car;
import kea.sem3.jwtdemo.entity.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    CarRepository carRepository;

    @BeforeEach
    void setUp() {
        memberRepository.save(new Member("MaltheOG","malt@gmail.com","123","Malthe","Gram"));
        carRepository.save(new Car());
    }

    @Test
    public void testCount(){
        assertEquals(1,memberRepository.count());
    }

}