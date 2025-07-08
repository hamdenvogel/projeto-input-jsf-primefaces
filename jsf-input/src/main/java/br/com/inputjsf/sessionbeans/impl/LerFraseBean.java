package br.com.inputjsf.sessionbeans.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.inputjsf.sessionbeans.LerFrase;

@Stateless
@Local(LerFrase.class)
public class LerFraseBean implements LerFrase {

	@Override
	public int quantidadePalavrasDistintas(String frase) {
		
		Set<String> palavrasDistintas = new HashSet<String>();
        String[] palavras = frase.split("\\s+"); //Divide a frase em palavras usando espaço como delimitador

        for (String palavra : palavras) {
            palavrasDistintas.add(palavra.toLowerCase()); //Converte para minúsculas para evitar contagem diferente de palavras com maiúsculas e minúsculas
        }

		return palavrasDistintas.size();
	}

	@Override
	public List<String> ocorrenciasDePalavrasDistintas(String frase) {
		String[] words = frase.split("\\s+"); //Divide a frase em palavras usando espaço como delimitador
		
		//armazenar quantidade de palavras
        Map<String, Integer> wordCountMap = new HashMap<String, Integer>();
        for (String word : words) {
            word = word.toLowerCase();
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        
        List<String> listaOcorrencias = new ArrayList<String>();
        System.out.println("Ocorrências de Palavras:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
        	String itemOcorrenciaChaveValor = entry.getKey() + ": " + entry.getValue();
            System.out.println(itemOcorrenciaChaveValor);
            listaOcorrencias.add(itemOcorrenciaChaveValor);
        }
        
		return listaOcorrencias;
	}

}
