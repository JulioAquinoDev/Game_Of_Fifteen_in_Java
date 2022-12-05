import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;

public class GameOfFifteen{

	public static void main(String[] args){
	
		/*
		** Creating ArrayList with
		** values defined,
		** from one until fifteen, and one hyphen.
		*/		
		ArrayList<String> numbers = gerarListaNum();
		
		/* 
		** This script create a matriz 4x4,
		** when datas will allocate in 	
		** columns and rows.
		** Read a ArrayList that values is defined
		** from One until Fifteen.
		**/
		
		String[][] tab = gerarMatriz(numbers);
		
		/* String[][] tab = new String[4][4];	
		for (int i = 0; i < 4; ++i) {
			for(int j = 0; j < 4; ++j) {
				Random random = new Random();
				int index1 = (int) (Math.random() * numbers.size());
				String a = numbers.get(index1);
				tab[i][j] = String.valueOf(a);
				numbers.remove(a);
			}
		} */ 

		/*
		** While the variable "laco" to be biggest that zero.
		** Then the game start.
		** The variable "cont" is movements count.
		*/
		int laco = 1;
		int cont = 0;
		while(laco >= 0){
			System.out.println("\n--------------------------------------------------------------------");
			/*
			** Show the Matriz.
			*/
			System.out.println("\n==============================================");
			for (int i = 0; i < tab.length; ++i) {
				for(int j = 0; j < tab[i].length; ++j) {
					String valor = tab[i][j];
					int tam = valor.length();
					if(tam == 1){
						System.out.print("\t| " + valor + "  |");
					}else{
						System.out.print("\t| " + valor + " |");
					}
					
					
				}
				System.out.print("\n");
			}
			System.out.println("==============================================");
			
			
			/*
			** Get matriz empty position.
			*/
			String element = "-";
			int element_l = -8;
			int element_c = -9;		
			for (int i = 0; i < tab.length; ++i) {
				for(int j = 0; j < tab[i].length; ++j) {
					String h = tab[i][j];
					if(h == element){
						element_l = i;
						element_c = j;
					}
				}
			}
				
			System.out.println("\tLinha: "+ (element_l+1) + " - Coluna: "+ (element_c+1));
			System.out.println("\n\t*** Movimentos: "+ cont + " ***\n");
			
			menu();			
			
			/*
			** Get value for menu option.
			*/
			Scanner scan = new Scanner(System.in);	
			String op = scan.nextLine();
		
			/*
			** The condition that validate movements
			*/
			
			/*
			** Move element up.
			** Then the element that to be down empty element, it goes up.
			*/
			if(op.equals("8") || op.equals("w")){
				if(element_l != 3){
					int aux_l = element_l + 1;
					
					String elemento_baixo = tab[aux_l][element_c];
					
					// "-"
					tab[element_l][element_c] = elemento_baixo;
					
					// campo alterado
					tab[aux_l][element_c] = "-";
					
					System.out.println("elemento_baixo: "+ elemento_baixo);
				}else{
					System.out.println("Posição não permite o movimento.");
				}
				
			}
			/*
			** Then the element that to be up empty element, it goes down.
			*/
			else if(op.equals("2") || op.equals("s")){
				if(element_l != 0){
					int aux_l = element_l - 1;
					
					String elemento_acima = tab[aux_l][element_c];
					
					// "-"
					tab[element_l][element_c] = elemento_acima;
					
					// campo alterado
					tab[aux_l][element_c] = "-";
					
					System.out.println("elemento_acima: "+ elemento_acima);
				}else{
					System.out.println("Posição não permite o movimento.");
				}
			}
			/*
			** Then the element that to be right of empty element, it goes left.
			*/
			else if(op.equals("4") || op.equals("a")){
				
				if(element_c != 3){
					int aux_c = element_c + 1;
				
					String elemento_direita = tab[element_l][aux_c];
					
					// "-"
					tab[element_l][element_c] = elemento_direita;
					
					// campo alterado
					tab[element_l][aux_c] = "-";
					
					System.out.println("elemento_direita: "+ elemento_direita);
				}else{
					System.out.println("Posição não permite o movimento.");
				}
			}
			/*
			** Then the element that to be left of empty element, it goes right.
			*/
			else if(op.equals("6") || op.equals("d")){
				if(element_c != 0){
				
					int aux_c = element_c - 1;
					
					String elemento_esquerda = tab[element_l][aux_c];
					
					// "-"
					tab[element_l][element_c] = elemento_esquerda;
					
					// campo alterado
					tab[element_l][aux_c] = "-";
					
					System.out.println("elemento_esquerda: "+ elemento_esquerda);
				}else{
					System.out.println("Posição não permite o movimento.");
				}
			}
			/*
			** Case option zero, going out.
			*/
			else if(op.equals("0") || op.equals("sair")){
				System.out.println("Saindo...");
				laco = -1;
			}
			/*
			** Case option invalid.
			*/
			else{
				System.out.println("Valor invalido");
			}// end condition
			
			cont = cont + 1;
		}// end while
			
	}// end class main.
	
	static void menu(){
		System.out.println("\t8 / w - Mover o Numero de Cima");
		System.out.println("\t2 / s - Mover o Numero de Baixo");
		System.out.println("\t4 / a - Mover o Numero da Esquerda");
		System.out.println("\t6 / d - Mover o Numero da Direita");
		System.out.println("\n0 - Sair");
	}
	
	static ArrayList<String> gerarListaNum(){
		ArrayList<String> numbers = new ArrayList<String>();
		
		for(int  x = 1; x <= 16; x++){
			if(x == 16){
				numbers.add("-");
			}else{
				numbers.add(String.valueOf(x));
			}
		}
		return numbers;
	}
	
	static String[][] gerarMatriz(ArrayList<String> numbers){
		
		String[][] tab = new String[4][4];	
		for (int i = 0; i < 4; ++i) {
			for(int j = 0; j < 4; ++j) {
				Random random = new Random();
				int index1 = (int) (Math.random() * numbers.size());
				String a = numbers.get(index1);
				tab[i][j] = String.valueOf(a);
				numbers.remove(a);
			}
		}
		
		return tab;
	}
}