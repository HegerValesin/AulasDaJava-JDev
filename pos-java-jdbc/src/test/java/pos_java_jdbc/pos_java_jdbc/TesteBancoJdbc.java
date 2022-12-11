package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() {
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();

		userposjava.setNome("Divys da Silva 6");
		userposjava.setEmail("duvysv@gmail.com");

		userPosDAO.salvar(userposjava);

	}

	@Test
	public void initListar() {
		UserPosDAO dao = new UserPosDAO();

		try {
			List<Userposjava> list = dao.listar();

			for (Userposjava userposjava : list) {
				System.out.println(userposjava); // Se quiser trazer só o nome basta acolocar userposjava.getNome()
				System.out.println("--------------------------------------------------");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void initBuscar() {

		UserPosDAO dao = new UserPosDAO();

		try {
			Userposjava userposjava = dao.buscar(2L);

			System.out.println(userposjava);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void iniAtualizar() {

		UserPosDAO dao = new UserPosDAO();

		try {
			Userposjava objetoBanco = dao.buscar(5L);
			objetoBanco.setNome("Divys da Silva 5");

			dao.atualizar(objetoBanco);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void iniDeletar() {
		try {
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(6L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void InsertFone() {
		Telefone telefone = new Telefone();
		
		telefone.setNumero("(85) 99620-6589");
		telefone.setUsuario(2L);
		telefone.setTipo("Celular");
		
		UserPosDAO dao = new UserPosDAO();
		dao.salvarTelefone(telefone);
	}
	
	@Test
	public void testeCarregaFoneUser() {
		UserPosDAO dao = new UserPosDAO();
		
		List<BeanUserFone> beanUserFones = dao.listaUserFone(3L);
		
		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
			System.out.println("---------------------------------------");
		}
		
	}
	
	@Test
	public void testedeleteFoneUser() {
		UserPosDAO dao = new UserPosDAO();
		dao.deleteFoneUser(7L);
	}
}
