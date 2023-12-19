package br.com.ts.venda.de.ingressos.de.cinema.entidades;

public class Assento {
    private String numero;
    private Boolean DBOX;
    private Boolean disponivel;
    private Cliente cliente;

    public Assento(String numero, Boolean DBOX, Boolean disponivel, Cliente cliente) {
        this.numero = numero;
        this.DBOX = DBOX;
        this.disponivel = disponivel;
        this.cliente = cliente;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Boolean getDBOX() {
        return DBOX;
    }

    public void setDBOX(Boolean DBOX) {
        this.DBOX = DBOX;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
