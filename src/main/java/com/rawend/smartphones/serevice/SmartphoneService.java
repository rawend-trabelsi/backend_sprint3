package com.rawend.smartphones.serevice;

import java.util.List;

import com.rawend.smartphones.entities.Smartphone;

import com.rawend.smartphones.entities.Type; // Assurez-vous que c'est bien celui-ci


public interface SmartphoneService {
	Smartphone saveSmartphone(Smartphone s); 
	Smartphone updateSmartphone(Smartphone s); 
	  void deleteSmartphone(Smartphone s); 
	    void deleteSmartphonetById(Long id); 
	    Smartphone getSmartphone(Long id); 
	  List<Smartphone> getAllSmartphones(); 
	  List<Smartphone> findByNomSmartphone(String nom); 
	  List<Smartphone> findByNomSmartphoneContains(String nom); 
	  List<Smartphone> findByPrixSmartphone(String nom, Double prix); 
	  List<Smartphone> findByType (Type type); 
	  List<Smartphone> findByTypeIdType(Long id); 
	  List<Smartphone> findByOrderByNomSmartphonesAsc(); 
	  List<Smartphone> trierSmartphonesNomsPrix();
	
	  
}
