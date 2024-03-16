package application;

import xadrez.PartidaXadrez;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PartidaXadrez part = new PartidaXadrez();
		
		UI.printTabuleiro(part.getPecas());
	}

}
