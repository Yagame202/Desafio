package Correcao;

public class Aluno {
	String nome;
	double nota1;
	double nota2;
	
	public Aluno(String nome, double nota1, double nota2) {
		this.nome = nome;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}
	
	public double calcularMedia() {
		return (nota1+nota2)/2;
	}
	
	public String verificarSituacao() {
		double media = calcularMedia();
		if(media >= 7) {
			return "Aprovado";
		}
		else if(media >= 4) {
			return "Recuperação";
		}
		else {
			return "Reprovado";
		}
	}

}
