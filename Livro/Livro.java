package Livro;

public class Livro {
String titulo;
String autor;
int ano;

public Livro(String titulo, String autor, int ano) {
	 this.titulo = titulo;
	 this.autor = autor;
	 this.ano = ano;
	}
public String mostrar() {
	
	return "Titulo:" + titulo + "| autor:" + autor + "| ano:" + ano ;
	}
}
