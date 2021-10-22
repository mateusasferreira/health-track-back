import java.util.List;

public interface IDadosDao {
	void insert(float peso, float altura);
	RegistroDados get(int id);
	List<RegistroDados> getAll();
	/*
	void set(Object informacao);
	void update(long id, Object informacao);
	void delete(long id);
	*/
}
