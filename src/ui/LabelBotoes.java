package ui;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import cenario.Celula;
import cenario.CriarCenario;
import entities.Goleiro;

public class LabelBotoes extends JPanel {
	private static final long serialVersionUID = 1L;
	private ActionListener action;

	public LabelBotoes(CriarCenario c, ActionListener action) {
		this.action = action;
		setLayout(new GridLayout(9, 17));
		addBotoes(c.getCelulas(),action);
	}

	public LabelBotoes(Goleiro gol) {
		setLayout(new GridLayout(9, 17));
		addBotoes(gol.getCelulas(),action);
	}
	public LabelBotoes(ArrayList<Celula> celulas) {
		setLayout(new GridLayout(9, 17));
		addBotoes(celulas,null);
	}

	private void addBotoes(ArrayList<Celula> celulas,ActionListener action) {
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 17; y++) {
				ordenar(x, y, celulas,action);
			}
		}
	}

	private void ordenar(int x, int y, ArrayList<Celula> celulas,ActionListener action) {
		for (Celula botao : celulas) {
			if (botao.getPosicaoX() == x && botao.getPosicaoY() == y) {
				botao.addActionListener(action);
				add(botao);
			}
		}
	}
}
