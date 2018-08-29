package ar.com.tecnosoftware.somos.service;

import java.util.List;

public interface Service<T> {

    String add(T t);

    List<T> buscarTodos();

    T darBaja(int id);

    T buscar(int id);

    List<T> buscarNoBajas();

    T editar(T t);

}
