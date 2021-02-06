package ueb;

public class LinkedList {
    private Element elements;

    public boolean isEmpty() {
        return elements == null;
    }

    
    public void insertElement(int value) {
        if (this.isEmpty()) {
            elements = new Element(value);
        } else {
            elements = elements.insertElement(value);
        }
    }

   
    public void appendElement(int value) {
        if (this.isEmpty()) {
            elements = new Element(value);
        } else {
            elements = elements.appendElement(value);
        }
    }

    
    public void deleteElement(int value) {
        if (!isEmpty()) {
            elements = elements.deleteElement(value);
        }
    }

    
    public int size() {
        if (!isEmpty()) {
            return elements.size();
        }
        return 0;
    }

    
    public int sum() {
        if (!isEmpty()) {
            return elements.sum();
        }
        return 0;
    }

    
    public boolean isSorted() {
        // FIXME: DONE an empty list is sorted
        if (isEmpty()) {
            return true;
        }
        return elements.isSorted();
    }

    

    public boolean existsElement(int value) {
        if (!isEmpty()) {
            return elements.existsElement(value);
        }
        return false;
    }

    public String toString() {
        if (!isEmpty()) {
 
            return "{" + elements.toString() + "}";
        }
        
        return "{}";
    }

   
    public int[] toArray() {
        if (!isEmpty()) {
            int size = elements.size();
            Element copy = elements;
            int[] toArray = new int[size];
            for (int i = 0; i < size && copy != null; i++) {
                toArray[i] = copy.getValue();
                copy = copy.getNext();
            }
            return toArray;
        }
        return new int[]{};
    }

    
    public int getValueAt(int index) {
        if (!isEmpty()) {
            return elements.getValueAt(index);
        }
        return Integer.MAX_VALUE;
    }

    
    public void insertElementAt(int value, int index) {
      
        if (isEmpty()) {
           
            if (index == 0) {
                elements = new Element(value);
            }
        } else {
            elements = elements.insertElementAt(value, index);
        }
    }

 
    public void prependElement(int value) {
   
        if (isEmpty()) {
            elements = new Element(value);
        } else {
            elements = elements.prependElement(value);
        }
    }

    public void insertSortedIfUnique(int value) {
        if (isEmpty()) {
            elements = new Element(value);
        } else if (!existsElement(value)) {
            elements = elements.insertElement(value);
        }
    }

    public void deleteAll(int value) {
        if (!isEmpty()) {
            elements = elements.deleteAll(value);
        }
    }
}
