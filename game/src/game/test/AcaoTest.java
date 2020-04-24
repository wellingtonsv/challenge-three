package game.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import game.acao.Acao;
import game.exception.ErroIntenoException;
import game.modelo.Personagem;

public class AcaoTest {

	private Acao acao;

	@Before
	public void sertup() {
		acao = new Acao();
		acao.setModuloTeste(true);
	}

	@Test(expected = ErroIntenoException.class)
	public void naoDeveRealizarAtaqueComPersonagemNuloTest() throws ErroIntenoException {
		try {
			acao.ataque(null);
		} catch (ErroIntenoException eriex) {
			Assert.assertTrue("Deve ter uma mesagem de Erro.", !eriex.getMessage().isEmpty());
			Assert.assertTrue("Deve ser a mesma mesagem.", "Personagem no estado invalido".equals(eriex.getMessage()));
			throw new ErroIntenoException();
		}
	}

	@Test
	public void deveGerarMesagemErroHPTest() {
		try {
			acao.setFator(10);
			acao.ataque(new Personagem());
		} catch (ErroIntenoException eriex) {
			Assert.assertTrue("Não de ter mensagem de erro.",eriex.getMessage().isEmpty());
		}
	}
	
	@Test
	public void deveGerarMesagemNormalHPTest() {
		try {
			Personagem atacado = new Personagem("JogadorAtacado", 50, 40);
			acao.setFator(20);
			int energiaRestante = acao.ataque(atacado);
			Assert.assertTrue("Deve perder energia", energiaRestante<atacado.getPontosDeEnergia());
		} catch (ErroIntenoException eriex) {
			Assert.assertTrue("Não de ter mensagem de erro.",eriex.getMessage().isEmpty());
		}
	}
	
	@Test
	public void deveGerarMesagemSorteHPTest() {
		try {
			Personagem atacado = new Personagem("JogadorAtacado", 50, 40);
			acao.setFator(87);
			int energiaRestante = acao.ataque(atacado);
			Assert.assertTrue("Deve perder energia", energiaRestante<atacado.getPontosDeEnergia());
		} catch (ErroIntenoException eriex) {
			Assert.assertTrue("Não de ter mensagem de erro.",eriex.getMessage().isEmpty());
		}
	}
	
	@Test
	public void deveGerarMesagemCriticoHPTest() {
		try {
			Personagem atacado = new Personagem("JogadorAtacado", 50, 40);
			acao.setFator(98);
			int energiaRestante = acao.ataque(atacado);
			Assert.assertTrue("Deve perder energia", energiaRestante<atacado.getPontosDeEnergia());
		} catch (ErroIntenoException eriex) {
			Assert.assertTrue("Não de ter mensagem de erro.",eriex.getMessage().isEmpty());
		}
	}
	

}
