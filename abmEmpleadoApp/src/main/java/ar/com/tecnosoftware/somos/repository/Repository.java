package ar.com.tecnosoftware.somos.repository;

import java.util.List;

public interface Repository<T>{

    void guardar(T t);

    T buscar(int id);

    List<T> buscarTodos();

    void darBaja(T t);

}
