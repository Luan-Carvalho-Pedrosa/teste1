package com.ivory.TesteEstagio.CampoMinado;

public class Vizinhos {

	//Classe criada para organizar e emcapsular a coordenadas dos vizinhos


    public  int[][] vizinhoNormal(int l, int c ){

        int[][] vizinhos = new int[8][2];

		int[] zero = {l-1, c-1};
		int[] um = {l-1, c};
		int[] dois = {l-1, c+1};
		int[] tres = {l, c-1};
		int[] quatro = {l, c+1};
		int[] cinco = {l+1, c-1};
		int[] seis = {l+1, c};
		int[] sete = {l+1, c+1};

		vizinhos[0] = zero;
		vizinhos[1] = um;
		vizinhos[2] = dois;
		vizinhos[3] = tres;
		vizinhos[4] = quatro;
		vizinhos[5] = cinco;
		vizinhos[6] = seis;
		vizinhos[7] = sete;

		return vizinhos;

    }

    public int[][] vizinhoSuperiorEsquerda( ){
        int[][] vizinhos = new int[3][2];

        int[] zero = {0, 1};
		int[] um = {1, 1};
		int[] dois = {1, 0};

        vizinhos[0] = zero;
		vizinhos[1] = um;
		vizinhos[2] = dois;

        return vizinhos;
    
    }

    public int[][] vizinhoSuperiorDireita( ){
        int[][] vizinhos = new int[3][2];

        int[] zero = {0, 7};
		int[] um = {1, 7};
		int[] dois = {1, 8};

        vizinhos[0] = zero;
		vizinhos[1] = um;
		vizinhos[2] = dois;

        return vizinhos;
    
    }

    public int[][] vizinhoInferiorDireita( ){
        int[][] vizinhos = new int[3][2];

        int[] zero = {8, 7};
		int[] um = {7, 7};
		int[] dois = {7, 8};

        vizinhos[0] = zero;
		vizinhos[1] = um;
		vizinhos[2] = dois;

        return vizinhos;
    
    }

    public int[][] vizinhoInferiorEsquerda( ){
        int[][] vizinhos = new int[3][2];

        int[] zero = {8, 1};
		int[] um = {7, 1};
		int[] dois = {7, 0};

        vizinhos[0] = zero;
		vizinhos[1] = um;
		vizinhos[2] = dois;

        return vizinhos;
    
    }

    public int[][] vizinhoLateralEsquerda(int l ){
        int[][] vizinhos = new int[5][2];

        int[] zero = {l-1, 0};
		int[] um = {l-1, 1};
		int[] dois = {l, 1};
		int[] tres = {l+1, 1};
		int[] quatro = {l+1, 0};
		

        vizinhos[0] = zero;
		vizinhos[1] = um;
		vizinhos[2] = dois;
        vizinhos[3] = tres;
		vizinhos[4] = quatro;

        return vizinhos;
    
    }

    public int[][] vizinhoLateralDireita(int l){
        int[][] vizinhos = new int[5][2];

        int[] zero = {l-1, 8};
		int[] um = {l-1, 7};
		int[] dois = {l, 7};
		int[] tres = {l+1, 7};
		int[] quatro = {l+1, 8};
		

        vizinhos[0] = zero;
		vizinhos[1] = um;
		vizinhos[2] = dois;
        vizinhos[3] = tres;
		vizinhos[4] = quatro;

        return vizinhos;
    
    }

    public int[][] vizinhoSuperiorNormal( int c ){
        int[][] vizinhos = new int[5][2];

        int[] zero = {0, c-1};
		int[] um = {1, c-1};
		int[] dois = {1, c};
		int[] tres = {1, c+1};
		int[] quatro = {0, c+1};


        vizinhos[0] = zero;
		vizinhos[1] = um;
		vizinhos[2] = dois;
        vizinhos[3] = tres;
		vizinhos[4] = quatro;

        return vizinhos;
    
    }

    public int[][] vizinhoInferiorNormal( int c){
        int[][] vizinhos = new int[5][2];

        int[] zero = {8, c-1};
		int[] um = {7, c-1};
		int[] dois = {7, c};
		int[] tres = {7, c+1};
		int[] quatro = {8, c+1};


        vizinhos[0] = zero;
		vizinhos[1] = um;
		vizinhos[2] = dois;
        vizinhos[3] = tres;
		vizinhos[4] = quatro;

        return vizinhos;
    
    }


}
