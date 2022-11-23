package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cenario.CriarCenario;
import entities.ProcessarDados;
import ui.JanelaResultados;

public class BotaoFinalizar implements ActionListener {
	private ProcessarDados process;
	private CriarCenario cenario;
	public BotaoFinalizar(ProcessarDados process,CriarCenario cenario) {
		this.process = process;
		this.cenario=cenario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JanelaResultados janela= new JanelaResultados(process,cenario);
	}
	
}
