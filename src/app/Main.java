package app;

import controller.AcademiaController;
import model.*;
import service.AlunoService;

import java.util.ArrayList;
import java.util.List;
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
                case 0:
                    System.out.println("Saindo do sistema, obrigado por utilizar!");
                    break;
                case 1:
                    System.out.println("Nome do aluno: ");
                    String nome = scanner.nextLine();
                    System.out.println("Data de nascimento: ");
                    String dataNascimento = scanner.nextLine();
                    academiaController.criarAluno(nome, dataNascimento);
                    break;
                case 2:
                    System.out.println("Descricao do treino: ");
                    String descricao = scanner.nextLine();
                    System.out.println("Digite o dia do treino da seguinte forma (Segunda-feira): ");
                    String diaDeTreino = scanner.nextLine();
                    System.out.println("Digite se este dia é referente a descanso ou treino (Descanso/Treino)");
                    String tipoDia = scanner.nextLine();
                    academiaController.criarTreino(descricao, academiaController.criarDiaDeTreino(academiaController.diaPorDescricao(diaDeTreino), academiaController.tipoDiaPorDescricao(tipoDia)));
                    break;
                case 3:
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
                    break;
                case 4:
                    System.out.println("Alunos atuais: ");
                    academiaController.exibirAlunos();
                    System.out.println("Selecione um aluno para adicionar um treino: ");
                    int indexAluno = scanner.nextInt();
                    System.out.println("Treinos atuais: ");
                   academiaController.exibirTreinos();
                    System.out.println("Selecione um treino para ser adicionado ao aluno escolhido:");
                    int indexTreino = scanner.nextInt();
                    indexAluno = indexAluno - 1;
                    indexTreino = indexTreino - 1;
                    academiaController.adicionarTreinoAluno(academiaController.getTreinos().get(indexTreino), academiaController.getAlunos().get(indexAluno));

                    break;
                case 5:
                    academiaController.exibirExercicios();
                    System.out.println("Selecione um exercicio para adicionar um treino: ");
                    int indexExercicio = scanner.nextInt();
                    System.out.println("Treinos atuais: ");
                    academiaController.exibirTreinos();
                    System.out.println("Selecione um treino para ser adicionado o exercicio: ");
                    indexTreino = scanner.nextInt();
                    indexTreino = indexTreino - 1;
                    indexExercicio = indexExercicio - 1;

                    academiaController.adicionarExercicioTreino(academiaController.getTreinos().get(indexTreino), academiaController.getExercicios().get(indexExercicio));
                    break;
                case 6:
                    System.out.println("Alunos disponiveis ");
                    academiaController.exibirAlunos();
                    System.out.println("Selecione um aluno para visualizar seus treinos: ");
                    indexAluno = (scanner.nextInt() - 1);
                    academiaController.mostrarTreinosAluno(academiaController.getAlunos().get(indexAluno));
                    break;
                case 7:
                    if (academiaController.getTreinos().isEmpty()) {
                        System.out.println("Nenhum treino cadastrado ainda!");
                        continue;
                    }
                    academiaController.exibirTreinos();
                    break;
                case 8:
                    if (academiaController.getExercicios().isEmpty()) {
                        System.out.println("Nenhum exercicio cadastrado ainda!");
                        continue;
                    }
                    academiaController.exibirExercicios();
                    break;
                case 9:
                    System.out.println("Treinos disponíveis:");
                    academiaController.exibirTreinos();
                    System.out.println("Escolha um treino pra visualizar seus exercicios atuais: ");
                    indexTreino = scanner.nextInt();
                    System.out.println("Exercicios do treino: " + academiaController.getTreinos().get(indexTreino).getDescricaoTreino());
                    academiaController.mostrarExerciciosTreino(academiaController.getTreinos().get(indexTreino));
                default:
                    System.out.println("Opção inválida, por favor tente novamente!");
                    break;
            }
        } while (opcao != 0);
    }
}