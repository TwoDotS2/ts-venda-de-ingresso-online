package br.com.ts.venda.de.ingressos.de.cinema.builder;

import br.com.ts.venda.de.ingressos.de.cinema.entidades.Cliente;
import br.com.ts.venda.de.ingressos.de.cinema.entidades.Compra;
import br.com.ts.venda.de.ingressos.de.cinema.entidades.Ingresso;
import br.com.ts.venda.de.ingressos.de.cinema.entidades.Sessao;
import br.com.ts.venda.de.ingressos.de.cinema.enums.CategoriaCliente;
import br.com.ts.venda.de.ingressos.de.cinema.enums.ClassificacaoIndicativa;
import br.com.ts.venda.de.ingressos.de.cinema.enums.TipoDia;
import br.com.ts.venda.de.ingressos.de.cinema.enums.TipoSala;

import java.time.LocalDate;
import java.util.List;

public class CompraBuilder {
    private Sessao sessao = new SessaoBuilder().build();
    private Cliente cliente = new ClienteBuilder().build();
    private float preco = 100;
    private String codigoAssento = "A1";


    public static CompraBuilder umaCompra() {
        return new CompraBuilder();
    }

    public CompraBuilder comSessao(Sessao sessao) {
        this.sessao = sessao;
        return this;
    }

    public CompraBuilder comCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public CompraBuilder comPreco(float preco) {
        this.preco = preco;
        return this;
    }

    public CompraBuilder comCodigoAssento(String codigoAssento) {
        this.codigoAssento = codigoAssento;
        return this;
    }

    public CompraBuilder com_2d_MeiaEntrada_SegTerQuar(List<String> dbox){
        this.cliente = new ClienteBuilder().comCategoria(CategoriaCliente.ESTUDANTE).build();
        if(dbox.isEmpty()){
            this.sessao = new SessaoBuilder().comTipoDia(TipoDia.SEGUNDA).build();
        }
        else{
            this.sessao = new SessaoBuilder()
                    .comTipoDia(TipoDia.SEGUNDA)
                    .comSala(SalaBuilder.umaSala().comFileirasAssentosDBOX(dbox).build())
                    .build();
        }
        return this;
    }

    public CompraBuilder com_3d_MeiaEntrada_SegTerQuar(List<String> dbox){
        this.cliente = new ClienteBuilder().comCategoria(CategoriaCliente.ESTUDANTE).build();
        if(dbox.isEmpty()){
            this.sessao = new SessaoBuilder()
                    .comSala(SalaBuilder.umaSala().com3d().build())
                    .comTipoDia(TipoDia.TERCA)
                    .build();
        }
        else{
            this.sessao = new SessaoBuilder()
                    .comSala(SalaBuilder.umaSala().com3d().comFileirasAssentosDBOX(dbox).build())
                    .comTipoDia(TipoDia.TERCA)
                    .build();
        }
        return this;
    }

    public CompraBuilder com_2d_MeiaEntrada_Quinta(List<String> dbox){
        this.cliente = new ClienteBuilder().comCategoria(CategoriaCliente.ESTUDANTE).build();
        if(!dbox.isEmpty()){
            this.sessao = new SessaoBuilder()
                    .comSala(SalaBuilder.umaSala().comFileirasAssentosDBOX(dbox).build())
                    .build();
        }
        return this;
    }

    public CompraBuilder com_3d_MeiaEntrada_Quinta(List<String> dbox){
        this.cliente = new ClienteBuilder().comCategoria(CategoriaCliente.ESTUDANTE).build();
        if(!dbox.isEmpty()){
            this.sessao = new SessaoBuilder()
                    .comSala(SalaBuilder.umaSala().com3d().comFileirasAssentosDBOX(dbox).build())
                    .build();
        }
        else{
            this.sessao = new SessaoBuilder().comSala(SalaBuilder.umaSala().com3d().build()).build();
        }
        return this;
    }

    public CompraBuilder com_2d_MeiaEntrada_FdsFeriado(List<String> dbox){
        this.cliente = new ClienteBuilder().comCategoria(CategoriaCliente.ESTUDANTE).build();
        if(!dbox.isEmpty()){
            this.sessao = new SessaoBuilder()
                    .comSala(SalaBuilder.umaSala().comFileirasAssentosDBOX(dbox).build())
                    .comTipoDia(TipoDia.FERIADO)
                    .build();
        }
        else{
            this.sessao = new SessaoBuilder().comTipoDia(TipoDia.FERIADO).build();
        }
        return this;
    }

    public CompraBuilder com_3d_MeiaEntrada_FdsFeriado(List<String> dbox){
        this.cliente = new ClienteBuilder().comCategoria(CategoriaCliente.ESTUDANTE).build();
        if(!dbox.isEmpty()){
            this.sessao = new SessaoBuilder()
                    .comSala(SalaBuilder.umaSala().com3d().comFileirasAssentosDBOX(dbox).build())
                    .comTipoDia(TipoDia.SEXTA)
                    .build();
        }
        else{
            this.sessao = new SessaoBuilder()
                    .comSala(SalaBuilder.umaSala().com3d().build())
                    .comTipoDia(TipoDia.SEXTA)
                    .build();
        }
        return this;
    }

