package br.com.ts.venda.de.ingressos.de.cinema;

import br.com.ts.venda.de.ingressos.de.cinema.builder.*;
import br.com.ts.venda.de.ingressos.de.cinema.entities.Ingresso;
import br.com.ts.venda.de.ingressos.de.cinema.enums.CategoriaCliente;
import br.com.ts.venda.de.ingressos.de.cinema.enums.ClassificacaoIndicativa;
import br.com.ts.venda.de.ingressos.de.cinema.enums.TipoDia;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class Test {
    @ParameterizedTest
    @MethodSource("geraPedidoIngresso")
    void testaPrecoIngresso(Ingresso ingresso, Float precoEsperado){

        ingresso.calculaPreco();
        assertEquals(ingresso.getPreco(), precoEsperado);
    }

    @ParameterizedTest
    @MethodSource("geraPedidoComExcecao")
    void testaExcecaoIngresso(Ingresso ingresso, String excecaoEsperada){
        Exception excecao = assertThrows(Exception.class, ()->ingresso.calculaPreco());
        assertTrue(excecao.getMessage().contains(excecaoEsperada));
    }

    static Stream<Arguments> geraPedidoIngresso(){
        return Stream.of(Arguments.of(IngressoBuilder
                .umIngresso()
                .comSessao(SessaoBuilder.umaSessao()
                        .comSala(SalaBuilder.umaSala().build())
                        .comFilme(FilmeBuilder.umFilme().build())
                        .build())
                .comCliente(ClienteBuilder.umCliente().build())
                .build(), (float)40),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao()
                                .comSala(SalaBuilder.umaSala().com3d().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente().build())
                        .build(), (float)46),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.FERIADO)
                                .comSala(SalaBuilder.umaSala().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente().build())
                        .build(), (float)42),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.FERIADO)
                                .comSala(SalaBuilder.umaSala().com3d().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente().build())
                        .build(), (float)49),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao()
                                .comSala(SalaBuilder.umaSala().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente().build())
                                .comCodigoAssento("D7")
                        .build(), (float)60),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao()
                                .comSala(SalaBuilder.umaSala().com3d().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente().build())
                        .comCodigoAssento("E11")
                        .build(), (float)70),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.SEGUNDA)
                                .comSala(SalaBuilder.umaSala().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente().build())
                        .comCodigoAssento("E11")
                        .build(), (float)41),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.SEGUNDA)
                                .comSala(SalaBuilder.umaSala().com3d().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente().build())
                        .comCodigoAssento("E14")
                        .build(), (float)48),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.TERCA)
                                .comSala(SalaBuilder.umaSala().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente().build())
                        .comCodigoAssento("E11")
                        .build(), (float)41),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.TERCA)
                                .comSala(SalaBuilder.umaSala().com3d().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente().build())
                        .comCodigoAssento("E14")
                        .build(), (float)48),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.QUARTA)
                                .comSala(SalaBuilder.umaSala().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente().build())
                        .comCodigoAssento("E11")
                        .build(), (float)41),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.QUARTA)
                                .comSala(SalaBuilder.umaSala().com3d().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente().build())
                        .comCodigoAssento("E14")
                        .build(), (float)48),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.FERIADO)
                                .comSala(SalaBuilder.umaSala().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente().build())
                        .comCodigoAssento("E11")
                        .build(), (float)63),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.FERIADO)
                                .comSala(SalaBuilder.umaSala().com3d().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente().build())
                        .comCodigoAssento("E14")
                        .build(), (float)74),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao()
                                .comSala(SalaBuilder.umaSala().com3d().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente().build())
                        .comCodigoAssento("D11")
                        .build(), (float)70),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.SEGUNDA)
                                .comSala(SalaBuilder.umaSala().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente().build())
                        .build(), (float)27),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.SEGUNDA)
                                .comSala(SalaBuilder.umaSala().com3d().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente().build())
                        .build(), (float)34),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.TERCA)
                                .comSala(SalaBuilder.umaSala().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente().build())
                        .build(), (float)27),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.TERCA)
                                .comSala(SalaBuilder.umaSala().com3d().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente().build())
                        .build(), (float)34),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.QUARTA)
                                .comSala(SalaBuilder.umaSala().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente().build())
                        .build(), (float)27),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.QUARTA)
                                .comSala(SalaBuilder.umaSala().com3d().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente().build())
                        .build(), (float)34),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.SEGUNDA)
                                .comSala(SalaBuilder.umaSala().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente().comBeneficioNormal(2).build())
                        .build(), (float)0),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.QUARTA)
                                .comSala(SalaBuilder.umaSala().com3d().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente().comBeneficioNormal(2).build())
                        .build(), (float)34),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.QUARTA)
                                .comSala(SalaBuilder.umaSala().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente().comBeneficioBlack(2).build())
                        .comCodigoAssento("E15")
                        .build(), (float)41),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.QUARTA)
                                .comSala(SalaBuilder.umaSala().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente().comBeneficioBlack(2).build())
                        .build(), (float)0),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.QUARTA)
                                .comSala(SalaBuilder.umaSala().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente().comBeneficioNormal(2).build())
                        .build(), (float)0),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.QUARTA)
                                .comSala(SalaBuilder.umaSala().build())
                                .comFilme(FilmeBuilder.umFilme().build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente()
                                .comBeneficioNormal(2)
                                .comCategoria(CategoriaCliente.ESTUDANTE)
                                .build())
                        .build(), (float)0),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.QUARTA)
                                .comSala(SalaBuilder.umaSala().build())
                                .comFilme(FilmeBuilder.umFilme()
                                        .comFaixaEtaria(ClassificacaoIndicativa.DEZMAIS)
                                        .build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente()
                                .build())
                        .build(), (float)27),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.QUARTA)
                                .comSala(SalaBuilder.umaSala().build())
                                .comFilme(FilmeBuilder.umFilme()
                                        .comFaixaEtaria(ClassificacaoIndicativa.DOZEMAIS)
                                        .build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente()
                                .build())
                        .build(), (float)27),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.QUARTA)
                                .comSala(SalaBuilder.umaSala().build())
                                .comFilme(FilmeBuilder.umFilme()
                                        .comFaixaEtaria(ClassificacaoIndicativa.QUATORZEMAIS)
                                        .build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente()
                                .build())
                        .build(), (float)27),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.QUARTA)
                                .comSala(SalaBuilder.umaSala().build())
                                .comFilme(FilmeBuilder.umFilme()
                                        .comFaixaEtaria(ClassificacaoIndicativa.DEZESSEISMAIS)
                                        .build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente()
                                .build())
                        .build(), (float)27),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.QUARTA)
                                .comSala(SalaBuilder.umaSala().build())
                                .comFilme(FilmeBuilder.umFilme()
                                        .comFaixaEtaria(ClassificacaoIndicativa.DEZOITOMAIS)
                                        .build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente()
                                .build())
                        .build(), (float)27),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.QUARTA)
                                .comSala(SalaBuilder.umaSala().build())
                                .comFilme(FilmeBuilder.umFilme()
                                        .comFaixaEtaria(ClassificacaoIndicativa.DEZOITOMAIS)
                                        .build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente()
                                .comBeneficioBlack(0)
                                .build())
                        .build(), (float)27)
        );
    }
    public static Stream<Arguments> geraPedidoComExcecao() {
        return Stream.of(Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.QUARTA)
                                .comSala(SalaBuilder.umaSala().build())
                                .comFilme(FilmeBuilder.umFilme()
                                        .comFaixaEtaria(ClassificacaoIndicativa.DEZMAIS)
                                        .build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente()
                                .comDataNascimento(LocalDate.of(2020,10,10))
                                .build())
                        .build(), "Cliente não pode assistir à sessão. Cheque a classificação indicativa."),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.QUARTA)
                                .comSala(SalaBuilder.umaSala().build())
                                .comFilme(FilmeBuilder.umFilme()
                                        .comFaixaEtaria(ClassificacaoIndicativa.DOZEMAIS)
                                        .build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente()
                                .comDataNascimento(LocalDate.of(2018,5,1))
                                .build())
                        .build(), "Cliente não pode assistir à sessão. Cheque a classificação indicativa."),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.QUARTA)
                                .comSala(SalaBuilder.umaSala().build())
                                .comFilme(FilmeBuilder.umFilme()
                                        .comFaixaEtaria(ClassificacaoIndicativa.QUATORZEMAIS)
                                        .build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente()
                                .comDataNascimento(LocalDate.of(2018,10,10))
                                .build())
                        .build(), "Cliente não pode assistir à sessão. Cheque a classificação indicativa."),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.QUARTA)
                                .comSala(SalaBuilder.umaSala().build())
                                .comFilme(FilmeBuilder.umFilme()
                                        .comFaixaEtaria(ClassificacaoIndicativa.DEZESSEISMAIS)
                                        .build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente()
                                .comDataNascimento(LocalDate.of(2012,10,10))
                                .build())
                        .build(), "Cliente não pode assistir à sessão. Cheque a classificação indicativa."),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.QUARTA)
                                .comSala(SalaBuilder.umaSala().build())
                                .comFilme(FilmeBuilder.umFilme()
                                        .comFaixaEtaria(ClassificacaoIndicativa.DEZOITOMAIS)
                                        .build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente()
                                .comDataNascimento(LocalDate.of(2009,10,10))
                                .build())
                        .build(), "Cliente não pode assistir à sessão. Cheque a classificação indicativa."),
                Arguments.of(IngressoBuilder
                        .umIngresso()
                        .comSessao(SessaoBuilder.umaSessao().comTipoDia(TipoDia.QUARTA)
                                .comSala(SalaBuilder.umaSala()
                                        .comAssentoOcupado("A5")
                                        .build())
                                .comFilme(FilmeBuilder.umFilme()
                                        .build())
                                .build())
                        .comCliente(ClienteBuilder.umCliente()
                                .build())
                        .comCodigoAssento("A5")
                        .build(), "Assento escolhido já está ocupado. Por favor, escolha um outro assento.")
        );
    }
}
