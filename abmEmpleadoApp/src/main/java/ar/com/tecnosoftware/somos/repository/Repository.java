package ar.com.tecnosoftware.somos.repository;

import java.util.List;

public interface Repository<T>{

    void guardar(T t);

    T buscar(int id);

    List<T> buscar(String extension);

    T darBaja(T t);

    T editar(T t);

}
