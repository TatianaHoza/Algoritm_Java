package lesson_4;

public class HashTable <K,V> {

    private static final double load_size = 0.75;

    private int size;
    private Bucket <K,V>[] buckets;

    HashTable(){
        buckets = new Bucket[8];
    }
    private int calcInd(K key){
        return Math.abs(key.hashCode()% buckets.length);
    }

    public boolean add (K key,V value){
        if(buckets.length*load_size <=size)
            resize();
        int index = calcInd(key);
        if (buckets[index] == null)
            buckets[index] = new Bucket<>();
        boolean result = buckets[index].add(key,value);
if(result)
    size ++;
        return result;
    }

    public boolean remove(K key){
        int index = calcInd(key);
        if(buckets[index] == null)
            return false;
        boolean result = buckets[index].remove(key);
        if(result)
            size --;
        return result;
    }

    private void resize(){
        Bucket<K,V> [] old = buckets;
        buckets = new Bucket[old.length*2];
        for (int i = 0; i < old.length ; i++) {
            Bucket<K,V> bucket = old[i];
            if(bucket == null)
                continue;
            Bucket.Node node = bucket.root;
            while (node != null)
                this.add((K) node.pair.key, (V) node.pair.value);
            node = node.next;

            old[i] = null;
        } old = null;

    }

    public void print() {
    }


    private class Bucket<K,V> {

        Node root;

        public boolean add(K key, V value) {
            if (root == null) {
                root = new Node(key, value);
                return true;
            }
            Node currentNode = root;
            while (currentNode.next != null) {
                if (currentNode.pair.key == key)
                    return false;
                currentNode = currentNode.next;
            }
            if(currentNode.pair.key == key)
                return false;

            currentNode.next = new Node(key,value);
            return true;
        }

        public boolean remove(K key){
            if (root == null) {
                return false;
            }
            if(root.pair.key == key){
                root = root.next;
                return true;
            }
            Node currentNode = root;
            while (currentNode.next != null) {
                if (currentNode.next.pair.key == key)
                    currentNode.next = currentNode.next.next;
                return true;
            }
            currentNode= currentNode.next;
            return false;

        }

        public V getValue(K key){
            Node currentNode = root;
            while(currentNode != null)
                if(currentNode.pair.key == key)
                    return currentNode.pair.value;
            else
                currentNode = currentNode.next;
            return null;

        }

        public void print() {
            for (var item: buckets){
                if (item != null){
                    item.print();
                    System.out.println();
                } else System.out.println("---------");
            }
        }



        private class Node{
            Pair pair;
            Node next;

            Node(){}
            Node(K key, V value){pair = new Pair(key,value);}

        }
        private class Pair{
            K key;
            V value;
            Pair(K key, V value){this.key = key; this.value = value;}
        }

    }

}
