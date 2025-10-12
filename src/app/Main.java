package app;

import controller.AcademiaController;
import exception.*;
import model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao = 0;
        Scanner scanner = new Scanner(System.in);
        AcademiaController academiaController = new AcademiaController();

        do {
            System.out.println("\n=== Sistema de Acompanhamento de Treinos ===");
            System.out.println("1 - Criar aluno");
            System.out.println("2 - Criar treino");
            System.out.println("3 - Criar exercício");
            System.out.println("4 - Associar treino a um aluno");
            System.out.println("5 - Associar exercício a um treino");
            System.out.println("6 - Visualizar treinos de um aluno específico");
            System.out.println("7 - Visualizar treinos existentes");
            System.out.println("8 - Visualizar exercicios existentes");
            System.out.println("9 - Visualizar exercicios de um treino específico");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 0: {
                    System.out.println("Saindo do sistema, obrigado por utilizar!");
                }
                break;
                case 1: {
                    System.out.println("Nome do aluno: ");
                    String nome = scanner.nextLine();
                    System.out.println("Data de nascimento: ");
                    String dataNascimento = scanner.nextLine();
                    try {
                        academiaController.criarAluno(nome, dataNascimento);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    }
                }
                break;
                case 2: {
                    System.out.println("Descricao do treino: ");
                    String descricao = scanner.nextLine();
                    System.out.println("Digite o dia do treino da seguinte forma (Segunda-feira): ");
                    String diaDeTreinoInput = scanner.nextLine();
                    System.out.println("Digite se este dia é referente a descanso ou treino (Descanso/Treino)");
                    String tipoDiaInput = scanner.nextLine();
                    DiaDeTreino diaDeTreino = null;
                    try {
                        diaDeTreino = academiaController.criarDiaDeTreino(diaDeTreinoInput, tipoDiaInput);
                    } catch (DiaInvalidoException | TipoDiaInvalidoException e) {
                        throw new RuntimeException(e);
                    }
                    academiaController.criarTreino(descricao, diaDeTreino);
                }
                break;
                case 3: {
                    System.out.println("Nome do exercicio: ");
                    String nomeExercicio = scanner.nextLine();
                    System.out.println("Carga atual em KGs: ");
                    double carga = scanner.nextDouble();
                    System.out.println("Tempo de descanso em segundos: ");
                    int tempoDescanso = scanner.nextInt();
                    System.out.println("Séries: ");
                    int series = scanner.nextInt();
                    System.out.println("Repetições: ");
                    int repeticoes = scanner.nextInt();
                    academiaController.criarExercicio(nomeExercicio, carga, tempoDescanso, series, repeticoes);
                }
                break;
                case 4: {
                    if (academiaController.getAlunos().isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado ainda!");
                        continue;
                    }
                    System.out.println("Alunos atuais: ");
                    academiaController.exibirAlunos();
                    System.out.println("Selecione um aluno para adicionar um treino: ");
                    int indexAluno = scanner.nextInt();
                    if (academiaController.getTreinos().isEmpty()) {
                        System.out.println("Nenhum treino cadastrado ainda !");
                        continue;
                    }
                    System.out.println("Treinos atuais: ");
                    academiaController.exibirTreinos();
                    System.out.println("Selecione um treino para ser adicionado ao aluno escolhido:");
                    int indexTreino = scanner.nextInt();
                    try {
                        academiaController.adicionarTreinoAluno(academiaController.getTreino(indexTreino), academiaController.getAluno(indexAluno));
                    } catch (AlunoNaoEncontradoException | TreinoNaoEncontradoException e) {
                        e.printStackTrace();
                    }
                }
                break;
                case 5: {
                    if (academiaController.getTreinos().isEmpty()) {
                        System.out.println("Nenhum treino cadastrado ainda!");
                        continue;
                    }
                    academiaController.exibirExercicios();
                    System.out.println("Selecione um exercicio para adicionar um treino: ");
                    int indexExercicio = scanner.nextInt();
                    System.out.println("Treinos atuais: ");
                    academiaController.exibirTreinos();
                    System.out.println("Selecione um treino para ser adicionado o exercicio: ");
                    int indexTreino = scanner.nextInt();
                    try {
                        academiaController.adicionarExercicioTreino(academiaController.getTreino(indexTreino), academiaController.getExercicio(indexExercicio));
                    } catch (TreinoNaoEncontradoException | ExercicioNaoEncontradoException e) {
                        e.printStackTrace();
                    }

                }
                break;
                case 6: {
                    if (academiaController.getAlunos().isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado ainda!");
                        continue;
                    }
                    System.out.println("Alunos disponiveis: ");
                    academiaController.exibirAlunos();

                    System.out.println("Selecione um aluno para visualizar seus treinos: ");
                    int indexAluno = scanner.nextInt();
                    academiaController.mostrarTreinosAluno(academiaController.getAluno(indexAluno));
                }
                break;
                case 7: {
                    academiaController.exibirTreinos();
                }
                break;
                case 8: {
                    academiaController.exibirExercicios();
                }
                break;
                case 9: {
                    if (academiaController.getTreinos().isEmpty()) {
                        System.out.println("Nenhum treino cadastrado ainda!");
                        continue;
                    }
                    try {
                        System.out.println("Lista atual de treinos");
                        academiaController.exibirTreinos();

                        System.out.println("Digite um treino para visualizar seus exercicios:");
                        int indexTreino = scanner.nextInt();
                        academiaController.mostrarExerciciosTreino(academiaController.getTreino(indexTreino));
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                    }
                }
                break;
                default:
                    System.out.println("Opção inválida, por favor tente novamente!");
                    break;
            }
        } while (opcao != 0);
    }
}