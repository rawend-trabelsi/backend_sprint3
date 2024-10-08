package com.rawend.smartphones.serevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rawend.smartphones.entities.Smartphone;
import com.rawend.smartphones.repos.SmartphoneRepository;

import com.rawend.smartphones.entities.Type; // Assurez-vous que c'est bien celui-ci

@Service
public class SmartphoneServiceImpl  implements SmartphoneService{
	@Autowired
	SmartphoneRepository smartphoneRepository;
	@Override
	public Smartphone saveSmartphone(Smartphone s) {
		
		 return smartphoneRepository.save(s);
	}

	@Override
	public Smartphone updateSmartphone(Smartphone s) {
		
		return smartphoneRepository.save(s);
	}

	@Override
	public void deleteSmartphone(Smartphone s) {
		smartphoneRepository.delete(s);
		
	}

	@Override
	public void deleteSmartphonetById(Long id) {
		smartphoneRepository.deleteById(id);
		
	}

	@Override
	public Smartphone getSmartphone(Long id) {
	
		return smartphoneRepository.findById(id).get();
	}

	@Override
	public List<Smartphone> getAllSmartphones() {
		
		return smartphoneRepository.findAll();
	}

	@Override
	public List<Smartphone> findByNomSmartphone(String nom) {
		
		return smartphoneRepository.findByNomSmartphone(nom);
	}

	@Override
	public List<Smartphone> findByNomSmartphoneContains(String nom) {
		
		return smartphoneRepository.findByNomSmartphoneContains(nom);
	}
	@Override
	public List<Smartphone> findByPrixSmartphone(String nom, Double prix) {
		
		return smartphoneRepository.findByPrixSmartphone(nom, prix);
	}

	@Override
	public List<Smartphone> findByType(Type type) {
		
		return smartphoneRepository.findByType(type);
	}	

	@Override
	public List<Smartphone> findByTypeIdType(Long id) {
		
		return smartphoneRepository.findByTypeIdType(id);
	}

	@Override
	public List<Smartphone> findByOrderByNomSmartphonesAsc() {
		
		return smartphoneRepository.findByOrderByNomSmartphoneAsc();
	}

	@Override
	public List<Smartphone> trierSmartphonesNomsPrix() {
		
		return smartphoneRepository.trierSmartphonesNomsPrix();
	}

}
