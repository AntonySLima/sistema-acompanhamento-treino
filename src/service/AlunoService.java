package service;

import model.Aluno;


import java.util.ArrayList;
import java.util.List;

public class AlunoService {
    private List<Aluno> alunos = new ArrayList<>();

    public Aluno criarAluno(String nome, String dataNascimento) {
       Aluno aluno = new Aluno(nome, dataNascimento);
       alunos.add(aluno);
       return aluno;
    }

    public void exibirInformacoesAluno(Aluno aluno) {
        System.out.println("Nome do aluno: " + aluno.getNome());
        System.out.println("Data de nascimento: " + aluno.getDataNascimento());
    }

    public void exibirAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado ainda!");
            return;
        }
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println((i + 1) + " - " + alunos.get(i).getNome());
        }
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }
}
