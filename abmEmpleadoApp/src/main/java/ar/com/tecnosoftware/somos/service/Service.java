package ar.com.tecnosoftware.somos.service;

import java.util.List;

public interface Service<T> {

    void add(T entity);

    List<T> buscarTodos();

    void darBaja(int id);

    T buscar(int id);

}
