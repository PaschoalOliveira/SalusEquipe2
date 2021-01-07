package com.salus.api.model;

public class Empregado {

	String nome;
	
	Double salario;

	public Empregado(String nome, Double salario) {
		this.nome = nome;
		this.salario = salario;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + " | Salário: " + salario;
	}
}
