package uesocc.edu.sv.tpi2018.ejb.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uesocc.edu.sv.tpi2018.ejb.entities.Equipo;
import uesocc.edu.sv.tpi2018.ejb.entities.ModeloDetalle;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-04-02T15:56:29")
@StaticMetamodel(Modelo.class)
public class Modelo_ { 

    public static volatile SingularAttribute<Modelo, String> descripcion;
    public static volatile ListAttribute<Modelo, Equipo> equipoList;
    public static volatile SingularAttribute<Modelo, Integer> idModelo;
    public static volatile ListAttribute<Modelo, ModeloDetalle> modeloDetalleList;
    public static volatile SingularAttribute<Modelo, String> nombre;
    public static volatile SingularAttribute<Modelo, Boolean> activo;

}