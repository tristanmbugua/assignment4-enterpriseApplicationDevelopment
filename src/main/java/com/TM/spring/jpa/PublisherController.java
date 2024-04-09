package com.TM.spring.jpa;

import lombok.*;
import reactor.core.publisher.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;



@RequestMapping("Publisher")

@AllArgsConstructor

@RestController

public class PublisherController {

@Autowired
private PublisherService pubService;

	@GetMapping
	public Flux<Publisher> getAll() {
		System.out.println("All the Publisher information");
		return pubService.getAll();
	}

	@CrossOrigin(origins = "http://localhost:3001")
	@GetMapping("{id}")
	public Mono<Publisher> getById(@PathVariable("id") final String id) {
		System.out.println("One Publisher information based for the given ID");
		return pubService.getById(id);
	}

	@CrossOrigin(origins = "http://localhost:3001")
	@PutMapping("{id}")
	public Object updateById(@PathVariable("id") final String id, @RequestBody final Publisher Publisher) {
		if (
				pubService.getById(id).block() != null
				) {
			System.out.println("Updating an Publisher Info");
			return pubService.update(id, Publisher);
		}
			return "Error! Publisher does not exist!";
		
	}

	@CrossOrigin(origins = "http://localhost:3001")
	@PostMapping
	public Mono save(@RequestBody final Publisher Publisher) {
		System.out.println(
				"Added Publisher Info "+ Publisher.get_name() + " - " 
				+ " - " + Publisher.get_address()
				+ " - " + Publisher.get_pub_id());
		return pubService.save(Publisher);
	}

	@CrossOrigin(origins = "http://localhost:3001")
	@DeleteMapping("{id}")
	public Object delete(@PathVariable final String id) {
		if (pubService.getById(id).block() != null) {
			System.out.println("An Publisher Info deleted");
			return pubService.delete(id);
		}
		return "Publisher does not exist!";
		
	}
}