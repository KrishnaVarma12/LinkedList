package ueb;

public class ElementCForLinkedList {
    private final int value;
    private Element next;


    public Element(int value) {
        this.value = value;
    }

    public Element(int value, Element next) {
        this.value = value;
        this.next = next;
    }

    
    public int getValue() {
        return this.value;
    }

   
    public Element getNext() {
        return this.next;
    }

    
    public Element appendElement(int value) {
        if (this.next == null) {
            this.next = new Element(value, null);
        } else {
            this.next = this.next.appendElement(value);
        }
        return this;
    }

    public Element insertElement(int value) {
        if (this.value > value) {
            return new Element(value, this);
        } else if (this.next == null) {
            this.next = new Element(value, null);
            return this;
        } else {
            this.next = this.next.insertElement(value);
            return this;
        }
    }

    public Element deleteElement(int value) {
        if (this.value == value) {
            return this.next;
        } else {
            if (this.next != null) {
                this.next = this.next.deleteElement(value);
            }
            return this;
        }
    }

    public int getValueAt(int index) {
        // FIXME: DONE do not use this.size() here
        if (index == 0) {
            return this.value;
        } else if (this.next != null) {
            return this.next.getValueAt(index - 1);
        } else {
            return Integer.MAX_VALUE;
        }
    }

   
    public int size() {
        return this.next != null
                ? 1 + this.next.size()
                : 1;
    }

    
    public int sum() {
        return this.next != null
                ? this.value + this.next.sum()
                : this.value;
    }

   
    public String toString() {
        return this.next != null
                ? this.value + " " + this.next.toString()
                : "" + this.value;
    }

    
    public boolean existsElement(int value) {
        if (this.next != null) {
            if (this.value == value) {
                return true;
            } else {
                return this.next.existsElement(value);
            }
        } else {
            return this.value == value;
        }
    }

    
    public boolean isSorted() {
        if (this.next != null) {
            if (this.value > this.next.value) {
                return false;
            }
            return this.next.isSorted();
        }
        return true;
    }

   
    public Element insertElementAt(int value, int index) {
        
        if (index == 0 && this.next != null) {
            return this.prependElement(value);
        }
        if (index >= 0 && this.next != null) {
            if (index == 1) {
                Element element = this.next;
                this.next = new Element(value, element);
            } else {
                this.next = this.next.insertElementAt(value, index - 1);
            }
            return this;
        } else if (index == 1) {
            return this.appendElement(value);
        }
        return this;
    }

   
    public Element prependElement(int value) {
        return new Element(value, this);
    }

    public Element deleteAll(int value) {
        
        if (this.value == value) {
            // FIXME DONE: remove all other occurrences of "value", too
            if (this.next != null) {
                this.next = this.next.deleteAll(value);
            }
            return this.next;
        } else {
            if (this.next != null) {
                this.next = this.next.deleteAll(value);
            }
            return this;
        }
    }
}
