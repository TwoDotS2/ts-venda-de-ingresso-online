package br.com.ts.venda.de.ingressos.de.cinema.entidades;

import br.com.ts.venda.de.ingressos.de.cinema.enums.*;

public class Compra {
    private Sessao sessao;
    private Cliente cliente;
    private float preco;
    private String codigoAssento;

    public Compra(Sessao sessao, Cliente cliente, float preco, String codigoAssento) {
        this.sessao = sessao;
        this.cliente = cliente;
        this.preco = preco;
        this.codigoAssento = codigoAssento;
    }
    public Ingresso comprarIngresso(){

        if(!sessao.assentoEstaDisponivel(codigoAssento)){
            throw new RuntimeException("Assento não está disponível");
        }

        long idade = cliente.calcularIdade();
        long faixaEtaria = sessao.filme().faixaEtaria().getClassificacaoIndicativa();

        if(idade < faixaEtaria){
            throw new RuntimeException("Idade menor que o esperado. Verifique a classificação indicativa!");
        }

        definirPrecoDoIngresso();

        CategoriaCliente categoriaCliente = cliente.categoria();
        if (categoriaCliente == CategoriaCliente.ESTUDANTE) {
            preco = preco / 2;
        }

        return new Ingresso(sessao.sala().numero(), categoriaCliente, codigoAssento, sessao.data(), sessao.horario());
    }

    private void definirPrecoDoIngresso() {
        TipoDia tipoDia = sessao.tipoDia();
        TipoSala tipoSala = sessao.sala().tipoSala();
        boolean assentoEhDBOX = sessao.sala().assentoEhDBOX(codigoAssento);

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

        }else if(tipoDia == TipoDia.SEXTA || tipoDia == TipoDia.SABADO || tipoDia == TipoDia.DOMINGO
                || tipoDia == TipoDia.FERIADO || tipoDia == TipoDia.PRE_ESTREIA){
            if (tipoSala == TipoSala._2D){
                preco = assentoEhDBOX? Preco.FIM_SEMANA_2D_DBOX.getPreco() : Preco.FIM_SEMANA_2D.getPreco();

            } else {
                preco = assentoEhDBOX? Preco.FIM_SEMANA_3D_DBOX.getPreco() : Preco.FIM_SEMANA_3D.getPreco();

            }
        }
    }

    public Sessao sessao() {
        return sessao;
    }

    public Cliente cliente() {
        return cliente;
    }

    public float preco() {
        return preco;
    }

    public String codigoAssento() {
        return codigoAssento;
    }

    @Override
    public String toString() {
        return "Compra{" + "\n" +
                " sessao=" + sessao.toString() + "\n" +
                " cliente=" + cliente.toString() + "\n" +
                " preco=" + preco + "\n" +
                " codigoAssento=" + codigoAssento + "\n" +
                "}";
    }
}
