package com.ivory.TesteEstagio.CampoMinado;

import java.util.ArrayList;


public class Program {
	
	private int i;

	public  ArrayList eBomba = new ArrayList<Integer[]>();

	//String[][] jogo = this.replicaDoJogo(campoMinado);


	private boolean add;

	private boolean add2;

	public void executar() {
		
		CampoMinado campoMinado = new CampoMinado();

		String[][] jogo = this.replicaDoJogo(campoMinado);


		
		System.out.println("Início do jogo\n=======");
		System.out.println(campoMinado.Tabuleiro());
		
		// Realize sua codificação a partir deste ponto, boa sorte!

		System.out.println(campoMinado.JogoStatus());

			

		int l = 0;

		while(campoMinado.JogoStatus() == StatusTipo.Aberto && l < 9){

			this.Sonda(l, campoMinado, jogo);



			l++;
		}



		


	}

	/**
	 * Metodo que seleciona a analise das casas por linha,
	 *  podendo revisar as de parecer aberto
	 * @param l linha a ser analisada
	 * @param campoMinado jogo
	 */
	public void Sonda(int l, CampoMinado campoMinado, String[][] jogo){

		ArrayList casasAbertas = new ArrayList<Integer>();

		for(int c = 0; c < 9; c++){
			String parecer = this.analisaMatriz(l, c, campoMinado, jogo);
			System.out.println(parecer);

			

			if(parecer.equals("Aberto")){
				casasAbertas.add(c);
			}
			else{
				System.out.println(campoMinado.Tabuleiro());
				System.out.println("Status do jogo: " +campoMinado.JogoStatus() + "\n");


			}
		}

		if(!casasAbertas.isEmpty()){
			System.out.println("Corrigindo casas em aberto na linha " + l + "\n");

			int size = casasAbertas.size();
			for(int j = 0; j < size; j++){
				Integer c = (Integer) casasAbertas.get(0);
				String parecer = this.analisaMatriz(l, c, campoMinado, jogo);
				System.out.println(parecer);
				System.out.println(campoMinado.Tabuleiro());

				casasAbertas.remove(0);
				System.out.println("Status do jogo: " +campoMinado.JogoStatus() + "\n");

			}
		}



	}

	/**
	 * Cria uma replica do tabuleiro para a analise
	 * @param campoMinado o jogo
	 * @return replica do tabuleiro
	 */
	private String[][] replicaDoJogo(CampoMinado campoMinado){

		String[] jogo1 = campoMinado.Tabuleiro().split("\r\n");

		String[][] jogo2 = new String[9][9];

		for(int i = 0; i < jogo1.length; i++){

			String[] linha = jogo1[i].split("");

			jogo2[i] = linha;
		}

		return jogo2;
	}

	/**
	 * metodo que analiza os vizinhos da casa e dar um parecer
	 * @param l linha da casa
	 * @param c coluna da casa
	 * @param campoMinado jogo correspondente
	 * @return  parecer sobre a casa
	 */
	private String analisaMatriz(int l, int c, CampoMinado campoMinado, String[][] jogo ){
		     System.out.println("linha: "+ l + " coluna: " + c);

	
			if (jogo[l][c].equals("0") || jogo[l][c].equals("-") || jogo[l][c].equals("*") ){

				System.out.println("não precisa de analise! valor: " +jogo[l][c] );

				return "Fechado";
			}

			
	
			int[][] vizinhos = vizinhos(l, c);

			String valor1 = jogo[l][c];

			System.out.println("valor: "+valor1);

			Integer valor = Integer.parseInt(valor1);
			
			int bombas = 0;

			ArrayList indefinidos = new ArrayList<int[]>();
	
			for(int i = 0; i < vizinhos.length; i++){
	
				int linha = vizinhos[i][0];
	
				int coluna = vizinhos[i][1];
				
				String simbol = jogo[linha][coluna];
	
				if (simbol.equals("*")){
					bombas++;
				}
	
				if (simbol.equals("-")){

					
					int[] coordenadas = {linha, coluna};

				
					indefinidos.add(coordenadas);
					
				}
			}
	
			int size = indefinidos.size();

			
	
			if (bombas == valor){

				if(!indefinidos.isEmpty()){

					for(int i = 0; i < size; i++){
						int[] array =  (int[]) indefinidos.get(0);
						int linha = array[0];
						int coluna = array[1];
						campoMinado.Abrir(linha+1, coluna+1);
						String[][] jogo2 = this.replicaDoJogo(campoMinado);
						jogo[linha][coluna] = jogo2[linha][coluna];

						indefinidos.remove(0);
					}
				}

				return "Fechado";
			}
			else if(bombas < valor){
			int dif = valor - bombas;

				if(valor >= size){

					if(size > dif){

						if(valor%2 == 0){

						for(int i = 0; i < dif; i++){
								int[] array =  (int[]) indefinidos.get(0);
								int linha = array[0];
								int coluna = array[1];
								jogo[linha][coluna] = "*";
								indefinidos.remove(0);
							}

						int size2 = indefinidos.size();

						for(int i = 0; i < size2; i++){
							int[] array =  (int[]) indefinidos.get(0);
							int linha = array[0];
							int coluna = array[1];
							campoMinado.Abrir(linha+1, coluna+1);
							String[][] jogo2 = this.replicaDoJogo(campoMinado);
							jogo[linha][coluna] = jogo2[linha][coluna];
	
							indefinidos.remove(0);
						}
						
	
						return "Fechado";

					}
						


					}

					for(int i = 0; i < size; i++){
						int[] array =  (int[]) indefinidos.get(0);
						int linha = array[0];
						int coluna = array[1];
						jogo[linha][coluna] = "*";
						indefinidos.remove(0);
					}


	
					return "Fechado";
				}
	
				else {

					return "Aberto";
				}
			}

			return "Aberto";
		}
		

	
	
	public Program() {
	}

	/**
	 * Metodo que defini a lista de visinhos de uma casa
	 * @param l linha da casa
	 * @param c coluna da casa
	 * @return lista de listas correspondes a linhas e colunas
	 */
	private int[][] vizinhos(int l, int c){

		Vizinhos v = new Vizinhos();


		if(l == 0){
			if(c == 0){
				return v.vizinhoSuperiorEsquerda();
			}

			else if(c == 8){
				return v.vizinhoSuperiorDireita();
			}

			return v.vizinhoSuperiorNormal( c);
		}

		if(l == 8){
			if(c == 0){

			return v.vizinhoInferiorEsquerda();
		}

		else if(c == 8){
			return v.vizinhoInferiorDireita();
		}

		return v.vizinhoInferiorNormal(c);
	    }

		else if(c == 0){
			return v.vizinhoLateralEsquerda(l);
		}

		else if (c == 8){
			return v.vizinhoLateralDireita(l);
		}

		return v.vizinhoNormal(l, c);

		
		}

		
}
	



	


