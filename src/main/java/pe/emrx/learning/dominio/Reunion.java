package pe.emrx.learning.dominio;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reunion")
public class Reunion {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "fecha")
    private LocalDateTime fecha;
    @Column(name = "asunto")
    private String asunto;
    @ManyToOne(fetch = FetchType.LAZY)
    private Sala sala;

    @OneToOne(mappedBy = "reunion")
    private Acta acta;

    @ManyToMany(mappedBy = "reuniones", cascade = CascadeType.ALL)
    private Set<Persona> participantes;

    public Reunion() {
        participantes = new HashSet<>();
    }

    public Reunion(LocalDateTime fecha, String asunto) {
        this();
        this.fecha = fecha;
        this.asunto = asunto;
    }

    public Reunion(Reunion reunion) {
        this();
        this.fecha = reunion.fecha;
        this.asunto = reunion.asunto;
    }

    // getters and setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Acta getActa() {
        return acta;
    }

    public void setActa(Acta acta) {
        this.acta = acta;
    }

    public Set<Persona> getParticipantes() {
        return participantes;
    }

    public void addParticipante(Persona participante) {
        this.participantes.add(participante);
        if(!participante.getReuniones().contains(this)) {
            participante.addReunion(this);
        }
    }

    @Override
    public String toString() {
        return "Reunion [id=" + id + ", fecha=" + fecha + ", asunto=" + asunto + "]";
    }

}
