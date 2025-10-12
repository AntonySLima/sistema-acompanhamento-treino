package service;

import model.Aluno;
import model.DiaDeTreino;
import model.Exercicio;
import model.Treino;

import java.util.ArrayList;
import java.util.List;

public class TreinoService {
    private List<Treino> treinos = new ArrayList<>();

    public Treino criarTreino(String descricaoTreino, DiaDeTreino diaDeTreino) {
        Treino treino = new Treino(descricaoTreino, diaDeTreino);
        treinos.add(treino);
        return treino;
    }

    public void adicionarExercicio(Treino treino, Exercicio exercicio) {
        treino.adicionarExercicioInterno(exercicio);
    }

    public void exibirExerciciosTreino(Treino treino) {
        if (treino.getExercicios() == null || treino.getExercicios().isEmpty()) {
            System.out.println("Não existem exercicios cadastrados pra este treino!");
            return;
        }
        for (Exercicio exercicio : treino.getExercicios()){
            System.out.println("Nome do exercicío: " + exercicio.getNome());
            System.out.println("Carga: " + exercicio.getCarga());
            System.out.println("Séries: " + exercicio.getSeries());
            System.out.println("Repetições: " + exercicio.getRepeticoes());
            System.out.println("Tempo de descanso em segundos: " + exercicio.getTempoDescanso());
        }
    }

    public void exibirTreinos() {
        if (treinos.isEmpty()) {
            System.out.println("Nenhum treino cadastrado ainda!");
            return;
        }
        for (int i = 0; i < treinos.size(); i++) {
            System.out.println((i + 1) + " - " + treinos.get(i).getDescricaoTreino());
        }
    }

    public List<Treino> getTreinos() {
        return treinos;
    }


}
