package game.test;

import org.junit.Before;
import org.junit.Test;

import game.controle.ArenaControle;
import game.modelo.Personagem;

public class ArenaControleTest {
	
	private ArenaControle arena;
	
	@Before
	public void sertup() {
		arena = new ArenaControle();
		arena.getAcao().setModuloTeste(true);
	}
	
	@Test
	public void jogadorOneVenceUnitTest() {
		arena.setPersonagem1(new Personagem("Jogador1", 30, 40));
		arena.setPersonagem2(new Personagem("Jogador2", 0, 50));
		arena.verificaVencedor();
	}
	
	@Test
	public void jogadorTowVenceUnitTest() {
		arena.setPersonagem1(new Personagem("Jogador1", 0, 40));
		arena.setPersonagem2(new Personagem("Jogador2", 30, 50));
		arena.verificaVencedor();
	}
}
