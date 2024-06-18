package pl.programista1024.demos.jpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bus extends Vehicle {

	@Id
	private Long id;
}
