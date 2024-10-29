package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ej1 {

	public static void main(String[] args) {
		List<String> listaNombres = Arrays.asList("Angel", "Aaul", "Pedro", "Cristian", "Paco");
		Stream<String> stream = listaNombres.stream();
		
		stream.filter(x -> x.startsWith("A")).forEach(System.out::println);
	}
}
