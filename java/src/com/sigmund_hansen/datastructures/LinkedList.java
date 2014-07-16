/*
 * The data structures language practice project.
 * Copyright (C) 2013 Sigmund Hansen
 *
 * This file is part of Data Structures Language Practice Project, DSLPP.
 * 
 * DSLPP is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DSLPP is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with DSLPP.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.sigmund_hansen.datastructures;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * A generic doubly linked list.
 * 
 * @author Sigmund Hansen
 * @param <E> The type of elements that will be stored in the list.
 */
public class LinkedList<E> implements List<E>, Deque<E> {

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

        public void remove() {
            if (previous != null) {
                previous.next = next;
            }

            if (next != null) {
                next.previous = previous;
            }
            
            if (this == first) {
                first = next;
            }

            if (this == last) {
                last = previous;
            }
            
            size--;
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
    @Override
    public boolean contains(Object o) {
        if (o == null) {
            return false;
        }
        
        for (E e : this) {
            if (o.equals(e)) {
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
    @Override
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
     *         or higher than or equal to the size of the list.
     * @return The element at the specified index.
     */
    @Override
    public E get(int index) {
        return getNode(index).element;
    }
    
    @Override
    public E getFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E pop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E getLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E peekFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E peekLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E element() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Gets the node at the specified position.
     *
     * This helper method is used by methods that require accessing a
     * node at specific indices.
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
     *         or higher than or equal to the size of the list.
     * @return The element at the specified index.
     */
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        NodeIterator it = new NodeIterator(index);

        return it.next();
    }

    /**
     * Gets the number of elements in the list.
     *
     * @return The number of elements in the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks whether there are any elements in the list.
     *
     * @return <code>true</code> if the list does not contain any elements.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds an element at the end of the list.
     *
     * @param e The element to add to the list.
     * @return <code>true</code> if the element was added (i.e. always).
     */
    @Override
    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException("Null elements are not supported.");
        }
        
        last = new Node(e, null, last);
        size++;
        
        if (first == null) {
            first = last;
        }
        return true;
    }

    /**
     * Adds an element at the beginning of the list.
     * 
     * @param e The element to add to the list.
     */
    @Override
    public void addFirst(E e) {
        if (e == null) {
            throw new NullPointerException("Null elements are not supported.");
        }
        
        first = new Node(e, first, null);
        size++;
        
        if (last == null) {
            last = first;
        }
    }

    @Override
    public void push(E e) {
        addFirst(e);
    }

    @Override
    public boolean offerFirst(E e) {
        if (e == null) {
            return false;
        }
        
        addFirst(e);
        return true;
    }

    /**
     * Adds an element to the end of the list.
     * 
     * @param e The element to add to the list.
     * @see #add(java.lang.Object) 
     */
    @Override
    public void addLast(E e) {
        add(e);
    }

    @Override
    public boolean offerLast(E e) {
        if (e == null) {
            return false;
        }
        
        return add(e);
    }
    
    @Override
    public boolean offer(E e) {
        return offerLast(e);
    }
    
    /**
     * Adds an element at the specified position.
     *
     * @param index The index where the element should be inserted.
     * @param e The element to insert into the list.
     * @throws IndexOutOfBoundsException if the index is negative
     *         or higher than the size of the list.
     */
    @Override
    public void add(int index, E e) {
        ListIterator<E> it = listIterator(index);
        it.add(e);
    }

    /**
     * Appends all elements of the given collection to this list.
     *
     * @param c The collection whose elements should be added to the list.
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c.isEmpty()) {
            return false;
        }
        
        for (E e : c) {
            add(e);
        }
        
        return true;
    }

    /**
     * Inserts all elements from the given collection at the specified
     * position.
     *
     * @param index The index at which to insert the collection's elements.
     * @param c The collection whose elements should be addd to the list.
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (c.isEmpty()) {
            return false;
        }
        
        ListIterator<E> it = listIterator(index);
        
        for (E e : c) {
            it.add(e);
        }
        
        return true;
    }

    /**
     * Exchanges the element at the specified position for the passed
     * element.
     *
     * @param index The index of the element to switch out.
     * @param e The element to insert.
     * @throws IndexOutOfBoundsException if the index is negative
     *         or higher than or equal to the size of the list.
     * @return The element previously located at that position.
     */
    @Override
    public E set(int index, E e) {
        ListIterator<E> it = listIterator(index);
        E ret = it.next();
        it.set(e);
        return ret;
    }

    /**
     * Removes all elements from the list.
     */
    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Removes the element at the specified position
     *
     * @param index The index of the element to remove.
     * @throws IndexOutOfBoundsException if the index is negative
     *         or higher than or equal to the size of the list.
     * @return The element that was removed.
     */
    @Override
    public E remove(int index) {
        Iterator<E> it = listIterator(index);
        E ret = it.next();
        it.remove();
        return ret;
    }

    /**
     * Removes the first occurrence of the specified object from the
     * list.
     *
     * @param o The object to remove from the list.
     * @return <code>true</code> if the list changed due to the
     *         operation (i.e. the element was found and removed).
     */
    @Override
    public boolean remove(Object o) {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (o.equals(it.next())) {
                it.remove();
                return true;
            }
        }
        
        return false;
    }

