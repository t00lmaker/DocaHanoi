package com.luanpontes.hanoi.model;

/**
 * Representação das zonas de movimentação.
 * 
 * @author toolmaker
 *
 */
public enum ZoneEnum {
	
	A(0, "Abstecimento"),
	
	T(1, "Transferência"),
	
	C(2, "Caminhão")
	;
	
	private int id;

	private String description;
	
	
	ZoneEnum(int id, String description) {
		this.setId(id);
		this.setDescription(description);
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

}
