package model;

import javax.persistence.*;

@Entity
@Table(name = "xogo")
public class Xogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "estudio")
    private String estudio;

    @Column(name = "descripcion")
    private String descripcion;

    public Xogo(Integer id, String nome, String estudio, String descripcion) {
        this.id = id;
        this.nome = nome;
        this.estudio = estudio;
        this.descripcion = descripcion;
    }

    public Xogo(String nome, String estudio, String descripcion) {
        this.nome = nome;
        this.estudio = estudio;
        this.descripcion = descripcion;
    }

    public Xogo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "\nXogo: " +
                "\nid: " + id +
                "\nnome: " + nome +
                "\nestudio: " + estudio+
                "\ndescripcion='" + descripcion;
    }
}