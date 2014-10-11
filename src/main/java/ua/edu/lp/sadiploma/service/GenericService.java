package ua.edu.lp.sadiploma.service;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface GenericService<T> {
	/**
	 * @param entity
	 * @throws Exception
	 */
	void create(T entity);

	/**
	 * @param entity
	 * @return updated element
	 * @throws Exception
	 */
	T update(T entity);

	/**
	 * @param entity
	 */
	void delete(T entity);

	/**
	 * @param id
	 * @return element
	 */
	T findById(Long id);

	/**
	 * @return list of elements
	 */
	List<T> findAll();

}
