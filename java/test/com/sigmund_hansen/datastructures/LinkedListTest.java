/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmund_hansen.datastructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sigmund Hansen
 */
public class LinkedListTest {

    public LinkedListTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of contains method, of class LinkedList.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        LinkedList<Integer> instance = new LinkedList<>();
        assertFalse("Contains on empty list should return false.",
                    instance.contains(5));

        instance.add(5);
        assertTrue("After adding an element it should be found in the list.",
                   instance.contains(5));

        instance.add(1);
        assertTrue("After adding elements, a previously added element should be found.",
                   instance.contains(5));

        instance.add(2);
        instance.add(3);
        assertTrue("After adding an element it should be found in the list.",
                   instance.contains(1));
        assertTrue("After adding an element it should be found in the list.",
                   instance.contains(2));
        assertTrue("After adding an element it should be found in the list.",
                   instance.contains(3));

        assertFalse("Contains should not return true for non-added elements.",
                    instance.contains(10));
    }

    /**
     * Test of containsAll method, of class LinkedList.
     */
    @Test
    public void testContainsAll() {
        System.out.println("containsAll");
        Collection<?> c = null;
        LinkedList instance = new LinkedList();
        boolean expResult = false;
        boolean result = instance.containsAll(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class LinkedList.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        LinkedList<Integer> instance = new LinkedList<>();
        for (int i = 0; i <= 10; i++) {
            instance.add(i);
        }

        for (int i = 0; i <= 10; i++) {
            assertEquals("Elements should be indexed in the order they are added.",
                         i, instance.get(i).intValue());
        }
        
        try {
            instance.get(-1);
            fail("Get should throw IndexOutOfBoundsException on negative indices.");
        } catch (IndexOutOfBoundsException ioe) { }
        
        try {
            instance.get(instance.size());
            fail("Get should throw IndexOutOfBoundsException on indices >= size.");
        } catch (IndexOutOfBoundsException ioe) { }
    }

    /**
     * Test of size method, of class LinkedList.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        LinkedList<Integer> instance = new LinkedList<>();
        assertEquals("Empty lists should have size 0.",
                     0, instance.size());
        
        for (int i = 0; i < 5; i++) {
            instance.add(i);
        }
        assertEquals("Size should reflect number of added elements.",
                     5, instance.size());
        
        for (int i = 0; i < 5; i++) {
            instance.add(i);
        }
        assertEquals("Size should reflect number of added elements.",
                     10, instance.size());
    }

    /**
     * Test of isEmpty method, of class LinkedList.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        LinkedList instance = new LinkedList();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class LinkedList.
     */
    @Test
    public void testAdd_GenericType() {
        System.out.println("add");
        Object e = null;
        LinkedList instance = new LinkedList();
        boolean expResult = false;
        boolean result = instance.add(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class LinkedList.
     */
    @Test
    public void testAdd_int_GenericType() {
        System.out.println("add");
        int index = 0;
        Object e = null;
        LinkedList instance = new LinkedList();
        instance.add(index, e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAll method, of class LinkedList.
     */
    @Test
    public void testAddAll_Collection() {
        System.out.println("addAll");
        Collection<Integer> c = new ArrayList<>();
        LinkedList<Integer> instance = new LinkedList<>();
        boolean expResult = false;
        boolean result = instance.addAll(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAll method, of class LinkedList.
     */
    @Test
    public void testAddAllIndexedCollection() {
        System.out.println("addAll");
        int index = 0;
        Collection<Integer> c = new ArrayList<>();
        LinkedList<Integer> instance = new LinkedList<>();
        boolean expResult = false;
        boolean result = instance.addAll(index, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class LinkedList.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        int index = 0;
        Object e = null;
        LinkedList instance = new LinkedList();
        Object expResult = null;
        Object result = instance.set(index, e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class LinkedList.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        LinkedList instance = new LinkedList();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class LinkedList.
     */
    @Test
    public void testRemove_int() {
        System.out.println("remove");
        int index = 0;
        LinkedList instance = new LinkedList();
        Object expResult = null;
        Object result = instance.remove(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class LinkedList.
     */
    @Test
    public void testRemove_Object() {
        System.out.println("remove");
        Object o = null;
        LinkedList instance = new LinkedList();
        boolean expResult = false;
        boolean result = instance.remove(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAll method, of class LinkedList.
     */
    @Test
    public void testRemoveAll() {
        System.out.println("removeAll");
        Collection<?> c = null;
        LinkedList instance = new LinkedList();
        boolean expResult = false;
        boolean result = instance.removeAll(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retainAll method, of class LinkedList.
     */
    @Test
    public void testRetainAll() {
        System.out.println("retainAll");
        Collection<?> c = null;
        LinkedList instance = new LinkedList();
        boolean expResult = false;
        boolean result = instance.retainAll(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of indexOf method, of class LinkedList.
     */
    @Test
    public void testIndexOf() {
        System.out.println("indexOf");
        Object o = null;
        LinkedList instance = new LinkedList();
        int expResult = 0;
        int result = instance.indexOf(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lastIndexOf method, of class LinkedList.
     */
    @Test
    public void testLastIndexOf() {
        System.out.println("lastIndexOf");
        Object o = null;
        LinkedList instance = new LinkedList();
        int expResult = 0;
        int result = instance.lastIndexOf(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subList method, of class LinkedList.
     */
    @Test
    public void testSubList() {
        System.out.println("subList");
        int from = 0;
        int to = 0;
        LinkedList instance = new LinkedList();
        List expResult = null;
        List result = instance.subList(from, to);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toArray method, of class LinkedList.
     */
    @Test
    public void testToArray_0args() {
        System.out.println("toArray");
        LinkedList instance = new LinkedList();
        Object[] expResult = null;
        Object[] result = instance.toArray();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toArray method, of class LinkedList.
     */
    @Test
    public void testToArray_GenericType() {
        System.out.println("toArray");
        Integer[] a = null;
        LinkedList instance = new LinkedList();
        Object[] expResult = null;
        Object[] result = instance.toArray(a);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class LinkedList.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        LinkedList instance = new LinkedList();
        Iterator expResult = null;
        Iterator result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listIterator method, of class LinkedList.
     */
    @Test
    public void testListIterator_0args() {
        System.out.println("listIterator");
        LinkedList instance = new LinkedList();
        ListIterator expResult = null;
        ListIterator result = instance.listIterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listIterator method, of class LinkedList.
     */
    @Test
    public void testListIterator_int() {
        System.out.println("listIterator");
        int startIndex = 0;
        LinkedList instance = new LinkedList();
        ListIterator expResult = null;
        ListIterator result = instance.listIterator(startIndex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}