package org.examples;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public interface Engine {
	
	void start();
	
}


@Component
@Qualifier("petrol")
class PetrolEngine implements Engine{
	
	@Override
	public void start() {
		System.out.println("Petrol engine started");
	}
}


@Component
class DieselEngine implements Engine{
	
	@Override
	public void start() {
		System.out.println("Diesel engine started");
	}
}