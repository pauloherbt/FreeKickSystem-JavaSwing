package cenario;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Chute extends Celula {
	private static final long serialVersionUID = 1L;

	public Chute(int posicaoX, int posicaoY) {
		super(posicaoX, posicaoY);
		Icon imageIcon = new ImageIcon("src/icons/bola.png");
		setIcon(imageIcon);
		setBackground(Color.orange);
	}

}
