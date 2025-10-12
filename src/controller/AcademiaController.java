package controller;

import exception.*;
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

    private void validarExercicio(String nome, double carga, int tempoDescanso, int series, int repeticoes) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome do exercício inválido!");
        if (carga < 0) throw new IllegalArgumentException("Carga não pode ser negativa!");
        if (tempoDescanso < 0) throw new IllegalArgumentException("Tempo de descanso não pode ser negativo!");
        if (series <= 0) throw new IllegalArgumentException("Número de séries deve ser maior que zero!");
        if (repeticoes <= 0) throw new IllegalArgumentException("Número de repetições deve ser maior que zero!");
    }

    private void validarAluno(String nome, String dataNascimento) {
        if(nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do aluno inválido, por favor insira novamente!");
        }

        if(dataNascimento == null || dataNascimento.isBlank()) {
            throw new IllegalArgumentException("Data de nascimento inválida, por favor insira novamente!");
        }
    }

    private void validarDiaDeTreino(String diaDaSemanaInput, String tipoDiaInput) {
        if (diaDaSemanaInput == null || diaDaSemanaInput.isBlank()) {
            throw new DiaInvalidoException("Dia da semana invalido, por favor siga o padrão necessário!");
        }
        if (tipoDiaInput == null || tipoDiaInput.isBlank()) {
            throw new TipoDiaInvalidoException("Tipo do dia inválido, por favor siga o padrão necessário!");
        }
    }

    public Exercicio criarExercicio(String nome, double carga, int tempoDescanso, int series, int repeticoes) {
        validarExercicio(nome, carga, tempoDescanso, series, repeticoes);
        return exercicioService.criarExercicio(nome, carga, tempoDescanso, series, repeticoes);
    }

    public Treino criarTreino(String descricaoTreino, DiaDeTreino diaDeTreino) {
        return treinoService.criarTreino(descricaoTreino, diaDeTreino);
    }

    public void adicionarExercicioTreino(Treino treino, Exercicio exercicio) {
        treino.adicionarExercicioInterno(exercicio);
    }

    public Aluno criarAluno(String nome, String dataNascimento) {
        validarAluno(nome, dataNascimento);
        return alunoService.criarAluno(nome, dataNascimento);
    }

    public void adicionarTreinoAluno(Treino treino, Aluno aluno) {
        aluno.adicionarTreinoInterno(treino);
    }

    public void mostrarTreinosAluno(Aluno aluno) {
        if (aluno.getTreinos().isEmpty()) {
            System.out.println("Aluno ainda não tem nenhum treino associado!");
            return;
        }
        System.out.println("Aluno: " + aluno.getNome());
        for (Treino treino : aluno.getTreinos()) {
            System.out.println("Treino: " + treino.getDescricaoTreino());
            System.out.println("Dia da semana: " + treino.getDiaDeTreino().getDiaDaSemana().getDescricaoDia());
        }
    }

    public void mostrarExerciciosTreino(Treino treino) {
        if (treino.getExercicios().isEmpty()) {
            throw new RuntimeException("Nenhum exercicio cadastrado no treino!");
        }
        for (Exercicio exercicio : treino.getExercicios()) {
            System.out.println(exercicio.getNome());
        }
    }

    public DiaDeTreino criarDiaDeTreino(String diaDaSemanaInput, String tipoDiaInput){
        validarDiaDeTreino(diaDaSemanaInput, tipoDiaInput);
        DiaDaSemana diaDaSemana = diaPorDescricao(diaDaSemanaInput);
        TipoDia tipoDia = tipoDiaPorDescricao(tipoDiaInput);
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

    public Aluno getAluno(int index) {
        index -= 1;
        if (index < 0 || index >= getAlunos().size()) {
            throw new AlunoNaoEncontradoException("Aluno não encontrado, por favor insira um indíce correto!");
        }
        return getAlunos().get(index);
    }

    public Treino getTreino(int index) {
        index -= 1;
        if (index < 0 || index >= getTreinos().size()) {
            throw new TreinoNaoEncontradoException("Treino não encontrado, por favor insira um indíce correto!");
        }
        return getTreinos().get(index);
    }

    public Exercicio getExercicio(int index) {
        index -= 1;
        if (index < 0 || index >= getExercicios().size()) {
            throw new ExercicioNaoEncontradoException("Exercicio não encontrado, por favor insira um indíce correto!");
        }
        return getExercicios().get(index);
    }

}
