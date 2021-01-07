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
		
		List<Empregado> empregadosComSalario12000 = empregados
				.stream()
				.filter(empregado -> empregado.getSalario() == 12000.00)
				.collect(Collectors.toList());
		
		System.out.println("Empregados com salário igual a 12000:");
		empregadosComSalario12000.stream().forEach(empregado -> System.out.println(empregado.getNome()));
		
		List<Empregado> empregadosComSalario12000ENomeComecandoComR = empregados
				.stream()
				.filter(empregado -> empregado.getSalario() == 12000.00)
				.filter(empregado -> empregado.getNome().startsWith("R"))
				.collect(Collectors.toList());
		
		System.out.println("\nEmpregados com salário igual a 12000 e comecem com a letra R");
		empregadosComSalario12000ENomeComecandoComR.stream().forEach(empregado -> System.out.println(empregado.getNome()));
		
		Optional<Empregado> empregadoComMaiorSalario = empregados.stream().max(Comparator.comparingDouble(Empregado::getSalario));
		
		if (empregadoComMaiorSalario.isPresent()) {
			System.out.println("\nEmpregado com maior salário:");
			System.out.println(empregadoComMaiorSalario.get().getNome());
		}
		
		empregados = empregados
						.stream()
						.map(empregado -> {
							empregado.setSalario(8000.00);
							return empregado;
						}).collect(Collectors.toList());
		
		return empregados;
	}
}
