package br.edu.fateccotia.tasklist.controller;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/short")
public class RedirController {

	@GetMapping("/{key}")
	public ResponseEntity<?> redir(@PathVariable(name = "key") String key) {
		String url = switch (key) {
		case "qwe" -> "https://stackoverflow.com/"; 
		case "asd" -> "https://www.baeldung.com/"; 
		case "zxc" -> "https://refactoring.guru/pt-br/design-patterns/"; 
		default -> "https://google.com/"; 
		};
		
//		return ResponseEntity.status(HttpStatus.FOUND)
//				.header("Location", url)
//				.build();
		return ResponseEntity.ok(randomKey());
	}
	public String randomKey() {
		String x = "";
		for (int i=0; i<10; i++) {
			int nextInt = new Random().nextInt(65, 122);
			x += (char)(nextInt);
		}
		x = x.replaceAll("\\W", "").substring(0, 6);
		return x;
	}
}
