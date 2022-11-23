package entities;

import java.util.ArrayList;

import cenario.AreaDoGoleiro;
import cenario.Celula;
import cenario.Chute;
import cenario.PosInicialGoleiro;
import cenario.PosMaoDireita;
import cenario.PosMaoEsquerda;

public class Goleiro {
	private ArrayList<Celula> celulas;
	private PosInicialGoleiro posGoleiro;
	private PosMaoDireita maoDireita;
	private PosMaoEsquerda maoEsquerda;

	public Goleiro(Sorteador sc, ArrayList<Celula> celulas) {
		this.posGoleiro = sc.getPosGoleiro();
		this.maoDireita = sc.getMaoDireita();
		this.maoEsquerda = sc.getMaoEsquerda();
		this.celulas = celulas;
	}

	public void mapearArea() {
		criarSegmentoEsquerdo();
		criarSegmentoDireito();
		addPosIniciais();
	}

	private void addPosIniciais() {
		addExtremidade(posGoleiro);
		addExtremidade(maoDireita);
		addExtremidade(maoEsquerda);
	}

	private void addExtremidade(Celula celula) {
		celulas.remove(buscarCelula(celula.getPosicaoX(), celula.getPosicaoY()));
		celulas.add(celula);
	}

	private Celula buscarCelula(int x, int y) {
		for (Celula celula : celulas) {
			if (celula.getPosicaoX() == x && celula.getPosicaoY() == y) {
				return celula;
			}
		}
		return null;
	}

	public void addArea(int x, int y) {
		celulas.remove(buscarCelula(x, y));
		celulas.add(new AreaDoGoleiro(x, y));
	}

	private void criarSegmentoEsquerdo() {
		mesmaLinhaEsquerda();
		int linhaLimite = maoEsquerda.getPosicaoX();
		int contador = razaoGolMaoEsquerda();
		for (int x = posGoleiro.getPosicaoX() - 1; x >= linhaLimite; x--) {
			int y = posGoleiro.getPosicaoY();
			addArea(x, y);
			criarAdjacenteEsquerda(x, y, contador);
			contador += contador;
		}

	}

	private void criarSegmentoDireito() {
		mesmaLinhaDireita();
		int linhaLimite = maoDireita.getPosicaoX();
		int contador = razaoGolMaoDireita();
		for (int x = posGoleiro.getPosicaoX() - 1; x >= linhaLimite; x--) {
			int y = posGoleiro.getPosicaoY();
			addArea(x, y);
			criarAdjacenteDireita(x, y, contador);
			contador += contador;
		}
	}

	private void criarAdjacenteDireita(int x, int y, int contador) {
		for (int i = 0; i < contador; i++) {
			y++;
			if (y < maoDireita.getPosicaoY()) {
				addArea(x, y);
			}
		}
	}

	private void criarAdjacenteEsquerda(int x, int y, int contador) {
		for (int i = 0; i < contador; i++) {
			y--;
			if (y > maoEsquerda.getPosicaoY()) {
				addArea(x, y);
			}
		}
	}

	private void mesmaLinhaEsquerda() {
		if (posGoleiro.getPosicaoX() == maoEsquerda.getPosicaoX()) {
			for (int y = posGoleiro.getPosicaoY(); y > maoEsquerda.getPosicaoY(); y--) {
				addArea(posGoleiro.getPosicaoX(), y);
			}
		}
	}

	private void mesmaLinhaDireita() {
		if (posGoleiro.getPosicaoX() == maoDireita.getPosicaoX()) {
			for (int y = posGoleiro.getPosicaoY(); y < maoDireita.getPosicaoY(); y++) {
				addArea(posGoleiro.getPosicaoX(), y);
			}
		}
	}

	private int razaoGolMaoDireita() {
		int diffColuna = (maoDireita.getPosicaoY() - posGoleiro.getPosicaoY()) - 1;
		int diffLinha = (posGoleiro.getPosicaoX() - maoDireita.getPosicaoX()) - 1;
		return verificaRazao(diffColuna, diffLinha);
	}

	private int razaoGolMaoEsquerda() {
		int diffColuna = (posGoleiro.getPosicaoY() - maoEsquerda.getPosicaoY()) - 1;
		int diffLinha = (posGoleiro.getPosicaoX() - maoEsquerda.getPosicaoX()) - 1;
		return verificaRazao(diffColuna, diffLinha);
	}
	public void addChute(int x,int y) {
		celulas.remove(buscarCelula(x, y));
		celulas.add(new Chute(x,y));
	}
	private int verificaRazao(int diffColuna, int diffLinha) {
		int razao = 0;
		try {
			razao = diffColuna / diffLinha;
		} catch (Exception e) {
			return 0;
		}
		if (diffColuna % diffLinha == 0) {
			return razao;
		} else
			return razao + 1;
	}

	public ArrayList<Celula> getCelulas() {
		return celulas;
	}

}
