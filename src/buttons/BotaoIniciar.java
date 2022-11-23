package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ui.Janela;

public class BotaoIniciar implements ActionListener {
	private Janela label;
	public BotaoIniciar(Janela janela) {
		this.label=janela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = JOptionPane.showInputDialog(null,"Digite seu nome",null,1);
		label.getProcess().setNome(name);
		label.addLabel();
	}

}
