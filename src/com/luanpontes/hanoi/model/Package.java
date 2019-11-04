package com.luanpontes.hanoi.model;

/**
 * Representação de um pacote.
 * 
 * @author toolmaker
 *
 */
public class Package {
	
	private String id;
	
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
