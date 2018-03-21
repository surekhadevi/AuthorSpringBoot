package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Excpetion.NotFoundException;
import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepo;

	public Author createAuth(Author auth) throws Exception{
		Author author = authorRepo.save(auth);
		return author;
	}
	
	public Author update(Author auth) {
		Author author = authorRepo.save(auth);
		return author;
	}
	
	public void delete(Long id) throws Exception{
		Author author = authorRepo.findOne(id);
		if(author==null) {
			throw new NotFoundException("Author with "+id+ " is not found");
		}
		authorRepo.delete(id);
	}
	
	public List<Author> getAll() throws Exception{
		List<Author> authorList = authorRepo.findAll();
		return authorList;
	}
	
	public Author get(Long id) throws Exception{
		return authorRepo.findOne(id);
	}
}
