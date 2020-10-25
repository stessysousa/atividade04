package br.ufc.web.carro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.web.carro.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Integer> {
	Carro findFirstByNome(String nome);


}
