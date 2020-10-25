package br.ufc.web.carro.controller;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.web.carro.model.Carro;
import br.ufc.web.carro.service.CarroService;
 
@RestController
@CrossOrigin
@RequestMapping(path = "/api/carros")
public class CarroController {
 
    @Autowired
    CarroService carroService;
 
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Carro>> getCarros() {
        return new ResponseEntity<List<Carro>>(carroService.getCarros(), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<Carro> getCarro(@PathVariable("id") Integer id) {
        return new ResponseEntity<Carro>(carroService.getCarro(id), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public ResponseEntity<Carro> getCarroByName(@RequestParam("nome") String nome) {
        return new ResponseEntity<Carro>(carroService.getCarroByName(nome), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Carro> addCarro(@RequestBody Carro carro) {
        return new ResponseEntity<Carro>(carroService.addCarro(carro.getNome(), carro.getMarca(), carro.getFabricacao(), carro.getModelo(), carro.getData()), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public ResponseEntity<Carro> updateCarro(@PathVariable("id") Integer id, @RequestBody Carro carro) {
        return new ResponseEntity<Carro>(carroService.updateCarro(id, carro.getNome(), carro.getMarca(), carro.getFabricacao(), carro.getModelo(), carro.getData()), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public ResponseEntity<Void> deleteCarro(@PathVariable("id") Integer id) {
        if (carroService.removeCarro(id)) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
 
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}
