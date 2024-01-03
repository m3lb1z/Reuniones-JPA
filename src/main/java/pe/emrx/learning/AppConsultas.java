package pe.emrx.learning;

import java.util.List;

import pe.emrx.learning.dao.SalaDao;
import pe.emrx.learning.dominio.Sala;

public class AppConsultas {
    
    public static void main(String[] args) {
        SalaDao salaDao = new SalaDao();

        List<Sala> salasPara4 = salaDao.findSalasParaN(4);
        System.out.println("Salas para 4 personas:" + salasPara4);

        List<Sala> salasPara3 = salaDao.findSalasParaN(3);
        System.out.println("Salas para 3 personas:" + salasPara3);

        List<Sala> salasAdecuadasPara3 = salaDao.findSalasAdecuadasParaN(3);
        System.out.println("Salas adecuadas para 3 personas: " + salasAdecuadasPara3);
    }
}
