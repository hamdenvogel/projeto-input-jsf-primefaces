package br.com.inputjsf.managedbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.inputjsf.sessionbeans.LerFrase;

@ManagedBean
@ViewScoped
public class FraseMB {
	
	@EJB
	private LerFrase lerFrase;
	
	@PostConstruct
	public void init(){
		System.out.println("Bean FraseMB método init() executado!");
		this.palavras = new ArrayList<>();
	}
	
	private String inputFrase;
	private String palavrasRetornadas;		    
	private List<String> palavras;    

	public void submit() {
		this.palavras = new ArrayList<>();
        //inputFrase contém o valor do campo p:inputText.
        System.out.println("Input Frase: " + inputFrase);
        int quantidadePalavrasDistintas = lerFrase.quantidadePalavrasDistintas(inputFrase);
        this.palavrasRetornadas = "quantidade de palavras distintas: " + quantidadePalavrasDistintas;
        List<String> listaOcorrenciasPalavrasDistintas = lerFrase.ocorrenciasDePalavrasDistintas(inputFrase);
        this.palavrasRetornadas += " => ";
        listaOcorrenciasPalavrasDistintas.forEach(item -> {
        	this.palavrasRetornadas += (" " + item + "\n");
        	this.palavras.add(item);
        });        
    }	
    
    public String getInputFrase() {
        return inputFrase;
    }

    public void setInputFrase(String inputFrase) {
        this.inputFrase = inputFrase;
    }
	
	public String getPalavrasRetornadas() {
		return palavrasRetornadas;
	}
	public void setPalavrasRetornadas(String palavrasRetornadas) {
		this.palavrasRetornadas = palavrasRetornadas;
	}
	
	public List<String> getPalavras() {
		return palavras;
	}

	public void setPalavras(List<String> palavras) {
		this.palavras = palavras;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(inputFrase, palavrasRetornadas);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FraseMB other = (FraseMB) obj;
		return Objects.equals(inputFrase, other.inputFrase) && Objects.equals(palavrasRetornadas, other.palavrasRetornadas);
	}
		
}
