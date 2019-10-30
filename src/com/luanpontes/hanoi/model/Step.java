package com.luanpontes.hanoi.model;


/**
 * Representação de Step de movimentação 
 * para uma entraga de pacote.
 * 
 * @author toolmaker
 *
 */
public class Step {
	
	private String step;
	
	private String packageId;
	
	private String from;
	
	private String to; 
	
	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}


}
