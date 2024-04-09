package com.TM.spring.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import lombok.*;
import java.util.*;
import reactor.core.publisher.*;

@Service

@Transactional

@AllArgsConstructor

public class MemberService {

	@Autowired
	private MemberRepository membRepository;
	
	public Flux<Member> getAll() {
		return membRepository.findAll().switchIfEmpty(Flux.empty());
	}
	
	public Mono<Member> getById(final String id) {
		return membRepository.findById(id);
	}
	
	public Mono update(final String id, final Member Member) {
		return membRepository.save(Member);
	}
	
	public Mono save(final Member Member) {
		return membRepository.save(Member);
	}
	
	public Mono delete(final String id) {
		final Mono<Member> dbMember = getById(id);
		if (Objects.isNull(dbMember)) {
			return Mono.empty();
		}
		
		return getById(id).switchIfEmpty(
				Mono.empty()).filter(Objects::nonNull).flatMap(
						MemberToBeDeleted -> 
							membRepository.delete(MemberToBeDeleted)
							.then(Mono.just(MemberToBeDeleted)));
	}
}
