package ar.com.tecnosoftware.somos.cargo.service.impl;

import ar.com.tecnosoftware.somos.cargo.entity.Cargo;
import ar.com.tecnosoftware.somos.cargo.repository.CargoRepository;
import ar.com.tecnosoftware.somos.cargo.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public String add(Cargo cargo) {
        cargo.setBaja(false);
        cargoRepository.guardar(cargo);
        return "Cargo creado con exito";
    }

    @Override
    public Cargo buscar(int id) {
        return cargoRepository.buscar(id);
    }

    @Override
    public List<Cargo> buscarTodos() {
        return cargoRepository.buscar("");
    }

    @Override
    public List<Cargo> buscarNoBajas() {
        return cargoRepository.buscar("WHERE baja = false");
    }

    @Override
    public Cargo darBaja(int id) {

        Cargo cargo = cargoRepository.buscar(id);
        if (cargo == null){
            return null;
        }

        return cargoRepository.darBaja(cargo);
    }

    @Override
    public Cargo editar(Cargo cargo) {
        if (cargoRepository.buscar(cargo.getId()) == null){
            return null;
        }
        return cargoRepository.editar(cargo);
    }
}
