package com.luanpontes.hanoi

import com.luanpontes.hanoi.model.Delivery
import com.luanpontes.hanoi.service.DeliveryService
import com.luanpontes.hanoi.model.Package

import spock.lang.Specification

class DeliveryValidationSpec extends Specification {

	DeliveryService deliveryService

	Delivery validDelivery
	
	def setup() {
		deliveryService = new DeliveryService()
		validDelivery = new Delivery()
		validDelivery.vehicle = "123"
		validDelivery.deliveryId = "321"
		validDelivery.packages = [
			new Package("1", 14.5),
			new Package("2", 12.15),
			new Package("3", 19.5)
		]
	}
	
	def "Delivery com todos os atributos preenchidos deve ser válido."(){
		when:
			def errors = deliveryService.validate(validDelivery)
		then: 
			errors.isEmpty()
	}

	def "Delivery deve ser inválido quando atributo vehicle for nulo."(){
		given:
			validDelivery.vehicle = null
		when:
			def errors = deliveryService.validate(validDelivery)
		then:
			errors.size() == 2
			errors.contains("vehicle : Não pode estar vazio")
			errors.contains("vehicle : não pode ser nulo")
	}

	def "Delivery deve ser inválido quando atributo deliveryId for nulo."(){
		given:
			validDelivery.deliveryId = null
		when:
			def errors = deliveryService.validate(validDelivery)
		then:
			errors.size() == 2
			errors.contains("deliveryId : Não pode estar vazio")
			errors.contains("deliveryId : não pode ser nulo")
	}
	
	def "Delivery deve ser inválido quando atributo vehicle estiver vazio."(){
		given:
			validDelivery.vehicle = ""
		when:
			def errors = deliveryService.validate(validDelivery)
		then:
			errors.size() == 1
			errors.contains("vehicle : Não pode estar vazio")
	}
	
	def "Delivery deve ser inválido quando atributo deliveryId estiver vazio."(){
		given:
			validDelivery.deliveryId = ""
		when:
			def errors = deliveryService.validate(validDelivery)
		then:
			errors.size() == 1
			errors.contains("deliveryId : Não pode estar vazio")
	}

	def "Delivery deve ser inválido quando atributo packages estiver vazio."(){
		given:
			validDelivery.packages = []
		when:
			def errors = deliveryService.validate(validDelivery)
		then:
			errors.size() == 1
			errors.contains("packages : Não pode estar vazio")
	}
	
	def "Delivery deve ser inválido quando um dos packages estiver com id null"(){
		given:
			validDelivery.packages[0].id = null
		when:
			def errors = deliveryService.validate(validDelivery)
		then:
			errors.size() == 2
			errors.contains("packages[0].id : não pode ser nulo")
			errors.contains("packages[0].id : Não pode estar vazio")
	}
	
	def "Delivery deve ser inválido quando um dos packages estiver com id vazio"(){
		given:
			validDelivery.packages[1].id = ""
		when:
			def errors = deliveryService.validate(validDelivery)
		then:
			errors.size() == 1
			errors.contains("packages[1].id : Não pode estar vazio")
	}
	
	def "Delivery deve ser inválido quando um dos packages estiver com weight null"(){
		given:
			validDelivery.packages[1].weight = null
		when:
			def errors = deliveryService.validate(validDelivery)
		then:
			errors.size() == 1
			errors.contains("packages[1].weight : não pode ser nulo")
	}
	
	def "Delivery deve ser inválido quando um dos packages estiver com weight estive negativo"(){
		given:
			validDelivery.packages[2].weight = -1.0
		when:
			def errors = deliveryService.validate(validDelivery)
		then:
			errors.size() == 1
			errors.contains("packages[2].weight : deve ser maior que 0")
	}




}
