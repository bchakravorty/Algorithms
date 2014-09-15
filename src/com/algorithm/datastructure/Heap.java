package com.algorithm.datastructure;

import java.util.Optional;

public class Heap<T extends Comparable> {
    @SuppressWarnings("unchecked")
    private T[] elements;
    private int size;
    private final int DEFAULT_SIZE = 11;

    public Heap() {
        elements = (T[]) new Comparable[DEFAULT_SIZE];
        this.size = 1;
    }

    public void add(T element) {
        elements[size] = element;
        heapifyUp(size);
        size++;
    }

    public Optional<T> removeMax() {
        Optional maxOptional = getMax();
        if (maxOptional.isPresent()) {
            exchange(1, size -1);
            elements[size-1] = null;
            size --;
            heapifyDown(1);
        }
        return maxOptional;
    }

    public Optional<T> getMax() {
        if (this.size <= 1) {
            return Optional.empty();
        } else {
            T max = elements[1];
            return Optional.of(max);
        }
    }

    public Optional<T> deleteElement(T element) {
        int index = findElement(element);
        Optional<T> resultElement = null;
        if (index == -1) {
            resultElement = Optional.empty();
        } else {
            resultElement = Optional.of(elements[index]);
            exchange(index, size);
            heapifyDown(index);
        }
        return resultElement;
    }

    private void exchange(int i, int j) {
        T temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    private int findElement(T element) {
        int index = -1;
        if (size > 1) {
            for(int i = 1 ; i < size; i++){
                if (elements[i].equals(element)) {
                    index = i; break;
                }
            }
        }
        return index;

    }

    private void heapifyUp(int index) {
        if (index <= 1) return ;
        int parentIndex = index /2;
        if ((elements[parentIndex].compareTo(elements[index])) < 0) {
            exchange(parentIndex, index);
            heapifyUp(parentIndex);
        }
    }

    private void heapifyDown(int index) {
        if (index >= size || 2*index >= size ) return;
        if ((2*index+1 < size) && (elements[2* index+1].compareTo(elements[2 * index])) > 0 && (elements[2*index + 1].compareTo(elements[index]))> 0)  {
            exchange(index, 2*index +1);
            heapifyDown(2*index +1);
        }  else if (elements[2*index].compareTo(elements[index]) > 0){
            exchange(index, 2*index);
            heapifyDown(2*index);
        }
    }

    public String toString(){
        String str = new String();
        if (size < 1) {
            str = "There are no elements in the heap";
        } else {
            for (int i = 1; i < size ; i ++) {
                str+=  elements[i] + " : ";
            }
        }
        return str;
    }

}
