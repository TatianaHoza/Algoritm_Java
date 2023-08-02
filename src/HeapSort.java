import java.util.Arrays;
import java.util.Scanner;
public class HeapSort {
    public static void heapSort(int[] array, int length) {
        int temp;
        int size = length - 1;
        for (int i = length/2; i >=0 ; i--) {
            heapify(array,i,size);

        }
        for(int i= size; i>=0; i--) {
            temp = array[0];
            array[0] = array[size];
            array[size] = temp;
            size--;
            heapify(array, 0, size);
        }
        System.out.println(array.toString());
    }
    public static void heapify (int [] array, int i, int heapSize) {
        int a = 2*i;
        int b = 2*i+1;
        int largestElement;
        boolean b1 = array[a] > array[i];

        if (a<= heapSize & array[a] > array[i]) {
            largestElement = a;
        } else {
            largestElement = i;
        }
        if (b <= heapSize & array[b] > array[largestElement]) {
            largestElement = b;
        }
        if (largestElement != i) {
            int temp = array[i];
            array[i] = array[largestElement];
            array[largestElement] = temp;
            heapify(array, largestElement, heapSize);
        }
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array :: ");
        int size = scanner.nextInt();
        System.out.println("Enter the elements of the array :: ");
        int[] myArray = new int[size];
        for(int i=0; i<size; i++) {
            myArray[i] = scanner.nextInt();
        }
        heapSort(myArray, size);
    }
}



