package application;

import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		PartidaXadrez part = new PartidaXadrez();
		
		
		while(true) {
		UI.printTabuleiro(part.getPecas());
	
		System.out.println();
		System.out.print("Origem: ");
		PosicaoXadrez origem = UI.readPosicaoXadrez(sc);
		
		
		System.out.println();
		System.out.print("Destino: ");
		PosicaoXadrez destino = UI.readPosicaoXadrez(sc);
				
		PecaXadrez capturaPeca = part.movaXadrez(origem, destino);
		}
	}
}
