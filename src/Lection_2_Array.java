//import static com.sun.jndi.toolkit.dir.DirSearch.search;

public class Lection_2_Array {
    //Массив - это контейнер, хранящий данные идентифицируемые по индексу. К
    //любому элементу массива всегда можно обратиться по его индексу и достать или
    //заменить его.
    //В зависимости от языка программирования, массив может иметь как статичную
    //длину (Java), так и динамическую (JavaScript), но основной особенность работы с
    //массивами является скорость доступа к элементам – т.к. каждый из них имеет один
    //конкретный индекс, программа всегда знает где в памяти лежит конкретный индекс
    //за счет чего скорость доступа к ним составляет O(1).

    //Пузырьковая сортировка: Базовый алгоритм предполагает, что каждый элемент необходимо сравнить с
    //соседним и, если правый элемент меньше левого, то их меняют местами. Алгоритм
    //повторяется до тех пор, пока все элементы в массиве не выстроятся в нужном
    //порядке.


//    public static void main(int[] array) {
//
//        boolean needSort;
//        do{
//            needSort = false;
//            for (int i = 0; i < array.length -1; i++) {
//                if(array[i] > array[i+1]){
//                    int temp = array[i];
//                    array[i] = array [i+1];
//                    array[i+1] = temp;
//                    needSort = true;
//                }
//
//            }
//        } while (needSort);
//
//    }

//    Максимальная сложность – количество шагов для обработки наиболее
//    неблагоприятного состояния входных данных.
//    Ожидаемая сложность – это вариант, который будет релевантен для большей
//    части возможных кейсов


    // Сортировка выбором

//    public static void main(int[] array) {
//        for (int i = 0; i < array.length; i++) {
//            int minPosition = i;
//            for (int j = i+1; j < array.length ; j++) {
//                if (array[j] <array[minPosition]){
//                    minPosition = j;
//
//                }
//
//            }
//            if (minPosition != i){
//                int temp = array[i];
//                array[i] = array[minPosition];
//                array[minPosition] = temp;
//
//            }
//        }

//    Сортировка вставками
//    Так же, как нечто среднее, между сортировкой пузырьком и выбором, можно
//    выделить сортировку вставками. Принцип работы у нее точно такой же, как у
//    предыдущей, только после сравнения двух элементов мы не запоминаем индекс
//    наименьшего (наибольшего) из элементов, а сразу производим перестановку.

//    public static void main(int[] array) {
//        for (int i = 0; i < array.length; i++) {
//            for (int j = i+1; j <array.length ; j++) {
//                if (array[j]<array[i]){
//                    int temp = array[i];
//                    array[i] = array[j];
//                    array[j] = temp;
//
//            }
//
//        }


    // АЛГОРИТМЫ ПОИСКА

// перебор массива: O(n)
//    public static int findIndex(int value, int[] array){
//        for (int i = 0; i < array.length ; i++) {
//            if (array[i] == value){
//                return i;
//
//        }
//    }return  -1;
//


        //БИНАРНЫЙ ПОИСК O(log n).
//        Бинарный поиск - тип поискового алгоритма, который последовательно
//        делит пополам заранее отсортированный массив данных, чтобы обнаружить
//        нужный элемент. Другие его названия — двоичный поиск, метод половинного
//        деления, дихотомия. Принцип работы алгоритма бинарного поиска. Основная
//        последовательность действий алгоритма выглядит так: Сортируем массив
//        данных. Делим его пополам и находим середину.


//    public static void main(int value,int[] array, int min, int max) {
//        int midpoint;
//        if(max<min){
//            return; -1;
//
//    } else {
//            midpoint = (max-min)/2 +min;
//
//        }
//        if(array[midpoint]< value)
//            return search(value,array,midpoint +1, max);
//        else{
//            if(array[midpoint]>value){
//                return search(value,array, min, midpoint-1);
//
//            } else {
//                return midpoint;
//            }
//        }

// АЛГОРИТМ БЫСТРОЙ СОРТИРОВК


    // СОРТИРОВКА КУЧЕЙ(ПИРАМИДАЛЬНАЯ) O(n log n)




    public class HeapSort
    {
        public void sort(int arr[])
        {
            int n = arr.length;

            // Построение кучи (перегруппируем массив)
            for (int i = n / 2 - 1; i >= 0; i--)
                heapify(arr, n, i);

            // Один за другим извлекаем элементы из кучи
            for (int i=n-1; i>=0; i--)
            {
                // Перемещаем текущий корень в конец
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                // Вызываем процедуру heapify на уменьшенной куче
                heapify(arr, i, 0);
            }
        }

        // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i, что является
// индексом в arr[]. n - размер кучи
        void heapify(int arr[], int n, int i)
        {
            int largest = i; // Инициализируем наибольший элемент как корень
            int l = 2*i + 1; // левый = 2*i + 1
            int r = 2*i + 2; // правый = 2*i + 2

            // Если левый дочерний элемент больше корня
            if (l < n && arr[l] > arr[largest])
                largest = l;

            // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
            if (r < n && arr[r] > arr[largest])
                largest = r;
            // Если самый большой элемент не корень
            if (largest != i)
            {
                int swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;

                // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
                heapify(arr, n, largest);
            }
        }

        /* Вспомогательная функция для вывода на экран массива размера n */
        static void printArray(int arr[])
        {
            int n = arr.length;
            for (int i=0; i<n; ++i)
                System.out.print(arr[i]+" ");
            System.out.println();
        }

        // Управляющая программа
        public static void main(String args[])
        {
            int arr[] = {12, 11, 13, 5, 6, 7};
            int n = arr.length;

            //HeapSort ob = new HeapSort();
           // ob.sort(arr);

            System.out.println("Sorted array is");
            printArray(arr);
        }
    }



}


