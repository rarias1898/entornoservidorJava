package com.ceu.ej12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceu.ej12.repository.LibroRepository;


@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	private LibroRepository repository;
}
