package com.springcourse.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageModel<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int totalElements;//Total de registros
	private int pageSize;//Quantidade de registros por página
	private int totalPages;//Total de páginas
	private List<T> elements;//Elementos de cada página

}
