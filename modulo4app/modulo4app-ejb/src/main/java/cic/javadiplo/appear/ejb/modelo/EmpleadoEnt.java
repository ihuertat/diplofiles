package cic.javadiplo.appear.ejb.modelo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Empleado")
public class EmpleadoEnt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional=false)
    @Column(name="id")
    private Integer id;

    @Column(name="nombre", nullable = false ,length = 45)
    private String nombre;

    @Column(name="salario", nullable = false)
    private Double salario;

    @Column(name="correo",length = 45)
    private String correo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="departamento")
    private DepartamentoEnt departamento;

    @ManyToMany
    @JoinTable(name="EmpleadosProyecto",
            joinColumns = @JoinColumn(name="idEmpleado"),
            inverseJoinColumns = @JoinColumn(name="idProyecto"))
    private Set<ProyectoEnt> proyectos = new LinkedHashSet<>();

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

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public DepartamentoEnt getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoEnt departamento) {
        this.departamento = departamento;
    }

    public Set<ProyectoEnt> getProyectos() {
        return proyectos;
    }

    public void setProyectos(Set<ProyectoEnt> proyectos) {
        this.proyectos = proyectos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpleadoEnt that = (EmpleadoEnt) o;
        return id.equals(that.id) && nombre.equals(that.nombre) && salario.equals(that.salario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, salario);
    }

    @Override
    public String toString() {
        return "EmpleadoEnt{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", salario=" + salario +
                ", correo='" + correo + '\'' +
                ", departamento=" + departamento +
                '}';
    }
}
