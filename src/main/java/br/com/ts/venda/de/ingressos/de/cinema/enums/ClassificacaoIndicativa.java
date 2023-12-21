package br.com.ts.venda.de.ingressos.de.cinema.enums;

public enum ClassificacaoIndicativa {
    LIVRE(0),
    DEZMAIS(10),
    DOZEMAIS(12),
    QUATORZEMAIS(14),
    DEZESSEISMAIS(16),
    DEZOITOMAIS(18);

    private final long classificacaoIndicativa;

    ClassificacaoIndicativa(long classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public long getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }
}
