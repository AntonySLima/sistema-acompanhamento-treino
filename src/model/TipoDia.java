package model;

public enum TipoDia {
    TREINO ("Treino"),
    DESCANSO ("Descanso");

    private String descricaoTipo;

    TipoDia(String descricaoTipo) {
        this.descricaoTipo = descricaoTipo;
    }

    public String getDescricaoTipo() {
        return descricaoTipo;
    }
}
