import java.util.*;
import java.util.stream.Collectors;

class Product {
	private String name;
	private double price;
	private String category;

	public Product(String name, double price, String category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}
	public String getName() {
	return name;
}

public double getPrice() {
	return price;
}

public String getCategory() {
	return category;
}

@Override
public String toString() {
	return name + " (" + price + ")";
}
}

public class ProductAnalyzer {
	public static Map<String, List<Product>> analyze(List<Product> products) {
		return products.stream()
		.filter(p -> p.getPrice() > 1000)
		.sorted(Comparator.comparing(Product::getPrice).reversed())
		.collect(Collectors.groupingBy(Product::getCategory));
	}

	public static void main(String[] args) {
		List<Product> items = Arrays.asList(
				new Product("Gutal", 1500, "huvtsas"),
				new Product("Togloom", 800, "togloom"),
				new Product("Tsamts", 1200, "huvtsas"));
Map<String, List<Product>> result = analyze(items);

for (String category : result.keySet()) {
	System.out.println(category + ": " + result.get(category));
}	}
}