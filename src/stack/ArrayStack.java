/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import exceptions.EmptyStructureException;

/**
 *
 * @author Daniel
 */
public class ArrayStack<E> {

    private E[] data;
    private int size;

    public ArrayStack() {
        this.data = (E[]) new Object[1];
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    protected boolean isFull() {
        return this.size == this.data.length;
    }

    public E peek() throws EmptyStructureException {
        if (isEmpty()) {
            throw new EmptyStructureException();
        }

        return this.data[(this.size - 1)];
    }

    public E pop() throws EmptyStructureException {
        if (isEmpty()) {
            throw new EmptyStructureException();
        }
        this.size -= 1;

        return this.data[this.size];
    }

    public void push(E target) {
        if (isFull()) {
            stretch();
        }

        this.data[this.size] = target;
        this.size += 1;
    }

    protected void stretch() {
        Object[] newData = new Object[2 * this.data.length];

        for (int i = 0; i < this.data.length; i++) {
            newData[i] = this.data[i];
        }

        this.data = (E[]) newData;
    }

    public void fix() {
        if (!isFull()) {
            Object[] newData = new Object[this.size];

            for (int i = 0; i < this.size; i++) {
                newData[i] = this.data[i];
            }

            this.data = (E[]) newData;
        }
    }

    public int getSize() {
        return this.size;
    }

    public E get(int index) throws ArrayIndexOutOfBoundsException {
        return this.data[(index - 1)];
    }

    public void clear() {
        this.data = (E[]) new Object[1];
        this.size = 0;
    }

    public boolean contains(E target) {
        for (int i = 0; i < this.size; i++) {
            if (target.equals(this.data[i])) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        String result = "";
        
        while(!this.isEmpty()){
            result  = this.pop() + " " + result; 
        }
        
        return result.substring(0, result.length() - 1);
    }
     
}
