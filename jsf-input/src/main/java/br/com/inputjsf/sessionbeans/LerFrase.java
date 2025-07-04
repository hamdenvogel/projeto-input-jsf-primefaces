package br.com.inputjsf.sessionbeans;

import java.util.List;

public interface LerFrase {	
	int quantidadePalavrasDistintas(String frase);
	List<String> ocorrenciasDePalavrasDistintas(String frase);
}
