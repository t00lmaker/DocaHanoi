package com.luanpontes.hanoi.model;

import java.io.Serializable;
import java.util.Collection;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class Delivery implements Serializable{
	
	private static final long serialVersionUID = -7718146278982486408L;
	
	@NotEmpty
	@NotNull
	private String vehicle;
	
	@NotEmpty
	@NotNull
	private String deliveryId;
	
	@NotEmpty
	private Collection<Package> packages;

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(String deliveryId) {
		this.deliveryId = deliveryId;
	}

	public Collection<Package> getPackages() {
		return packages;
	}

	public void setPackages(Collection<Package> packages) {
		this.packages = packages;
	}
}
