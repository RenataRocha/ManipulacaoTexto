package aula;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {
	
	public void inserir(String texto) throws IOException {
		//Gravação
		 FileWriter arq = new FileWriter("d:\\teste.txt",true);
		 PrintWriter gravarArq = new PrintWriter(arq);
		 
		 gravarArq.println(texto); 

		 arq.close();
	}
	
	public void leitura(String texto) throws IOException {
		//Leitura
		 FileReader arqleitura = new FileReader("d:\\teste.txt");
		 BufferedReader lerArq = new BufferedReader(arqleitura);
	 
	     String linha = lerArq.readLine(); 
	     int i = 0;
	     
	     while (linha != null) {
	    	 i++;
	    	 if(linha.contains(texto)) {
	    		 System.out.println("linha: " + i + " conteúdo: " + linha); 
	    	 } 
	    	 linha = lerArq.readLine();
	     }
	     
	     arqleitura.close();
	}
	
	public void atualizar(String texto, String textNew) throws IOException {
		//Leitura
		 File arquivo = new File("d:\\teste.txt");
		 File arquivotemporario = new File("d:\\teste1.txt");
		 FileReader arqleitura = new FileReader(arquivo);
		 BufferedReader lerArq = new BufferedReader(arqleitura);
		 FileWriter arq = new FileWriter(arquivotemporario,true);
		 PrintWriter gravarArq = new PrintWriter(arq);
		 
	     String linha = lerArq.readLine();
	     int i = 0;
	     String textOld = "";
		
	     while (linha != null) {
	    	 i++;
	    	
	    	 if(linha.contains(texto)) {
	    		 textOld += textNew + "\n";
	    	 }else {
	    		 textOld += linha + "\n";
	    	 }
	    	 linha = lerArq.readLine();
	     }
	     gravarArq.println(textOld); 
	     System.out.println(textOld);
		 arqleitura.close();
		 arq.close();
		 arquivo.delete();
		 arquivotemporario.renameTo(arquivo);
	}
	
	public void deletar(String texto) throws IOException {
		 File arquivo = new File("d:\\teste.txt");
		 File arquivotemporario = new File("d:\\teste1.txt");
		 FileReader arqleitura = new FileReader(arquivo);
		 BufferedReader lerArq = new BufferedReader(arqleitura);
		 FileWriter arq = new FileWriter(arquivotemporario,true);
		 PrintWriter gravarArq = new PrintWriter(arq);
		 
	     String linha = lerArq.readLine();
	     int i = 0;
	     String textOld = "";
		
	     while (linha != null) {
	    	 i++;
	    	
	    	 if(linha.contains(texto)) {
	    	 }else {
	    		 textOld += linha + "\n";
	    	 }
	    	 linha = lerArq.readLine();
	     }
	     gravarArq.println(textOld); 
	     System.out.println(textOld);
		 arqleitura.close();
		 arq.close();
		 arquivo.delete();
		 arquivotemporario.renameTo(arquivo);
	}
	
	public static void main(String args[]) throws Exception {
		Arquivo arq = new Arquivo();
		//arq.inserir("Amanda");
		//arq.leitura("Pedro");
		//arq.atualizar("Pedro","Joaquim");
		arq.deletar("Joaquim");
	}
}
