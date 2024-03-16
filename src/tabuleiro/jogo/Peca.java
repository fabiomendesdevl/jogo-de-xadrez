package tabuleiro.jogo;

public class Peca {

	protected Posicao posicao;
	private Tabuleiro tabuleiro;

	public Peca(Tabuleiro tabuleiro) {
		super();
		this.tabuleiro = tabuleiro;
		posicao = null;
	}

	// Nao permite que o tabuleiro possa ser alterado
	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

}
