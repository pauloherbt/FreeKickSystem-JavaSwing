package ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import cenario.CriarCenario;
import entities.ProcessarDados;

public class JanelaResultados extends JFrame {
	private static final long serialVersionUID = 1L;
	public JanelaResultados(ProcessarDados process,CriarCenario cenario) {
		setTitle("Resultados");
		setLayout(new BorderLayout());
		setSize(600,600);
		setLocation(100, 50);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		add(new PanelPrincipal(process, cenario));
	}
}
