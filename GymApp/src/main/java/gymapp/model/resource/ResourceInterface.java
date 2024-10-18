package gymapp.model.resource;

import java.util.List;

public interface ResourceInterface<T> {

	public void save(T t) throws Exception;

	public T find(T t) throws Exception;

	public List<T> findAll() throws Exception;

	public void update(T t) throws Exception;

	public void delete(T t) throws Exception;
}
