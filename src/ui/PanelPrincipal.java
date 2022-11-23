package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cenario.Celula;
import cenario.CriarCenario;
import entities.ProcessarDados;

public class PanelPrincipal extends JPanel {
	private static final long serialVersionUID = 1L;
	private ProcessarDados process;
	private CriarCenario cenario;

	public PanelPrincipal(ProcessarDados process, CriarCenario cenario) {
		this.process = process;
		this.cenario = cenario;
		setLayout(new BorderLayout());
		addLabelSuperior();
		mostrarOcorrencias();
	}

	private void addLabelSuperior() {
		JPanel superior = new JPanel();
		superior.setPreferredSize(new Dimension(100, 100));
		superior.setLayout(new GridLayout(3, 1, 0, 0));
		superior.setAlignmentX(CENTER_ALIGNMENT);
		add(BorderLayout.NORTH, superior);
		JLabel nome = new JLabel("Jogador: " + process.getNome() + " Pontuacao: " + process.totalGols() + " gols"
				+ " Maquina: " + process.totalDefesas() + " defesas");
		superior.add(nome);
		JLabel ocorrencia = new JLabel("OCORRENCIAS DE DEFESAS");
		superior.add(ocorrencia);
		JLabel quantidade = new JLabel("Mao esquerda: " + process.defesasMaoEsquerda() + " Mao direita: "
				+ process.defesasMaoDireita() + " Posicao do goleiro: " + process.defesasPosGoleiro());
		superior.add(quantidade);
	}

	public void mostrarOcorrencias() {
		ArrayList<Celula> ocorrencias = new ArrayList<>();
		for (Celula celula : cenario.getCelulas()) {
			Celula celulaEncontrada = procurarOcorrencia(celula);

			if (celulaEncontrada != null) {
				if (celulaEncontrada.getGols() > 0) {
					celulaEncontrada.setIcon(new ImageIcon("src/icons/bola.png"));
				} else if (celulaEncontrada.getDefesas() > 0) {
					celulaEncontrada.setIcon(new ImageIcon("src/icons/can.png"));
				}
				ocorrencias.add(celulaEncontrada);
			} else {
				celula.setEnabled(false);
				ocorrencias.add(celula);
			}

		}
		JPanel painel = new LabelBotoes(ocorrencias);
		add(BorderLayout.CENTER, painel);
	}

	private Celula procurarOcorrencia(Celula celula) {
		for (Celula ocorrencia : process.getOcorrencias()) {
			if (ocorrencia.getPosicaoX() == celula.getPosicaoX() && ocorrencia.getPosicaoY() == celula.getPosicaoY()) {
				return ocorrencia;
			}
		}
		return null;
	}
}
