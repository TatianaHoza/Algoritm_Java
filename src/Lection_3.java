//import static sun.security.ssl.Utilities.swap;

public class Lection_3 {

    //Связный список – базовая структура данных, состоящая из узлов, где каждый узел
    //содержит одну или две ссылки, который ссылаются на следующий или на
    //следующий и предыдущий узел соответственно.
    // HEAD - первый узел связанного списка, TAIL - последний элемент связанного списка

    // БАЗОВАЯ РЕАЛИЗАЦИЯ СВЯЗАННОГО СПИСКА

    private Node head;
    private Node tail;

    class Node{
        private int value;
        private Node nextNode;
        private Node previousNode;
    }

    //Поиск элементов методом перебора-перебираем узлы: - O(n)

    public Node findNode(int value){
        Node node = head;
        while (node.nextNode != null){
            node = node.nextNode;
            if(node.value == value){
                return node;
            }
        }
        return null;
    }
// подобие бинарного поиска -  O(n)
    public Node findIndNode(int index){
        Node node = head;
        for (int i = 0; i < index ; i++) {
            node = node.nextNode;
            if(node == null) return null;

        } return node;
    }


    // добавление нового элемента- O(1)

    public void addLast(int value){
        Node node = new Node();
        node.value = value;
        tail.nextNode = node;
        node.previousNode = tail;
        tail = node;

    }
    //А вот операции добавления в начало или середину массива будут уже иметь свои
    //накладные расходы, а именно – при добавлении нового элемента необходимо
    //обновить индексы всех элементов, находящихся правее вставляемого значения,
    //т.к. вставляемый элемент занимает индекс уже существующего объекта, а значит
    //для всех правых элементов индекс должен увеличиться на единицу. O(n)
    //В связном списке же сдвигать индексы после вставки не требуется, т.к. они
    //физически не отслеживаются и не определяются. Любая операция вставки будет
    //похожа на операцию вставки в конец и иметь константную сложность O(1)

    public void add(int value, Node previousNode){
        Node node = new Node();
        node.value = value;
        Node nextNode = previousNode.nextNode;
        previousNode.nextNode = node;
        node.previousNode = previousNode;
        node.nextNode = nextNode;
        nextNode.previousNode = node;
    }

    //Для связного списка также существуют специфические задачи – например,
    //разворот. Разворотом называется операция, когда последний элемент становится
    //первым, предпоследний вторым и т.д. _ O(1) -для односвязного списка

    public void revert(){
        Node node = head;

        //меняем местами указатели на  head tail
        Node temp = head;
        head = tail;
        tail = temp;

        // перебираем список, переворачивая указатели

        while (node.nextNode != null){
            temp = node.nextNode;
            node.nextNode = node.previousNode;
            node.previousNode = temp;
            node = node.previousNode;
        }
    }

    //СОРТИРОВКА ВЫБОРОМ O(n^2)

    public void sort(){
        Node node = head;
        while(node.nextNode!=null) {
            Node minPositionNode = node;
            Node innerNode = node.nextNode;
            while (innerNode != null) {
                if (innerNode.value < minPositionNode.value) {
                    minPositionNode = innerNode;
                }
            }
            innerNode = innerNode.nextNode;

            if (minPositionNode != node) swap(node, minPositionNode);

            //обновляем ссылки head tail

            if (minPositionNode.previousNode == null) head = minPositionNode;

            if (node.nextNode == null) tail = node;
            else node = node.nextNode;

            //сдвигаем
            node = minPositionNode.nextNode;



        }



    }
    private void swap(Node node1,Node node2){
        // мнеяем объекты местами, меняя ссылки на соседние элементы
        Node temp = node1.previousNode;
        node1.previousNode = node2.previousNode;
        node2.previousNode = temp;
        temp = node1.nextNode;
        node1.nextNode = node2.nextNode;
        node2.nextNode = temp;

        //корректируем ссылки соседних элементов

        if(node2.previousNode!=null) node2.previousNode.nextNode = node2;

        if(node2.nextNode!=null) node2.nextNode.previousNode = node2;

        if (node1.previousNode != null) node1.previousNode.nextNode = node1;

        if(node1.nextNode !=null) node1.nextNode.previousNode=node1;

    }








}
