package br.univille.projfabsoft.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id;
    @Column(length = 200, nullable = false)
    private String nome;
    private String email;
    @Column(length = 20000)
    private String historicoProfissional;
    @Column(length = 20000)
    private String qualificacoes;
    @Column(length = 20000)
    private String areasDeInteresse;
    @OneToMany
    private List<Projeto> projeto;
    @OneToOne
    private PlanoDeAssinatura planoAssinado;
    @OneToMany
    private List<Curso> cursosInscrito;
    @OneToMany
    private List<TesteDeHabilidade> testesFeitos;
    

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHistoricoProfissional() {
        return historicoProfissional;
    }

    public void setHistoricoProfissional(String historicoProfissional) {
        this.historicoProfissional = historicoProfissional;
    }

    public String getQualificacoes() {
        return qualificacoes;
    }

    public void setQualificacoes(String qualificacoes) {
        this.qualificacoes = qualificacoes;
    }

    public String getAreasDeInteresse() {
        return areasDeInteresse;
    }

    public void setAreasDeInteresse(String areasDeInteresse) {
        this.areasDeInteresse = areasDeInteresse;
    }
}
