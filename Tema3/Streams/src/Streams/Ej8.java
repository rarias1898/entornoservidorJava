package Streams;

import java.util.stream.Stream;

public class Ej8 {

	public static void main(String[] args) {
		Double[] precios = { 1.50, 25.40, 50.20, 15.50, 28.60 };
		Stream<Double> mayores = Stream.of(precios).filter(x -> x > 20);
		mayores.forEach(System.out::println);
	}

}
