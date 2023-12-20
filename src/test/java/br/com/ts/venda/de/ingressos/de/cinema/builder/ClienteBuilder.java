package br.com.ts.venda.de.ingressos.de.cinema.builder;

import br.com.ts.venda.de.ingressos.de.cinema.entidades.Cliente;
import br.com.ts.venda.de.ingressos.de.cinema.enums.CategoriaCliente;
import br.com.ts.venda.de.ingressos.de.cinema.enums.TipoBeneficio;

import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.Map;

public class ClienteBuilder {
    private CategoriaCliente categoria = CategoriaCliente.VISITANTE;
    private LocalDate dataNascimento = LocalDate.of(2000, 2, 2);
    private String nomeCompleto = "Fulano da Silva";
    private String CPF = "00000000000";
    private String endereco = "Avenida Salgado Filho";

    public static ClienteBuilder umCliente(){ return new ClienteBuilder(); }

    public ClienteBuilder comCategoria(CategoriaCliente categoria){
        this.categoria = categoria;
        return this;
    }
    public ClienteBuilder comEstudante(){
        this.categoria = CategoriaCliente.ESTUDANTE;
        return this;
    }

    public ClienteBuilder comDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
        return this;
    }

    public ClienteBuilder comNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public ClienteBuilder comCPF(String CPF) {
        this.CPF = CPF;
        return this;
    }

    public ClienteBuilder comEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }


    public Cliente build() {
        return new Cliente(categoria, dataNascimento, nomeCompleto, CPF, endereco);
    }
}
