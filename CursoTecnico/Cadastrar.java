package CursoTecnico;
public class Cadastrar {
String prjNome;
String rpNome;
String status;


public Cadastrar(String prjNome, String rpNome, String status) {
	this.prjNome = prjNome;
	this.rpNome = rpNome;
	this.status = status;
	
	
	}

public String escStatus() {

	return " | " +"Nome do Projeto:" + " " + prjNome + " | " + "Nome do responsavel: " + rpNome + " | " + "Status:" + " " + status;
	}
}

