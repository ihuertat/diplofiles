package cic.javadiplo.appear.ejb.servicios;

import cic.javadiplo.appear.ejb.modelo.ProductoEnt;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface ProductoServiceLocal {
    List<ProductoEnt> listar();
    public ProductoEnt crear(ProductoEnt entity);
    public ProductoEnt actualiza(ProductoEnt entity);
    public void borrar(ProductoEnt entity);
}
