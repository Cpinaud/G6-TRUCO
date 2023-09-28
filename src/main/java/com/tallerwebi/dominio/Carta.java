package com.tallerwebi.dominio;

import com.tallerwebi.dominio.Palo;

import javax.persistence.*;

@Entity
@Table(name = "Carta")
public class Carta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nro")
    private int nro;

    @ManyToOne
    @JoinColumn(name = "palo_id") // Asegúrate de que este nombre coincida con la columna en tu base de datos
    private Palo palo;

    @Column(name = "valor")
    private int valor;

    @Column(name = "imagen")
    private String imagen;

    public Carta() {
        // Constructor vacío requerido por Hibernate
    }

    public Carta(int nro, Palo palo, int valor, String imagen) {
        this.nro = nro;
        this.palo = palo;
        this.valor = valor;
        this.imagen = imagen;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public Palo getPalo() {
        return palo;
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Carta [id=" + id + ", nro=" + nro + ", palo=" + palo + ", valor=" + valor + ", imagen=" + imagen + "]";
    }
}
