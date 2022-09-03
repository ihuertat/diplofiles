package cic.javadiplo.appear.ejb.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name="producto")
public class ProductoEnt {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Basic(optional=false)
    @Column(name="id")
    private Integer id;

    @Basic(optional=false)
    @Size(max=45)
    @Column(name="nombre")
    private String nombre;

    @Basic(optional=false)
    @Size(max=45)
    @Column(name="descripcion")
    private String descripcion;

    @Column(name="precio")
    private Float precio;

    public ProductoEnt(){

    }

    public ProductoEnt(Integer id, String nombre, String descripcion, Float precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoEnt that = (ProductoEnt) o;
        return id.equals(that.id) && nombre.equals(that.nombre) && Objects.equals(descripcion, that.descripcion) && Objects.equals(precio, that.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion, precio);
    }
}
