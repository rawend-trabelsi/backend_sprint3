package com.rawend.smartphones.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rawend.smartphones.entities.Smartphone;
import com.rawend.smartphones.serevice.SmartphoneService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")

public class SmartphoneRESTController {
@Autowired
SmartphoneService smartphoneService;
@RequestMapping(method=RequestMethod.GET)
public List<Smartphone> getAllSmartphones(){
	return smartphoneService.getAllSmartphones();}
@RequestMapping(value="/{id}",method = RequestMethod.GET) 
	public Smartphone getSmartphoneById(@PathVariable("id") Long id) {  
	return smartphoneService.getSmartphone(id); 
	} 	
@RequestMapping(method = RequestMethod.POST) 
public Smartphone createSmartphone(@RequestBody Smartphone smartphone) { 
return smartphoneService.saveSmartphone(smartphone); 
}
@RequestMapping(method = RequestMethod.PUT) 
public Smartphone updateSmartphone(@RequestBody Smartphone smartphone) { 
return smartphoneService.updateSmartphone(smartphone); 
}
@RequestMapping(value="/{id}",method = RequestMethod.DELETE) 
public void deleteSmartphone(@PathVariable("id") Long id) 
{ 
smartphoneService.deleteSmartphonetById(id); 
}
@RequestMapping(value="/smartyp/{idType}",method = RequestMethod.GET) 
public List<Smartphone> getSmartphonesById(@PathVariable("idType") Long idType) { 
return smartphoneService.findByTypeIdType(idType); 
} 
@RequestMapping(value="/smarsByName/{nom}",method = RequestMethod.GET) 
public List<Smartphone> findByNomSmartphoneContains(@PathVariable("nom") String nom) { 
return smartphoneService.findByNomSmartphoneContains(nom); 
} 
}

