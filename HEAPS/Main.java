import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws Exception {
        // Create an instance of the IntHeap class
        IntHeap heap = new IntHeap();

        // Insert integer values into the heap
        heap.insert(34);
        heap.insert(45);
        heap.insert(22);
        heap.insert(89);
        heap.insert(76);

        // Perform heap sort and store the result in an ArrayList
         ArrayList<Integer> list = heap.heapSort();

        // Print the sorted list to the console
        System.out.println(list);
    }

    static class IntHeap {
        // ArrayList to store the elements of the heap
        private ArrayList<Integer> list;

        // Constructor that initializes the list when a new IntHeap object is created.
        public IntHeap() {
            list = new ArrayList<>();
        }

        // Swap elements at two given indices in the list
        private void swap(int first, int second) {
            int temp = list.get(first);
            list.set(first, list.get(second));
            list.set(second, temp);
        }

        // Calculate the index of the parent node
        private int parent(int index) {
            return (index - 1) / 2;
        }

        // Calculate the index of the left child node
        private int left(int index) {
            return index * 2 + 1;
        }

        // Calculate the index of the right child node
        private int right(int index) {
            return index * 2 + 2;
        }

        // Public method to insert a new integer value into the heap. It adds the value to the end of the list and then calls upheap to maintain the heap property.
        public void insert(int value) {
            list.add(value);
            upheap(list.size() - 1);
        }

        // Private recursive method to move an element up the heap until the heap property is satisfied.
        private void upheap(int index) {
            if(index == 0) {
                return;
            }
            int p = parent(index);
            if(list.get(index) < list.get(p)) {
                swap(index, p);
                upheap(p);
            }
        }

        // Remove the root element from the heap and restore the heap property
        public int remove() throws Exception {
            if (list.isEmpty()) {
                throw new Exception("Removing from an empty heap!");
            }

            int temp = list.get(0); // It saves the value of the root element (element at index 0) in a temporary variable (temp). This value will be returned at the end of the method.

            int last = list.remove(list.size() - 1); //It removes the last element from the heap. The last element will be moved to the root position (index 0) later to replace the removed root element.
            if (!list.isEmpty()) {
                list.set(0, last);
                downheap(0);
            }

            return temp;
        }

        // ? Move an element down the heap to maintain the heap property
        private void downheap(int index) {
            int min = index;
            int left = left(index);
            int right = right(index);

            if(left < list.size() && list.get(min) > list.get(left)) {
                min = left;
            }

            if(right < list.size() && list.get(min) > list.get(right)) {
                min = right;
            }

            if(min != index) {
                swap(min, index);
                downheap(min);
            }
        }

        // Perform heap sort and return the sorted elements in an ArrayList
        public ArrayList<Integer> heapSort() throws Exception {
            ArrayList<Integer> data = new ArrayList<>();
            while(!list.isEmpty()) {
                data.add(this.remove());
            }
            return data;
        }
    }
}
