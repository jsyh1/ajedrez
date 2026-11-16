package co.edu.poli.dao;

import java.util.List;

public interface DAO<T> {
	boolean crear(T objeto);
	
	List<T> listar();
	
	T buscarPorId(int id);
	
	boolean actualizar(T objeto);
	
	boolean eliminar(int id);
}
