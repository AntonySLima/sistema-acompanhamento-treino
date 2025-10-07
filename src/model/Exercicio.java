package model;

public class Exercicio {
    private String nome;
    private double carga;
    private int tempoDescanso;
    private int series;
    private int repeticoes;

    public Exercicio(String nome, double carga, int tempoDescanso, int series, int repeticoes) {
        this.nome = nome;
        this.carga = carga;
        this.tempoDescanso = tempoDescanso;
        this.series = series;
        this.repeticoes = repeticoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }

    public int getTempoDescanso() {
        return tempoDescanso;
    }

    public void setTempoDescanso(int tempoDescanso) {
        this.tempoDescanso = tempoDescanso;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }
}
