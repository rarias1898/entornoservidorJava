package Streams;

import java.util.stream.Stream;

public class Ej6 {

	public static void main(String[] args) {
		Integer[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Stream<Integer> pares = Stream.of(numeros).filter(x -> x % 2 == 0);
		pares.forEach(System.out::println);
	}

}
