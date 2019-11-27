package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import dao.UserPosDao;
import model.Userposjava;

public class TesteBancoJdbc{

	@Test
	public void initBanco() {
		UserPosDao userPosDao = new UserPosDao();
		Userposjava userposjava = new Userposjava();

		userposjava.setNome("Paulo");
		userposjava.setEmail("Pauloteste@gmail.com");

		userPosDao.salvar(userposjava);
	}

	@Test
	public void initListar() {
		UserPosDao dao = new UserPosDao();

		try {
			List<Userposjava> lista = dao.listar();

			for(Userposjava userposjava: lista) {
				System.out.println(userposjava);
				System.out.println("----------------------------------------------");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initBuscar() {

		UserPosDao dao = new UserPosDao();

		try {
			Userposjava userposjava = dao.buscar(2L);
			System.out.println(userposjava);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void initAtualizar() {

		try {
			UserPosDao dao = new UserPosDao();
			Userposjava objetoBanco = dao.buscar(3L);

			objetoBanco.setNome("Nome editado");
			dao.atualizar(objetoBanco);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initDeletar() {
		try {
			UserPosDao dao = new UserPosDao();
			dao.deletar(5L);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
