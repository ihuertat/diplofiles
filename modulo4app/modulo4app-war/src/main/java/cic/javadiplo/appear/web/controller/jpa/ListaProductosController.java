package cic.javadiplo.appear.web.controller.jpa;

import cic.javadiplo.appear.ejb.modelo.DepartamentoEnt;
import cic.javadiplo.appear.ejb.modelo.ProductoEnt;
import cic.javadiplo.appear.ejb.servicios.CatalogosServiceLocal;
import cic.javadiplo.appear.ejb.servicios.ProductoServiceLocal;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value="listaProductosController")
@RequestScoped
public class ListaProductosController {
    private static final Logger logger = Logger.getLogger(ListaProductosController.class.getName());
    private String opcionMenu;
    private List<DepartamentoEnt> listaDepartamentos;

    private List<ProductoEnt> productosLista;

    @Inject
    private CatalogosServiceLocal catalogosServ;
    @Inject
    private ProductoServiceLocal productoService;

    @PostConstruct
    public void iniciaDatos(){
        listaDepartamentos = catalogosServ.getCatalogoDepartamentos();
        productosLista = productoService.listar();
        for(ProductoEnt producto : productosLista){
            logger.log(Level.INFO,"Producto: {0}",producto.getNombre());
        }
    }


    public List<ProductoEnt> getProductosLista() {
        return productosLista;
    }

    public void setProductosLista(List<ProductoEnt> productosLista) {
        this.productosLista = productosLista;
    }

    public String getOpcionMenu() {
        return opcionMenu;
    }

    public void setOpcionMenu(String opcionMenu) {
        this.opcionMenu = opcionMenu;
    }

    public List<DepartamentoEnt> getListaDepartamentos() {
        return listaDepartamentos;
    }

    public void setListaDepartamentos(List<DepartamentoEnt> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }
}
