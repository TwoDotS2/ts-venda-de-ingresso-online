package br.com.ts.venda.de.ingressos.de.cinema;

import br.com.ts.venda.de.ingressos.de.cinema.builder.*;
import br.com.ts.venda.de.ingressos.de.cinema.entidades.Compra;
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
    void testaPrecoIngresso(String CT, Compra compra, Float precoEsperado) {
        exibirCompra(compra, CT);

        compra.comprarIngresso();
        assertEquals(compra.preco(), precoEsperado);
    }

    @ParameterizedTest
    @MethodSource("geraPedidoComExcecao")
    void testaExcecaoIngresso(String CT, Compra compra, String excecaoEsperada) {
        exibirCompra(compra, CT);

        Exception excecao = assertThrows(Exception.class, () -> compra.comprarIngresso());
        assertTrue(excecao.getMessage().contains(excecaoEsperada));
        System.out.println(compra.toString());
    }

    static Stream<Arguments> geraPedidoIngresso() {
        return Stream.of(Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_2d_MeiaEntrada_SegTerQuar(List.of())
                        .build(), (float) 13.5),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_2d_MeiaEntrada_Quinta(List.of())
                        .build(), (float) 20),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_2d_MeiaEntrada_FdsFeriado(List.of())
                        .build(), (float) 21),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_2d_Inteira_SegTerQuar(List.of())
                        .build(), (float) 27),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_2d_Inteira_Quinta(List.of())
                        .build(), (float) 40),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_2d_Inteira_FdsFeriado(List.of())
                        .build(), (float) 42),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_3d_MeiaEntrada_SegTerQuar(List.of())
                        .build(), (float) 17),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_3d_MeiaEntrada_Quinta(List.of())
                        .build(), (float) 23),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_3d_MeiaEntrada_FdsFeriado(List.of())
                        .build(), (float) 24.5),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_3d_Inteira_SegTerQuar(List.of())
                        .build(), (float) 34),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_3d_Inteira_Quinta(List.of())
                        .build(), (float) 46),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_3d_Inteira_FdsFeriado(List.of())
                        .build(), (float) 49),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_2d_MeiaEntrada_SegTerQuar(List.of("A"))
                        .build(), (float) 20.5),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_2d_MeiaEntrada_Quinta(List.of("A"))
                        .build(), (float) 30),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_2d_MeiaEntrada_FdsFeriado(List.of("A"))
                        .build(), (float) 31.5),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_2d_Inteira_SegTerQuar(List.of("A"))
                        .build(), (float) 41),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_2d_Inteira_Quinta(List.of("A"))
                        .build(), (float) 60),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_2d_Inteira_FdsFeriado(List.of("A"))
                        .build(), (float) 63),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_3d_MeiaEntrada_SegTerQuar(List.of("A"))
                        .build(), (float) 24),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_3d_MeiaEntrada_Quinta(List.of("A"))
                        .build(), (float) 35),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_3d_MeiaEntrada_FdsFeriado(List.of("A"))
                        .build(), (float) 37),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_3d_Inteira_SegTerQuar(List.of("A"))
                        .build(), (float) 48),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_3d_Inteira_Quinta(List.of("A"))
                        .build(), (float) 70),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_3d_Inteira_FdsFeriado(List.of("A"))
                        .build(), (float) 74),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_TipoSala_E_Dia_Especificos(TipoSala._3D, TipoDia.DOMINGO, List.of())
                        .build(), (float) 49),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_TipoSala_E_Dia_Especificos(TipoSala._2D, TipoDia.EMENDA, List.of())
                        .build(), (float) 100),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2013, 10, 25),
                                ClassificacaoIndicativa.DEZMAIS, List.of())
                        .build(), (float) 40),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2012, 10, 25),
                                ClassificacaoIndicativa.DEZMAIS, List.of())
                        .build(), (float) 40),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2011, 10, 25),
                                ClassificacaoIndicativa.DOZEMAIS, List.of())
                        .build(), (float) 40),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2010, 10, 25),
                                ClassificacaoIndicativa.DOZEMAIS, List.of())
                        .build(), (float) 40),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2009, 10, 25),
                                ClassificacaoIndicativa.QUATORZEMAIS, List.of())
                        .build(), (float) 40),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2008, 10, 25),
                                ClassificacaoIndicativa.QUATORZEMAIS, List.of())
                        .build(), (float) 40),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2007, 10, 25),
                                ClassificacaoIndicativa.DEZESSEISMAIS, List.of())
                        .build(), (float) 40),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2006, 10, 25),
                                ClassificacaoIndicativa.DEZESSEISMAIS, List.of())
                        .build(), (float) 40),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2005, 10, 25),
                                ClassificacaoIndicativa.DEZOITOMAIS, List.of())
                        .build(), (float) 40),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2004, 10, 25),
                                ClassificacaoIndicativa.DEZOITOMAIS, List.of())
                        .build(), (float) 40)
        );
    }

    public static Stream<Arguments> geraPedidoComExcecao() {
        return Stream.of(Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_3d_Inteira_FdsFeriado(List.of("A"))
                        .comCodigoAssento("A4")
                        .build(), "Assento não está disponível"),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2014, 12, 25),
                                ClassificacaoIndicativa.DEZMAIS, List.of())
                        .build(), "Idade menor que o esperado. Verifique a classificação indicativa!"),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2012, 10, 25),
                                ClassificacaoIndicativa.DOZEMAIS, List.of())
                        .build(), "Idade menor que o esperado. Verifique a classificação indicativa!"),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2010, 10, 25),
                                ClassificacaoIndicativa.QUATORZEMAIS, List.of())
                        .build(), "Idade menor que o esperado. Verifique a classificação indicativa!"),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2008, 10, 25),
                                ClassificacaoIndicativa.DEZESSEISMAIS, List.of())
                        .build(), "Idade menor que o esperado. Verifique a classificação indicativa!"),

                Arguments.of("CT - <Inserir Nº teste>", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2006, 10, 25),
                                ClassificacaoIndicativa.DEZOITOMAIS, List.of())
                        .build(), "Idade menor que o esperado. Verifique a classificação indicativa!")
        );
    }

    public void exibirCompra(Compra compra, String CT){
        System.out.println("=================================================================");
        System.out.println("\t" + CT);
        System.out.println("=================================================================");

        System.out.println(parametrosDeTesteDaCompra(compra));
    }

    public String parametrosDeTesteDaCompra(Compra compra){
        String assentoEhDBOX = compra.sessao().sala().assentoEhDBOX(compra.codigoAssento())? "SIM": "NÂO";

        return "Compra:\n" +
                "-----------------------------------------------------------------\n" +
                "Tipo do Dia: " + compra.sessao().tipoDia().name() + "\n" +
                "Data/Horário: " + compra.sessao().data() + " / " + compra.sessao().horario() + "\n" +
                "Tipo de Sala: " + compra.sessao().sala().tipoSala().name() + "\n" +
                "Assento é DBOX? " + assentoEhDBOX + "\n" +
                "Classificação Indicativa: " + compra.sessao().filme().faixaEtaria() + "\n" +
                "Idade do Cliente: " + compra.cliente().calcularIdade() + "\n" +
                "-----------------------------------------------------------------\n" +
                "\n\nExtras:\n\n" + compra.toString();
    }
}
