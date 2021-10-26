package interfaces;
import java.util.List;

public interface IDao<T> {
	void insert(T t);
	T get(long id);
	List<T> getAll();
	
	void update(long id, T t);
	void delete(long id);
}
