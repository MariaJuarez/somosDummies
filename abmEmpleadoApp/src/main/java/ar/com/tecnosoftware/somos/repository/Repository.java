package ar.com.tecnosoftware.somos.repository;

import java.util.List;

public interface Repository<T>{

    void guardar(T t);

    T buscar(int id);

    List<T> buscar(String extension);

    void darBaja(T t);

}
