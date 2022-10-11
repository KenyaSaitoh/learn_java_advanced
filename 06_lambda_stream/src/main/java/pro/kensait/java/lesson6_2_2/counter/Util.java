package pro.kensait.java.lesson6_2_2.counter;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

public class Util {
    public static List<Integer> getIntList() {
        List<Integer> intList = new IntList<Integer>();
        for (int i = 0; i < 10000; i++) {
            intList.add(i);
        }
        return intList;
    }

    public static void sleepAWhile(long time) {
        try {
            Thread.sleep(time);
        } catch(InterruptedException ie) {
            throw new RuntimeException(ie);
        }
    }
}

class IntList<T> extends ArrayList<T> {
    @Override
    public T get(int index) {
        Util.sleepAWhile(1000);
        System.out.println("###############");
        return super.get(index);
    }
    
    @Override
    public ListIterator listIterator() {
        System.out.println("###############");
        return new ListIterator2(super.listIterator());
    }
}

class ListIterator2<E> implements ListIterator<E> {
    private ListIterator<E> iterator;
    ListIterator2(ListIterator<E> iterator) {
        this.iterator = iterator;
    }
    public boolean hasNext() {
        return iterator.hasNext();
    }
    public E next() {
        Util.sleepAWhile(1000);
        System.out.println("###############");
        return iterator.next();
    }
    public boolean hasPrevious() {
        return iterator.hasPrevious();
    }
    public void forEachRemaining(Consumer<? super E> action) {
        iterator.forEachRemaining(action);
    }
    public E previous() {
        return iterator.previous();
    }
    public int nextIndex() {
        return iterator.nextIndex();
    }
    public int previousIndex() {
        return iterator.previousIndex();
    }
    public void remove() {
        iterator.remove();
    }
    public void set(E e) {
        iterator.set(e);
    }
    public void add(E e) {
        iterator.add(e);
    }
}