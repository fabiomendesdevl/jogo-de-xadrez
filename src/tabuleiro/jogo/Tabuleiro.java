package tabuleiro.jogo;

public class Tabuleiro {

	private int linha;
	private int coluna;
	private Peca[][] pecas;

	public Tabuleiro(int linha, int coluna) {
		// programçao defensiva
		if (linha < 1 || coluna < 1) {
			throw new TabuleiroException(
					"Erro na criação do tabuleiro: Tem que haver pelo menos 1 linha e 1 coluna...");
		}
		this.linha = linha;
		this.coluna = coluna;
		pecas = new Peca[linha][coluna];
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}

	public Peca peca(int linha, int coluna) {
		if (!posicaoExiste(linha, coluna)) {
			throw new TabuleiroException("Essa posicão não existe no tabuleiro..." + linha + ", " + coluna);
		}
		return pecas[linha][coluna];
	}

	public Peca peca(Posicao posicao) {
		if (!posicaoExiste(posicao)) {
			throw new TabuleiroException("Essa posicão não existe no tabuleiro..." + posicao);
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}

	public void coloquePeca(Peca peca, Posicao posicao) {
		if (temPeca(posicao)) {
			throw new TabuleiroException("Tem uma peça nesssa posicação..." + posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}

	private boolean posicaoExiste(int linhas, int colunas) {
		return linhas >= 0 && linhas < linha && colunas >= 0 && colunas < coluna;
	}

	public boolean posicaoExiste(Posicao posicao) {
		return posicaoExiste(posicao.getLinha(), posicao.getColuna());
	}

	public boolean temPeca(Posicao posicao) {
		if (!posicaoExiste(posicao)) {
			throw new TabuleiroException("Essa posicão não existe no tabuleiro...");
		}
		return peca(posicao) != null;
	}

}
