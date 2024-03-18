package tabuleiro.jogo;

public abstract class Peca {

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

	public abstract boolean[][] possivelMovimentos();

	public boolean possivelMovimento(Posicao posicao) {
		return possivelMovimentos()[posicao.getLinha()][posicao.getColuna()];
	}

	public boolean movimentoExiste() {
		boolean[][] mat = possivelMovimentos();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}
