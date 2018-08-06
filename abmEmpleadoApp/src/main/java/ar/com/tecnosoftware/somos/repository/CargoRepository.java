package ar.com.tecnosoftware.somos.repository;

import ar.com.tecnosoftware.somos.entity.Cargo;

import java.util.List;

public interface CargoRepository {

        public void guardar(Cargo cargo);

        public Cargo buscar(int id);

        public List<Cargo> buscarTodos();

        public void darBaja(Cargo cargo);

}
