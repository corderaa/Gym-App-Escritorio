package gymapp.service;

import java.util.List;

public interface ServiceInterface<T> {

	public void save(T t) throws Exception;

	public T find(T t) throws Exception;

	public List<T> findAll() throws Exception;

	public void upodate(T t) throws Exception;

	public void delete(T t) throws Exception;
}
