import java.util.Random;



public class Lesson_2 {

    public static void print(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = new Random().nextInt(20);
//
//            print(array);
//            selectionSort(array);
//            print(array);
        }
    }
//алгоритмы сортировок

    // сортировка выбором

    public static void selectionSort(int[] array) {

        for (int i = 0; i < array.length-1; i++) {

            int min = i;
            for (int j = i +1; j < array.length ; j++) {
                if(array[j] < array[min])
                    min = j;
                    if (min != i){
                        int temp = array[min];
                        array[min] = array[i];
                        array[i] = temp;
                    }


            }


        }

    }

    public static void main(int[] array) {
            for (int i:array)
                System.out.println(i + ' ');

    }
//БЫСТРАЯ СОРТИРОВКА

    public static void quickSort(int[] array) {
        quickSort(array, 0 , array.length - 1);



    }
 private static void quickSort(int[] array,int leftBorder, int rightBorder){
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = array[(leftMarker+rightMarker)/2];
        while( leftMarker <= rightMarker){
            while(array[leftMarker] < pivot) leftMarker++;
            while (array[rightMarker] > pivot) rightMarker--;
          if(leftMarker<=rightMarker){
              if(leftMarker!=rightMarker) {
                  int temp = array[leftMarker];
                  array[leftMarker] = array[rightMarker];
                  array[rightMarker] = temp;
              }
              leftMarker++;
              rightMarker--;
          }
        }
        if (leftMarker<rightBorder){
            quickSort(array,leftMarker,rightBorder);
        }
        if(leftBorder<rightMarker){
            quickSort(array,leftBorder,rightMarker);
        }
 }


 //ПИРАМИДАЛЬНАЯ СОРТИРОВКА



}
