package xadrez;

import tabuleiro.jogo.Posicao;
import tabuleiro.jogo.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {

	private Tabuleiro tabuleiro;

	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		iniciarPartida();
	}

	public PecaXadrez[][] getPecas() {
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinha()][tabuleiro.getColuna()];
		for (int i = 0; i < tabuleiro.getLinha(); i++) {
			for (int j = 0; j < tabuleiro.getColuna(); j++) {
				mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
			}
		}
		return mat;
	}

	private void iniciarPartida() {
		tabuleiro.coloquePeca(new Torre(tabuleiro, Color.BRANCO), new Posicao(2, 1));
		tabuleiro.coloquePeca(new Rei(tabuleiro, Color.PRETO), new Posicao(0, 4));
		tabuleiro.coloquePeca(new Rei(tabuleiro, Color.BRANCO), new Posicao(7, 4));
	}

}
