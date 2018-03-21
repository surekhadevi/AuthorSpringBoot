package com.example.demo.restcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.service.AuthorService;

@RestController
@RequestMapping("/surekha/authors")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping(path="/all")
	public List<Author> getAll() throws Exception{
		/*List<Author> authors = new ArrayList<Author>();
		authors.add(new Author("surekha","Devi"));
		authors.add(new Author("prathyu","mandagani"));
		authors.add(new Author("pradip","maddela"));*/
		List<Author> authors = authorService.getAll();
		return authors;
	}
	
	@GetMapping
	public Author getAuthor(@RequestParam("id") Long id) throws Exception {
//		Author a = new Author("Surekha","Devi");
		Author a = authorService.get(id);
		return a;
	}
	 
	@GetMapping("/{a_id}")
	public Author getAuthorPathVariable(@PathVariable("a_id") Long id) throws Exception {
//		Author a = new Author("Jaggu","Thatimatla");
		Author a = authorService.get(id);
		return a;
	}
	
	@PostMapping
	public Author createAuth(@Valid @RequestBody Author auth) throws Exception {
		Author author = authorService.createAuth(auth);
		return author;
	}
	
	@PutMapping("/{id}")
	public Author updateAuth(@RequestBody Author auth) {
		return authorService.update(auth);
	}
	
	@DeleteMapping("/{id}") 
	public HttpStatus deleteAuth(@PathVariable("id") Long id) throws Exception {
		authorService.delete(id);
		return HttpStatus.OK;
	}
	
}
