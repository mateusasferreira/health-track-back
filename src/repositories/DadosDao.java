package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ConnManager;
import interfaces.IDao;
import models.RegistroDados;

	
public class DadosDao implements IDao<RegistroDados> {
	private Connection conn;
	private PreparedStatement pstmt = null;

	@Override
	public void insert(RegistroDados dados){
		try {
		
		conn = ConnManager.getInstance().getConn();

		pstmt = conn.prepareStatement("INSERT INTO T_DADOS" + "(peso, altura, imc)" + "VALUES (?, ?, ?)");
		pstmt.setFloat(1, dados.getPeso());
		pstmt.setFloat(2, dados.getAltura());
		pstmt.setFloat(3, dados.getImc());

		pstmt.executeUpdate();
	
		} catch(SQLException e) {
			System.out.println(e);
			e.getStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public RegistroDados get(long id) {	
		
		RegistroDados dados = null; 
		
		try {
			conn = ConnManager.getInstance().getConn();

			pstmt = conn.prepareStatement("SELECT * FROM T_DADOS WHERE id = ?;");
			pstmt.setLong(1, id);
			ResultSet result = pstmt.executeQuery();

			while(result.next()){
				long id_dados = result.getInt("id");
				float peso = result.getFloat("peso");
				float altura = result.getFloat("altura");
				String data = result.getString("data");

				dados =  new RegistroDados(id_dados, peso, altura, data);
			}
		} catch (SQLException e){
			System.out.println(e);
			e.getStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}

		return dados;

		
	}

	@Override
	public List<RegistroDados> getAll() {
		List<RegistroDados> listaDados =  new ArrayList<RegistroDados>();
		
		try {
		conn = ConnManager.getInstance().getConn();

		pstmt = conn.prepareStatement("SELECT * FROM T_DADOS");

		ResultSet result = pstmt.executeQuery();

		while(result.next()){
			int id_dados = result.getInt("id");
			float peso = result.getFloat("peso");
			float altura = result.getFloat("altura");
			String data = result.getString("data");

			RegistroDados dados =  new RegistroDados(id_dados, peso, altura, data);

			listaDados.add(dados);
		}

		} catch ( SQLException e ) {
			System.out.println(e);
			e.getStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}

		return listaDados;
	}

	public void delete(long id) {
		try {
			conn = ConnManager.getInstance().getConn();

			pstmt = conn.prepareStatement("DELETE FROM T_DADOS WHERE id = ?;");
			pstmt.setLong(1, id);
			pstmt.executeUpdate();
			
		} catch( SQLException e){
			System.out.println(e);
			e.getStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	} 

	@Override
	public void update(long id, RegistroDados dados) {
		try {
		
			conn = ConnManager.getInstance().getConn();
	
			pstmt = conn.prepareStatement("UPDATE T_DADOS SET peso = ?, altura = ? WHERE id = ?");
			pstmt.setFloat(1, dados.getPeso());
			pstmt.setFloat(2, dados.getAltura());
			pstmt.setFloat(3, id);
			pstmt.executeUpdate();
		
			} catch(SQLException e) {
				System.out.println(e);
				e.printStackTrace();
			} catch (Exception e){
				System.out.println(e);
				e.printStackTrace();
			}
		}
		
	

	// @Override
	// public void delete(long id) {
		
		
	// }
	
}

