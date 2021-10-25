package interfaces;
import java.util.List;

public interface IDao<T> {
	void insert(T t);
	T get(long id);
	List<T> getAll();
	
	//void set(Object informacao);
	//void update(long id, Object informacao);
	void delete(long id);
	
}
