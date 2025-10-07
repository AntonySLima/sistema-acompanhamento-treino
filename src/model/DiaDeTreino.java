package model;

public class DiaDeTreino {
    private DiaDaSemana diaDaSemana;
    private TipoDia tipoDia;

    public DiaDeTreino(DiaDaSemana diaDaSemana, TipoDia tipoDia) {
        this.diaDaSemana = diaDaSemana;
        this.tipoDia = tipoDia;
    }

    public DiaDaSemana getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public TipoDia getTipoDia() {
        return tipoDia;
    }

    public void setTipoDia(TipoDia tipoDia) {
        this.tipoDia = tipoDia;
    }
}
