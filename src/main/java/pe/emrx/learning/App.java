package pe.emrx.learning;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.NoResultException;

import pe.emrx.learning.dao.ReunionDao;
import pe.emrx.learning.dominio.Reunion;

public class App 
{
    public static void main( String[] args )
    {
        ReunionDao dao = new ReunionDao();
        List<Reunion> reuniones2 = dao.getAll();
        System.out.println("*** " + reuniones2);

        //Reunion reunion = new Reunion(LocalDateTime.now().plusDays(2), "Reunión de pasado mañana");
        /* 
        Reunion reunion = new Reunion(LocalDateTime.now().plus(1, ChronoUnit.DAYS), "Reunión de mañana");
        System.out.println(reunion);
        dao.save(reunion);
        System.out.println(reunion);
        */
        try{
            System.out.println("Tu proxima reunion es: " + dao.proximaReunion());
        } catch (NoResultException nre) {
            System.out.println("No tiene ninguna reunión a la vista");
        }

        List<Reunion> reunionesManyana = dao.reunionesManyana();
        System.out.println("Para mañana: " + reunionesManyana);
    }
}
