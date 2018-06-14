/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.tpi2018.web.boundary;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.persistence.EntityExistsException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import uesocc.edu.sv.tpi2018.ejb.controller.AbstractInterface;
import uesocc.edu.sv.tpi2018.ejb.controller.SolicitudFacadeLocal;
import uesocc.edu.sv.tpi2018.ejb.entities.Equipo;
import uesocc.edu.sv.tpi2018.ejb.entities.Modelo;
import uesocc.edu.sv.tpi2018.ejb.entities.Solicitud;
import uesocc.edu.sv.tpi2018.web.exceptions.ControllerException;

/**
 *
 * @author andrea
 */
@Path("solicitud")
public class SolicitudResource extends AbstractResource<Solicitud> {

    @EJB
    SolicitudFacadeLocal sfl;

    @Override
    protected AbstractInterface<Solicitud> getFacade() {
        return sfl;
    }

    @Override
    protected Solicitud crearNuevo() {
        return new Solicitud();
    }

    @GET
    @Path("{id}/estado")
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public List<Equipo> obtenerEstado(@PathParam("id") int id){
        return sfl.obtenerEstado(id);
    }

    
    @POST
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public Solicitud create(JsonObject registro) throws Exception {//en vez de T Object
        if (registro != null) {//igual cero 0 y areglar registro != null && registro.getidtipoDoc == null
            ObjectMapper om = new ObjectMapper();
            
            List<Equipo> equipos = om.readValue(registro.getString("equipoList"), new TypeReference<List<Equipo>>(){});
            equipos.forEach((equipo) -> {
                System.out.println(equipo);
            });
            System.out.println(equipos);
            Solicitud soli = new Solicitud();
            soli.setSolicitante(registro.getString("solicitante"));
            soli.setUnidad(registro.getString("unidad"));
            soli.setEquipoList(equipos);
            System.out.println("Antes de persistir: "+soli.toString());
            if (getFacade() != null) {
                try {
                    Solicitud r = getFacade().create(soli);
                    r= getFacade().edit(soli);
                    if (r != null) {
                        System.out.println(r.toString() + "Despues de persistir");
                        return r;
                    }
                    throw new ControllerException(ControllerException.Message.REGISTRO_NO_CREADO);
                } catch (EntityExistsException e) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                    throw new ControllerException(ControllerException.Message.REGISTRO_REPETIDO);
                }

            }
            throw new NullPointerException("Facade null");
        }
        throw new ControllerException(ControllerException.Message.FALTA_CAMPO_REQUERIDO);

    }
        
}
