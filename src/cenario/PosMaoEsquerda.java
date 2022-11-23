package cenario;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class PosMaoEsquerda extends Celula{
	private static final long serialVersionUID = 1L;

	public PosMaoEsquerda(int posicaoX, int posicaoY) {
		super(posicaoX, posicaoY);
		Icon imageIcon = new ImageIcon("src/icons/maoesquerda.png");
		setIcon(imageIcon);
		setBackground(Color.orange);
	}
	
}
