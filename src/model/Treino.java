package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Treino {
    private static int idCounter = 1;
    private int idTreino;
    private String descricaoTreino;
    private DiaDeTreino diaDeTreino;
    private List<Exercicio> exercicios = new ArrayList<>();

    public Treino(String descricaoTreino, DiaDeTreino diaDeTreino) {
        this.descricaoTreino = descricaoTreino;
        this.diaDeTreino = diaDeTreino;
    }

    public Treino(DiaDeTreino diaDeTreino, List<Exercicio> exercicios) {
        this.idTreino = idCounter++;
        this.diaDeTreino = diaDeTreino;
        this.exercicios = exercicios;
    }

    public DiaDeTreino getDiaDeTreino() {
        return diaDeTreino;
    }

    public void setDiaDeTreino(DiaDeTreino diaDeTreino) {
        this.diaDeTreino = diaDeTreino;
    }

    public List<Exercicio> getExercicios() {
        return Collections.unmodifiableList(exercicios);
    }

    public void adicionarExercicioInterno(Exercicio exercicio) {
        exercicios.add(exercicio);
    }

    public String getDescricaoTreino() {
        return descricaoTreino;
    }

    public void setDescricaoTreino(String descricaoTreino) {
        this.descricaoTreino = descricaoTreino;
    }
}
