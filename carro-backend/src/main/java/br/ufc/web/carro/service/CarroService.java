package br.ufc.web.carro.service;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.ufc.web.carro.model.Carro;
import br.ufc.web.carro.repository.CarroRepository;
 
@Service
public class CarroService {
 
    @Autowired
    CarroRepository carroRepo;
    
    public Carro addCarro(String nome, String marca, String fabricacao, String modelo, String data) {
    	Carro carro = new Carro(nome, marca, fabricacao, modelo, data);
        return carroRepo.save(carro);
    }
    
    public boolean removeCarro(Integer id) {
        if(carroRepo.existsById(id)) {
            carroRepo.deleteById(id);
            return true;
        }
        
        return false;
    }
    
    public List<Carro> getCarros() {
        return carroRepo.findAll();
    }
    
    public Carro getCarro(Integer id) {
        return carroRepo.findById(id).get();
    }
    
    public Carro getCarroByName(String nome) {
        return carroRepo.findFirstByNome(nome);
    }
    
    public Carro updateCarro(Integer id, String nome, String marca, String fabricacao, String modelo, String data) {
    	Carro carroAux = carroRepo.findById(id).get();
        
        if(carroAux != null) {
        	carroAux.setNome(nome);;
        	carroAux.setMarca(marca);
        	carroAux.setFabricacao(fabricacao);
        	carroAux.setModelo(modelo);
        	carroAux.setData(data);
        	
        	carroRepo.save(carroAux);         
        }
        
        return carroAux;
    }
}