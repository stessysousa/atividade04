package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import model.Carro;

public class CarroDAO {
	
	private static final Map<Integer, Carro> carroMap = new HashMap<Integer, Carro>();
    private static int i = 2;
 
    static {
        initCarros();
    }
 
    private static void initCarros() {
    	Carro carro1 = new Carro (1, "Veinho", "gol", "1999", "2000" , "10/12/99");
    	
 
    	carroMap.put(carro1.getId(), carro1);
        
    }
 
    public static Carro getCarro(int id) {
        return carroMap.get(id);
    }
 
    public static Carro getCarroByMarca(String marca) {
        List<Carro> list = getAllCarros();
 
        for (Carro carro : list) {
            if (carro.getMarca().equals(marca)) {
                return carro;
            }
        }
 
        return null;
    }
 
    public static Carro addCarro(String nome, String marca, String fabricacao, String modelo, String data) {
    	System.out.println("xxx");
    	Carro carro = new Carro(i, nome, marca, fabricacao, modelo, data);
    	carroMap.put(carro.getId(), carro);
        i++;
        return carro;
    }
 
    public static Carro updateCarro(int id, String nome, String marca, String fabricacao, String modelo, String data) {
    	Carro carro = new Carro(id, nome, marca, fabricacao, modelo, data);
        carroMap.put(carro.getId(), carro);
        return carro;
    }
 
    public static void deleteCarro(int id) {
        if (carroMap.containsKey(id)) {
        	carroMap.remove(id);
        }
    }
 
    public static List<Carro> getAllCarros() {
        return new ArrayList<Carro>(carroMap.values());
    }

}
