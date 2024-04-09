package com.TM.spring.jpa;

import lombok.*;
import reactor.core.publisher.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;



@RequestMapping("Book")

@AllArgsConstructor

@RestController

public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private MemberService membService;
	
	@Autowired
	private PublisherService pubService;
	
	@GetMapping
	public Flux<Book> getAll() {
		System.out.println("All the Book information");
		return bookService.getAll();
	}
	
	@CrossOrigin(origins = "http://localhost:3001")
	@GetMapping("{id}")
	public Mono<Book> getById(@PathVariable("id") final String id) {
		System.out.println("One Book information based for the given ID");
		return bookService.getById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:3001")
	@PutMapping("{id}")
	public Object updateById(@PathVariable("id") final String id, @RequestBody final Book Book) {
		if (
			bookService.getById(id).block() != null
			) {
			System.out.println("Updating an Book Info");
			return bookService.update(id, Book);
		}
		return "Error! Book does not exist!";
		
	}

	@CrossOrigin(origins = "http://localhost:3001")
	@PostMapping(consumes = {"application/json"})
	public Object save(@RequestBody final Book Book) {
		System.out.println("Added Book Info "+ Book.get_title() + " - " 
			+ " - " + Book.get_author() + " - " + Book.get_pub_id());
			return bookService.save(Book);
		
	}

	@CrossOrigin(origins = "http://localhost:3001")
	@DeleteMapping("{id}")
	public Object delete(@PathVariable final String id) {
		return bookService.delete(id);
	}
}