package com.trabajo_final.trabajo_final.persistence.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "autos_empleados")
public class AutoEmpleado {
    @Id
    private String id;
    @DBRef
    private Auto autoId;
    @DBRef
    private Empleado empleadoId;
    @DBRef
    private Reparacion reparacionId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Auto getAutoId() {
        return autoId;
    }

    public void setAutoId(Auto autoId) {
        this.autoId = autoId;
    }

    public Empleado getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Empleado empleadoId) {
        this.empleadoId = empleadoId;
    }

    public Reparacion getReparacionId() {
        return reparacionId;
    }

    public void setReparacionId(Reparacion reparacionId) {
        this.reparacionId = reparacionId;
    }
}