    public CompraBuilder com_2d_Inteira_SegTerQuar(List<String> dbox){
        if(!dbox.isEmpty()){
            this.sessao = new SessaoBuilder()
                    .comSala(SalaBuilder.umaSala().comFileirasAssentosDBOX(dbox).build())
                    .comTipoDia(TipoDia.QUARTA)
                    .build();
        }
        else{
            this.sessao = new SessaoBuilder().comTipoDia(TipoDia.QUARTA).build();
        }
        return this;
    }

    public CompraBuilder com_3d_Inteira_SegTerQuar(List<String> dbox){
        if(!dbox.isEmpty()){
            this.sessao = new SessaoBuilder()
                    .comSala(SalaBuilder.umaSala().com3d().comFileirasAssentosDBOX(dbox).build())
                    .comTipoDia(TipoDia.SEGUNDA)
                    .build();
        }
        else{
            this.sessao = new SessaoBuilder()
                    .comSala(SalaBuilder.umaSala().com3d().build())
                    .comTipoDia(TipoDia.SEGUNDA)
                    .build();
        }
        return this;
    }

    public CompraBuilder com_2d_Inteira_Quinta(List<String> dbox){
        if(!dbox.isEmpty()){
            this.sessao = new SessaoBuilder()
                    .comSala(SalaBuilder.umaSala().comFileirasAssentosDBOX(dbox).build())
                    .build();
        }
        return this;
    }

    public CompraBuilder com_3d_Inteira_Quinta(List<String> dbox){
        if(!dbox.isEmpty()){
            this.sessao = new SessaoBuilder()
                    .comSala(SalaBuilder.umaSala().com3d().comFileirasAssentosDBOX(dbox).build())
                    .build();
        }
        else{
            this.sessao = new SessaoBuilder().comSala(SalaBuilder.umaSala().com3d().build()).build();
        }
        return this;
    }

    public CompraBuilder com_2d_Inteira_FdsFeriado(List<String> dbox){
        if(!dbox.isEmpty()){
            this.sessao = new SessaoBuilder()
                    .comSala(SalaBuilder.umaSala().comFileirasAssentosDBOX(dbox).build())
                    .comTipoDia(TipoDia.SABADO)
                    .build();
        }
        else{
            this.sessao = new SessaoBuilder().comTipoDia(TipoDia.SABADO).build();
        }
        return this;
    }

    public CompraBuilder com_3d_Inteira_FdsFeriado(List<String> dbox){
        if(!dbox.isEmpty()){
            this.sessao = new SessaoBuilder()
                    .comSala(SalaBuilder.umaSala().com3d().comFileirasAssentosDBOX(dbox).build())
                    .comTipoDia(TipoDia.PRE_ESTREIA)
                    .build();
        }
        else{
            this.sessao = new SessaoBuilder()
                    .comSala(SalaBuilder.umaSala().com3d().build())
                    .comTipoDia(TipoDia.PRE_ESTREIA)
                    .build();
        }
        return this;
    }
    public CompraBuilder com_TipoSala_E_Dia_Especificos(TipoSala tiposala, TipoDia tipodia, List<String> dbox){
        if(!dbox.isEmpty()){
            this.sessao = new SessaoBuilder()
                    .comSala(SalaBuilder.umaSala().comTipoSala(tiposala).comFileirasAssentosDBOX(dbox).build())
                    .comTipoDia(tipodia)
                    .build();
        }
        else{
            this.sessao = new SessaoBuilder()
                    .comSala(SalaBuilder.umaSala().comTipoSala(tiposala).build())
                    .comTipoDia(tipodia)
                    .build();
        }
        return this;
    }

    public CompraBuilder com_Idade_E_Classificacao_Especificos(LocalDate nascimento, ClassificacaoIndicativa classificacaoIndicativa, List<String> dbox) {
        this.cliente = new ClienteBuilder().comDataNascimento(nascimento).build();
        if (!dbox.isEmpty()) {
            this.sessao = new SessaoBuilder()
                    .comSala(SalaBuilder.umaSala().comFileirasAssentosDBOX(dbox).build())
                    .comFilme(FilmeBuilder.umFilme().comFaixaEtaria(classificacaoIndicativa).build())
                    .build();
        }
        else{
            this.sessao = new SessaoBuilder()
                    .comFilme(FilmeBuilder.umFilme().comFaixaEtaria(classificacaoIndicativa).build())
                    .build();
        }
        return this;
    }



    public Compra build() {
        return new Compra(sessao, cliente, preco, codigoAssento);
    }
}
