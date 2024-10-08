package com.rawend.smartphones.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.rawend.smartphones.entities.Type;


@RepositoryRestResource(path = "typ")
@CrossOrigin("http://localhost:4200/") //pour autoriser angular
public interface TypeRepository extends JpaRepository<Type, Long>{

}
