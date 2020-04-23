package game.controle;

import java.util.InputMismatchException;
import java.util.Scanner;

import game.acao.Acao;
import game.exception.ErroIntenoException;
import game.modelo.Personagem;

public class ArenaControle {

	Personagem personagem1 = new game.modelo.Personagem();
	Acao acao = new Acao();
	Personagem personagem2 = new Personagem();

	@SuppressWarnings("resource")
	public void setup() throws ErroIntenoException {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Entre a primeira personagem:");
			personagem1.setNome(scanner.next());
			scanner.nextLine();
			personagem1.setPontosDeEnergia(scanner.nextInt());
			scanner.nextLine();
			personagem1.setPontosdePoder(scanner.nextInt());
			scanner.nextLine();

			System.out.println(personagem1.getNome() + " " + personagem1.getPontosDeEnergia() + " "
					+ personagem1.getPontosdePoder());

			personagem2 = new Personagem();
			Scanner scanner2 = new Scanner(System.in);
			System.out.println("Entre a segunda personagem:");
			personagem2.setNome(scanner2.next());
			scanner2.nextLine();
			personagem2.setPontosDeEnergia(scanner2.nextInt());
			scanner2.nextLine();
			personagem2.setPontosdePoder(scanner2.nextInt());
			scanner2.nextLine();

			System.out.println(personagem2.getNome() + " " + personagem2.getPontosDeEnergia() + " "
					+ personagem2.getPontosdePoder());

			System.out.println("O jogo começou");

			int rodada = 0;
			personagem1.setAcao(true);
			System.out.println("Batalha entre " + personagem1.getNome() + " e " + personagem2.getNome());

			do {
				
				if (!personagem1.hasEnergia() | !personagem2.hasEnergia()) {
					break;
				} 
				
				if (personagem1.isAcao() && (rodada % 2 == 0)) {
					System.out.println(personagem1.getNome() + " atacou " + personagem2.getNome());
					int x = acao.ataque(personagem2);
					personagem2.setPontosDeEnergia(x);
					personagem1.setAcao(false);
					personagem2.setAcao(true);
				}

				if (personagem2.isAcao() && (rodada % 2 == 1)) {
					System.out.println(personagem2.getNome() + " atacou " + personagem1.getNome());
					int x = acao.ataque(personagem1);
					personagem1.setPontosDeEnergia(x);
					personagem2.setAcao(false);
					personagem1.setAcao(true);
				}
				
				if (!personagem1.hasEnergia() | !personagem2.hasEnergia()) {
					break;
				}
				rodada++;
			} while (true);

			if (personagem1.getPontosDeEnergia() == 0) {
				System.out.println("Jogo acabou, o vencedor foi " + personagem2.getNome() + " com HP restante de "
						+ personagem2.getPontosDeEnergia());
			} else {
				System.out.println("Jogo acabou, o vencedor foi " + personagem1.getNome() + " com HP restante de "
						+ personagem1.getPontosDeEnergia());
			}

		} catch (InputMismatchException ime) {
			System.err.println("Só é permido número na energia ou no poder!\n");
			return;
		} catch (ErroIntenoException erie) {
			System.err.println("Só é permido número na energia ou no poder!\n");
			return;
		}
	}
}
