package assistant;

import java.util.Random;

public class Lab06_JoshuaLazaro {

	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 3, 4, 5};
		
		permuteBySorting(arr);
		
		
	}
	
	public static void printArr(int[] arrA, int[] arrP){
		System.out.print("Actual Values:\t\t");
		for(int element : arrA){
			System.out.print(element + " ");
		}
		System.out.println();
		System.out.print("Randomized Value:\t");
		for(int element : arrP){
			System.out.print(element + " ");
		}
		
	}

	public static int [] permuteBySorting(int[] arr){
		int[] newList = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++){
			newList[i] = (int) (Math.random() * Math.pow(arr.length, 3));
		}
		
		sort(arr, newList, 0, arr.length - 1);
		
		printArr(arr, newList);
		
		return arr;
	}
	
	public static void sort(int[] listA, int [] listP, int left, int right){
		if(left < right){
			int mid = (left + right) / 2;
			
			sort(listA, listP, left, mid);
			sort(listA, listP, mid + 1, right);
			
			merge(listA, listP, left, mid, right);
		}
		else{
			return;
		}
	}
	private static void merge(int[] listA, int[] listP, int left, int mid, int right){
		//int i, j, k;
		int[] leftArr = new int[mid - left + 1];
		int[] leftRef = new int[mid - left + 1];
		int[] rightArr = new int[right - mid];
		int[] rightRef = new int[right - mid];
		
		for(int i = 0; i < leftArr.length; i++){
			leftArr[i] = listA[left +  i];
			leftRef[i] = listP[left + i];
		}
		for(int i = 0; i < rightArr.length; i++){
			rightArr[i] = listA[mid + 1 + i];
			rightRef[i] = listP[mid + 1 + i];
		}
		int leftIndex = 0;
		int rightIndex = 0;
		int mergedIndex = left;
		
		while(leftIndex < leftArr.length && rightIndex < rightArr.length){
			if(leftRef[leftIndex] <= rightRef[rightIndex]){
				listA[mergedIndex] = leftArr[leftIndex];
				leftIndex++;
			}
			else{
				listA[mergedIndex] = rightArr[rightIndex];
				rightIndex++;
			}
			mergedIndex++;
		}
		
		while(leftIndex < leftArr.length){
			listA[mergedIndex] = leftArr[leftIndex];
			leftIndex++;
			mergedIndex++;
		}
		while(rightIndex < rightArr.length){
			listA[mergedIndex] = rightArr[rightIndex];
			rightIndex++;
			mergedIndex++;
		}
	}
}
