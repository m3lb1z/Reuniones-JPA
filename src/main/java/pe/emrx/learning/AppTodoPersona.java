package pe.emrx.learning;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import pe.emrx.learning.dao.PersonaDao;
import pe.emrx.learning.dominio.Acta;
import pe.emrx.learning.dominio.Persona;
import pe.emrx.learning.dominio.Reunion;
import pe.emrx.learning.dominio.Sala;

public class AppTodoPersona {
    
    public static void main(String[] args) {
        PersonaDao personaDao = new PersonaDao();

        Optional<Persona> optPersona = personaDao.get(1);
        if (optPersona.isPresent()) {
            Persona p = optPersona.get();
            System.out.println(p);

            Set<Reunion> reuniones = p.getReuniones();
            System.out.println(reuniones);

            Set<Sala> salas = new HashSet<>();
            Set<Persona> compis = new HashSet<>();
            Set<Acta> actas = new HashSet<>();

            for (Reunion reunion : reuniones) {
                salas.add(reunion.getSala());
                compis.addAll(reunion.getParticipantes());
                actas.add(reunion.getActa());
            }
            
            System.out.println("Salas: " + salas);
            System.out.println("Compis: " + compis);
            System.out.println("Actas: " + actas);
        }
    }
}
