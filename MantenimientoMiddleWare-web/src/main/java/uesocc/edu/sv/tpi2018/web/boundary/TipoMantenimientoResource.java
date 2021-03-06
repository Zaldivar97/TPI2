/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.tpi2018.web.boundary;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import uesocc.edu.sv.tpi2018.ejb.controller.AbstractInterface;
import uesocc.edu.sv.tpi2018.ejb.controller.TipoMantenimientoFacadeLocal;
import uesocc.edu.sv.tpi2018.ejb.entities.TipoMantenimiento;

/**
 *
 * @author danm
 */
@Path("tipomantenimiento")
public class TipoMantenimientoResource extends AbstractResource<TipoMantenimiento> implements FindByName<TipoMantenimiento>{

    @EJB
    TipoMantenimientoFacadeLocal tmfl;
    
    @Override
    protected AbstractInterface<TipoMantenimiento> getFacade() {
        return tmfl;
    }

    @Override
    protected TipoMantenimiento crearNuevo() {
        return new TipoMantenimiento();
    }

    @Override
    public AbstractInterface<TipoMantenimiento> getFacadeName() {
        return tmfl;
    }
    
    
}
