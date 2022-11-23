package cenario;

import javax.swing.JButton;

public class Celula extends JButton {
	private static final long serialVersionUID = 1L;
	private int posicaoX;
	private int posicaoY;
	private int gols;
	private int defesas;

	public Celula(int posicaoX, int posicaoY) {
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
	}

	public int getPosicaoX() {
		return posicaoX;
	}

	public int getPosicaoY() {
		return posicaoY;
	}

	public int getGols() {
		return gols;
	}

	public void addGols() {
		this.gols++;
	}

	public int getDefesas() {
		return defesas;
	}

	public void addDefesas() {
		this.defesas++;
	}

}
