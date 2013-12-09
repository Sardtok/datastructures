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
import java.util.NoSuchElementException;

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
     *         or higher than or equal to the size of the list.
     * @return The element at the specified index.
     */
    public E get(int index) {
        return getNode(index).element;
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
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");        
    }

    /**
     * Gets the number of elements in the list.
     *
     * @return The number of elements in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Checks whether there are any elements in the list.
     *
     * @return <code>true</code> if the list does not contain any elements.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds an element at the end of the list.
     *
     * @param e The element to add to the list.
     * @return <code>true</code> if the element was added (i.e. always).
     */
    public boolean add(E e) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    /**
     * Adds an element at the specified position.
     *
     * @param index The index where the element should be inserted.
     * @param e The element to insert into the list.
     * @throws IndexOutOfBoundsException if the index is negative
     *         or higher than the size of the list.
     */
    public void add(int index, E e) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    /**
     * Appends all elements of the given collection to this list.
     *
     * @param c The collection whose elements should be added to the list.
     */
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    /**
     * Inserts all elements from the given collection at the specified
     * position.
     *
     * @param index The index at which to insert the collection's elements.
     * @param c The collection whose elements should be addd to the list.
     */
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
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
    public E set(int index, E e) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    /**
     * Removes all elements from the list.
     */
    public void clear() {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    /**
     * Removes the element at the specified position
     *
     * @param index The index of the element to remove.
     * @throws IndexOutOfBoundsException if the index is negative
     *         or higher than or equal to the size of the list.
     * @return The element that was removed.
     */
    public E remove(int index) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    /**
     * Removes the first occurrence of the specified object from the
     * list.
     *
     * @param o The object to remove from the list.
     * @return <code>true</code> if the list changed due to the
     *         operation (i.e. the element was found and removed).
     */
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    /**
     * Removes all the elements from the given collection from this list.
     *
     * @param c The collection whose elements should be removed from
     *          this list.
     * @return <code>true</code> if the list changed due to the
     *         operaton (i.e. any element was removed).
     */
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    /**
     * Removes all elements in this list that are not contained in the
     * given collection.
     *
     * @param c The collection whose elements are to be kept in this list.
     * @return <code>true</code> if the list changed due to the
     *         operation (i.e. any element was removed).
     */
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    /**
     * Gets the first index of the given object.
     *
     * @param o The object to look up.
     * @return The first index of the object or -1 if the list does
     *         not contain the item.
     */
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    /**
     * Gets the last index of the given object.
     *
     * @param o The object to look up.
     * @return The last index of the object or -1 if the list does not
     *         contain the item.
     */
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
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
    public List<E> subList(int from, int to) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    /**
     * Gets an array containing the items of this list.
     *
     * @return An array containing this list's items.
     */
    public Object[] toArray() {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    /**
     * Fills the specified array with the items from this list if the
     * items will fit, or a new array of the same type.
     *
     * @param a The array to fill with this list's items.
     * @return The array that was passed, if it's big enough, or a new
     *         array of the same type.
     */
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Coming soon to a data structure near you!");
    }

    /**
     * Gets an iterator which will iterate over the elements of the list
     * from first to last.
     * 
     * @return An iterator iterating from start to finish.
     */
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    /**
     * Gets a list iterator allowing forwards and backwards traversal,
     * starting at the first element.
     *
     * @return A list iterator starting at the first element.
     */
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
    public ListIterator<E> listIterator(final int startIndex) {
        return new ListIterator<E>() {
            NodeIterator it = new NodeIterator(startIndex);

            public boolean hasNext() {
                return it.hasNext();
            }
            
            public boolean hasPrevious() {
                return it.hasPrevious();
            }
            
            public int nextIndex() {
                return it.nextIndex();
            }
            
            public int previousIndex() {
                return it.previousIndex();
            }

            public E next() {
                return it.next().element;
            }
            
            public E previous() {
                return it.previous().element;
            }
            
            public void remove() {
                it.remove();
            }
            
            public void set(E e) {
                it.set(new Node(e));
            }
            
            public void add(E e) {
                it.add(new Node(e));
            }
        };
    }

    private class NodeIterator implements ListIterator<Node> {
        private Node current;
        private Node previous;
        private int index;

        NodeIterator(int index) {
            int i = 0;

            if (index < 0 || (index > 0 && index >= size)) {
                throw new IndexOutOfBoundsException();
            }

            if (index < size / 2) {
                current = first;
                while (i != index) {
                    current = current.next;
                    i++;
                }

            } else {
                i = size - 1;
                while (i != index) {
                    current = current.previous;
                    i--;
                }
            }

            this.index = index;
        }

        public boolean hasNext() {
            return index < size;
        }

        public boolean hasPrevious() {
            return index > 0;
        }

        public int nextIndex() {
            return index;
        }

        public int previousIndex() {
            return index - 1;
        }

        public Node next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            index++;
            previous = current;
            current = current.next;
            return previous;
        }

        public Node previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            
            index--;
            previous = current = current.previous;
            return previous;
        }

        public void remove() {
            if (previous == null) {
                throw new IllegalStateException();
            }
            
            previous.remove();
            index -= current != previous ? 1 : 0;
            previous = null;
        }

        public void set(Node n) {
            if (previous == null) {
                throw new IllegalStateException();
            }

            n.previous = previous.previous;
            n.next = previous.next;

            if (current == previous) {
                current = n;
            }

            previous = n;
        }
        
        public void add(Node n) {
            throw new UnsupportedOperationException("Coming to a data structure near you, with much more book-keeping pointers.");
        }
    }
}
