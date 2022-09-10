package cic.javadiplo.appear.ejb.servicios;

import cic.javadiplo.appear.ejb.exception.SaveEntityException;
import cic.javadiplo.appear.ejb.modelo.ProductoEnt;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface ProductoServiceLocal {
    List<ProductoEnt> listar();
    public ProductoEnt crear(ProductoEnt entity) throws SaveEntityException;
    public ProductoEnt actualiza(ProductoEnt entity);
    public void borrar(ProductoEnt entity);
}
