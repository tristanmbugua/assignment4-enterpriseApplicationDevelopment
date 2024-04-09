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

public class BookService {

@Autowired

private BookRepository empRepository;

public Flux<Book> getAll() {

return empRepository.findAll().switchIfEmpty(Flux.empty());

}

public Mono<Book> getById(final String id) {

return empRepository.findById(id);

}

public Mono update(final String id, final Book Book) {

return empRepository.save(Book);

}

public Mono save(final Book Book) {

	return empRepository.save(Book);

}

public Mono delete(final String id) {
	final Mono<Book> dbBook = getById(id);
	if (Objects.isNull(dbBook)) {
		return Mono.empty();
	}
	
	return getById(id).switchIfEmpty(
			Mono.empty()).filter(Objects::nonNull).flatMap(
					BookToBeDeleted -> 
						empRepository.delete(BookToBeDeleted)
						.then(Mono.just(BookToBeDeleted)));
	}
}
