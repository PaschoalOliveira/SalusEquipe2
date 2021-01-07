package com.salus.api.controller;

import java.util.ArrayList;
import java.util.Collections;
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
		empregados.add(new Empregado("Claudia", 14000.00));
		empregados.add(new Empregado("Amaral", 8000.00));
		empregados.add(new Empregado("Guilherme", 9000.00));
		empregados.add(new Empregado("Rafael", 12000.00));

		List<Empregado> empregadosRafael = empregados.stream().filter(empregado -> empregado.getNome().equals("Rafael"))
				.collect(Collectors.toList());

		// Exercicio:

		// Retornar funcionarios que ganham 12 mil reais
		List<Empregado> empregados_12k = empregados.stream().filter(empregado -> empregado.getSalario() == 12000.00)
				.collect(Collectors.toList());

		// Retornar funcionarios que ganham 12 mil reais e que comecem o nome com R
		List<Empregado> empregados_12k_R = empregados.stream()
				.filter(empregado -> empregado.getSalario() == 12000.00 && empregado.getNome().startsWith("R"))
				.collect(Collectors.toList());
		
		// Retornar funcionário(s) com o maior salário
		Empregado umEmpregadoComMaiorSalario = Collections.max(empregados, Comparator.comparing(e -> e.getSalario()));
		Double maiorSalario = umEmpregadoComMaiorSalario.getSalario();
		List<Empregado> empregadosMaiorSalario = empregados.stream()
				.filter(empregado -> empregado.getSalario().doubleValue() == maiorSalario)
				.collect(Collectors.toList());
		
		// Retornar funcionarios e alterar o salario destes para 8k
				List<Empregado> empregados_8k = empregados.stream()
						.map(empregado-> {empregado.setSalario(8000.00); return empregado;})
						.collect(Collectors.toList());
			
		
		// Optional<Empregado> empregado = empregados2.stream().findFirst();

		return empregados_8k;
	}
}
