package buttons;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import ui.Janela;

public class Botao extends JButton {

	private static final long serialVersionUID = 1L;

	public Botao(String text,Janela janela) {
		setText(text);
		addActionListener(new BotaoIniciar(janela));
	}

	public Botao(String text,ActionListener actionButton) {
		setText(text);
		addActionListener(actionButton);
	}
	
}
