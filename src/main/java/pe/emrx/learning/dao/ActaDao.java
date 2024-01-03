package pe.emrx.learning.dao;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import pe.emrx.learning.dominio.Acta;
import pe.emrx.learning.dominio.Reunion;

public class ActaDao extends AbstractDao<Acta> {
    
    public ActaDao() {
        setClazz(Acta.class);
    }

    public List<Acta> findActasReunionesAntiguasQuery() {
        String qlString = "FROM " + Acta.class.getName() + " a WHERE a.reunion.fecha < :ayer";
        //LocalDateTime ayer = LocalDateTime.now().minusDays(1);
        LocalDateTime hoy = LocalDateTime.now();
        
        Query query = getEntityManager().createQuery(qlString);
        query.setParameter("ayer", hoy);
        return query.getResultList();
    }

    public List<Acta> findActasReunionesAntiguasCriteria() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Acta> criteriaQuery = cb.createQuery(Acta.class);
        Root<Acta> rootActa = criteriaQuery.from(Acta.class);
        Join<Acta, Reunion> joinReunion = rootActa.join("reunion", JoinType.INNER);

        Predicate fechaAyer = cb.lessThan(joinReunion.get("fecha"), LocalDateTime.now().minusDays(1));
        criteriaQuery.where(fechaAyer);
        
        Query query = getEntityManager().createQuery(criteriaQuery);
        return query.getResultList();
    }
}
