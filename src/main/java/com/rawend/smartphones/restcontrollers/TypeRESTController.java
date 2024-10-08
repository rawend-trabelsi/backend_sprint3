package com.rawend.smartphones.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rawend.smartphones.entities.Type;
import com.rawend.smartphones.repos.TypeRepository;

@RestController
@RequestMapping("/api/typ")

@CrossOrigin("*")
public class TypeRESTController {
	@Autowired
	TypeRepository typeRepository;
	@RequestMapping(method=RequestMethod.GET) 
	 public List<Type> getAllTypes() 
	 { 
	  return typeRepository.findAll(); 
	 } 
	@RequestMapping(value="/{id}",method = RequestMethod.GET) 
	 public Type getTypeById(@PathVariable("id") Long id) { 
	  return typeRepository.findById(id).get(); 
	  } 
	

}
