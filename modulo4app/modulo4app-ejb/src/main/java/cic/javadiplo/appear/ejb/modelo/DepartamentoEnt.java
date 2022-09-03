package cic.javadiplo.appear.ejb.modelo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="Departamento")
public class DepartamentoEnt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional=false)
    @Column(name="id")
    private Integer id;

    @Column(name="nombre", nullable = false ,length = 45)
    private String nombre;

    @OneToMany(mappedBy = "departamento")
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
    public int hashCode() {
        return Objects.hash(id,nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || getClass()!= obj.getClass()){
            return false;
        }
        DepartamentoEnt otro = (DepartamentoEnt) obj;
        return id.equals(otro.id) && nombre.equals(otro.nombre);
    }

    @Override
    public String toString() {
        return "Departamento : "+id+":"+nombre;
    }
}
