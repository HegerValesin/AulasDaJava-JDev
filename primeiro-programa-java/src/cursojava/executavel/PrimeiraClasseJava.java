package cursojava.executavel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;
import cursojava.classes.Secretario;
import cursojava.constantes.StatusAluno;

public class PrimeiraClasseJava {

	/* Main é um metado auto executável em Java */
	public static void main(String[] args) {

		List<Aluno> alunos = new ArrayList<Aluno>();

		List<Aluno> alunosAprovados = new ArrayList<Aluno>();
		List<Aluno> alunosRecuperacao = new ArrayList<Aluno>();
		List<Aluno> alunosRepovados = new ArrayList<Aluno>();
		
		
		String login = JOptionPane.showInputDialog("Informe o login");
		String senha = JOptionPane.showInputDialog("Informe a Senha");
		
		
				
		if (new Secretario().autenticar(login, senha)) {
		for (int qtd = 1; qtd <= 6; qtd++) {

			String nome = JOptionPane.showInputDialog("Qual o nome do Aluno?");
			// String idade = JOptionPane.showInputDialog("Qual a idade ?");

			/*
			 * //Objeto ainda não existe na memoria Aluno aluno;
			 */
			Aluno aluno1 = new Aluno();

			/* Objeto o objeto esta na memoria */
			aluno1.setNome(nome);
			// aluno1.setIdade(Integer.valueOf(idade));

			for (int pos = 1; pos <= 1; pos++) {
				String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina " + pos + " ?");
				String notaDisciplina = JOptionPane.showInputDialog("Nota da disciplina " + pos + " ?");

				Disciplina disciplina = new Disciplina();
				disciplina.setDisciplina(nomeDisciplina);
				disciplina.setNota(Double.valueOf(notaDisciplina));

				aluno1.getDisciplinas().add(disciplina);
			}

			/* Removendo um disciplina */
			/*int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");

			if (escolha == 0) {
				String disciplinaRemover = JOptionPane.showInputDialog("Qual a diciplina 1, 2, 3 ou 4 ?");
				aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - 1);
			}*/
			alunos.add(aluno1);
		}

		/*
		 * Vamos processar alunos para colocar nas listas de repovados e aprovados
		 */

		for (Aluno aluno : alunos) {

			if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
				alunosAprovados.add(aluno);
			} else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
				alunosRecuperacao.add(aluno);
			} else {
				alunosRepovados.add(aluno);
			}
		}

		System.out.println("------------------- Lista de Aprovados-------------------");
		for (Aluno aluno : alunosAprovados) {
			System.out.println("Resultados = " + aluno.getAlunoAprovado2() +" do aluno "+ aluno.getNome()+ " com média de = " + aluno.getMediaNota());
		}

		System.out.println("------------------- Lista de Recuperação-------------------");
		for (Aluno aluno : alunosRecuperacao) {
			System.out.println("Resultados = " + aluno.getAlunoAprovado2()  +" do aluno "+ aluno.getNome()+  " com média de = " + aluno.getMediaNota());
		}

		System.out.println("------------------- Lista de Reprovados-------------------");
		for (Aluno aluno : alunosRepovados) {
			System.out.println("Resultados = " + aluno.getAlunoAprovado2()  +" do aluno "+ aluno.getNome()+  " com média de = " + aluno.getMediaNota());
		}
		}else {
			JOptionPane.showMessageDialog(null, "Acesso não permitido!!");
		}

		/*
		 * Trocar de aluno no momento de execução
		 */

		/*
		 * for (int pos = 0; pos < alunos.size(); pos++) {
		 * 
		 * Aluno aluno = alunos.get(pos);
		 * 
		 * if (aluno.getNome().equalsIgnoreCase("heger")) { Aluno trocar = new Aluno();
		 * 
		 * trocar.setNome("Divys da Silva");
		 * 
		 * Disciplina disciplina = new Disciplina();
		 * disciplina.setDisciplina("Matematica"); disciplina.setNota(97);
		 * 
		 * trocar.getDisciplinas().add(disciplina);
		 * 
		 * alunos.set(pos, trocar); aluno = alunos.get(pos); }
		 * 
		 * System.out.println("Aluno = "+ aluno.getNome());
		 * System.out.println("Madia do aluno = "+ aluno.getMediaNota());
		 * System.out.println("Resultado = " + aluno.getAlunoAprovado2());
		 * System.out.println("----------------------------------------------");
		 * 
		 * for (int posd = 0; posd<aluno.getDisciplinas().size(); posd++) { Disciplina
		 * disc = aluno.getDisciplinas().get(posd); System.out.println("Materia = " +
		 * disc.getDisciplina() + " Nota = " + disc.getNota()); }
		 * System.out.println("----------------------------------------------");
		 * System.out.println("----------------------------------------------"); }
		 */

		/*
		 * for (Aluno aluno : alunos) {
		 * 
		 * //percorrer uma lista e encontrar um aluno if
		 * (aluno.getNome().equalsIgnoreCase("Heger")) { System.out.println("O aluno " +
		 * aluno.getNome()+ " foi removido"); System.out.println(
		 * "-----------------------------------------------------------------------------------------------------------------"
		 * ); alunos.remove(aluno); //Remover o aluno da lista break; }else {
		 * 
		 * System.out.println(aluno); System.out.println("O nome é " + aluno.getNome() +
		 * " com a idade " + aluno.getIdade()); System.out.println("Média da nota é = "
		 * + aluno.getMediaNota()); System.out.println("Resultado = " +
		 * (aluno.getAlunoAprovado() ? "Aprovado" : "Reprovado"));
		 * 
		 * System.out.println(aluno.getDisciplinas()); System.out.println(
		 * "----------------------------------------------------------------------------------------------------"
		 * );
		 * 
		 * } }
		 */
		/*
		 * pega a lista de alunos que restou e imprime com suas materias
		 */
		/*
		 * for (Aluno aluno : alunos) {
		 * System.out.println("Aluno que sobraram na lista");
		 * System.out.println((aluno.getNome())); System.out.println("Sua matéria são");
		 * 
		 * for (Disciplina disciplina : aluno.getDisciplinas()) {
		 * System.out.println(disciplina.getDisciplina()); } }
		 */

	}

}
