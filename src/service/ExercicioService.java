package service;

import model.Exercicio;

import java.util.ArrayList;
import java.util.List;

public class ExercicioService {
    private List<Exercicio> exercicios = new ArrayList<>();

    public Exercicio criarExercicio(String nome, double carga, int tempoDescanso, int series, int repeticoes) {
        Exercicio exercicio = new Exercicio(nome, carga, tempoDescanso, series, repeticoes);
        exercicios.add(exercicio);
        return exercicio;
    }

    public List<Exercicio> listarExercicios() {
        return new ArrayList<>(exercicios);
    }

    public void removerExercicio(Exercicio exercicio) {
        exercicios.remove(exercicio);
    }

    public void exibirExercicios() {
        if (exercicios.isEmpty()) return;
        for (int i = 0; i < exercicios.size(); i++) {
            System.out.println((i + 1) + " - " + exercicios.get(i).getNome());
        }
    }

    public List<Exercicio> getExercicios() {
        return exercicios;
    }
}
