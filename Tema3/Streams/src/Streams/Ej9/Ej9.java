package Streams.Ej9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ej9 {

	public static void main(String[] args) {
		
		List<Persona> persona = new ArrayList<>();
		
		Persona p1 = new Persona("Angel", 28);
		Persona p2 = new Persona("Ana", 24);
		Persona p3 = new Persona("Pablo", 22);
		Persona p4 = new Persona("Cristian", 17);
		Persona p5 = new Persona("Maria", 45);
		
		persona.add(p1);
		persona.add(p2);
		persona.add(p3);
		persona.add(p4);
		persona.add(p5);
		
		Stream<Persona> streamPersona = persona.stream().filter(x -> x.getEdad() > 25);
		streamPersona.map(x -> x.getNombre() + " (" + x.getEdad() + " años)").sorted().forEach(System.out::println);
	}

}
