package com.salus.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Collections;

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

		empregados.add(new Empregado("Rafael", 10000.00));
		empregados.add(new Empregado("Juliano", 12000.00));
		empregados.add(new Empregado("Gumersindo", 14000.00));
		empregados.add(new Empregado("Amaral", 8000.00));
		empregados.add(new Empregado("Guilherme", 9000.00));

		return empregados;
	}
	

	@RequestMapping("getStream")
	public List<Empregado> getStream() {

		List<Empregado> empregados = new ArrayList<Empregado>();

		empregados.add(new Empregado("Rafael", 10000.00));
		empregados.add(new Empregado("Juliano", 12000.00));
		empregados.add(new Empregado("Raimundo", 12000.00));
		empregados.add(new Empregado("Gumersindo", 14000.00));
		empregados.add(new Empregado("Amaral", 8000.00));
		empregados.add(new Empregado("Guilherme", 9000.00));
		empregados.add(new Empregado("Rafael", 12000.00));

		//1 - Retorna empregados com salários igual a 12.000	
		List<Empregado> empregadosSalus = empregados.stream()
				.filter(emp -> emp.getSalario() < 12000.00)
				.collect(Collectors.toList());

		return empregadosSalus;
	}
	
	@RequestMapping("getStream")
	public List<Empregado> getFiltro() {

		List<Empregado> empregados = new ArrayList<Empregado>();

		empregados.add(new Empregado("Rafael", 10000.00));
		empregados.add(new Empregado("Juliano", 12000.00));
		empregados.add(new Empregado("Raimundo", 12000.00));
		empregados.add(new Empregado("Gumersindo", 14000.00));
		empregados.add(new Empregado("Amaral", 8000.00));
		empregados.add(new Empregado("Guilherme", 9000.00));
		empregados.add(new Empregado("Rafael", 12000.00));

		//2 - Retorna empregados com salários igual a 12.000 
		//E empregados cujo nome começem com a letra R		
		List<Empregado> empregadosSalus = empregados.stream()
				.filter(emp -> emp.getSalario() == 12000.00 && emp.getNome().charAt(0) == 'R')
				.collect(Collectors.toList());

		return empregadosSalus;
	}
	
	@RequestMapping("getStream")
	public Empregado getMaiorSalario() {
		
		List<Empregado> empregados = new ArrayList<Empregado>();
		
		empregados.add(new Empregado("Rafael", 10000.00));
		empregados.add(new Empregado("Juliano", 12000.00));
		empregados.add(new Empregado("Raimundo", 12000.00));
		empregados.add(new Empregado("Gumersindo", 14000.00));
		empregados.add(new Empregado("Amaral", 8000.00));
		empregados.add(new Empregado("Guilherme", 9000.00));
		empregados.add(new Empregado("Tony Stark", 99999999999999999999999.00));
		
		Empregado empregadoComMaiorSalario = Collections.max(empregados, Comparator.comparing(e -> e.getSalario()));
		
		
		return empregadoComMaiorSalario;
	}
	
	@RequestMapping("getStream")
	public List<Empregado> set8000() {

		List<Empregado> empregados = new ArrayList<Empregado>();

		empregados.add(new Empregado("Rafael", 10000.00));
		empregados.add(new Empregado("Juliano", 12000.00));
		empregados.add(new Empregado("Raimundo", 12000.00));
		empregados.add(new Empregado("Gumersindo", 14000.00));
		empregados.add(new Empregado("Amaral", 8000.00));
		empregados.add(new Empregado("Guilherme", 9000.00));
		empregados.add(new Empregado("Rafael", 12000.00));

		//2 - Retorna empregados com salários igual a 12.000 
		//E empregados cujo nome começem com a letra R		
		List<Empregado> empregados8000 = empregados.stream()
				.map(empregado-> {empregado.setSalario(8000.00); return empregado;})
				.collect(Collectors.toList());
		
		return empregados8000;
	}
	
	
	
	
	public static void main(String[] args) {
		EmpregadoController emp = new EmpregadoController();
		
		
		System.out.println("1 - Empregados com salário menor que R$ 12.000,00 \n");
		for(Empregado pessoa : emp.getStream()) {
			System.out.println(pessoa.getNome() + " R$ " + 
							   pessoa.getSalario());
		}
		
		System.out.println("\n" + "2 - Empregados com salário igual a R$ 12.000,00 e noem começa com 'R' \n");
		for(Empregado pessoa : emp.getFiltro()) {
			System.out.println(pessoa.getNome() + " R$ " + 
							   pessoa.getSalario());
		}
		
		System.out.println("\n" + "3 - Empregado com maior salário: \n");
		System.out.println(emp.getMaiorSalario().getNome());
		
		System.out.println("\n" + "4 - Altere o valor do salário de cada elemento para 8000,00");
		emp.set8000();
		
		System.out.println();
		
		for(Empregado pessoa : emp.set8000()) {
			System.out.println(pessoa.getNome() + " R$ " + pessoa.getSalario());
		}
	}
	
	
	
	
}
