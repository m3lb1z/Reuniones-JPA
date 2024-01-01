package pe.emrx.learning.dominio;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    public Reunion() {
    }

    public Reunion(LocalDateTime fecha, String asunto) {
        this.fecha = fecha;
        this.asunto = asunto;
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

    @Override
    public String toString() {
        return "Reunion [id=" + id + ", fecha=" + fecha + ", asunto=" + asunto + "]";
    }

}
