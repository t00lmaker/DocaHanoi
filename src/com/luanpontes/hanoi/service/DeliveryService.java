package com.luanpontes.hanoi.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.luanpontes.hanoi.model.Delivery;
import com.luanpontes.hanoi.model.Doca;
import com.luanpontes.hanoi.model.Package;
import com.luanpontes.hanoi.model.Step;

import static com.luanpontes.hanoi.model.ZoneEnum.*;

public class DeliveryService {
	
	
	public List<String> validate(Delivery delivery){
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		
		Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<Delivery>> violations = validator.validate(delivery);
		
		Stream<String> errors = violations.stream().map((it)-> { 
			return ""+it.getPropertyPath()+" : "+ it.getMessage();
		});
		
		return errors.collect(Collectors.toList());
	}
	
	public List<Step> stepsDoca(Delivery delivery) {
		
		Collection<Package> packages = delivery.getPackages();
		
		return new Doca()
				.origin(A)
				.aux(T)
				.target(C)
				.packages(packages)
				.steps();
		
		
	}
	

}
