package uesocc.edu.sv.tpi2018.ejb.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import uesocc.edu.sv.tpi2018.ejb.entities.OrdenTrabajo;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-03-27T14:34:26")
@StaticMetamodel(Prioridad.class)
public class Prioridad_ { 

    public static volatile SingularAttribute<Prioridad, String> descripcion;
    public static volatile ListAttribute<Prioridad, OrdenTrabajo> ordenTrabajoList;
    public static volatile SingularAttribute<Prioridad, Integer> idPrioridad;
    public static volatile SingularAttribute<Prioridad, String> nombre;

}