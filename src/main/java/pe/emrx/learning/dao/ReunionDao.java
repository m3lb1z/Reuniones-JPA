package pe.emrx.learning.dao;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import pe.emrx.learning.dominio.Persona;
import pe.emrx.learning.dominio.Reunion;

public class ReunionDao extends AbstractDao<Reunion> {
    
    public ReunionDao() {
        setClazz(Reunion.class);
    }

    public Reunion proximaReunion() {
        String queryString = "FROM " + Reunion.class.getName() + " WHERE fecha > now() order by fecha ";
        Query query = getEntityManager().createQuery(queryString).setMaxResults(1);
        return (Reunion) query.getSingleResult();
    }

    public List<Reunion> reunionesManyana() {
        String qlString = "FROM " + Reunion.class.getName() + " WHERE fecha between ?1 and ?2";
        Query query = getEntityManager().createQuery(qlString);
        LocalDate manyana = LocalDate.now().plus(1, ChronoUnit.DAYS);
        query.setParameter(1, manyana.atStartOfDay());
        query.setParameter(2, manyana.plus(1, ChronoUnit.DAYS).atStartOfDay());
        return query.getResultList();
    }

    public List<Reunion> reunionesParticipante(String numEmple) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Reunion> criteriaQuery = cb.createQuery(Reunion.class);

        Root<Persona> fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.where(cb.equal(fromPersona.get("numeroEmpleado"), numEmple));

        Join<Persona, Reunion> joinReunion = fromPersona.join("reuniones", JoinType.INNER);

        CriteriaQuery<Reunion> cq = criteriaQuery.multiselect(joinReunion);
        TypedQuery<Reunion> query = getEntityManager().createQuery(cq);
        return query.getResultList();
    }
}
