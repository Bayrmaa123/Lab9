import java.util.*;
import java.util.function.*;

public class StringProcessor {
	public static void processStrings(List<String> strings,
			Predicate<String> filter,
			Function<String, String> transformer,
			Consumer<String> printer) {
		for (String s : strings) {
    if (filter.test(s)) {
        String transformed = transformer.apply(s);
        printer.accept(transformed);
    }
}
	}

	public static void main(String[] args) {
		List<String> words = Arrays.asList("Java", "Programmclal", "Code");
Predicate<String> filter = s -> s.length() > 4;
Function<String, String> transformer = s -> s.toUpperCase();
Consumer<String> printer = s -> System.out.println(s);

processStrings(words, filter, transformer, printer);	}
}