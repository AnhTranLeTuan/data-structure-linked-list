public class LinkedList<E extends Comparable<E>> {

    private class Node<E extends Comparable<E>> {

        private E item;
        private Node nextNode;

        public Node(E item){
            this.item = item;
        }

    }
    private Node firstNode;
    private Node lastNode;
    private int listSize;

    public LinkedList(){}

    public LinkedList(E item){
        Node node = new Node(item);
        firstNode = node;
        lastNode = node;
        return;
    }

    public void addFirst(E item){
        if (item == null)
            throw new IllegalArgumentException();

        listSize++;

        Node node = new Node(item);

        if (firstNode == null) {
            sameNodeForFirstLast(node);
            return;
        }

        node.nextNode = firstNode;
        firstNode = node;
    }

    public void addLast(E item){
        if (item == null)
            throw new IllegalArgumentException();

        listSize++;

        Node node = new Node(item);

        if (lastNode == null) {
            sameNodeForFirstLast(node);
            return;
        }

        lastNode.nextNode = node;
        lastNode = node;
    }

    public void addMiddle(E item, int index){
        if (item == null || !isIndexEligible(index))
            throw new IllegalArgumentException();

        listSize++;

        if (index == 0) {
            addFirst(item);
            return;
        }

        Node node = new Node(item);
        Node previousNode = firstNode;
        Node currentNode = firstNode.nextNode;

        for (int i = 1; i <= index; i++){
            if (i == index){
                node.nextNode = currentNode;
                previousNode.nextNode = node;
                break;
            }

            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }
    }

    public void deleteFirst(){
        if (firstNode == null)
            throw new IllegalArgumentException();

        listSize--;

        if(firstNode.nextNode == null) {
            sameNodeForFirstLast(null);
            return;
        }

        Node tempNode = firstNode;
        firstNode = firstNode.nextNode;
        tempNode.nextNode = null;
    }

    public void deleteLast(){
        if (lastNode == null)
            throw new IllegalArgumentException();

        listSize--;

        if (firstNode.nextNode == null) {
            sameNodeForFirstLast(null);
            return;
        }

        Node previousNode = null;
        Node currentNode = firstNode;

        while (currentNode.nextNode != null){
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }

        previousNode.nextNode = null;
        lastNode = previousNode;
    }

    public void deleteMiddle(E item, int index){
        if (item == null || !isIndexEligible(index))
            throw new IllegalArgumentException();

        listSize--;

        if (index == 0) {
            deleteFirst();
            return;
        }

        Node node = new Node(item);
        Node previousNode = firstNode;
        Node currentNode = firstNode.nextNode;

        for (int i = 1; i <= index; i++){
            if (i == index){
                previousNode.nextNode = currentNode.nextNode;
                currentNode.nextNode = null;
                break;
            }

            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }
    }

    public boolean contains(E item){
        if (item == null || firstNode == null)
            return false;

        return traverseAndComPareItems(item) >= 0;
    }

    public int indexOf(E item){
        if (item == null)
            return -1;

        return traverseAndComPareItems(item);
    }

    public int size(){
        return listSize;
    }

    public E[] convertToArray(){
        E[] array = (E[])new Student[listSize];

        Node node = firstNode;
        for (int i = 0; i < listSize; i++) {
            array[i] = (E) node.item;

            node = node.nextNode;
        }

        return array;
    }

    public void reverse(){
        if (listSize < 2)
            return;

        Node previousNode = firstNode;
        Node currentNode = firstNode.nextNode;
        Node tempNode;

        while (currentNode != null){
            tempNode = currentNode.nextNode;
            currentNode.nextNode = previousNode;

            previousNode = currentNode;
            currentNode = tempNode;
        }

        tempNode = firstNode;
        firstNode = lastNode;
        lastNode = tempNode;
        lastNode.nextNode = null;
    }

    public E kthNodeFromTheEnd(int value){
        if (!(value >= 0 && value <= listSize))
            throw new IllegalArgumentException();

        int indexOfKthNode = listSize - value;
        Node currentNode = firstNode;

        for(int i = 0; i <= indexOfKthNode; i++){
            if(i == indexOfKthNode)
                break;

            currentNode = currentNode.nextNode;
        }

        return (E) currentNode.item;
    }



    private void sameNodeForFirstLast(Node node){
        firstNode = node;
        lastNode = node;
    }

    private int traverseAndComPareItems(E item){
        int index = 0;
        Node node = firstNode;

        while (true){
            if (node.item.compareTo(item) > 0)
                return index;

            if (node.nextNode == null)
                return -1;

            node = node.nextNode;
            index++;
        }
    }

    private boolean isIndexEligible(int index){
        if (index >= 0 && index < listSize)
            return true;

        return false;
    }

}
