package com.rawend.smartphones.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rawend.smartphones.entities.Image;
public interface ImageRepository extends JpaRepository<Image , Long> {
}