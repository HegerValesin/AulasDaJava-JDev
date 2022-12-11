package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import conexaojdbc.SingleConnection;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class UserPosDAO {

	private Connection connection;

	public UserPosDAO() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(Userposjava userposjava) {
		try {
			String sql = "insert into userposjava (nome, email) values (?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);

			insert.setString(1, userposjava.getNome());
			insert.setString(2, userposjava.getEmail());
			insert.execute();
			connection.commit();

		} catch (Exception e) {

			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public void salvarTelefone(Telefone telefone) {

		try {
			String sql = "INSERT INTO telefoneuser (numero, usuariopessoa, tipo) VALUES (?, ?, ?)";
			PreparedStatement insertFone = connection.prepareStatement(sql);
			
			insertFone.setString(1, telefone.getNumero());
			insertFone.setString(3, telefone.getTipo());
			insertFone.setLong(2, telefone.getUsuario());
			insertFone.execute();
			
			connection.commit();
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	public List<Userposjava> listar() throws Exception {
		List<Userposjava> list = new ArrayList<Userposjava>();

		String sql = "select * from userposjava";

		PreparedStatement startment = connection.prepareStatement(sql);
		ResultSet resultado = startment.executeQuery();

		while (resultado.next()) {
			Userposjava userposjava = new Userposjava();
			userposjava.setId(resultado.getLong("id"));
			userposjava.setNome(resultado.getString("nome"));
			userposjava.setEmail(resultado.getString("email"));

			list.add(userposjava);
		}

		return list;
	}

	public Userposjava buscar(Long id) throws Exception {
		Userposjava retorno = new Userposjava();

		String sql = "select * from userposjava where id = " + id;

		PreparedStatement startment = connection.prepareStatement(sql);
		ResultSet resultado = startment.executeQuery();

		while (resultado.next()) {
			Userposjava userposjava = new Userposjava();
			retorno.setId(resultado.getLong("id"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setEmail(resultado.getString("email"));

		}

		return retorno;
	}

	public void atualizar(Userposjava userposjava) {
		try {
			String sql = "update userposjava set nome = ? where id = " + userposjava.getId();
			PreparedStatement startement = connection.prepareStatement(sql);

			startement.setString(1, userposjava.getNome());

			startement.execute();
			connection.commit();
		} catch (SQLException e) {

			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	public void deletar(Long id) {
		try {
			String sql = "delete from userposjava where id = " + id;
			PreparedStatement del = connection.prepareStatement(sql);
			del.execute();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public List<BeanUserFone> listaUserFone(Long idUser) {
		List<BeanUserFone> beanUserFones = new ArrayList<BeanUserFone>();
		String sql = " select upj.nome, upj.email, tu.tipo, tu.numero from userposjava as upj ";
		sql += " inner join telefoneuser as tu ";
		sql += " on tu.usuariopessoa = upj.id ";
		sql += " where upj.id = " + idUser;
		
		try {
			
			PreparedStatement listFoneUser = connection.prepareStatement(sql);
			ResultSet resultSet = listFoneUser.executeQuery();
			
			while (resultSet.next()) {
				BeanUserFone userFone = new BeanUserFone();
				userFone.setNome(resultSet.getString("nome"));
				userFone.setEmail(resultSet.getString("email"));
				userFone.setTipo(resultSet.getString("tipo"));
				userFone.setNumero(resultSet.getString("numero"));
				beanUserFones.add(userFone);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return beanUserFones;
	}
	
	 public void deleteFoneUser(Long idUser) {
		 try {
				String sqlfone = "delete from telefoneuser where usuariopessoa = " + idUser;
				//String sqlUser = "delete from userposjava where id = " + idUser;
				PreparedStatement delFone = connection.prepareStatement(sqlfone);
				delFone.execute();
				connection.commit();
				
				deletar(idUser);
				/*PreparedStatement delUser = connection.prepareStatement(sqlUser);
				delUser.execute();
				connection.commit();*/
				
			} catch (Exception e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
	 }

}
