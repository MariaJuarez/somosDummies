package ar.com.tecnosoftware.somos.repository;

import java.util.List;

public interface Repository<T>{

    void guardar(T entity);

    T buscar(int id);

    List<T> buscarTodos();

    void darBaja(T entity);

}
