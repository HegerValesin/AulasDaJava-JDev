package cursojava.executavel;

import cursojava.classes.Aluno;
import cursojava.classes.Diretor;
import cursojava.classes.Secretario;

public class TestandoClassesFilhas {
	public static void main(String[] args) {

		Aluno aluno = new Aluno();
		aluno.setNome("Heger Valesin");
		aluno.setNomeEscola("Jdev -Treinamentos");
		
		Diretor diretor = new Diretor();
		diretor.setRegistroEducacao("792852125444");
		diretor.setNome("Divianny Vieira");
		
		Secretario secretario = new Secretario();
		secretario.setNivelCargo("Administrativo");
		secretario.setNome("Enzo Vieira");
		
		
		System.out.println(aluno);
		System.out.println(diretor);
		System.out.println(secretario);
	}
}
