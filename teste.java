package hexacta;
import java.util.*;

public class teste {
	
	//retorna o menor inteiro positivo que nao esta no array
	public int solution1 (int[] vet) {
		int i, menor = 0;
		
		Arrays.sort(vet);
		
		for (i = 0; i < vet.length; i++) {
			if (vet[i] > 0 && i < vet.length -1) {
				if ((vet[i] + 1) != vet[i+1] && vet[i] != vet[i+1]) {
					menor = vet[i] + 1;
					break;
				}
			}
			if (vet[i] < 0) {
				menor = 1;
			}
		}
		
		if (menor == 0) {
			menor = vet[i-1] + 1;
		}
		
		return menor;
	}
	
	//informa os pares cuja soma seja o x informado
	public void solution2 (int[] vet, int x) {
		int i, j, k;
		k = 0;
		int[][] pares = new int[100000][2];
		
		teste t = new teste();
		
		for (i = 0; i < vet.length; i++) {
			for (j = 0; j < vet.length; j++) {
				if (vet[i] + vet[j] == x) {
					if (t.verificaPares(pares, vet[i], vet[j]) == 0) {
						pares[k][0] = vet[i];
						pares[k][1] = vet[j];	
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
	public int verificaPares (int[][] vet, int x, int y) {
		int i, j;
		
		for (i = 0; i < vet.length; i++) {
			if (vet[i][0] == x && vet[i][1] == y) {
				return 1;
			}
			if (vet[i][0] == y && vet[i][1] == x) {
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
		
		ini.solution2(array1, 10);
		ini.solution2(array5, 8);
		
	}

}
