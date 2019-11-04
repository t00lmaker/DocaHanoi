package com.luanpontes.hanoi;

import java.util.ArrayList;
import java.util.List;

import com.luanpontes.hanoi.model.Package;
import com.luanpontes.hanoi.model.Step;
import com.luanpontes.hanoi.model.ZoneEnum;


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

	private Doca(){
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

	public Doca packages(List<Package> packages) {
		indexStep = 0;
		packages.sort((p1, p2) -> 
			Double.compare(p1.getWeight(), p2.getWeight())
		);

		this.packages = packages;

		return this;
	}

	public List<Step> steps(){
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
