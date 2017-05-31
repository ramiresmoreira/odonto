package br.edu.ifce.odonto.util;

import java.util.Comparator;

import br.edu.ifce.odonto.model.Horario;

public class ComparadorHorario implements Comparator<Horario>{

	@Override
	public int compare(Horario h1, Horario h2) {
		//comparando os dias da semana
//				if(h1.getDiaDaSemana().getValue() < h2.getDiaDaSemana().getValue())
//					return -1;
//				else if(h1.getDiaDaSemana().getValue() > h2.getDiaDaSemana().getValue())
//					return 1;
//				
//				//comparando os horarios do mesmo dia
//				if(h1.getDiaDaSemana().getValue() == h2.getDiaDaSemana().getValue()){
//					if(h1.getHorario().isBefore(h2.getHorario()))
//						return -1;
//					else if(h1.getHorario().isAfter(h2.getHorario()))
//						return 1;
//				}
				return 0;
	}

}
