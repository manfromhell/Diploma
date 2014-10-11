package ua.edu.lp.sadiploma.dao;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public interface GenericDao<T> {
	
	void create(T entity);

	T update(T entity);

	void delete(T entity);

	T findById(Class<T> entityClass, Long id);

	List<T> findAll(Class<T> entityClass);

}
