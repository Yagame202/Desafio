package evento;

public class Registro {
String nome;
String email;
double qtdhora;

public Registro(String nome, String email, double qtdhora) {
	this.nome = nome;
	this.email = email;
	this.qtdhora = qtdhora;
}
public String exibir() {
	return "Nome:" + nome + " | " + "Email:" + email +  " | " + "Quantidade de horas" + "|" + qtdhora + "|";
	}
public String direitoCertificado() {
	double certificado = 5;
	if (qtdhora >= certificado) {
		return "Tem direito a certificado!";
		}else {
		return "Não tem direito a certificado";
		}
	}
}
