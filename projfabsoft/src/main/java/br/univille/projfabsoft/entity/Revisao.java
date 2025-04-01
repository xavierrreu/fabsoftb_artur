package br.univille.projfabsoft.entity;

import java.util.List;

public class Revisao {
    private Long id;
    private Cliente cliente;
    private Carro carro;
    private String dataEntrada;
    private String dataSaida;
    private Double valor;
    private List<Peca> pecasTrocadas;
    private List<Servico> servicosRealizados;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public List<Peca> getPecasTrocadas() {
        return pecasTrocadas;
    }

    public void setPecasTrocadas(List<Peca> pecasTrocadas) {
        this.pecasTrocadas = pecasTrocadas;
    }

    public List<Servico> getServicosRealizados() {
        return servicosRealizados;
    }

    public void setServicosRealizados(List<Servico> servicosRealizados) {
        this.servicosRealizados = servicosRealizados;
    }
}