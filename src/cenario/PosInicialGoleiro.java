package cenario;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class PosInicialGoleiro extends Celula {
	private static final long serialVersionUID = 1L;

	public PosInicialGoleiro(int posicaoX, int posicaoY) {
		super(posicaoX, posicaoY);
		setBackground(Color.orange);
		Icon imageIcon = new ImageIcon("src/icons/golicon.png");
		setIcon(imageIcon);
		
		
	}

}
