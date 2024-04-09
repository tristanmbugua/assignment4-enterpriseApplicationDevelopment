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

public class PublisherService {

@Autowired

private PublisherRepository pubRepository;

public Flux<Publisher> getAll() {

return pubRepository.findAll().switchIfEmpty(Flux.empty());

}

public Mono<Publisher> getById(final String id) {

return pubRepository.findById(id);

}

public Mono update(final String id, final Publisher Publisher) {

	return pubRepository.save(Publisher);

}

public Mono save(final Publisher Publisher) {

	return pubRepository.save(Publisher);

}

public Mono delete(final String id) {
	final Mono<Publisher> dbPublisher = getById(id);
	if (Objects.isNull(dbPublisher)) {
		return Mono.empty();
	}
	
	return getById(id).switchIfEmpty(
			Mono.empty()).filter(Objects::nonNull).flatMap(
					PublisherToBeDeleted -> 
						pubRepository.delete(PublisherToBeDeleted)
						.then(Mono.just(PublisherToBeDeleted)));
	}
}
