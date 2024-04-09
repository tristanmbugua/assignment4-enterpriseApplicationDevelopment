package com.TM.spring.jpa;


import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface MemberRepository extends 
ReactiveMongoRepository<Member, String>{

}
