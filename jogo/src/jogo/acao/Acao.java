package jogo.acao;

import java.math.BigDecimal;
import java.util.Random;

import jogo.exception.ErroIntenoException;
import jogo.modelo.Personagem;

public class Acao {

	private boolean ehModuloTeste = false;
	private int fator = 0;

	public int ataque(Personagem p) throws ErroIntenoException {
		return calculaAtaque(p);
	}

	private int calculaAtaque(Personagem p) throws ErroIntenoException {
		Random gerador = new Random();
		if (!ehModuloTeste) {
			fator = gerador.nextInt(100);
		}

		if (fator >= 0 && fator <= 15) {
			System.out.println("Errou - 0 HP");
			return p.getPontosDeEnergia();
		}

		if (fator >= 16 && fator <= 70) {
			BigDecimal umTerco = new BigDecimal(0.33);
			BigDecimal energia = new BigDecimal(p.getPontosDeEnergia());
			if (energia.doubleValue() <= 0.0) {
				return 0;
			}
			BigDecimal poder = new BigDecimal(p.getPontosdePoder());
			BigDecimal dano = (poder.multiply(umTerco));
			if (dano.doubleValue() <= 0.0) {
				return 0;
			}
			BigDecimal energiaRestante = energia.subtract(dano);
			System.out.println("Normal - " + dano.intValue() + " HP");
			return energiaRestante.intValue();
		}

		if (fator >= 71 && fator <= 96) {
			BigDecimal umTerco = new BigDecimal(0.33);
			BigDecimal vintePorCento = new BigDecimal(0.20);
			BigDecimal energia = new BigDecimal(p.getPontosDeEnergia());
			if (energia.doubleValue() <= 0.0) {
				return 0;
			}
			BigDecimal poder = new BigDecimal(p.getPontosdePoder());
			BigDecimal dano = (poder.multiply((umTerco.add(vintePorCento))));
			if (dano.doubleValue() <= 0.0) {
				return 0;
			}
			BigDecimal resultadoEnergia = energia.subtract(dano);
			System.out.println("Sorte!!! - " + dano.intValue() + " HP");
			return resultadoEnergia.intValue();
		}

		if (fator >= 97 && fator <= 100) {
			BigDecimal umTerco = new BigDecimal(0.33);
			BigDecimal quarentaPorCento = new BigDecimal(0.40);
			BigDecimal energia = new BigDecimal(p.getPontosDeEnergia());
			BigDecimal poder = new BigDecimal(p.getPontosdePoder());
			if (energia.doubleValue() <= 0.0) {
				return 0;
			}
			BigDecimal dano = (poder.multiply((umTerco.add(quarentaPorCento))));
			if (dano.doubleValue() <= 0.0) {
				return 0;
			}
			BigDecimal resultadoEnergia = energia.subtract(dano);
			System.out.println("Crítico! - " + dano.intValue() + " HP");
			return resultadoEnergia.intValue();
		}
		return p.getPontosDeEnergia();
	}

	public boolean isModuloTeste() {
		return ehModuloTeste;
	}

	public void setModuloTeste(boolean ehModuloTeste) {
		this.ehModuloTeste = ehModuloTeste;
	}

	public int getFator() {
		return fator;
	}

	public void setFator(int fator) {
		this.fator = fator;
	}
}