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
 */
public class LinkedList<E> implements List<E> {

    /**
     * A node in the list.
     */
    private class Node {

        /** The element pointed to by this node. */
        private final E element;

        /** Next node in the  list. */
        Node next;

        /** Previous node in the list. */
        Node previous;

        /**
         * Creates a new Node
         * without setting its next and previous pointers.
         *
         * @param element The element contained in this node.
         */
        public Node(E element) {
            this.element = element;
        }

        /**
         * Creates a new Node and sets its next and previous pointers.
         *
         * @param element The element contained in this node.
         * @param next The next node in the list.
         * @param previous The previous node in the list.
         */
        public Node(E element, Node next, Node previous) {
            this(element);
            this.next = next;
            this.previous = previous;

            if (next != null) {
                next.previous = this;
            }

            if (previous != null) {
                previous.next = this;
            }
        }
    }

    /** The first element in the list. */
    private Node first;

    /** The last element in the list.*/
    private Node last;

    /** The number of elements in the list. */
    private int size;

    /**
     * Searches the list for an object and returns whether it exists.
     *
     * This method uses a simple linear search,
     * and therefore has linear time complexity.
     *
     * @param o The object to search for.
     * @return <code>true</code> if the object exists in the list.
     */
    public boolean contains(Object o) {
        for (E e : this) {
            if (e.equals(o)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Searches the list for every element in a collection
     * and returns whether all of them exist.
     *
     * This method uses a linear search for every element,
     * and therefore has quadratic time complexity,
     * or more specifically O(m * n) where m is the size of the collection
     * and n is the size of this list.
     *
     * @param c The collection whose elements are to be searched for.
     * @return <code>true</code> if all of the elements exist in the list.
     */
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Gets the element at the specified position.
     *
     * This method has to traverse the list,
     * and therefore has linear time complexity.
     *
     * It will traverse from the back of the list,
     * if the index is closer to the end.
     *
     * This should yield an average access time of n/4,
     * where n is the size of the list.
     *
     * @param index The index of the element to retrieve.
     * @throws IndexOutOfBoundsException if the index is negative
     *         or higher than the size of the list.
     * @return The element at the specified index.
     */
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
