
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

	
public class DadosDao implements IDadosDao {
	private Connection conn;
	private PreparedStatement pstmt = null;

	@Override
	public void insert(float peso, float altura){
		try {
		float imc = peso / (altura * altura);
		conn = ConnManager.getInstance().getConn();

		pstmt = conn.prepareStatement("INSERT INTO T_DADOS" + "(peso, altura, imc)" + "VALUES (?, ?, ?)");
		pstmt.setFloat(1, peso);
		pstmt.setFloat(2, altura);
		pstmt.setFloat(3, imc);

		pstmt.executeUpdate();
	
		} catch(SQLException e) {
			System.out.println(e);
			e.getStackTrace();
		}
	}
	
	@Override
	public RegistroDados get(int id) {	
		
		RegistroDados dados = null; 
		
		try {
			conn = ConnManager.getInstance().getConn();

			pstmt = conn.prepareStatement("SELECT * FROM T_DADOS WHERE id = ?;");
			pstmt.setInt(1, id);
			ResultSet result = pstmt.executeQuery();

			while(result.next()){
				int id_dados = result.getInt("id");
				float peso = result.getFloat("peso");
				float altura = result.getFloat("altura");
				float imc = result.getFloat("imc");
				String data = result.getString("data");

				dados =  new RegistroDados(id_dados, peso, altura, imc, data);
			}
		} catch (SQLException e){
			System.out.println(e);
			e.getStackTrace();
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
			float imc = result.getFloat("imc");
			String data = result.getString("data");

			RegistroDados dados =  new RegistroDados(id_dados, peso, altura, imc, data);

			listaDados.add(dados);
		}

		} catch ( SQLException e ) {
			System.out.println(e);
			e.getStackTrace();
		}

		return listaDados;
	}

	/*
	@Override
	public void set(Object informacao) {
		
		
	}

	@Override
	public void update(long id, Object informacao) {
		
		
	}

	@Override
	public void delete(long id) {
		
		
	}
	*/
}

