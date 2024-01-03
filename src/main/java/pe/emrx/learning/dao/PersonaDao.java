package pe.emrx.learning.dao;

import pe.emrx.learning.dominio.Persona;

public class PersonaDao extends AbstractDao<Persona> {
    
    public PersonaDao() {
        setClazz(Persona.class);
    }

}
