package com.salus.api.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salus.api.model.Empregado;

@RestController
@RequestMapping(value = "/empregados")
public class EmpregadoController {

	
	@GetMapping
	public List<Empregado> get() {
		
		List<Empregado> empregados = new ArrayList<Empregado>();
		
		empregados.add(new Empregado("Rafael",10000.00));
		empregados.add(new Empregado("Juliano",12000.00));
		empregados.add(new Empregado("Gumersindo",14000.00));
		empregados.add(new Empregado("Amaral",8000.00));
		empregados.add(new Empregado("Guilherme",9000.00));
		
		return empregados;
	}
	
	@RequestMapping("getStream")
	public List<Empregado> getStream() {
		
		List<Empregado> empregados = new ArrayList<Empregado>();
		
		empregados.add(new Empregado("Rafael",10000.00));
		empregados.add(new Empregado("Juliano",12000.00));
		empregados.add(new Empregado("Raimundo",12000.00));
		empregados.add(new Empregado("Gumersindo",14000.00));
		empregados.add(new Empregado("Amaral",8000.00));
		empregados.add(new Empregado("Guilherme",9000.00));
		empregados.add(new Empregado("Rafael",12000.00));
		
		List<Empregado> empregadosSalarioIgual1200 = empregados
				.stream()
				.filter(empregado -> empregado.getSalario().equals(12000.00))
				.collect(Collectors.toList());

		System.out.println("Empregados com salario igual 12000");
		empregadosSalarioIgual1200.forEach(employee -> System.out.println(employee));
	
		List<Empregado> empregadosSalarioIgual1200EPrimeiraLetraNomeIgualR = empregadosSalarioIgual1200
				.stream()
				.filter(empregado -> empregado.getNome().startsWith("R"))
				.collect(Collectors.toList());
		
		System.out.println("\nEmpregados com salario igual 12000 e primeira letra do nome igual a R");
		empregadosSalarioIgual1200EPrimeiraLetraNomeIgualR.forEach(empregado -> System.out.println(empregado));
		
		Optional<Empregado> empregadoComMaiorSalario = empregados
				.stream()
				.max(Comparator.comparingDouble(Empregado::getSalario));
		
		if(empregadoComMaiorSalario.isPresent()) {
			System.out.println("\nEmpregado com o maior salário:");
			System.out.println(empregadoComMaiorSalario.get());
		}
		
		List<Empregado> salariosAlterados = empregados
				.stream()
				.map(empregado -> new Empregado(empregado.getNome(),8000.00))
				.collect(Collectors.toList());
		
		System.out.println("\nEmpregados com salarios modificados para 8000");
		salariosAlterados.forEach(empregado -> System.out.println(empregado));
		return empregados;
	}
}
