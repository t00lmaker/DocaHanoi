package com.luanpontes.hanoi.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Represeenta um doca com suas Zonas 
 * de transferencia de carga.
 * 
 * 
 * @author toolmaker
 *
 */
public class Doca {
	
	int indexStep;

	ZoneEnum origin;

	ZoneEnum aux;

	ZoneEnum target;

	List<Step> steps;

	List<Package> packages;

	public Doca(){
		indexStep = 0;
		steps = new ArrayList<>();
	}

	public Doca origin(ZoneEnum origin) {
		this.origin = origin;
		return this;
	}

	public Doca aux(ZoneEnum aux) {
		this.aux = aux;
		return this;
	}

	public Doca target(ZoneEnum target) {
		this.target = target;
		return this;
	}

	public Doca packages(Collection<Package> packages) {
		
		List<Package> packagesList = new ArrayList<>(packages);
		
		packagesList.sort((p1, p2) -> 
			Double.compare(p1.getWeight(), p2.getWeight())
		);

		this.packages = packagesList;

		return this;
	}

	public List<Step> steps(){
		indexStep = 0;
		
		move(packages.size(), origin, target, aux);
		
		return steps;
	}

	private void move(int indexPck, ZoneEnum origin, ZoneEnum target, ZoneEnum aux) {
		if(indexPck > 0) { 
			move(indexPck - 1, origin, aux, target);
			steps.add(new Step(++indexStep, packages.get(indexPck-1).getId(), origin.getDesc(), target.getDesc()));
			move(indexPck - 1, aux, target, origin);
		}
	}

}
