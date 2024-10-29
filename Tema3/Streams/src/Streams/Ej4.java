package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ej4 {

	public static void main(String[] args) {
		/*List<String> listaNombres = Arrays.asList("Angel", "Aaul", "Pedro", "Cristian", "Paco");*/
		String[] listaNombres = { "Angel", "Aaul", "Pedro", "Cristian", "Paco" };
		List<Integer> streamNombres = Stream.of(listaNombres).map(x -> x.length()).toList();
		streamNombres.forEach(System.out::println);
	}

}
