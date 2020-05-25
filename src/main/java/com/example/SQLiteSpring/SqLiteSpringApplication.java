package com.example.SQLiteSpring;

import com.example.SQLiteSpring.entities.Product;
import com.example.SQLiteSpring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SqLiteSpringApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(SqLiteSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Demo3();
		Demo4();
	}

	private void Demo1() {
		for (Product p : productService.findAll()) {
			System.out.println("Product : " + p.getName());
			System.out.println("Price : " + p.getPrice());
			System.out.println("Quantity : " + p.getQuantity());
			System.out.println("=============================");
		}
	}

	private void Demo2() {
		for (Product p : productService.search(5,10)) {
			System.out.println("Product : " + p.getName());
			System.out.println("Price : " + p.getPrice());
			System.out.println("Quantity : " + p.getQuantity());
			System.out.println("=============================");
		}
	}


	private void Demo3() {
		Product p = productService.find(2);
			System.out.println("Product : " + p.getName());
			System.out.println("Price : " + p.getPrice());
			System.out.println("Quantity : " + p.getQuantity());
			System.out.println("=============================");

	}

	private void Demo4() {
		Product p = new Product();
		p.setName("Banana");
		p.setPrice(7.9);
		p.setQuantity(50);
		p.setStatus(true);
		productService.save(p);
		System.out.println("Product id : " + p.getId());
		System.out.println("=============================");
	}
}
