package Streams;

import java.util.Arrays;
import java.util.List;

public class Ej10 {

	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		numeros.stream().filter(x -> x % 2 == 0).map(x -> x * x).forEach(System.out::println);
	}

}
