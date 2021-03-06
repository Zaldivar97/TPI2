/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.tpi2018.ejb.controller;

import java.util.List;
import javax.ejb.Local;
import uesocc.edu.sv.tpi2018.ejb.entities.Equipo;
import uesocc.edu.sv.tpi2018.ejb.entities.Solicitud;

/**
 *
 * @author irvin
 */
@Local
public interface SolicitudFacadeLocal extends AbstractInterface<Solicitud>{
    public List<Equipo> obtenerEstado(int id);
    public List<Object[]> pasosCompletados(int id);
}
