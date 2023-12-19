package br.com.ts.venda.de.ingressos.de.cinema.enums;

public enum Preco {
    INICIO_SEMANA_2D(27),
    MEIO_SEMANA_2D(40),
    FIM_SEMANA_2D(42),
    
    INICIO_SEMANA_3D(34),
    MEIO_SEMANA_3D(46),
    FIM_SEMANA_3D(49),
    
    INICIO_SEMANA_2D_DBOX(41),
    MEIO_SEMANA_2D_DBOX(60),
    FIM_SEMANA_2D_DBOX(63),
    
    INICIO_SEMANA_3D_DBOX(48),
    MEIO_SEMANA_3D_DBOX(70),
    FIM_SEMANA_3D_DBOX(74);

    private final int preco;

    Preco(int preco) {
        this.preco = preco;
    }

    public int getPreco() {
        return preco;
    }
}
