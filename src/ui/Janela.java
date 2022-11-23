package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import buttons.BotaoIniciar;
import buttons.Botao;
import buttons.BotaoFinalizar;
import cenario.CriarCenario;
import entities.ProcessarDados;

public class Janela extends JFrame {
	private static final long serialVersionUID = 1L;
	private ProcessarDados process;
	private LabelBotoes label;
	private CriarCenario cenario;

	public Janela(String title, CriarCenario cenario, ActionListener action, ProcessarDados process) {
		setTitle(title);
		setLayout(new BorderLayout());
		setSize(1280, 720);
		setLocation(100, 50);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		this.cenario=cenario;
		this.process = process;
		this.label = new LabelBotoes(cenario, action);
		addLabelSuperior();

	}

	public void addLabelSuperior() {
		JPanel labelSuperior = new JPanel();
		labelSuperior.setVisible(false);
		labelSuperior.setPreferredSize(new Dimension(100, 50));
		labelSuperior.add(new Botao("Iniciar", new BotaoIniciar(this)));
		labelSuperior.add(new Botao("Finalizar", new BotaoFinalizar(process,cenario)));
		add(BorderLayout.NORTH, labelSuperior);
		labelSuperior.setVisible(true);
	}

	public void addlabel(LabelBotoes label) {
		this.label = label;
		this.label.setVisible(false);
		add(BorderLayout.CENTER, this.label);
		this.label.setVisible(true);
	}

	public void addLabel() {
		label.setVisible(false);
		add(BorderLayout.CENTER, label);
		label.setVisible(true);
	}

	public ProcessarDados getProcess() {
		return process;
	}

}
