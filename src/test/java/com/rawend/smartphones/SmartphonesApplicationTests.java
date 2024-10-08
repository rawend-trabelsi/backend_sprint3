package com.rawend.smartphones;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rawend.smartphones.entities.Smartphone;
import com.rawend.smartphones.entities.Type;
import com.rawend.smartphones.repos.SmartphoneRepository;



@SpringBootTest 
class SmartphonesApplicationTests { 
@Autowired 
private SmartphoneRepository smartphoneRepository; 
@Test 
public void testCreateSmartphone() { 
	Smartphone smar = new Smartphone("Samsung", 1300.500, new Date(), "black"); 
    smartphoneRepository.save(smar); 
}  
@Test 
public void testFindSmartphone() 
{ 
	Smartphone s = smartphoneRepository.findById(3L).get();     
System.out.println(s); 
} 
@Test 
public void testUpdateSmartphone() 
{ 
Smartphone s = smartphoneRepository.findById(3L).get(); 
s.setPrixSmartphone(1222000.0); 
smartphoneRepository.save(s); 
} 
@Test 
public void testDeleteSmartphone() 
 { 
  smartphoneRepository.deleteById(14L);; 
   
 }
@Test 
public void testListerTousSmartphones() 
 { 
  List<Smartphone> smars = smartphoneRepository.findAll();   
  for (Smartphone s : smars) 
  { 
   System.out.println(s); 
  }   
 } 


@Test 
public void testFindSmartphoneByNom() 
{ 
	List <Smartphone> sms =  smartphoneRepository.findByNomSmartphone("PC ASUS");     
	 for(Smartphone s :sms) {
		 	System.out.println(s); 
}}
@Test 
public void findByNomSmartphoneContains()
{ 
	List <Smartphone> sms =  smartphoneRepository.findByNomSmartphoneContains("M");     
	 for(Smartphone s :sms) {
		 	System.out.println(s); 
}
}
@Test 

public void testfindByPrixSmartphone() 
{ 
List<Smartphone>  sms = smartphoneRepository.findByPrixSmartphone("iphone12pro", 2300.0); 
for (Smartphone s : sms) 
{ 
System.out.println(s); 
} 
} 
@Test 
public void testfindByType() { 
    Type type = new Type(); 
    type.setIdType(1L); 

   
    List<Smartphone> sms = smartphoneRepository.findByType(type); 
    for (Smartphone s : sms) { 
        System.out.println(s); 
    }
}
@Test 
public void findByTypeIdType() 
{    
List<Smartphone>  sms = smartphoneRepository.findByTypeIdType(1L); 
for (Smartphone p : sms) 
{ 
System.out.println(p); 
} 
} 
@Test 
public void testfindByOrderByNomSmartphoneAsc() 
 { 
 List<Smartphone>  sms=   smartphoneRepository.findByOrderByNomSmartphoneAsc();   
  for (Smartphone s: sms) 
  { 
   System.out.println(s); 
  } 
 } 


}