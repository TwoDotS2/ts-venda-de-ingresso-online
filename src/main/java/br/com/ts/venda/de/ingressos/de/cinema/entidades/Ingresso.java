package br.com.ts.venda.de.ingressos.de.cinema.entidades;

import br.com.ts.venda.de.ingressos.de.cinema.enums.CategoriaCliente;
import br.com.ts.venda.de.ingressos.de.cinema.enums.TipoBeneficio;
import br.com.ts.venda.de.ingressos.de.cinema.enums.TipoSala;

import java.time.LocalDate;

import static br.com.ts.venda.de.ingressos.de.cinema.enums.TipoDia.*;
import static java.lang.constant.ConstantDescs.NULL;

public class Ingresso {
    private Sessao sessao;
    private Cliente cliente;
    private float preco;
    private String codigoAssento;
    private Assento cadeiraEscolhida;

    public Ingresso(Sessao sessao, Cliente cliente, float preco, String assento) {
        this.sessao = sessao;
        this.cliente = cliente;
        this.preco = preco;
        this.codigoAssento = assento;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getAssento() {
        return codigoAssento;
    }

    public void setAssento(String assento) {this.codigoAssento = assento;
    }
    public void calculaPreco() {
        if(!checaClassficacaoIndicativa()){
            throw new RuntimeException("Cliente não pode assistir à sessão. Cheque a classificação indicativa.");
        };
        if(!checaDisponibilidadeAssento()){
            throw new RuntimeException("Assento escolhido já está ocupado. Por favor, escolha um outro assento.");
        };
        if (sessao.getSala().getTipoSala() == TipoSala._2D) {
            if (cadeiraEscolhida.getDBOX()) {
                if (sessao.getTipoDia() == SEGUNDA || sessao.getTipoDia() == TERCA
                        || sessao.getTipoDia() == QUARTA) {
                    preco = 41;
                }
                else if (sessao.getTipoDia() == QUINTA) {
                    preco = 60;
                }
                else {
                    preco = 63;
                }
            }
            else{
                if (sessao.getTipoDia() == SEGUNDA || sessao.getTipoDia() == TERCA
                        || sessao.getTipoDia() == QUARTA) {
                    preco = 27;
                }
                else if (sessao.getTipoDia() == QUINTA) {
                    preco = 40;
                }
                else {
                    preco = 42;
                }
            }
        }
        if(sessao.getSala().getTipoSala() == TipoSala._3D) {
            if (cadeiraEscolhida.getDBOX()) {
                if (sessao.getTipoDia() == SEGUNDA || sessao.getTipoDia() == TERCA
                        || sessao.getTipoDia() == QUARTA) {
                    preco = 48;
                }
                else if (sessao.getTipoDia() == QUINTA) {
                    preco = 70;

                } else {
                    preco = 74;
                }
            }
            else {
                if (sessao.getTipoDia() == SEGUNDA || sessao.getTipoDia() == TERCA
                        || sessao.getTipoDia() == QUARTA) {
                    preco = 34;
                }
                else if (sessao.getTipoDia() == QUINTA) {
                    preco = 46;
                } else {
                    preco = 49;
                }
            }
        }
        if(checaBeneficio()) preco = 0;
        if(cliente.getCategoriaCliente()==CategoriaCliente.ESTUDANTE) preco = preco / 2;
    }
    public Boolean checaClassficacaoIndicativa(){
        switch(sessao.getFilme().getFaixaEtaria()){
            case LIVRE: return true;
            case DEZMAIS: {
                if(cliente.getDataNascimento().getYear()+10<= LocalDate.now().getYear()){
                    return true;
                }
            };
            case DOZEMAIS:{
                if(cliente.getDataNascimento().getYear()+12<= LocalDate.now().getYear()){
                    return true;
                }
            };
            case QUATORZEMAIS:{
                if(cliente.getDataNascimento().getYear()+14<= LocalDate.now().getYear()){
                    return true;
                }
            };
            case DEZESSEISMAIS:{
                if(cliente.getDataNascimento().getYear()+16<= LocalDate.now().getYear()){
                    return true;
                }
            };
            case DEZOITOMAIS:{
                if(cliente.getDataNascimento().getYear()+18<= LocalDate.now().getYear()){
                    return true;
                }
            };
            default: return false;
        }
    };
    public Boolean checaDisponibilidadeAssento(){
        Boolean retorno = false;
        if(sessao.getSala().getAssentos().get(codigoAssento).getDisponivel()){
            cadeiraEscolhida = sessao.getSala().getAssentos().get(codigoAssento);
            retorno = true;
        }
        return retorno;
    };

    public Boolean checaBeneficio(){
        Boolean retorno = false;

        if(cliente.getBeneficio().getValue()>0 && !cadeiraEscolhida.getDBOX()){
            if(cliente.getBeneficio().getKey() == TipoBeneficio.NORMAL && sessao.getSala().getTipoSala()==TipoSala._2D){
                cliente.decrementaBeneficio();
                retorno = true;
            }
            else if(cliente.getBeneficio().getKey() == TipoBeneficio.BLACK){
                cliente.decrementaBeneficio();
                retorno = true;
            }
        }
        return retorno;
    };
}
