package com.example.domains.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.domains.contracts.repositories.FilmActorRepository;
import com.example.domains.contracts.services.FilmActorService;
import com.example.domains.entities.FilmActor;
import com.example.domains.entities.FilmActorPK;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;

@Service

public class FilmActorServiceImpl implements FilmActorService {

	private FilmActorRepository dao;
	
	
	public FilmActorServiceImpl(FilmActorRepository dao) {
		this.dao = dao;
	}

	@Override
	public <T> List<T> getByProjection(Class<T> type) {
		return dao.findAllBy(type);
	}

	@Override
	public <T> Iterable<T> getByProjection(Sort sort, Class<T> type) {
		return dao.findAllBy(sort, type);
	}

	@Override
	public <T> Page<T> getByProjection(Pageable pageable, Class<T> type) {
		return dao.findAllBy(pageable, type);
	}

	@Override
	public Iterable<FilmActor> getAll(Sort sort) {
		return dao.findAll(sort);
	}

	@Override
	public Page<FilmActor> getAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public List<FilmActor> getAll() {
		return dao.findAll();
	}

	@Override
	public Optional<FilmActor> getOne(FilmActorPK id) {
		return dao.findById(id);
	}

	@Override
	public FilmActor add(FilmActor item) throws DuplicateKeyException, InvalidDataException {
		if(item == null) {
			throw new InvalidDataException("No puede ser nulo");
		}
		if(item.isInvalid()) {
			throw new InvalidDataException(item.getErrorsMessage(), item.getErrorsFields());
		}
		if(dao.existsById(item.getId())) {
			throw new DuplicateKeyException("Ya existe");
		}
		return dao.save(item);
	}

	@Override
	public FilmActor modify(FilmActor item) throws NotFoundException, InvalidDataException {
		if(item == null) {
			throw new InvalidDataException("No puede ser nulo");
		}
		if(item.isInvalid()) {
			throw new InvalidDataException(item.getErrorsMessage(), item.getErrorsFields());
		}
		if(!dao.existsById(item.getId())) {
			throw new NotFoundException("No existe");
		}
		return dao.save(item);
	}

	@Override
	public void delete(FilmActor item) throws InvalidDataException {
		if(item == null) {
			throw new InvalidDataException("No puede ser nulo");
		}
		dao.delete(item);
		
	}

	@Override
	public void deleteById(FilmActorPK id) {
		dao.deleteById(id);
		
	}

}
