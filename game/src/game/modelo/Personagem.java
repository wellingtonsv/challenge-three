package game.modelo;

public class Personagem {

	private String nome;
	private int pontosDeEnergia;
	private int pontosdePoder;
	private boolean acao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontosDeEnergia() {
		return pontosDeEnergia;
	}

	public void setPontosDeEnergia(int pontosDeEnergia) {
		this.pontosDeEnergia = pontosDeEnergia;
	}

	public int getPontosdePoder() {
		return pontosdePoder;
	}

	public void setPontosdePoder(int pontosdePoder) {
		this.pontosdePoder = pontosdePoder;
	}

	public boolean isAcao() {
		return acao;
	}

	public void setAcao(boolean acao) {
		this.acao = acao;
	}

	public boolean hasEnergia() {
		if (this.getPontosDeEnergia() > 0) {
			return true;
		}
		return false;
	}
}