    @Override
    public E removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E pollFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E pollLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E poll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Removes all the elements from the given collection from this list.
     *
     * @param c The collection whose elements should be removed from
     *          this list.
     * @return <code>true</code> if the list changed due to the
     *         operaton (i.e. any element was removed).
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        Iterator<E> it = iterator();
        boolean removedItems = false;
        
        while (it.hasNext()) {
            if (c.contains(it.next())) {
                it.remove();
                removedItems = true;
            }
        }
        
        return removedItems;
    }

    /**
     * Removes all elements in this list that are not contained in the
     * given collection.
     *
     * @param c The collection whose elements are to be kept in this list.
     * @return <code>true</code> if the list changed due to the
     *         operation (i.e. any element was removed).
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        Iterator<E> it = iterator();
        boolean removedItems = false;
        
        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                it.remove();
                removedItems = true;
            }
        }
        
        return removedItems;
    }

    /**
     * Gets the first index of the given object.
     *
     * @param o The object to look up.
     * @return The first index of the object or -1 if the list does
     *         not contain the item.
     */
    @Override
    public int indexOf(Object o) {
        ListIterator<E> it = listIterator();
        
        while (it.hasNext()) {
            if (o.equals(it.next())) {
                return it.previousIndex();
            }
        }
        
        return -1;
    }

    /**
     * Gets the last index of the given object.
     *
     * @param o The object to look up.
     * @return The last index of the object or -1 if the list does not
     *         contain the item.
     */
    @Override
    public int lastIndexOf(Object o) {
        ListIterator<E> it = listIterator(size);
        
        while (it.hasPrevious()) {
            if (o.equals(it.previous())) {
                return it.nextIndex();
            }
        }
        
        return -1;
    }

    /**
     * Gets a view of part of this list.
     *
     * @param from The index of the first element to include.
     * @param to The index directly following the returned view.
     * @throws IndexOutOfBoundsException if the starting index is
     *         negative, the ending index is larger than the size of
     *         the list or the starting index is higher than the
     *         ending index.
     * @return A view of a subset of this list.
     */
    @Override
    public List<E> subList(int from, int to) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    /**
     * Gets an array containing the items of this list.
     *
     * @return An array containing this list's items.
     */
    @Override
    public Object[] toArray() {
        Object[] ret = new Object[size];
        int i = 0;
        
        for (E e : this) {
            ret[i++] = e;
            System.out.println(e);
        }
        
        return ret;
    }

    /**
     * Fills the specified array with the items from this list if the
     * items will fit, or a new array of the same type.
     *
     * @param a The array to fill with this list's items.
     * @return The array that was passed, if it's big enough, or a new
     *         array of the same type.
     */
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length > size) {
            a[size] = null;
        }
        
        if (a.length < size) {
            a = (T[]) Array.newInstance(a.getClass().getComponentType(), size);
        }
        
        int i = 0;
        
        for (E e : this) {
            a[i++] = (T) e;
        }
        
        return a;
    }

    /**
     * Gets an iterator which will iterate over the elements of the list
     * from first to last.
     * 
     * @return An iterator iterating from start to finish.
     */
    @Override
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    /**
     * Gets a list iterator allowing forwards and backwards traversal,
     * starting at the first element.
     *
     * @return A list iterator starting at the first element.
     */
    @Override
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    /**
     * Gets a list iterator allowing forwards and backwards traversal,
     * starting at the specified position.
     *
     * @param startIndex The index of the first element to return upon
     *                   calling next.
     * @return A list iterator starting at the specified position.
     */
    @Override
    public ListIterator<E> listIterator(final int startIndex) {
        return new ListIterator<E>() {
            NodeIterator it = new NodeIterator(startIndex);

            @Override
            public boolean hasNext() {
                return it.hasNext();
            }
            
            @Override
            public boolean hasPrevious() {
                return it.hasPrevious();
            }
            
            @Override
            public int nextIndex() {
                return it.nextIndex();
            }
            
            @Override
            public int previousIndex() {
                return it.previousIndex();
            }

            @Override
            public E next() {
                return it.next().element;
            }
            
            @Override
            public E previous() {
                return it.previous().element;
            }
            
            @Override
            public void remove() {
                it.remove();
            }
            
            @Override
            public void set(E e) {
                it.set(new Node(e));
            }
            
            @Override
            public void add(E e) {
                it.add(new Node(e));
            }
        };
    }

    @Override
    public Iterator<E> descendingIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class NodeIterator implements ListIterator<Node> {
        private Node next;
        private Node current;
        private Node previous;
        private int nextIndex;
        private int prevIndex;

        NodeIterator(int index) {
            int i = 0;

            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException();
            }

            if (index <= size / 2) {
                next = first;
                while (i < index) {
                    next = next.next;
                    i++;
                }
                
                if (next != null) {
                    previous = next.previous;
                }

            } else {
                previous = last;
                i = size;
                while (i > index) {
                    previous = previous.previous;
                    i--;
                }
                
                if (previous != null) {
                    next = previous.next;
                }
            }

            this.nextIndex = index;
            this.prevIndex = index - 1;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public boolean hasPrevious() {
            return prevIndex >= 0 && size > 0;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return prevIndex;
        }

        @Override
        public Node next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            prevIndex++;
            nextIndex++;
            current = next;
            next = next.next;
            previous = current;
            return current;
        }

        @Override
        public Node previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            
            prevIndex--;
            nextIndex--;
            current = previous;
            previous = previous.previous;
            next = current;
            return current;
        }

        @Override
        public void remove() {
            if (current == null) {
                throw new IllegalStateException();
            }
            
            current.remove();
            if (current == next) {
                next = next.next;
            } else {
                nextIndex--;
            }
            
            if (current == previous) {
                previous = previous.previous;
                prevIndex--;
            }
            current = null;
        }

        @Override
        public void set(Node n) {
            if (current == null) {
                throw new IllegalStateException();
            }

            n.previous = current.previous;
            n.next = current.next;
            
            if (current.previous != null) {
                current.previous.next = n;
            }
            
            if (current.next != null) {
                current.next.previous = n;
            }

            if (current == first) {
                first = n;
            }
            
            if (current == last) {
                last = n;
            }
            
            if (current == next) {
                next = n;
            }
            
            if (current == previous) {
                previous = n;
            }
            
            current = n;
        }
        
        @Override
        public void add(Node n) {
            n.next = next;
            n.previous = previous;
            
            if (next != null) {
                next.previous = n;
            }
            
            if (previous != null) {
                previous.next = n;
            }

            if (next == first) {
                first = n;
            }
            
            current = null;
            previous = n;
            nextIndex++;
            prevIndex++;
            size++;
        }
    }
}
