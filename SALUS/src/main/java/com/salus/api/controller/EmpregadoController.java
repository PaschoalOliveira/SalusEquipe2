package com.salus.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

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
		
		return empregados;
	}
}
