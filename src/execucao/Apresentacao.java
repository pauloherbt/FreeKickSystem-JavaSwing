package execucao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cenario.Celula;
import cenario.CriarCenario;
import entities.Goleiro;
import entities.ProcessarDados;
import entities.Sorteador;
import ui.Janela;
import ui.LabelBotoes;

public class Apresentacao implements ActionListener {
	private CriarCenario cenario;
	private ProcessarDados process;
	private Sorteador sortear;
	private Goleiro goleiro;
	private Janela janela;

	public Apresentacao() {
		cenario = new CriarCenario(9, 17);
		process = new ProcessarDados();
		janela = new Janela("Programa", cenario, this, process);
	}

	public void start(int x, int y) {
		cenario = new CriarCenario(9, 17);
		sortear = new Sorteador(cenario);
		goleiro = new Goleiro(sortear, cenario.getCelulas());
		goleiro.mapearArea();
		process.computar(x, y, goleiro.getCelulas());
	}

	public void mudarLabel(Celula botao) {
		goleiro.addChute(botao.getPosicaoX(), botao.getPosicaoY());
		LabelBotoes label = new LabelBotoes(goleiro);
		janela.addlabel(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Celula botao = (Celula) e.getSource();
		start(botao.getPosicaoX(), botao.getPosicaoY());
		mudarLabel(botao);

	}

}
