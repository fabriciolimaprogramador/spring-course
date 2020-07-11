package com.springcourse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageRequestModel {
	
	private int page;//Número da página, inicia com zero.
	private int size;//Quantidade e elementos de cada página
	

}
