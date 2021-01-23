package hexacta;
import java.util.*;

public class teste {
	
	//retorna o menor inteiro positivo que nao esta no array
	public int solution1 (int[] vetor) {
		int i, menor = 0;
		
		Arrays.sort(vetor);
		
		for (i = 0; i < vetor.length; i++) {
			if (vetor[i] >= 0 && i < vetor.length -1) {
				if ((vetor[i] + 1) != vetor[i+1] && vetor[i] != vetor[i+1]) {
					menor = vetor[i] + 1;
					break;
				}
			}
			if (vetor[i] < 0) {
				menor = 1;
			}
		}
		
		if (menor == 0) {
			menor = vetor[i-1] + 1;
		}
		
		return menor;
	}
	
	//informa os pares cuja soma seja o x informado
	public void solution2 (int[] vetor, int x) {
		int i, j, k;
		k = 0;
		int[][] pares = new int[100000][2];
		
		teste t = new teste();
		
		for (i = 0; i < vetor.length; i++) {
			for (j = 0; j < vetor.length; j++) {
				if (vetor[i] + vetor[j] == x) {
					if (t.verificaPares(pares, vetor[i], vetor[j]) == 0) {
						pares[k][0] = vetor[i];
						pares[k][1] = vetor[j];	
						k++;
					}	
				}
			}
		}
		
		System.out.print("[");
		for (i = 0; i < k; i++) {
			System.out.printf("[%d,%d]", pares[i][0], pares[i][1]);	
			if (i != k-1) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}
	
	//metodo complementar do solution2, que verifica se ja existe o par na matriz
	public int verificaPares (int[][] matriz, int x, int y) {
		int i, j;
		
		for (i = 0; i < matriz.length; i++) {
			if (matriz[i][0] == x && matriz[i][1] == y) {
				return 1;
			}
			if (matriz[i][0] == y && matriz[i][1] == x) {
				return 1;
			}
		}
		
		return 0;
	}
	
	public static void main (String[] args) {
		int[] array1 = {1,5,8,6,2,9,5,2,7,8,0,12,43,10};
		int[] array2 = {1,3,6,4,1,2};
		int[] array3 = {1,2,3};
		int[] array4 = {-1,-3};
		int[] array5 = {-2,-1,0,2,4,7,8,9,9};
		int[] array6 = {0};
		int menor;
		
		teste ini = new teste();
		
		menor = ini.solution1(array1);
		System.out.printf("%d \n", menor);
		menor = ini.solution1(array2);
		System.out.printf("%d \n", menor);
		menor = ini.solution1(array3);
		System.out.printf("%d \n", menor);
		menor = ini.solution1(array4);
		System.out.printf("%d \n", menor);
		menor = ini.solution1(array5);
		System.out.printf("%d \n", menor);
		menor = ini.solution1(array6);
		System.out.printf("%d \n", menor);
		
		
		ini.solution2(array1, 10);
		ini.solution2(array5, 8);
		ini.solution2(array6, 8);
		ini.solution2(array1, 45);
		ini.solution2(array5, 23);
		
	}

}
