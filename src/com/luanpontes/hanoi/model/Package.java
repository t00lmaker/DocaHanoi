package com.luanpontes.hanoi.model;

/**
 * Representação de um pacote.
 * 
 * @author toolmaker
 *
 */
public class Package {
	
	private String id;
	
	private String weight;
	
	public Package(String id, String weight) {
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

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

}
