package cenario;

import java.util.ArrayList;

public class CriarCenario {
	private ArrayList<Celula> celulas;
	private int numeroLinhas;
	private int numeroColunas;

	public CriarCenario(int numeroLinhas, int numeroColunas) {
		this.celulas = new ArrayList<>();
		this.numeroColunas = numeroColunas;
		this.numeroLinhas = numeroLinhas;
		mapearGol();
	}

	private void mapearGol() {
		criarTraveEsquerda();
		criarTraveDireita();
		criarTravessao();
		criarDentroGol();
		criarForaDoGol();
	}

	private void criarTraveEsquerda() {
		for (int i = 2; i < numeroLinhas; i++) {
			celulas.add(new Trave(i, 1));
		}
	}

	private void criarTraveDireita() {
		for (int i = 2; i < numeroLinhas; i++) {
			celulas.add(new Trave(i, numeroColunas - 2));
		}
	}

	private void criarTravessao() {
		for (int i = 1; i < numeroColunas - 1; i++) {
			celulas.add(new Trave(1, i));
		}
	}

	private void criarDentroGol() {
		for (int i = 2; i < numeroLinhas; i++) {
			for (int j = 2; j < numeroColunas - 2; j++) {
				celulas.add(new DentroGol(i, j));
			}
		}
	}

	private void criarForaDoGol() {
		// parte esquerda
		for (int i = 1; i < numeroLinhas; i++) {
			celulas.add(new Fora(i, 0));
		}
		// parte superior
		for (int i = 0; i < numeroColunas; i++) {
			celulas.add(new Fora(0, i));
		}
		// parte direita
		for (int i = 1; i < numeroLinhas; i++) {
			celulas.add(new Fora(i, numeroColunas - 1));
		}
	}


	public int getNumeroLinhas() {
		return numeroLinhas;
	}

	public int getNumeroColunas() {
		return numeroColunas;
	}

	public ArrayList<Celula> getCelulas() {
		return celulas;
	}


}
