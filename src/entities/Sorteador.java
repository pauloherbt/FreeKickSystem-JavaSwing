package entities;

import java.util.Random;

import cenario.CriarCenario;
import cenario.PosInicialGoleiro;
import cenario.PosMaoDireita;
import cenario.PosMaoEsquerda;

public class Sorteador {
	
	private PosInicialGoleiro posGoleiro;
	private PosMaoDireita maoDireita;
	private PosMaoEsquerda maoEsquerda;
	private CriarCenario c;
	
	public Sorteador(CriarCenario c) {
		this.c=c;
		sortearPosicoes();
	}
	private void sortearPosicoes() {
		Random rd= new Random();
		sortearGoleiro(rd);
		sortearMaoEsquerda(rd);
		sortearMaoDireita(rd);
		
	}
	private void sortearGoleiro(Random rd) {
		int x=c.getNumeroLinhas()-1;
		int y=rd.nextInt(c.getNumeroColunas());
		posGoleiro= new PosInicialGoleiro(x,y);
		
	}
	private void sortearMaoEsquerda(Random rd) {
		int x;
		int y;
		boolean flag= false;
		do {
			x=rd.nextInt(c.getNumeroLinhas());
			y=rd.nextInt(c.getNumeroColunas());
			flag=y<=posGoleiro.getY()?true:false;
		}while(flag==false);
		maoEsquerda= new PosMaoEsquerda(x,y);
	}
	private void sortearMaoDireita(Random rd) {
		int x;
		int y;
		boolean flag=false;
		do {
			x=rd.nextInt(c.getNumeroLinhas());
			y=rd.nextInt(c.getNumeroColunas());
			flag=y>=posGoleiro.getY()? true:false;
		}while(flag==false);
		maoDireita= new PosMaoDireita(x,y);
	}
	
	public PosInicialGoleiro getPosGoleiro() {
		return posGoleiro;
	}
	public PosMaoDireita getMaoDireita() {
		return maoDireita;
	}
	public PosMaoEsquerda getMaoEsquerda() {
		return maoEsquerda;
	}
	
	
}
