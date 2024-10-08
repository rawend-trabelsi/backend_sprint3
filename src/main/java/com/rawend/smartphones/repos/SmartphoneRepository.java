package com.rawend.smartphones.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rawend.smartphones.entities.Smartphone;
import com.rawend.smartphones.entities.Type;

@RepositoryRestResource(path = "rest") 
public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {
List <Smartphone> findByNomSmartphone(String nom);
List <Smartphone> findByNomSmartphoneContains(String nom);
@Query("select s from Smartphone s where s.nomSmartphone like %?1 and s.prixSmartphone > ?2") 
List<Smartphone> findByPrixSmartphone(String nom, Double prix); 

//@Query("select s from Smartphone s where s.nomSmartphone like %:nom and p.prixSmartpohone> :prix") 
//List<Smartphone> findByPrixSmartphone (@Param("nom") String nom,@Param("prix") Double prix);
@Query("SELECT s FROM Smartphone s WHERE s.type = ?1")
List<Smartphone> findByType(Type type); 
List<Smartphone> findByTypeIdType(Long id);
List<Smartphone> findByOrderByNomSmartphoneAsc();
@Query("select s from Smartphone s order by s.nomSmartphone ASC, s.prixSmartphone DESC") 
List<Smartphone> trierSmartphonesNomsPrix();






}