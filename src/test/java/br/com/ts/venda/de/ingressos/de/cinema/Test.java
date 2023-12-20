package br.com.ts.venda.de.ingressos.de.cinema;

import br.com.ts.venda.de.ingressos.de.cinema.builder.*;
import br.com.ts.venda.de.ingressos.de.cinema.entidades.Compra;
import br.com.ts.venda.de.ingressos.de.cinema.entidades.Ingresso;
import br.com.ts.venda.de.ingressos.de.cinema.enums.CategoriaCliente;
import br.com.ts.venda.de.ingressos.de.cinema.enums.ClassificacaoIndicativa;
import br.com.ts.venda.de.ingressos.de.cinema.enums.TipoDia;
import br.com.ts.venda.de.ingressos.de.cinema.enums.TipoSala;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class Test {
    @ParameterizedTest
    @MethodSource("geraPedidoIngresso")
    void testaPrecoIngresso(Compra compra, Float precoEsperado){
        compra.comprarIngresso();
        assertEquals(compra.preco, precoEsperado);
    }

    @ParameterizedTest
    @MethodSource("geraPedidoComExcecao")
    void testaExcecaoIngresso(Compra compra, String excecaoEsperada){
        Exception excecao = assertThrows(Exception.class, ()->compra.comprarIngresso());
        assertTrue(excecao.getMessage().contains(excecaoEsperada));
    }

    static Stream<Arguments> geraPedidoIngresso(){
        return Stream.of(Arguments.of(CompraBuilder.umaCompra()
                .com_2d_MeiaEntrada_SegTerQuar(List.of())
                .build(),(float)13.5),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_2d_MeiaEntrada_Quinta(List.of())
                        .build(),(float)20),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_2d_MeiaEntrada_FdsFeriado(List.of())
                        .build(),(float)21),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_2d_Inteira_SegTerQuar(List.of())
                        .build(),(float)27),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_2d_Inteira_Quinta(List.of())
                        .build(),(float)40),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_2d_Inteira_FdsFeriado(List.of())
                        .build(),(float)42),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_3d_MeiaEntrada_SegTerQuar(List.of())
                        .build(),(float)17),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_3d_MeiaEntrada_Quinta(List.of())
                        .build(),(float)23),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_3d_MeiaEntrada_FdsFeriado(List.of())
                        .build(),(float)24.5),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_3d_Inteira_SegTerQuar(List.of())
                        .build(),(float)34),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_3d_Inteira_Quinta(List.of())
                        .build(),(float)46),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_3d_Inteira_FdsFeriado(List.of())
                        .build(),(float)49),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_2d_MeiaEntrada_SegTerQuar(List.of("A"))
                        .build(),(float)20.5),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_2d_MeiaEntrada_Quinta(List.of("A"))
                        .build(),(float)30),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_2d_MeiaEntrada_FdsFeriado(List.of("A"))
                        .build(),(float)31.5),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_2d_Inteira_SegTerQuar(List.of("A"))
                        .build(),(float)41),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_2d_Inteira_Quinta(List.of("A"))
                        .build(),(float)60),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_2d_Inteira_FdsFeriado(List.of("A"))
                        .build(),(float)63),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_3d_MeiaEntrada_SegTerQuar(List.of("A"))
                        .build(),(float)24),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_3d_MeiaEntrada_Quinta(List.of("A"))
                        .build(),(float)35),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_3d_MeiaEntrada_FdsFeriado(List.of("A"))
                        .build(),(float)37),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_3d_Inteira_SegTerQuar(List.of("A"))
                        .build(),(float)48),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_3d_Inteira_Quinta(List.of("A"))
                        .build(),(float)70),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_3d_Inteira_FdsFeriado(List.of("A"))
                        .build(),(float)74),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_TipoSala_E_Dia_Especificos(TipoSala._3D, TipoDia.DOMINGO, List.of())
                        .build(),(float)49),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_TipoSala_E_Dia_Especificos(TipoSala._2D, TipoDia.EMENDA, List.of())
                        .build(),(float)100),
                Arguments.of(CompraBuilder.umaCompra()
                                .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                                (2013,10,25),
                                                ClassificacaoIndicativa.DEZMAIS, List.of())
                        .build(),(float)40),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2012,10,25),
                                ClassificacaoIndicativa.DEZMAIS, List.of())
                        .build(),(float)40),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2011,10,25),
                                ClassificacaoIndicativa.DOZEMAIS, List.of())
                        .build(),(float)40),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2010,10,25),
                                ClassificacaoIndicativa.DOZEMAIS, List.of())
                        .build(),(float)40),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2009,10,25),
                                ClassificacaoIndicativa.QUATORZEMAIS, List.of())
                        .build(),(float)40),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2008,10,25),
                                ClassificacaoIndicativa.QUATORZEMAIS, List.of())
                        .build(),(float)40),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2007,10,25),
                                ClassificacaoIndicativa.DEZESSEISMAIS, List.of())
                        .build(),(float)40),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2006,10,25),
                                ClassificacaoIndicativa.DEZESSEISMAIS, List.of())
                        .build(),(float)40),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2005,10,25),
                                ClassificacaoIndicativa.DEZOITOMAIS, List.of())
                        .build(),(float)40),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2004,10,25),
                                ClassificacaoIndicativa.DEZOITOMAIS, List.of())
                        .build(),(float)40)
        );
    }

    public static Stream<Arguments> geraPedidoComExcecao() {
        return Stream.of(Arguments.of(CompraBuilder.umaCompra()
                        .com_3d_Inteira_FdsFeriado(List.of("A"))
                        .comCodigoAssento("A4")
                        .build(),"Assento não está disponível"),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2014,12,25),
                                ClassificacaoIndicativa.DEZMAIS, List.of())
                        .build(),"Idade menor que o esperado. Verifique a classificação indicativa!"),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2012,10,25),
                                ClassificacaoIndicativa.DOZEMAIS, List.of())
                        .build(),"Idade menor que o esperado. Verifique a classificação indicativa!"),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2010,10,25),
                                ClassificacaoIndicativa.QUATORZEMAIS, List.of())
                        .build(),"Idade menor que o esperado. Verifique a classificação indicativa!"),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2008,10,25),
                                ClassificacaoIndicativa.DEZESSEISMAIS, List.of())
                        .build(),"Idade menor que o esperado. Verifique a classificação indicativa!"),
                Arguments.of(CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2006,10,25),
                                ClassificacaoIndicativa.DEZOITOMAIS, List.of())
                        .build(),"Idade menor que o esperado. Verifique a classificação indicativa!")
                );
    }
}
