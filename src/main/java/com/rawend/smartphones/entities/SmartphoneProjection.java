package com.rawend.smartphones.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomSmar", types = { Smartphone.class }) 
public interface SmartphoneProjection {
	public String getNomSmartphone();

}
