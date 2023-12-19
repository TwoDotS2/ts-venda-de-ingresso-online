package br.com.ts.venda.de.ingressos.de.cinema.entidades;

import br.com.ts.venda.de.ingressos.de.cinema.enums.CategoriaCliente;
import br.com.ts.venda.de.ingressos.de.cinema.enums.Preco;
import br.com.ts.venda.de.ingressos.de.cinema.enums.TipoDia;
import br.com.ts.venda.de.ingressos.de.cinema.enums.TipoSala;

public class Compra {
    public Sessao sessao;
    public Cliente cliente;
    public float preco;
    public String codigoAssento;

    public Compra(){}

    public Compra(Sessao sessao, Cliente cliente, float preco, String codigoAssento) {
        this.sessao = sessao;
        this.cliente = cliente;
        this.preco = preco;
        this.codigoAssento = codigoAssento;
    }

    public Ingresso comprarIngresso(String codigoAssento){

        if(!sessao.assentoEstaDisponivel(codigoAssento)){
            throw new RuntimeException("Assento não está disponível");
        }

        long idade = cliente.calcularIdade();
        long faixaEtaria = sessao.getFilme().getFaixaEtaria();

        if(idade < faixaEtaria){
            throw new RuntimeException("Idade menor que o esperado. Verifique a classificação indicativa!");
        }

        definirPrecoDoIngresso();

        CategoriaCliente categoriaCliente = cliente.getCategoria();
        if (categoriaCliente == CategoriaCliente.ESTUDANTE) {
            preco = preco / 2;
        }

        return new Ingresso(sessao.getSala().getNumero(), categoriaCliente, codigoAssento, sessao.getData(), sessao.getHorario());
    }

    private void definirPrecoDoIngresso() {
        TipoDia tipoDia = sessao.getTipoDia();
        TipoSala tipoSala = sessao.getSala().getTipoSala();
        boolean assentoEhDBOX = sessao.getSala().assentoEhDBOX(codigoAssento);

        if(tipoDia == TipoDia.SEGUNDA || tipoDia == TipoDia.TERCA || tipoDia == TipoDia.QUARTA){
            if(tipoSala == TipoSala._2D){
                preco = assentoEhDBOX? Preco.INICIO_SEMANA_2D_DBOX.getPreco() : Preco.INICIO_SEMANA_2D.getPreco();

            } else {
                preco = assentoEhDBOX? Preco.INICIO_SEMANA_3D_DBOX.getPreco() : Preco.INICIO_SEMANA_3D.getPreco();

            }

        } else if(tipoDia == TipoDia.QUINTA){
            if(tipoSala == TipoSala._2D){
                preco = assentoEhDBOX? Preco.MEIO_SEMANA_2D_DBOX.getPreco() : Preco.MEIO_SEMANA_2D.getPreco();

            } else {
                preco = assentoEhDBOX? Preco.MEIO_SEMANA_3D_DBOX.getPreco() : Preco.MEIO_SEMANA_3D.getPreco();

            }

        } else if(tipoDia == TipoDia.SEXTA || tipoDia == TipoDia.SABADO || tipoDia == TipoDia.DOMINGO
                || tipoDia == TipoDia.FERIADO || tipoDia == TipoDia.PRE_ESTREIA){
            if (tipoSala == TipoSala._2D){
                preco = assentoEhDBOX? Preco.FIM_SEMANA_2D_DBOX.getPreco() : Preco.FIM_SEMANA_2D.getPreco();

            } else {
                preco = assentoEhDBOX? Preco.FIM_SEMANA_3D_DBOX.getPreco() : Preco.FIM_SEMANA_3D.getPreco();

            }
        }
    }
}
