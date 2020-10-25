package br.ufc.web.carro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="carros")
public class Carro {
	
	@Id
	@GeneratedValue
	int id;
	String nome;
	String marca;
	String fabricacao;
	String modelo;
	String data;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getFabricacao() {
		return fabricacao;
	}
	public void setFabricacao(String fabricacao) {
		this.fabricacao = fabricacao;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Carro(int id, String nome, String marca, String fabricacao, String modelo, String data) {
		super();
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.fabricacao = fabricacao;
		this.modelo = modelo;
		this.data = data;
	}
	
	public Carro(String nome, String marca, String fabricacao, String modelo, String data) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.fabricacao = fabricacao;
		this.modelo = modelo;
		this.data = data;
	}
	
	public Carro() {
		super();
	}
	@Override
	public String toString() {
		return "Carro [id=" + id + ", nome=" + nome + ", marca=" + marca + ", fabricacao=" + fabricacao + ", modelo="
				+ modelo + ", data=" + data + "]";
	}
	
	
	

}
