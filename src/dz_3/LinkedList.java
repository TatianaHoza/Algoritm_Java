package dz_3;

public class LinkedList<T> {

    LinkedList<Integer> list = new LinkedList<>() ;


    private Node head;
    private Node tail;


    private class Node{
        private int value;
        private Node nextNode;
        private Node previousNode;
    }

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

    public void print(Node head){
        Node node = head;
        while (node!=null){
            System.out.println(node + " ");
            node = node.nextNode;
        }
        System.out.println("null");
    }


}
