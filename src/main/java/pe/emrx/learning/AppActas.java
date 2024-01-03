package pe.emrx.learning;

import java.util.List;

import pe.emrx.learning.dao.ActaDao;
import pe.emrx.learning.dominio.Acta;

public class AppActas {
    
    public static void main(String[] args) {
        ActaDao actaDao = new ActaDao();
        List<Acta> actasAntiguas = actaDao.findActasReunionesAntiguasQuery();
        System.out.println(actasAntiguas);
        System.out.println("Actas antiguas: " + actasAntiguas.size());
        
        List<Acta> actasAntiguasCriteria = actaDao.findActasReunionesAntiguasCriteria();
        System.out.println(actasAntiguasCriteria);
        System.out.println("Actas antiguas: " + actasAntiguasCriteria.size());

    }
}
