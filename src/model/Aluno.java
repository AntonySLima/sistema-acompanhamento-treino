package model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aluno {
    private static int idCounter = 1;
    private int idAluno;
    private String nome;
    private LocalDate dataNascimento;
    private List<Treino> treinos;

    public Aluno(String nome, String dataNascimento) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.idAluno = idCounter++;
        this.nome = nome;
        this.dataNascimento = LocalDate.parse(dataNascimento, dateTimeFormatter);
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Treino> getTreinos() {
        return Collections.unmodifiableList(treinos);
    }

    public void adicionarTreinoInterno(Treino treino) {
        treinos.add(treino);
    }
}
