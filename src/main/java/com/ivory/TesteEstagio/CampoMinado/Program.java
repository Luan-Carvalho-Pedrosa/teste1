package com.ivory.TesteEstagio.CampoMinado;

import java.util.ArrayList;


public class Program {
	
	private int i;

	public  ArrayList eBomba = new ArrayList<Integer[]>();

	private boolean add;

	private boolean add2;

	public void executar() {
		
		CampoMinado campoMinado = new CampoMinado();

		
		System.out.println("Início do jogo\n=======");
		System.out.println(campoMinado.Tabuleiro());
		
		// Realize sua codificação a partir deste ponto, boa sorte!

		System.out.println(campoMinado.JogoStatus());

			

		int l = 0;

		while(campoMinado.JogoStatus() == StatusTipo.Aberto && l < 9){
			System.out.println("ok");

			this.Sonda(l, campoMinado);

			l++;
		}



		


	}

	/**
	 * Metodo que seleciona a analise das casas por linha,
	 *  podendo revisar as de parecer aberto
	 * @param l linha a ser analisada
	 * @param campoMinado jogo
	 */
	public void Sonda(int l, CampoMinado campoMinado){

		ArrayList casasAbertas = new ArrayList<Integer>();

		for(int c = 0; c < 9; c++){
			String parecer = this.analisaMatriz(l, c, campoMinado);
			System.out.println(campoMinado.JogoStatus());

			

			if(parecer.equals("Aberto")){
				casasAbertas.add(c);
			}
		}

		if(!casasAbertas.isEmpty()){
			int size = casasAbertas.size();
			for(int j = 0; j < size; j++){
				Integer c = (Integer) casasAbertas.get(0);
				String parecer = this.analisaMatriz(l, c, campoMinado);
				System.out.println(campoMinado.JogoStatus());

				casasAbertas.remove(0);
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
	private String analisaMatriz(int l, int c, CampoMinado campoMinado ){
		System.out.println("linha: "+ l + " coluna: " + c);


			String[][] jogo = this.replicaDoJogo(campoMinado);
	
			if (jogo[l][c].equals("0") || jogo[l][c].equals("-") ){
				return "Fechado";
			}

			
	
			int[][] vizinhos = vizinhos(l, c);
			String valor1 = jogo[l][c];
			System.out.println(valor1);

			Integer valor = Integer.parseInt(valor1);
			int bombas = 0;
			ArrayList indefinidos = new ArrayList<int[]>();
	
			for(int i = 0; i < vizinhos.length; i++){
	
				int linha = vizinhos[i][0];
	
				int coluna = vizinhos[i][1];
				
				String simbol = jogo[linha][coluna];
	
				
	
				if (simbol.equals("-")){

					
					int[] coordenadas = {linha, coluna};

					if(eBomba.contains(coordenadas)){
						System.out.println("bomba achada");

						bombas++;
					}
					else{
					indefinidos.add(coordenadas);
					}
				}
			}
	
			int size = indefinidos.size();

			System.out.println("indefinicoes: "+ size);




	
	
			if (bombas == valor){

				System.out.println("bombas == valor");


				if(!indefinidos.isEmpty()){
					for(int i = 0; i < size; i++){
						int[] array =  (int[]) indefinidos.get(0);
						int linha = array[0];
						int coluna = array[1];
						campoMinado.Abrir(linha+1, coluna+1);

						indefinidos.remove(0);
					}
				}

				return "Fechado";
			}
			else if(bombas < valor){
			System.out.println("bombas < valor");

				if(valor >= size){
					System.out.println("valor >= size");

					for(int i = 0; i < size; i++){
						int[] array =  (int[]) indefinidos.get(0);
						int linha = array[0];
						int coluna = array[1];
						System.out.println("l: " + linha +" c: "+ coluna);

						eBomba.add(array);
						indefinidos.remove(0);
					}

					System.out.println(campoMinado.Tabuleiro());

	
					return "Fechado";
				}
	
				else {
					System.out.println(campoMinado.Tabuleiro());

					return "Aberto";
				}
			}

			return null;
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
	



	


