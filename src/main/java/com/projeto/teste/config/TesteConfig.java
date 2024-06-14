package com.projeto.teste.config;

import java.time.Instant;
import java.util.Arrays;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projeto.teste.entidades.Category;
import com.projeto.teste.entidades.Order;
import com.projeto.teste.entidades.OrderItem;
import com.projeto.teste.entidades.Produtos;
import com.projeto.teste.entidades.Usuario;
import com.projeto.teste.entidades.enums.OrderStatus;
import com.projeto.teste.entidades.repository.CategoryRepository;
import com.projeto.teste.entidades.repository.OrdemItemRepository;
import com.projeto.teste.entidades.repository.OrderRepository;
import com.projeto.teste.entidades.repository.ProdutosRepository;
import com.projeto.teste.entidades.repository.UsuarioRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	
	Scanner ler = new Scanner(System.in);
	private Category category;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProdutosRepository produtosRepository;

	@Autowired
	private OrdemItemRepository ordemItemRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		usuarioRepository.saveAll(Arrays.asList(u1, u2));

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.ENVIADO);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.ESPERANDO_PAGAMENTO);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.CANCELADO);
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

		Produtos p1 = new Produtos(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produtos p2 = new Produtos(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, " ");
		Produtos p3 = new Produtos(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, " ");
		Produtos p4 = new Produtos(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, " ");
		Produtos p5 = new Produtos(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		produtosRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		produtosRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPreco());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPreco());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPreco());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPreco()); 
		
		ordemItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4 ));
		
	}

}
