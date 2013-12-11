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
        Collection<Integer> c = new ArrayList<>();
        LinkedList<Integer> instance = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            instance.add(i);
            c.add(i * 2);
        }
        assertFalse("Contains all should not return true, when only half the elements are in the list.",
                    instance.containsAll(c));

        for (int i = 10; i < 20; i++) {
            instance.add(i);
        }
        assertTrue("Contains all should return true, when all elements are in the list.",
                   instance.containsAll(c));
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
        } catch (IndexOutOfBoundsException ioe) {
        }

        try {
            instance.get(instance.size());
            fail("Get should throw IndexOutOfBoundsException on indices >= size.");
        } catch (IndexOutOfBoundsException ioe) {
        }
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
        LinkedList<Integer> instance = new LinkedList<>();
        assertTrue("isEmpty should return true for an empty list.",
                   instance.isEmpty());

        instance.add(1);
        assertFalse("isEmpty should return false for a non-empty list.",
                    instance.isEmpty());
    }

    /**
     * Test of add method, of class LinkedList.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        LinkedList<Integer> instance = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            assertTrue("Adding an element should return true.", instance.add(i));
            assertEquals("Size should be equal to the number of items added.",
                         i + 1, instance.size());
            assertTrue("Elements that are added, should be found in the list.",
                       instance.contains(i));
            assertEquals("The last item in the list should be the previously added item.",
                         Integer.valueOf(i), instance.get(i));
        }
        
        try {
            instance.add(null);
            fail("Null elements should not be allowed to be added.");
        } catch (NullPointerException npe) {}
        
    }

    /**
     * Test of add method, of class LinkedList.
     */
    @Test
    public void testAddIndexed() {
        System.out.println("add indexed");
        LinkedList<Integer> instance = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            instance.add(i + 5);
        }
        
        for (int i = 0; i < 5; i++) {
            assertEquals("The position of 5 should move forward in the list as items are added before it.",
                         Integer.valueOf(5), instance.get(i));
            instance.add(i, i);
            assertEquals("An item added to a specific index, should be found at that position.",
                         Integer.valueOf(i), instance.get(i));
            assertEquals("The size should increase by one every time an item is added.",
                         i + 5, instance.size());
        }
    }

    /**
     * Test of addAll method, of class LinkedList.
     */
    @Test
    public void testAddAll() {
        System.out.println("addAll");
        Collection<Integer> c = new ArrayList<>();
        LinkedList<Integer> instance = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            c.add(i);
        }
        
        instance.addAll(c);
        assertEquals("After adding a collection to the list, they should have the same size.",
                     c.size(), instance.size());
        assertTrue("The list should contain all items from the collection after adding them.",
                   instance.containsAll(c));
    }

    /**
     * Test of addAll method, of class LinkedList.
     */
    @Test
    public void testAddAllIndexed() {
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
        LinkedList<Integer> instance = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            instance.add(i);
            assertEquals("Exchanging an item should return the item previously located at that position",
                         Integer.valueOf(i), instance.set(i, i + 5));
            assertEquals("If an element has been exchanged at an index, the new element shoul be located there.",
                         Integer.valueOf(i + 5), instance.get(i));
        }
    }

    /**
     * Test of clear method, of class LinkedList.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        LinkedList<Integer> instance = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            instance.add(i);
        }
        
        assertEquals("", 5, instance.size());
        instance.clear();
        assertEquals("", 0, instance.size());
        try {
            instance.get(0);
            fail("There should not be a first item in the list after clearing it.");
        } catch (IndexOutOfBoundsException ioobe) {
        }
    }

    /**
     * Test of remove method, of class LinkedList.
     */
    @Test
    public void testRemoveIndexed() {
        System.out.println("remove");
        LinkedList<Float> instance = new LinkedList<>();
        for (float i = 0f; i < 10f; i++) {
            instance.add(i);
        }

        int sizeBefore = instance.size();
        assertTrue("3f should be in the list",
                   instance.contains(3f));
        assertEquals("Index of 4f should be 4 before removing 3f.",
                     4, instance.indexOf(4f));
        instance.remove(3);
        assertEquals("The size of a list should change after removing an object",
                     sizeBefore - 1, instance.size());
        assertFalse("An object should not exist in a list after removal.",
                    instance.contains(3.0f));
        assertEquals("The index of 4f should be 3 after removing the third item.",
                     3, instance.indexOf(4f));
    }

    /**
     * Test of remove method, of class LinkedList.
     */
    @Test
    public void testRemoveObject() {
        System.out.println("remove");
        LinkedList<Float> instance = new LinkedList<>();
        for (float i = 0.0f; i < 10f; i++) {
            instance.add(i);
        }

        int sizeBefore = instance.size();
        assertTrue("Removing an object that exists in a list, should result in a change.",
                   instance.remove(3.0f));
        assertFalse("Removing the same object twice, should not result in a change.",
                    instance.remove(3.0f));
        assertEquals("The size of a list should change after removing an object",
                     sizeBefore - 1, instance.size());
        assertFalse("An object should not exist in a list after removal.",
                    instance.contains(3.0f));
    }

    /**
     * Test of removeAll method, of class LinkedList.
     */
    @Test
    public void testRemoveAll() {
        System.out.println("removeAll");
        Collection<Integer> c = new ArrayList<>();
        LinkedList<Integer> instance = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            instance.add(i % 5);
            if (i % 2 == 0) {
                c.add(i);
            }
        }
        
        assertTrue("Removing all items of a collection from a list, should result in a change if any exist.",
                   instance.removeAll(c));
        assertFalse("Removing the same items twice, should not result in a change.",
                    instance.removeAll(c));
        for (int i : c) {
            assertFalse("No items from the collection that was removed from the list, should be in the list.",
                        instance.contains(i));
        }
    }

    /**
     * Test of retainAll method, of class LinkedList.
     */
    @Test
    public void testRetainAll() {
        System.out.println("retainAll");
        Collection<Integer> c = new ArrayList<>();
        LinkedList<Integer> instance = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            instance.add(i % 5);
            if (i < 5 && i % 2 == 0) {
                c.add(i);
            }
        }
        
        assertTrue("If a list contains other items than those retained, retaining should lead to a change.",
                   instance.retainAll(c));
        assertFalse("If a list only contains the items of a collection being retained, no change should occur.",
                    instance.retainAll(c));
        for (int i : c) {
            assertTrue("Unless the collection being retained contains items not originally in the list, all those items should be in the list.",
                       instance.contains(i));
            assertFalse("No other items should be in the list after retaining a collection.",
                        instance.contains(i - 1));
        }
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