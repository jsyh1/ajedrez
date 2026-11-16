package co.edu.poli.dao;

import java.util.List;
import co.edu.poli.service.ConexionDB;
import co.edu.poli.model.Jugador;

public class DaoImplementadoJugador implements JugadorDAO {

	/*
	 * Conexion DB
	 */

	@Override
	public boolean crear(Jugador objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Jugador> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Jugador buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizar(Jugador objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
