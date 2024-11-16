package Streams;

import java.util.stream.Stream;

public class Ej7 {

	public static void main(String[] args) {
		Integer[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Stream<Integer> multi = Stream.of(numeros).map(x -> x * x);
		multi.forEach(System.out::println);
	}

}