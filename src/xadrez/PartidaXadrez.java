package xadrez;

import tabuleiro.jogo.Peca;
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
	
	public PecaXadrez movaXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
		
		Posicao origem = posicaoOrigem.paraPosicao();
		Posicao destino = posicaoDestino.paraPosicao();
		validacaoDeOrigem(origem);
		Peca capturaPeca = movePeca(origem, destino);
		return (PecaXadrez)capturaPeca;
	}
	
	private Peca movePeca(Posicao origem, Posicao destino) {
		Peca p = tabuleiro.removePeca(origem);
		Peca capturaPeca = tabuleiro.removePeca(destino);
		tabuleiro.coloquePeca(p, destino);
		
		return capturaPeca;
	}
	
	private void validacaoDeOrigem(Posicao posicao) {
		if(!tabuleiro.temPeca(posicao)) {
			throw new XadrezException("Não existe peça na posicao de origem...");
		}
		if(tabuleiro.peca(posicao).movimentoExiste()) {
			throw new XadrezException("Não existe movimento possivel para a peça escolhida...");
		}
	}
	
	private void cNovaPeca(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.coloquePeca(peca, new PosicaoXadrez(coluna, linha).paraPosicao());
	}

	private void iniciarPartida() {
		
		cNovaPeca('c', 1, new Torre(tabuleiro, Color.WHITE));
        cNovaPeca('c', 2, new Torre(tabuleiro, Color.WHITE));
        cNovaPeca('d', 2, new Torre(tabuleiro, Color.WHITE));
        cNovaPeca('e', 2, new Torre(tabuleiro, Color.WHITE));
        cNovaPeca('e', 1, new Torre(tabuleiro, Color.WHITE));
        cNovaPeca('d', 1, new Rei(tabuleiro, Color.WHITE));
        cNovaPeca('c', 7, new Torre(tabuleiro, Color.BLACK));
        cNovaPeca('c', 8, new Torre(tabuleiro, Color.BLACK));
        cNovaPeca('d', 7, new Torre(tabuleiro, Color.BLACK));
        cNovaPeca('e', 7, new Torre(tabuleiro, Color.BLACK));
        cNovaPeca('e', 8, new Torre(tabuleiro, Color.BLACK));
        cNovaPeca('d', 8, new Rei(tabuleiro, Color.BLACK));
	}
}
