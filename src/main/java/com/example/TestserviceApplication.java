package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.mapping.JpaPersistentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TestserviceApplication {
	
	@Bean
	CommandLineRunner runner (ReservationRepository reservationRepository){
		return string ->{
			Stream.of("Mahesh","Test","Abs").forEach(n -> reservationRepository.save(new ReservationDetials(n,String.valueOf(Math.random()))));
		};
	
	}
	public static void main(String[] args) {
		SpringApplication.run(TestserviceApplication.class, args);
	}
}

@RepositoryRestResource
interface ReservationRepository extends JpaRepository<ReservationDetials, Long>{
	Collection<ReservationDetials> findByName(@Param ("name") String name);
}

@RestController
class testabc{
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/testList")
	Collection<Integer> readBookmarks() {
		List<Integer> test1= new ArrayList<Integer>();
		test1.add(1);
		test1.add(2);
		return test1;
	}
}

@Entity
class ReservationDetials{
	@Id
	@GeneratedValue
	private Long id;
	public ReservationDetials(String name, String test) {
		super();
		this.name = name;
		this.test = test;
	}
	private String name;
	private String test;
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public Long getId() {
		return id;
	}
	public ReservationDetials(String name) {
		super();
		this.name = name;
	}
	public ReservationDetials() {
		super();
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "ReservationDetials [id=" + id + ", name=" + name + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}