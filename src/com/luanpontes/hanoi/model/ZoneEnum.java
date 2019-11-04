package com.luanpontes.hanoi.model;

/**
 * Representação das zonas de movimentação.
 * 
 * @author toolmaker
 *
 */
public enum ZoneEnum {
	
	A(0, "zona abstecimento"),
	
	T(1, "zona transferência"),
	
	C(2, "zona caminhão")
	;
	
	private int id;

	private String desc;
	
	
	ZoneEnum(int id, String description) {
		this.setId(id);
		this.setDesc(description);
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String description) {
		this.desc = description;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

}
