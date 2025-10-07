package model;

public enum DiaDaSemana {
    DOMINGO (1, "Domingo"),
    SEGUNDA (2, "Segunda-feira"),
    TERCA(3, "Terça-feira"),
    QUARTA(4,"Quarta-feira"),
    QUINTA(5, "Quinta-feira"),
    SEXTA(6, "Sexta-feira"),
    SABADO(7, "Sábado");

    private int idDia;
    private String descricaoDia;
    DiaDaSemana(int idDia, String descricaoDia) {
        this.idDia = idDia;
        this.descricaoDia = descricaoDia;
    }

    public int getIdDia() {
        return idDia;
    }

    public String getDescricaoDia() {
        return descricaoDia;
    }


}
