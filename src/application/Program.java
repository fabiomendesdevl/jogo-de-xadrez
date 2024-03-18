package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;
import xadrez.XadrezException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		PartidaXadrez part = new PartidaXadrez();

		while (true) {
			try {
				UI.clearScreen();
				UI.printTabuleiro(part.getPecas());

				System.out.println();
				System.out.print("Origem: ");
				PosicaoXadrez origem = UI.readPosicaoXadrez(sc);

				System.out.println();
				System.out.print("Destino: ");
				PosicaoXadrez destino = UI.readPosicaoXadrez(sc);

				PecaXadrez capturaPeca = part.movaXadrez(origem, destino);
			} catch (XadrezException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}
}
