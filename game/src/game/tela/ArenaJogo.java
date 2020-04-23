package game.tela;

import game.controle.ArenaControle;

public class ArenaJogo {

	public static void main(String[] args) {
		try {
			new ArenaControle().setup();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
