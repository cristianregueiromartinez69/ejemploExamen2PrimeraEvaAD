package model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "inventariotenda")
public class Inventariotenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idxogo")
    private Xogo idxogo;

    @Column(name = "prezomayorista", precision = 10, scale = 2)
    private BigDecimal prezomayorista;

    @Column(name = "prezotenda", precision = 10, scale = 2)
    private BigDecimal prezotenda;

    @Column(name = "porcentaxeoferta")
    private Integer porcentaxeoferta;

    public Inventariotenda(Integer id, Xogo idxogo, BigDecimal prezomayorista, BigDecimal prezotenda, Integer porcentaxeoferta) {
        this.id = id;
        this.idxogo = idxogo;
        this.prezomayorista = prezomayorista;
        this.prezotenda = prezotenda;
        this.porcentaxeoferta = porcentaxeoferta;
    }

    public Inventariotenda(Xogo idxogo, BigDecimal prezomayorista, BigDecimal prezotenda, Integer porcentaxeoferta) {
        this.idxogo = idxogo;
        this.prezomayorista = prezomayorista;
        this.prezotenda = prezotenda;
        this.porcentaxeoferta = porcentaxeoferta;
    }

    public Inventariotenda() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Xogo getIdxogo() {
        return idxogo;
    }

    public void setIdxogo(Xogo idxogo) {
        this.idxogo = idxogo;
    }

    public BigDecimal getPrezomayorista() {
        return prezomayorista;
    }

    public void setPrezomayorista(BigDecimal prezomayorista) {
        this.prezomayorista = prezomayorista;
    }

    public BigDecimal getPrezotenda() {
        return prezotenda;
    }

    public void setPrezotenda(BigDecimal prezotenda) {
        this.prezotenda = prezotenda;
    }

    public Integer getPorcentaxeoferta() {
        return porcentaxeoferta;
    }

    public void setPorcentaxeoferta(Integer porcentaxeoferta) {
        this.porcentaxeoferta = porcentaxeoferta;
    }


    @Override
    public String toString() {
        return "\nInventariotenda: " +
                "\nid: " + id +
                "\nidxogo: " + idxogo +
                "\nprezomayorista: " + prezomayorista +
                "\nprezotenda: " + prezotenda +
                "\nporcentaxeoferta: " + porcentaxeoferta;
    }
}