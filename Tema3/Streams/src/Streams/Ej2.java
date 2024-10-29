package Streams;

import java.util.Arrays;
import java.util.List;

public class Ej2 {

	public static void main(String[] args) {
		List<String> listaNombres = Arrays.asList("Angel", "Raul", "Arandano", "Cristian", "Arameo");
		listaNombres.stream().filter(x -> x.startsWith("A")).map(x -> x.toUpperCase()).sorted().forEach(System.out::println);
	}

}
