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
        return Stream.of(Arguments.of("CT (1) | Sala 3D, Segunda a Quarta, Inteira | Retorno Esperado: 34.00", CompraBuilder.umaCompra()
                        .com_3d_Inteira_SegTerQuar(List.of())
                        .build(), (float) 34),

                Arguments.of("CT (2) | Sala 3D, Segunda a Quarta, Meia Entrada | Retorno Esperado: 17.00", CompraBuilder.umaCompra()
                        .com_3d_MeiaEntrada_SegTerQuar(List.of())
                        .build(), (float) 17),

                Arguments.of("CT (3) | Sala 2D, Segunda a Quarta, Inteira | Retorno Esperado: 27.00", CompraBuilder.umaCompra()
                        .com_2d_Inteira_SegTerQuar(List.of())
                        .build(), (float) 27),

                Arguments.of("CT (4) | Sala 2D, Segunda a Quarta, Meia Entrada | Retorno Esperado: 13.50", CompraBuilder.umaCompra()
                        .com_2d_MeiaEntrada_SegTerQuar(List.of())
                        .build(), (float) 13.5),

                Arguments.of("CT (5) | Sala 2D, Segunda a Quarta, Inteira, Assento DBOX | Retorno Esperado: 41.00", CompraBuilder.umaCompra()
                        .com_2d_Inteira_SegTerQuar(List.of("A"))
                        .build(), (float) 41),

                Arguments.of("CT (6) | Sala 2D, Segunda a Quarta, Meia Entrada, Assento DBOX | Retorno Esperado: 20.50", CompraBuilder.umaCompra()
                        .com_2d_MeiaEntrada_SegTerQuar(List.of("A"))
                        .build(), (float) 20.5),

                Arguments.of("CT (7) | Sala 3D, Segunda a Quarta, Inteira, Assento DBOX | Retorno Esperado: 48.00", CompraBuilder.umaCompra()
                        .com_3d_Inteira_SegTerQuar(List.of("A"))
                        .build(), (float) 48),

                Arguments.of("CT (8) | Sala 3D, Segunda a Quarta, Meia Entrada, Assento DBOX | Retorno Esperado: 24.00", CompraBuilder.umaCompra()
                        .com_3d_MeiaEntrada_SegTerQuar(List.of("A"))
                        .build(), (float) 24),

                Arguments.of("CT (9) | Sala 3D, Quinta, Inteira | Retorno Esperado: 46.00", CompraBuilder.umaCompra()
                        .com_3d_Inteira_Quinta(List.of())
                        .build(), (float) 46),

                Arguments.of("CT (10) | Sala 3D, Quinta, Meia Entrada | Retorno Esperado: 23.00", CompraBuilder.umaCompra()
                        .com_3d_MeiaEntrada_Quinta(List.of())
                        .build(), (float) 23),

                Arguments.of("CT (11) | Sala 2D, Quinta, Inteira | Retorno Esperado: 40.00", CompraBuilder.umaCompra()
                        .com_2d_Inteira_Quinta(List.of())
                        .build(), (float) 40),

                Arguments.of("CT (12) | Sala 2D, Quinta, Meia Entrada | Retorno Esperado: 20.00", CompraBuilder.umaCompra()
                        .com_2d_MeiaEntrada_Quinta(List.of())
                        .build(), (float) 20),

                Arguments.of("CT (13) | Sala 2D, Quinta, Inteira, Assento DBOX | Retorno Esperado: 60.00", CompraBuilder.umaCompra()
                        .com_2d_Inteira_Quinta(List.of("A"))
                        .build(), (float) 60),

                Arguments.of("CT (14) | Sala 2D, Quinta, Meia Entrada, Assento DBOX | Retorno Esperado: 30.00", CompraBuilder.umaCompra()
                        .com_2d_MeiaEntrada_Quinta(List.of("A"))
                        .build(), (float) 30),

                Arguments.of("CT (15) | Sala 3D, Quinta, Inteira, Assento DBOX | Retorno Esperado: 70.00", CompraBuilder.umaCompra()
                        .com_3d_Inteira_Quinta(List.of("A"))
                        .build(), (float) 70),

                Arguments.of("CT (16) | Sala 3D, Quinta, Meia Entrada, Assento DBOX | Retorno Esperado: 35.00", CompraBuilder.umaCompra()
                        .com_3d_MeiaEntrada_Quinta(List.of("A"))
                        .build(), (float) 35),

                Arguments.of("CT (34) | Sala 3D, Sexta a Domingo, Feriados e Pre-Estreias, Inteira | Retorno Esperado: 49.00", CompraBuilder.umaCompra()
                        .com_3d_Inteira_FdsFeriado(List.of())
                        .build(), (float) 49),

                Arguments.of("CT (35) | Sala 3D, Sexta a Domingo, Feriados e Pre-Estreias, Meia Entrada | Retorno Esperado: 24.50", CompraBuilder.umaCompra()
                        .com_3d_MeiaEntrada_FdsFeriado(List.of())
                        .build(), (float) 24.5),

                Arguments.of("CT (36) | Sala 2D, Sexta a Domingo, Feriados e Pre-Estreias, Inteira | Retorno Esperado: 42.00", CompraBuilder.umaCompra()
                        .com_2d_Inteira_FdsFeriado(List.of())
                        .build(), (float) 42),

                Arguments.of("CT (37) | Sala 2D, Sexta a Domingo, Feriados e Pre-Estreias, Meia Entrada | Retorno Esperado: 21.00", CompraBuilder.umaCompra()
                        .com_2d_MeiaEntrada_FdsFeriado(List.of())
                        .build(), (float) 21),

                Arguments.of("CT (38) | Sala 2D, Sexta a Domingo, Feriados e Pre-Estreias, Inteira, Assento DBOX | Retorno Esperado: 63.00", CompraBuilder.umaCompra()
                        .com_2d_Inteira_FdsFeriado(List.of("A"))
                        .build(), (float) 63),

                Arguments.of("CT (39) | Sala 2D, Sexta a Domingo, Feriados e Pre-Estreias, Meia Entrada, Assento DBOX | Retorno Esperado: 31.50", CompraBuilder.umaCompra()
                        .com_2d_MeiaEntrada_FdsFeriado(List.of("A"))
                        .build(), (float) 31.5),

                Arguments.of("CT (40) | Sala 3D, Sexta a Domingo, Feriados e Pre-Estreias, Inteira, Assento DBOX | Retorno Esperado: 74.00", CompraBuilder.umaCompra()
                        .com_3d_Inteira_FdsFeriado(List.of("A"))
                        .build(), (float) 74),

                Arguments.of("CT (41) | Sala 3D, Sexta a Domingo, Feriados e Pre-Estreias, Meia Entrada, Assento DBOX | Retorno Esperado: 37.00", CompraBuilder.umaCompra()
                        .com_3d_MeiaEntrada_FdsFeriado(List.of("A"))
                        .build(), (float) 37),

                Arguments.of("CT Adicional I | #Para Garantir 100% De cobertura Em Compra# | Sala 3D, Domingo, Inteira | Retorno Esperado: 49.00", CompraBuilder.umaCompra()
                        .com_TipoSala_E_Dia_Especificos(TipoSala._3D, TipoDia.DOMINGO, List.of())
                        .build(), (float) 49),

                Arguments.of("CT Adicional II | #Para Garantir 100% De cobertura Em Compra# | Sala 2D, Emenda, Inteira | Retorno Esperado: 100.00", CompraBuilder.umaCompra()
                        .com_TipoSala_E_Dia_Especificos(TipoSala._2D, TipoDia.EMENDA, List.of())
                        .build(), (float) 100),

                Arguments.of("CT (20) | Analise do Valor limite | Idade:10, Classificacao:10 | Retorno Esperado: 40.00", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2013, 10, 25),
                                ClassificacaoIndicativa.DEZMAIS, List.of())
                        .build(), (float) 40),

                Arguments.of("CT (21) | Analise do Valor limite | Idade:11, Classificacao:10 | Retorno Esperado: 40.00", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2012, 10, 25),
                                ClassificacaoIndicativa.DEZMAIS, List.of())
                        .build(), (float) 40),

                Arguments.of("CT (23) | Analise do Valor limite | Idade:12, Classificacao:12 | Retorno Esperado: 40.00", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2011, 10, 25),
                                ClassificacaoIndicativa.DOZEMAIS, List.of())
                        .build(), (float) 40),

                Arguments.of("CT (24) | Analise do Valor limite | Idade:13, Classificacao:12 | Retorno Esperado: 40.00", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2010, 10, 25),
                                ClassificacaoIndicativa.DOZEMAIS, List.of())
                        .build(), (float) 40),

                Arguments.of("CT (26) | Analise do Valor limite | Idade:14, Classificacao:14 | Retorno Esperado: 40.00", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2009, 10, 25),
                                ClassificacaoIndicativa.QUATORZEMAIS, List.of())
                        .build(), (float) 40),

                Arguments.of("CT (27) | Analise do Valor limite | Idade:15, Classificacao:14 | Retorno Esperado: 40.00", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2008, 10, 25),
                                ClassificacaoIndicativa.QUATORZEMAIS, List.of())
                        .build(), (float) 40),

                Arguments.of("CT (29) | Analise do Valor limite | Idade:16, Classificacao:16 | Retorno Esperado: 40.00", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2007, 10, 25),
                                ClassificacaoIndicativa.DEZESSEISMAIS, List.of())
                        .build(), (float) 40),

                Arguments.of("CT (30) | Analise do Valor limite | Idade:17, Classificacao:16 | Retorno Esperado: 40.00", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2006, 10, 25),
                                ClassificacaoIndicativa.DEZESSEISMAIS, List.of())
                        .build(), (float) 40),

                Arguments.of("CT (32) | Analise do Valor limite | Idade:18, Classificacao:18 | Retorno Esperado: 40.00", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2005, 10, 25),
                                ClassificacaoIndicativa.DEZOITOMAIS, List.of())
                        .build(), (float) 40),

                Arguments.of("CT (33) | Analise do Valor limite | Idade:19, Classificacao:18 | Retorno Esperado: 40.00", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2004, 10, 25),
                                ClassificacaoIndicativa.DEZOITOMAIS, List.of())
                        .build(), (float) 40)
        );
    }

    public static Stream<Arguments> geraPedidoComExcecao() {
        return Stream.of(Arguments.of("CT (17) | Assento Escolhido Esta Ocupado | Retorno Esperado: Erro", CompraBuilder.umaCompra()
                        .com_3d_Inteira_FdsFeriado(List.of())
                        .comCodigoAssento("A4")
                        .build(), "Assento não está disponível"),

                Arguments.of("CT (18) | Assento Escolhido Esta Ocupado, Assento DBOX | Retorno Esperado: Erro", CompraBuilder.umaCompra()
                        .com_3d_Inteira_FdsFeriado(List.of("A"))
                        .comCodigoAssento("A4")
                        .build(), "Assento não está disponível"),

                Arguments.of("CT (19) | Analise do Valor limite | Idade:9, Classificacao:10 | Retorno Esperado: Erro", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2014, 12, 25),
                                ClassificacaoIndicativa.DEZMAIS, List.of())
                        .build(), "Idade menor que o esperado. Verifique a classificação indicativa!"),

                Arguments.of("CT (22) | Analise do Valor limite | Idade:11, Classificacao:12 | Retorno Esperado: Erro", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2012, 10, 25),
                                ClassificacaoIndicativa.DOZEMAIS, List.of())
                        .build(), "Idade menor que o esperado. Verifique a classificação indicativa!"),

                Arguments.of("CT (25) | Analise do Valor limite | Idade:13, Classificacao:14 | Retorno Esperado: Erro", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2010, 10, 25),
                                ClassificacaoIndicativa.QUATORZEMAIS, List.of())
                        .build(), "Idade menor que o esperado. Verifique a classificação indicativa!"),

                Arguments.of("CT (28) | Analise do Valor limite | Idade:15, Classificacao:16 | Retorno Esperado: Erro", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2008, 10, 25),
                                ClassificacaoIndicativa.DEZESSEISMAIS, List.of())
                        .build(), "Idade menor que o esperado. Verifique a classificação indicativa!"),

                Arguments.of("CT (31) | Analise do Valor limite | Idade:17, Classificacao:18 | Retorno Esperado: Erro", CompraBuilder.umaCompra()
                        .com_Idade_E_Classificacao_Especificos(LocalDate.of
                                        (2006, 10, 25),
                                ClassificacaoIndicativa.DEZOITOMAIS, List.of())
                        .build(), "Idade menor que o esperado. Verifique a classificação indicativa!")
        );
    }

    public void exibirCompra(Compra compra, String CT){
        System.out.println("==================================================================================================================================");
        System.out.println("\t" + CT);
        System.out.println("==================================================================================================================================");

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
                "-----------------------------------------------------------------\n";
    }

    public void exibirCompraToString(Compra compra){
        System.out.println(compra.toString());
    }
}
