package com.example.springangular;

import com.example.springangular.Model.Departement;
import com.example.springangular.Model.Employee;
import com.example.springangular.repository.DepartementRepository;
import com.example.springangular.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringAngularApplication implements CommandLineRunner {

	@Autowired
	private DepartementRepository departementRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringAngularApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Departement departement1 = new Departement(1L,"informatique",null);
		Employee employee1 = new Employee(1L,"achraf","slassi","achraf.gmail.com",departement1);
		Departement departement2 = new Departement(2L,"RH",null);

		Employee employee2 = new Employee(2L,"youness","elaouni","youness@gmail.com",departement2);
		Employee employee3 = new Employee(3L,"marouane","slassi","marouane@gmail.com",departement2);
		departementRepository.saveAll(Arrays.asList(departement1, departement2));
		employeeRepository.saveAll(Arrays.asList(employee1, employee2, employee3));
		departementRepository.getEmployeesbydepartement(1L);
		//employeeRepository.getDepartementbyEmployee(2L);
	}
}
