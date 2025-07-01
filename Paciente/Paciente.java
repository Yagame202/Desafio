package Paciente;

public class Paciente {
String nome;
double reducaoDor;
double melhoraMobilidade;

public Paciente(String nome, double reducaoDor, double melhoraMobilidade) {
	this.nome = nome;
	this.reducaoDor = reducaoDor;
	this.melhoraMobilidade = melhoraMobilidade;
	}
public String exibir() {
	double media = (reducaoDor + melhoraMobilidade)/2;
	String situacao = "";
		if (media >= 7) {
			situacao = "Alta próxima";
		}else if(media >= 4) {
			situacao = "Em tratamento";
		}else if(media < 4) {
			situacao = "Avaliação médica necessária";
		}
		return "Nome: " + nome + " | Média: " + media + " | Situação: " + situacao;
		
	}
public String exibir2() {
	double media = (reducaoDor + melhoraMobilidade)/2;
	String situacao = "";
		if (media >= 7) {
			situacao = "Alta próxima";
		}else if(media >= 4) {
			situacao = "Em tratamento";
		}else if(media < 4) {
			situacao = "Avaliação médica necessária";
		}
	return "Nome: " + nome + " | Situação: " + situacao;
	}
}