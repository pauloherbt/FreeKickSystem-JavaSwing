package cenario;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class PosMaoDireita extends Celula {
	private static final long serialVersionUID = 1L;

	public PosMaoDireita(int posicaoX, int posicaoY) {
		super(posicaoX, posicaoY);
		Icon imageIcon = new ImageIcon("src/icons/maodireita.png");
		setIcon(imageIcon);
		setBackground(Color.orange);
	}
	
}
