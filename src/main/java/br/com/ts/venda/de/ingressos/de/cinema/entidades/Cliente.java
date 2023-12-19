package br.com.ts.venda.de.ingressos.de.cinema.entidades;

import br.com.ts.venda.de.ingressos.de.cinema.enums.CategoriaCliente;
import br.com.ts.venda.de.ingressos.de.cinema.enums.TipoBeneficio;

import java.time.LocalDate;
import java.util.Map;

public class Cliente {
    private CategoriaCliente categoria;
    private LocalDate dataNascimento;
    private String nomeCompleto;
    private String CPF;
    private String endereco;
    public Map.Entry<TipoBeneficio, Integer> beneficio;

    public Cliente(CategoriaCliente categoria, LocalDate dataNascimento, String nomeCompleto, String CPF, String endereco, Map.Entry<TipoBeneficio,Integer> beneficio) {
        this.categoria = categoria;
        this.dataNascimento = dataNascimento;
        this.nomeCompleto = nomeCompleto;
        this.CPF = CPF;
        this.endereco = endereco;
        this.beneficio = beneficio;
    }

    public CategoriaCliente getCategoriaCliente() {
        return categoria;
    }

    public void setCategoriaCliente(CategoriaCliente categoria) {
        this.categoria = categoria;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Map.Entry<TipoBeneficio, Integer> getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(Map.Entry<TipoBeneficio, Integer> beneficio) {
        this.beneficio = beneficio;
    }

    public void decrementaBeneficio(){
        if(beneficio.getValue()>0){
            beneficio.setValue(beneficio.getValue()-1);
        }
    }


}
