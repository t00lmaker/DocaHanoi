package com.luanpontes.hanoi.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * Representação de um pacote.
 * 
 * @author toolmaker
 *
 */
public class Package implements Serializable {
	
	private static final long serialVersionUID = -8659352172809275400L;
	
	@NotEmpty 
	@NotNull
	private String id;
	
	@Positive
	@NotNull
	private Double weight;
	
	public Package(String id, Double weight) {
		super();
		this.id = id;
		this.weight = weight;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

}
