package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ej3 {

	public static void main(String[] args) {
		/*List<String> listaNombres = Arrays.asList("Angel", "Aaul", "Pedro", "Cristian", "Paco");*/
		String[] listaNombres = { "Angel", "Aaul", "Pedro", "Cristian", "Paco" };
		Stream<String> streamNombres = Stream.of(listaNombres).map(x-> x.substring(0, 1));
		streamNombres.forEach(System.out::println);
	}

}
