package com.TM.spring.jpa;

import lombok.*;
import reactor.core.publisher.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;



@RequestMapping("Member")

@AllArgsConstructor

@RestController

public class MemberController {

@Autowired

private MemberService membService;

	@GetMapping
	public Flux<Member> getAll() {
		System.out.println("All the Member information");
		return membService.getAll();
	}

	@CrossOrigin(origins = "http://localhost:3001")
	@GetMapping("{id}")
	public Mono<Member> getById(@PathVariable("id") final String id) {
		System.out.println("One Member information based for the given ID");
		return membService.getById(id);
	}

 

	@CrossOrigin(origins = "http://localhost:3001")
	@PutMapping("{id}")
	public Object updateById(@PathVariable("id") final String id, @RequestBody final Member Member) {
		if (
			membService.getById(id).block() != null
			) {
				System.out.println("Updating an Member Info");
				return membService.update(id, Member);
			}
		return "Error! Member does not exist!";
	}

	@CrossOrigin(origins = "http://localhost:3001")
	@PostMapping
	public Object save(@RequestBody final Member Member) {
		System.out.println(
		"Added Member Info "+ Member.get_memb_id() + " - " 
		+ " - " + Member.get_name()
		+ " - " + Member.get_address());
		return membService.save(Member);
		
	}

	@CrossOrigin(origins = "http://localhost:3001")
	@DeleteMapping("{id}")
	public Object delete(@PathVariable final String id) {
		if (membService.getById(id).block() != null) {
			System.out.println("An Member Info deleted");
			return membService.delete(id);
		}
		return "Member does not exist!";
	
	}
}