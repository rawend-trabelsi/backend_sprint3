package com.rawend.smartphones.serevice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.rawend.smartphones.entities.Smartphone;
import com.rawend.smartphones.repos.ImageRepository;
import com.rawend.smartphones.repos.SmartphoneRepository;

import com.rawend.smartphones.entities.Type; // Assurez-vous que c'est bien celui-ci

@Service
public class SmartphoneServiceImpl  implements SmartphoneService{
	@Autowired
	SmartphoneRepository smartphoneRepository;
	
	@Autowired
	ImageRepository imageRepository;
	@PreAuthorize("hasAuthority('ADMIN')")
	@Override
	public Smartphone saveSmartphone(Smartphone s) {
		
		 return smartphoneRepository.save(s);
	}

	/*@Override
	public Smartphone updateSmartphone(Smartphone s) {
		
		return smartphoneRepository.save(s);
	}*/
	@Override
	public Smartphone updateSmartphone(Smartphone s) {
	//Long oldProdImageId =this.getSmartphone(s.getIdSmartphone()).getImage().getIdImage();
	//Long newProdImageId =s.getImage().getIdImage();
	Smartphone prodUpdated = smartphoneRepository.save(s);
	//if (oldProdImageId != newProdImageId) //si l'image a été modifiée
	//imageRepository.deleteById(oldProdImageId);
	return prodUpdated;
	}


	@Override
	public void deleteSmartphone(Smartphone s) {
		smartphoneRepository.delete(s);
		
	}

	/*@Override
	public void deleteSmartphonetById(Long id) {
		smartphoneRepository.deleteById(id);
		
	}*/
	@Override 
	public void deleteSmartphonetById(Long id) { 
	Smartphone s = getSmartphone(id); 
	//suuprimer l'image avant de supprimer le produit 
	try { 
	Files.delete(Paths.get(System.getProperty("user.home")+"/images/"+s.getImagePath())); 
	} catch (IOException e) { 
	e.printStackTrace(); 
	}  
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
