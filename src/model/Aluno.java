package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aluno {
    private static int idCounter = 1;
    private int idAluno;
    private String nome;
    private String dataNascimento;
    private List<Treino> treinos;

    public Aluno(String nome, String dataNascimento) {
        this.idAluno = idCounter++;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.treinos = new ArrayList<>();
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Treino> getTreinos() {
        return Collections.unmodifiableList(treinos);
    }

    public void adicionarTreinoInterno(Treino treino) {
        treinos.add(treino);
    }
}
