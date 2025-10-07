package service;

import model.DiaDaSemana;
import model.DiaDeTreino;
import model.TipoDia;

public class DiaDeTreinoService {

    public DiaDeTreino criarDiaDeTreino(DiaDaSemana diaDaSemana, TipoDia tipoDia) {
        return new DiaDeTreino(diaDaSemana, tipoDia);
    }
}
