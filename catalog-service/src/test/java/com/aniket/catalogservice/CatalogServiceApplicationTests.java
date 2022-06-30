package com.aniket.catalogservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.aniket.catalogservice.model.Product;
import com.aniket.catalogservice.repository.ProductRepository;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)               //used to take test cases in an particular Order
class CatalogServiceApplicationTests {

	@Autowired
	ProductRepository pRepo;

	@Test                                              //unit test case for adding new product
	@Order(1)
	public void testCreate() {
		Product p = new Product();
		p.setId(200);
		p.setName("iPhone XR");
		p.setDescription("Fantastic");
		p.setPrice(70000.00);
		pRepo.save(p);
		assertNotNull(pRepo.findById(200).get());
	}

	@Test                                              //unit test case for getting all product
	@Order(2)
	public void testReadAll() {
		List<Product> list = pRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test                                              //unit test case for getting product By ID
	@Order(3)
	public void testRead() {
		Product product = pRepo.findById(200).get();
		assertEquals("iPhone XR", product.getName());
	}

	@Test                                              //unit test case for updating product
	@Order(4)
	public void testUpdate() {
		Product p = pRepo.findById(200).get();
		p.setPrice(800.00);
		pRepo.save(p);
		assertNotEquals(700.00, pRepo.findById(200).get().getPrice());
	}

	@Test                                              //unit test case for deleting product
	@Order(5)
	public void testDelete() {
		pRepo.deleteById(200);
		assertThat(pRepo.existsById(200)).isFalse();
	}
}

