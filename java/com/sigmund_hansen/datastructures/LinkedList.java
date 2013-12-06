/*
 * The data structures language practice project.
 * Copyright (C) 2013 Sigmund Hansen
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.sigmund_hansen.datastructures;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * A generic doubly linked list.
 *
 * Released under the GPL
 */
public class LinkedList<E> implements List<E> {

    private class Node {
        private final E element;
        Node next, previous;

        public Node(E element) {
            this.element = element;
        }
    }

    private Node first, last;
    private int size;

    public boolean contains(Object o) {
        for (E e : this) {
            if (e.equals(o)) {
                return true;
            }
        }

        return false;
    }

    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }

        return true;
    }

    public E get(int index) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(E e) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    public void add(int index, E e) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    public E set(int index, E e) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    public void clear() {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    public E remove(int index) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    public List<E> subList(int from, int to) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    public Iterator<E> iterator() {
        return listIterator(0);
    }

    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    public ListIterator<E> listIterator(int startIndex) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }
}
