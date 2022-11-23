package entities;

import java.util.ArrayList;

import cenario.AreaDoGoleiro;
import cenario.Celula;
import cenario.DentroGol;
import cenario.PosInicialGoleiro;
import cenario.PosMaoDireita;
import cenario.PosMaoEsquerda;

public class ProcessarDados {
	private String nome;
	private ArrayList<Celula> ocorrencias;

	public ProcessarDados() {
		this.ocorrencias = new ArrayList<>();
	}

	public void computar(int chuteX, int chuteY, ArrayList<Celula> celulas) {
		Celula celulaEncontrada = pesquisarPosicao(chuteX, chuteY, celulas);

		if (celulaEncontrada instanceof AreaDoGoleiro
				||celulaEncontrada instanceof PosInicialGoleiro
				||celulaEncontrada instanceof PosMaoDireita
				||celulaEncontrada instanceof PosMaoEsquerda) {
		
			celulaEncontrada.addDefesas();
		} else if (celulaEncontrada instanceof DentroGol) {
			celulaEncontrada.addGols();
		}
		ocorrencias.add(celulaEncontrada);
	}

	private Celula pesquisarPosicao(int chuteX, int chuteY, ArrayList<Celula> celulas) {
		for (Celula celula : celulas) {
			if (celula.getPosicaoX() == chuteX && celula.getPosicaoY() == chuteY) {
				return celula;
			}
		}
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int totalGols() {
		int total = 0;
		for (Celula celula : ocorrencias) {
			total += celula.getGols();
		}
		return total;
	}

	public int totalDefesas() {
		int total = 0;
		for (Celula celula : ocorrencias) {
			total += celula.getDefesas();
		}
		return total;
	}

	public int defesasMaoEsquerda() {
		int total = 0;
		for (Celula celula : ocorrencias) {
			if (celula instanceof PosMaoEsquerda) {
				total += celula.getDefesas();
			}
		}
		return total;
	}

	public int defesasMaoDireita() {
		int total = 0;
		for (Celula celula : ocorrencias) {
			if (celula instanceof PosMaoDireita) {
				total += celula.getDefesas();
			}
		}
		return total;
	}

	public int defesasPosGoleiro() {
		int total = 0;
		for (Celula celula : ocorrencias) {
			if (celula instanceof PosInicialGoleiro) {
				total += celula.getDefesas();
			}
		}
		return total;
	}

	public ArrayList<Celula> getOcorrencias() {
		return ocorrencias;
	}

}
