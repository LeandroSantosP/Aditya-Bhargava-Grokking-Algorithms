package org.example;

class ExecLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(3);
        linkedList.clean();
        System.out.println(linkedList.getSize());
        System.out.println(linkedList);
    }
}

class No<T> {
     T value;
     No<T> nextValue;

    public No(T value) {
        this.value = value;
    }

    public No(T value, No<T> nextValue) {
        this.value = value;
        this.nextValue = nextValue;
    }

    public void setNextValue(No<T> nextValue) {
        this.nextValue = nextValue;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public No<T> getNextValue() {
        return this.nextValue;
    }

    @Override
    public String toString() {
        return "No [value=" + value + ", nextValue=" + nextValue + "]";
    }

}

public class LinkedList<T> {
    private No<T> noStart;
    private No<T> noEnd;
    private int size;

    public int getSize() {
        return size;
    }

    public void add(T element) {
        No<T> no = new No<>(element);
        if (this.size == 0) {
            this.noStart = no;
        } else {
            this.noEnd.setNextValue(no);
        }
        this.noEnd = no;
        this.size++;
    }

    public void clean() {
        for (No<T> current = this.noStart; current != null;) {
            No<T> next = current.getNextValue();
            current.setNextValue(null);
            current.setValue(null);
            current = next;
        }
        this.noStart = null;
        this.noEnd = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        No<T> current = this.noStart;
        for (int i = 0; i < this.size; i++) {
            if (current.getNextValue() != null) {
                builder.append(current.getValue()).append(", ");
                current = current.getNextValue();
                continue;
            }
            builder.append(current.getValue());
        }
        builder.append("]");
        return builder.toString();
    }
}

