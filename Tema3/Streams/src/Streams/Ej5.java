package Streams;

import java.util.stream.Stream;

public class Ej5 {

	public static void main(String[] args) {
		String[] listaNombres = { "Angel", "Aaul", "Pedro", "Cristian", "Pacoooooooooo" };
		Stream<String> streampalabras = Stream.of(listaNombres).filter(x -> x.length() > 5);
		streampalabras.forEach(System.out::println);
	}

}
