package com.luanpontes.hanoi

import com.luanpontes.hanoi.model.Package
import com.luanpontes.hanoi.model.Step
import static com.luanpontes.hanoi.model.ZoneEnum.*

import com.luanpontes.hanoi.model.Doca

import spock.lang.Specification

public class DocaSpec extends Specification {
	
	Doca doca
	
	def setup() {
		doca = new Doca()
			.origin(A)
			.aux(T)
			.target(C)
	}
	
	def "Um pacote, deve ser feito em um movimento."(){
		given:
			def packages = [
				new Package("1", 14.5),
			]
			
			doca.packages(packages)
		when:
			List<Step> steps = doca.steps()
		then:
			steps.size() == 1
	}
	
	def "Um pacotes, deve ser ser feito em apenas um movimento."(){
		given:
			def packages = [
				new Package("1", 14.5),
			]
			
			doca.packages(packages)
		when:
			List<Step> steps = doca.steps()
		then:
			steps.contains(new Step(step, packageId, from.desc, to.desc));
		where:
			step | packageId | from | to
			 1   |     "1"   |  A   | C
	}
	
	def "Dois pacotes, deve ser feito em três movimentos."(){
		given:
			def packages = [
				new Package("1", 14.5),
				new Package("2", 12.15),
			]
			
			doca.packages(packages)
		when:
			List<Step> steps = doca.steps()
		then:
			steps.size() == 3
	}
	
	def "Dois pacotes, devem ser movimentados na ordem correta."(){
		given:
			def packages = [
				new Package("1", 14.5),
				new Package("2", 12.15),
			]
			
			doca.packages(packages)
		when:
			List<Step> steps = doca.steps()
		then:
			steps.contains(new Step(step, packageId, from.desc, to.desc));
		where:
			step | packageId | from | to
			 1   |     "2"   |  A   | T
			 2   |     "1"   |  A   | C
			 3   |     "2"   |  T   | C
	}
	
	def "Três pacotes, deve ser feito o menor número de movimentos 7"(){
		given:
			def packages = [
				new Package("1", 14.5),
				new Package("2", 12.15), 
				new Package("3", 19.5)
			]
			
			doca.packages(packages)
		when:
			List<Step> steps = doca.steps()
		then:
			steps.size() == 7
	}
	
	def "Três pacotes, devem ser movimentados na ordem correta."(){
		given:
			def packages = [
				new Package("1", 14.5),
				new Package("2", 12.15),
				new Package("3", 19.5)
			]
			
			doca.packages(packages)
		when:
			List<Step> steps = doca.steps()
		then:
			steps.contains(new Step(step, packageId, from.desc, to.desc));
		where:
			step | packageId | from | to
			 1   |     "2"   |  A   | C
			 2   |     "1"   |  A   | T
			 3   |     "2"   |  C   | T
			 4   |     "3"   |  A   | C
			 5   |     "2"   |  T   | A
			 6   |     "1"   |  T   | C
			 7   |     "2"   |  A   | C
	}
	
	def "Quarto pacotes, deve ser feito o menor número de movimentos 15"(){
		given:
			def packages = [
				new Package("3", 14.5),
				new Package("2", 12.15),
				new Package("4", 19.5),
				new Package("1", 11.5)
			]
			
			doca.packages(packages)
		when:
			List<Step> steps = doca.steps()
		then:
			steps.size() == 15
	}
	
	def "Quatro pacotes, devem ser movimentados na ordem correta."(){
		given:
			def packages = [
				new Package("3", 14.5),
				new Package("2", 12.15),
				new Package("4", 19.5),
				new Package("1", 11.5)
			]
			
			doca.packages(packages)
		when:
			List<Step> steps = doca.steps()
		then:
			steps.contains(new Step(step, packageId, from.desc, to.desc));
		where:
			step | packageId | from | to
			 1   |    "1"      |  A  |  T 
			 2   |    "2"      |  A  |  C 
			 3   |    "1"      |  T  |  C 
			 4   |    "3"      |  A  |  T 
			 5   |    "1"      |  C  |  A 
			 6   |    "2"      |  C  |  T 
			 7   |    "1"      |  A  |  T 
			 8   |    "4"      |  A  |  C 
			 9   |    "1"      |  T  |  C 
			10   |    "2"      |  T  |  A 
			11   |    "1"      |  C  |  A 
			12   |    "3"      |  T  |  C 
			13   |    "1"      |  A  |  T 
			14   |    "2"      |  A  |  C 
			15   |    "1"      |  T  |  C 
	}
}