package cic.javadiplo.appear.ejb.modelo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="Proyecto")
public class ProyectoEnt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional=false)
    @Column(name="id")
    private Integer id;

    @Column(name="nombre", nullable = false ,length = 45)
    private String nombre;

    @ManyToMany
    @JoinTable(name="EmpleadosProyecto",
            joinColumns=@JoinColumn(name="idProyecto"),
            inverseJoinColumns = @JoinColumn(name = "idEmpleado"))
    private Set<EmpleadoEnt> empleados = new LinkedHashSet<>();

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

    public Set<EmpleadoEnt> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<EmpleadoEnt> empleados) {
        this.empleados = empleados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProyectoEnt that = (ProyectoEnt) o;
        return id.equals(that.id) && nombre.equals(that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    @Override
    public String toString() {
        return "ProyectoEnt{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
