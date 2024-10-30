package Streams.Ej11;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Ej11 {

	public static void main(String[] args) {
		List<Curso> curso = new ArrayList<>();
		
		Curso c1 = new Curso("Curso de Java", 1.2, 5, 25);
		Curso c2 = new Curso("Curso de JS", 10.5, 7, 501);
		Curso c3 = new Curso("Curso de Angular", 15.3, 5, 600);
		Curso c4 = new Curso("Curso de React", 14.5, 72, 54);
		Curso c5 = new Curso("Curso de NextJs", 22.3, 65, 12);
		
		curso.add(c1);
		curso.add(c2);
		curso.add(c3);
		curso.add(c4);
		curso.add(c5);
		
		long mayorDe5 = curso.stream().filter(x -> x.getDuracion() > 5).count();
		System.out.println("Hay " + mayorDe5 + " cursos con mas de 5 horas de duración");
		
		System.out.println("-------------------");
		
		long menorDe2 = curso.stream().filter(x -> x.getDuracion() < 2).count();
		System.out.println("Hay " + menorDe2 + " cursos con menos de 2 horas de duración");
		
		System.out.println("-------------------");
		
		Stream<Object> masDe50Videos = curso.stream().filter(x -> x.getNumeroVideos() > 50).map(x -> x.getNombre() + " (" + x.getNumeroVideos() + ")");
		masDe50Videos.forEach(System.out::println);
		
		System.out.println("-------------------");
		
		curso.stream().sorted((curso1, curso2) -> c1.getDuracion().compareTo(c2.getDuracion())).limit(3)
				.map(x -> x.getNombre() + " (" + x.getDuracion() + " )").forEach(System.out::println);
				
		
		System.out.println("-------------------");
		
		curso.stream().map(x -> x.getNombre() + " tiene una duración de " + x.getDuracion()).forEach(System.out::println);
		
		System.out.println("-------------------");
		
		curso.stream().filter(x -> x.getNumeroAlumnos() < 500).map(x -> x.getNombre() + ": " + x.getDuracion() + " horas").forEach(System.out::println);
		
		System.out.println("-------------------");
		
		Optional<Curso> mayorDuracion = curso.stream().max((curso1, curso2) -> curso1.getDuracion().compareTo(curso2.getDuracion()));
		mayorDuracion.ifPresent(x -> System.out.println(x.getNombre() + " con " + x.getDuracion() + " horas"));
		
		System.out.println("-------------------");
		
		curso.stream().map(x -> x.getNombre()).toList().forEach(System.out::println);
	}

}
