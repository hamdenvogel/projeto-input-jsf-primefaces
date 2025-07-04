package br.com.inputjsf.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class Info {
	
	@PostConstruct
	public void init(){
		System.out.println("Bean init() executado!");
	}

	public String getMessage(){
		return "Leitor de Frases 1.8";
	}

}
