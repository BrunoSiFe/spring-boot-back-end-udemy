package com.aula.udemy.cursoudemy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.aula.udemy.cursoudemy.dtos.CategoriaDTO;
import com.aula.udemy.cursoudemy.entities.CategoriaEntity;
import com.aula.udemy.cursoudemy.exceptions.DataIntegrityException;
import com.aula.udemy.cursoudemy.exceptions.ObjectNotFoundException;
import com.aula.udemy.cursoudemy.repositories.CategoriasRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriasRepository categoriaRepository;

	public CategoriaEntity buscarCategoriaPorId(Integer idCategoria) {

		Optional<CategoriaEntity> categoriaEntity = categoriaRepository.findById(idCategoria);

		return categoriaEntity.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + idCategoria + ", Tipo: " + CategoriaEntity.class.getName()));
	}

	public CategoriaEntity inserirCategoria(CategoriaDTO categoria) {
		CategoriaEntity categoriaEntity = convertDtoToEntity(categoria);
		categoriaEntity.setIdCategoria(null);
		
		return categoriaRepository.save(categoriaEntity);
		
	}
	
	public CategoriaEntity atualizarCategoria(CategoriaDTO categoria) {
		CategoriaEntity categoriaEntity = buscarCategoriaPorId(categoria.getIdCategoria());
		atualizarDados(categoria,categoriaEntity);
		return categoriaRepository.save(convertDtoToEntity(categoria));
	}
	
	public void deletarCategoria(Integer idcategoria) {
		buscarCategoriaPorId(idcategoria);
		
		try {
		categoriaRepository.deleteById(idcategoria);
		}catch(DataIntegrityViolationException ex) {
			throw new DataIntegrityException("Não é possível excluir esta categoria:"+idcategoria);
		}
	}
	
	public List<CategoriaEntity> listarCategorias(){
		return categoriaRepository.findAll();
	}
	
	public Page<CategoriaEntity> findAllInPages(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return categoriaRepository.findAll(pageRequest);
	}
	
	private CategoriaEntity convertDtoToEntity(CategoriaDTO categoria) {
		return new CategoriaEntity(categoria.getIdCategoria(),categoria.getNome());
	}
	
	private void atualizarDados(CategoriaDTO categoriaDTO, CategoriaEntity categoriaEntity) {
		categoriaEntity.setNome(categoriaDTO.getNome());
	}

}
