package controller;

import model.*;
import service.AlunoService;
import service.DiaDeTreinoService;
import service.ExercicioService;
import service.TreinoService;

import java.util.List;

public class AcademiaController {
    private AlunoService alunoService = new AlunoService();
    private ExercicioService exercicioService = new ExercicioService();
    private TreinoService treinoService = new TreinoService();
    private DiaDeTreinoService diaDeTreinoService = new DiaDeTreinoService();

    public Exercicio criarExercicio(String nome, double carga, int tempoDescanso, int series, int repeticoes) {
        return exercicioService.criarExercicio(nome, carga, tempoDescanso, series, repeticoes);
    }

    public Treino criarTreino(String descricaoTreino, DiaDeTreino diaDeTreino) {
        return treinoService.criarTreino(descricaoTreino, diaDeTreino);
    }

    public void adicionarExercicioTreino(Treino treino, Exercicio exercicio) {
        treino.adicionarExercicioInterno(exercicio);
    }

    public Aluno criarAluno(String nome, String dataNascimento) {
        return alunoService.criarAluno(nome, dataNascimento);
    }

    public void adicionarTreinoAluno(Treino treino, Aluno aluno) {
        aluno.adicionarTreinoInterno(treino);
    }

    public void mostrarTreinosAluno(Aluno aluno) {
        System.out.println("Aluno: " + aluno.getNome());
        for (Treino treino : aluno.getTreinos()) {
            System.out.println("Treino: " + treino.getDescricaoTreino());
            System.out.println("Dia da semana: " + treino.getDiaDeTreino().getDiaDaSemana().getDescricaoDia());
        }
    }

    public void mostrarExerciciosTreino(Treino treino) {
        for (Exercicio exercicio : treino.getExercicios()) {
            System.out.println(exercicio.getNome());
        }
    }

    public DiaDeTreino criarDiaDeTreino(DiaDaSemana diaDaSemana, TipoDia tipoDia){
        return diaDeTreinoService.criarDiaDeTreino(diaDaSemana, tipoDia);
    }

    public DiaDaSemana diaPorDescricao(String descricaoDia) {
        for (DiaDaSemana diaDaSemana : DiaDaSemana.values()) {
            if (diaDaSemana.getDescricaoDia().equals(descricaoDia)) {
                return diaDaSemana;
            }
        }
        return null;
    }

    public TipoDia tipoDiaPorDescricao(String descricaoTipoDia) {
        for (TipoDia tipoDiaPorDescricao : TipoDia.values()) {
            if (tipoDiaPorDescricao.getDescricaoTipo().equals(descricaoTipoDia)) {
                return tipoDiaPorDescricao;
            }
        }
        return null;
    }

    public void adicionarTreinoAluno(Aluno aluno, Treino treino){
        aluno.adicionarTreinoInterno(treino);
    }

    public void exibirAlunos() {
        alunoService.exibirAlunos();
    }

    public void exibirTreinos() {
        treinoService.exibirTreinos();
    }

    public void exibirExercicios() {
        exercicioService.exibirExercicios();
    }

    public List<Treino> getTreinos() {
        return treinoService.getTreinos();
    }

    public List<Aluno> getAlunos() {
        return alunoService.getAlunos();
    }

    public List<Exercicio> getExercicios() {
        return exercicioService.getExercicios();
    }

}
