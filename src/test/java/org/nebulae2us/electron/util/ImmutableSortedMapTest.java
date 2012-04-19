package org.nebulae2us.electron.util;

import java.text.RuleBasedCollator;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.TreeMap;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 */
public class ImmutableSortedMapTest {
	/**
	 * Run the ImmutableSortedMap() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testImmutableSortedMap_1()
		throws Exception {

		ImmutableSortedMap<?, ?> result = new ImmutableSortedMap<Object, Object>();

		assertNotNull(result);
		assertEquals(0, result.size());
		assertEquals(0, result.entrySet().size());
		assertEquals(0, result.keySet().size());
		assertEquals(0, result.values().size());
		
	}

	/**
	 * Run the ImmutableSortedMap(SortedMap<K,V>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testImmutableSortedMap_2()
		throws Exception {
		SortedMap<Integer, String> map = new TreeMap<Integer, String>();
		map.put(1, "one");
		map.put(3, "three");
		map.put(5, "five");

		ImmutableSortedMap<Integer, String> result = new ImmutableSortedMap<Integer, String>(map);

		assertNotNull(result);
		assertEquals(3, result.size());
		assertEquals(map, result);
		assertEquals(result, map);
	}

	/**
	 * Run the ImmutableSortedMap(Map<K,V>,Comparator<? super K>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testImmutableSortedMap_3()
		throws Exception {
		Map<Object, Object> data = new HashMap();
		Comparator<? extends Object> comparator = new RuleBasedCollator("");

		ImmutableSortedMap result = new ImmutableSortedMap(data, comparator);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.text.ParseException: Build rules empty.
		//       at java.text.RBTableBuilder.build(RBTableBuilder.java:67)
		//       at java.text.RBCollationTables.<init>(RBCollationTables.java:65)
		//       at java.text.RuleBasedCollator.<init>(RuleBasedCollator.java:276)
		//       at java.text.RuleBasedCollator.<init>(RuleBasedCollator.java:257)
		assertNotNull(result);
	}

	/**
	 * Run the ImmutableSortedMap(Map<K,V>,Comparator<? super K>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testImmutableSortedMap_4()
		throws Exception {
		Map<Object, Object> data = new HashMap();
		Comparator<? extends Object> comparator = null;

		ImmutableSortedMap result = new ImmutableSortedMap(data, comparator);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the ImmutableSortedMap(Map<K,V>,Comparator<? super K>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testImmutableSortedMap_5()
		throws Exception {
		Map<Object, Object> data = new HashMap();
		Comparator<? extends Object> comparator = new RuleBasedCollator("");

		ImmutableSortedMap result = new ImmutableSortedMap(data, comparator);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.text.ParseException: Build rules empty.
		//       at java.text.RBTableBuilder.build(RBTableBuilder.java:67)
		//       at java.text.RBCollationTables.<init>(RBCollationTables.java:65)
		//       at java.text.RuleBasedCollator.<init>(RuleBasedCollator.java:276)
		//       at java.text.RuleBasedCollator.<init>(RuleBasedCollator.java:257)
		assertNotNull(result);
	}

	/**
	 * Run the ImmutableSortedMap(Map<K,V>,Comparator<? super K>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testImmutableSortedMap_6()
		throws Exception {
		Map<Object, Object> data = new HashMap();
		Comparator<? extends Object> comparator = null;

		ImmutableSortedMap result = new ImmutableSortedMap(data, comparator);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the ImmutableSortedMap(Map<K,V>,Comparator<? super K>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testImmutableSortedMap_7()
		throws Exception {
		Map<Object, Object> data = new HashMap();
		Comparator<? extends Object> comparator = new RuleBasedCollator("");

		ImmutableSortedMap result = new ImmutableSortedMap(data, comparator);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.text.ParseException: Build rules empty.
		//       at java.text.RBTableBuilder.build(RBTableBuilder.java:67)
		//       at java.text.RBCollationTables.<init>(RBCollationTables.java:65)
		//       at java.text.RuleBasedCollator.<init>(RuleBasedCollator.java:276)
		//       at java.text.RuleBasedCollator.<init>(RuleBasedCollator.java:257)
		assertNotNull(result);
	}

	/**
	 * Run the ImmutableSortedMap(Map<K,V>,Comparator<? super K>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testImmutableSortedMap_8()
		throws Exception {
		Map<Object, Object> data = new HashMap();
		Comparator<? extends Object> comparator = null;

		ImmutableSortedMap result = new ImmutableSortedMap(data, comparator);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the ImmutableSortedMap(ImmutableSortedMap<K,V>,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testImmutableSortedMap_9()
		throws Exception {
		ImmutableSortedMap<Object, Object> cloned = new ImmutableSortedMap();
		boolean descending = false;

		ImmutableSortedMap result = new ImmutableSortedMap(cloned, descending);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the ImmutableSortedMap(ImmutableSortedMap<K,V>,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testImmutableSortedMap_10()
		throws Exception {
		ImmutableSortedMap<Object, Object> cloned = new ImmutableSortedMap();
		boolean descending = true;

		ImmutableSortedMap result = new ImmutableSortedMap(cloned, descending);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the java.util.Map.Entry<Object, Object> ceilingEntry(K) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testCeilingEntry_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		java.util.Map.Entry<Object, Object> result = fixture.ceilingEntry(null);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.nebulae2us.electron.util.ImmutableList.binarySearch(ImmutableList.java:337)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.ceilingIndex(ImmutableSortedSet.java:119)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.ceiling(ImmutableSortedSet.java:132)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.ceilingEntry(ImmutableSortedMap.java:93)
		assertNotNull(result);
	}

	/**
	 * Run the Object ceilingKey(K) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testCeilingKey_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		Object result = fixture.ceilingKey(null);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.nebulae2us.electron.util.ImmutableList.binarySearch(ImmutableList.java:337)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.ceilingIndex(ImmutableSortedSet.java:119)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.ceiling(ImmutableSortedSet.java:132)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.ceilingEntry(ImmutableSortedMap.java:93)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.ceilingKey(ImmutableSortedMap.java:97)
		assertNotNull(result);
	}

	/**
	 * Run the Object ceilingKey(K) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testCeilingKey_2()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		Object result = fixture.ceilingKey(null);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.nebulae2us.electron.util.ImmutableList.binarySearch(ImmutableList.java:337)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.ceilingIndex(ImmutableSortedSet.java:119)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.ceiling(ImmutableSortedSet.java:132)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.ceilingEntry(ImmutableSortedMap.java:93)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.ceilingKey(ImmutableSortedMap.java:97)
		assertNotNull(result);
	}

	/**
	 * Run the Comparator<? extends Object> comparator() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testComparator_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		Comparator<? extends Object> result = fixture.comparator();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Comparator<? extends Object> comparator() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testComparator_2()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		Comparator<? extends Object> result = fixture.comparator();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the boolean containsKey(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testContainsKey_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();
		Object key = null;

		boolean result = fixture.containsKey(key);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean containsKey(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testContainsKey_2()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();
		Object key = null;

		boolean result = fixture.containsKey(key);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean containsValue(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testContainsValue_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();
		Object value = new Object();

		boolean result = fixture.containsValue(value);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean containsValue(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testContainsValue_2()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();
		Object value = new Object();

		boolean result = fixture.containsValue(value);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean containsValue(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testContainsValue_3()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();
		Object value = new Object();

		boolean result = fixture.containsValue(value);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean containsValue(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testContainsValue_4()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();
		Object value = new Object();

		boolean result = fixture.containsValue(value);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean containsValue(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testContainsValue_5()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();
		Object value = new Object();

		boolean result = fixture.containsValue(value);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the NavigableSet<Object> descendingKeySet() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testDescendingKeySet_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		NavigableSet<Object> result = fixture.descendingKeySet();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the ImmutableSortedMap<Object, Object> descendingMap() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testDescendingMap_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		ImmutableSortedMap<Object, Object> result = fixture.descendingMap();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the ImmutableSortedSet<java.util.Map.Entry<Object, Object>> entrySet() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testEntrySet_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		ImmutableSortedSet<java.util.Map.Entry<Object, Object>> result = fixture.entrySet();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the java.util.Map.Entry<Object, Object> firstEntry() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testFirstEntry_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		java.util.Map.Entry<Object, Object> result = fixture.firstEntry();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the java.util.Map.Entry<Object, Object> firstEntry() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testFirstEntry_2()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		java.util.Map.Entry<Object, Object> result = fixture.firstEntry();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Object firstKey() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testFirstKey_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		Object result = fixture.firstKey();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Object firstKey() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testFirstKey_2()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		Object result = fixture.firstKey();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the java.util.Map.Entry<Object, Object> floorEntry(K) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testFloorEntry_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		java.util.Map.Entry<Object, Object> result = fixture.floorEntry(null);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.nebulae2us.electron.util.ImmutableList.binarySearch(ImmutableList.java:337)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.floorIndex(ImmutableSortedSet.java:97)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.floor(ImmutableSortedSet.java:110)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.floorEntry(ImmutableSortedMap.java:84)
		assertNotNull(result);
	}

	/**
	 * Run the Object floorKey(K) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testFloorKey_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		Object result = fixture.floorKey(null);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.nebulae2us.electron.util.ImmutableList.binarySearch(ImmutableList.java:337)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.floorIndex(ImmutableSortedSet.java:97)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.floor(ImmutableSortedSet.java:110)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.floorEntry(ImmutableSortedMap.java:84)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.floorKey(ImmutableSortedMap.java:88)
		assertNotNull(result);
	}

	/**
	 * Run the Object floorKey(K) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testFloorKey_2()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		Object result = fixture.floorKey(null);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.nebulae2us.electron.util.ImmutableList.binarySearch(ImmutableList.java:337)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.floorIndex(ImmutableSortedSet.java:97)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.floor(ImmutableSortedSet.java:110)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.floorEntry(ImmutableSortedMap.java:84)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.floorKey(ImmutableSortedMap.java:88)
		assertNotNull(result);
	}

	/**
	 * Run the Object get(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testGet_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();
		Object key = null;

		Object result = fixture.get(key);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Object get(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testGet_2()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();
		Object key = null;

		Object result = fixture.get(key);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the ImmutableSortedMap<Object, Object> headMap(K) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testHeadMap_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		ImmutableSortedMap<Object, Object> result = fixture.headMap(null);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.nebulae2us.electron.util.ImmutableList.binarySearch(ImmutableList.java:337)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.lowerIndex(ImmutableSortedSet.java:75)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.headMap(ImmutableSortedMap.java:153)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.headMap(ImmutableSortedMap.java:177)
		assertNotNull(result);
	}

	/**
	 * Run the ImmutableSortedMap<Object, Object> headMap(K,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testHeadMap_2()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();
		boolean inclusive = false;

		ImmutableSortedMap<Object, Object> result = fixture.headMap(null, inclusive);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.nebulae2us.electron.util.ImmutableList.binarySearch(ImmutableList.java:337)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.lowerIndex(ImmutableSortedSet.java:75)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.headMap(ImmutableSortedMap.java:153)
		assertNotNull(result);
	}

	/**
	 * Run the ImmutableSortedMap<Object, Object> headMap(K,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testHeadMap_3()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();
		boolean inclusive = true;

		ImmutableSortedMap<Object, Object> result = fixture.headMap(null, inclusive);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.nebulae2us.electron.util.ImmutableList.binarySearch(ImmutableList.java:337)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.floorIndex(ImmutableSortedSet.java:97)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.headMap(ImmutableSortedMap.java:153)
		assertNotNull(result);
	}

	/**
	 * Run the java.util.Map.Entry<Object, Object> higherEntry(K) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testHigherEntry_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		java.util.Map.Entry<Object, Object> result = fixture.higherEntry(null);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.nebulae2us.electron.util.ImmutableList.binarySearch(ImmutableList.java:337)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.higherIndex(ImmutableSortedSet.java:141)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.higher(ImmutableSortedSet.java:154)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.higherEntry(ImmutableSortedMap.java:102)
		assertNotNull(result);
	}

	/**
	 * Run the Object higherKey(K) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testHigherKey_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		Object result = fixture.higherKey(null);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.nebulae2us.electron.util.ImmutableList.binarySearch(ImmutableList.java:337)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.higherIndex(ImmutableSortedSet.java:141)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.higher(ImmutableSortedSet.java:154)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.higherEntry(ImmutableSortedMap.java:102)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.higherKey(ImmutableSortedMap.java:106)
		assertNotNull(result);
	}

	/**
	 * Run the Object higherKey(K) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testHigherKey_2()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		Object result = fixture.higherKey(null);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.nebulae2us.electron.util.ImmutableList.binarySearch(ImmutableList.java:337)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.higherIndex(ImmutableSortedSet.java:141)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.higher(ImmutableSortedSet.java:154)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.higherEntry(ImmutableSortedMap.java:102)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.higherKey(ImmutableSortedMap.java:106)
		assertNotNull(result);
	}

	/**
	 * Run the boolean isEmpty() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testIsEmpty_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		boolean result = fixture.isEmpty();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean isEmpty() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testIsEmpty_2()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		boolean result = fixture.isEmpty();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the NavigableSet<Object> keySet() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testKeySet_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		NavigableSet<Object> result = fixture.keySet();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the java.util.Map.Entry<Object, Object> lastEntry() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testLastEntry_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		java.util.Map.Entry<Object, Object> result = fixture.lastEntry();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the java.util.Map.Entry<Object, Object> lastEntry() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testLastEntry_2()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		java.util.Map.Entry<Object, Object> result = fixture.lastEntry();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Object lastKey() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testLastKey_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		Object result = fixture.lastKey();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Object lastKey() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testLastKey_2()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		Object result = fixture.lastKey();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the java.util.Map.Entry<Object, Object> lowerEntry(K) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testLowerEntry_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		java.util.Map.Entry<Object, Object> result = fixture.lowerEntry(null);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.nebulae2us.electron.util.ImmutableList.binarySearch(ImmutableList.java:337)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.lowerIndex(ImmutableSortedSet.java:75)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.lower(ImmutableSortedSet.java:88)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.lowerEntry(ImmutableSortedMap.java:75)
		assertNotNull(result);
	}

	/**
	 * Run the Object lowerKey(K) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testLowerKey_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		Object result = fixture.lowerKey(null);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.nebulae2us.electron.util.ImmutableList.binarySearch(ImmutableList.java:337)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.lowerIndex(ImmutableSortedSet.java:75)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.lower(ImmutableSortedSet.java:88)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.lowerEntry(ImmutableSortedMap.java:75)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.lowerKey(ImmutableSortedMap.java:79)
		assertNotNull(result);
	}

	/**
	 * Run the Object lowerKey(K) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testLowerKey_2()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		Object result = fixture.lowerKey(null);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.nebulae2us.electron.util.ImmutableList.binarySearch(ImmutableList.java:337)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.lowerIndex(ImmutableSortedSet.java:75)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.lower(ImmutableSortedSet.java:88)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.lowerEntry(ImmutableSortedMap.java:75)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.lowerKey(ImmutableSortedMap.java:79)
		assertNotNull(result);
	}

	/**
	 * Run the NavigableSet<Object> navigableKeySet() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testNavigableKeySet_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		NavigableSet<Object> result = fixture.navigableKeySet();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the java.util.Map.Entry<Object, Object> pollFirstEntry() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test(expected = java.lang.UnsupportedOperationException.class)
	public void testPollFirstEntry_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		java.util.Map.Entry<Object, Object> result = fixture.pollFirstEntry();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the java.util.Map.Entry<Object, Object> pollLastEntry() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test(expected = java.lang.UnsupportedOperationException.class)
	public void testPollLastEntry_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		java.util.Map.Entry<Object, Object> result = fixture.pollLastEntry();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the int size() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testSize_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		int result = fixture.size();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the ImmutableSortedMap<Object, Object> subMap(K,K) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testSubMap_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		ImmutableSortedMap<Object, Object> result = fixture.subMap(null, null);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.nebulae2us.electron.util.ImmutableList.binarySearch(ImmutableList.java:337)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.ceilingIndex(ImmutableSortedSet.java:119)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.subMap(ImmutableSortedMap.java:139)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.subMap(ImmutableSortedMap.java:173)
		assertNotNull(result);
	}

	/**
	 * Run the ImmutableSortedMap<Object, Object> subMap(K,boolean,K,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testSubMap_2()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();
		boolean fromInclusive = true;
		boolean toInclusive = true;

		ImmutableSortedMap<Object, Object> result = fixture.subMap(null, fromInclusive, null, toInclusive);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.nebulae2us.electron.util.ImmutableList.binarySearch(ImmutableList.java:337)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.ceilingIndex(ImmutableSortedSet.java:119)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.subMap(ImmutableSortedMap.java:139)
		assertNotNull(result);
	}

	/**
	 * Run the ImmutableSortedMap<Object, Object> subMap(K,boolean,K,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testSubMap_3()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();
		boolean fromInclusive = true;
		boolean toInclusive = true;

		ImmutableSortedMap<Object, Object> result = fixture.subMap(null, fromInclusive, null, toInclusive);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.nebulae2us.electron.util.ImmutableList.binarySearch(ImmutableList.java:337)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.ceilingIndex(ImmutableSortedSet.java:119)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.subMap(ImmutableSortedMap.java:139)
		assertNotNull(result);
	}

	/**
	 * Run the ImmutableSortedMap<Object, Object> subMap(K,boolean,K,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testSubMap_4()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();
		boolean fromInclusive = true;
		boolean toInclusive = false;

		ImmutableSortedMap<Object, Object> result = fixture.subMap(null, fromInclusive, null, toInclusive);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.nebulae2us.electron.util.ImmutableList.binarySearch(ImmutableList.java:337)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.ceilingIndex(ImmutableSortedSet.java:119)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.subMap(ImmutableSortedMap.java:139)
		assertNotNull(result);
	}

	/**
	 * Run the ImmutableSortedMap<Object, Object> subMap(K,boolean,K,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testSubMap_5()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();
		boolean fromInclusive = false;
		boolean toInclusive = true;

		ImmutableSortedMap<Object, Object> result = fixture.subMap(null, fromInclusive, null, toInclusive);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.nebulae2us.electron.util.ImmutableList.binarySearch(ImmutableList.java:337)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.higherIndex(ImmutableSortedSet.java:141)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.subMap(ImmutableSortedMap.java:139)
		assertNotNull(result);
	}

	/**
	 * Run the ImmutableSortedMap<Object, Object> tailMap(K) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testTailMap_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		ImmutableSortedMap<Object, Object> result = fixture.tailMap(null);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.nebulae2us.electron.util.ImmutableList.binarySearch(ImmutableList.java:337)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.ceilingIndex(ImmutableSortedSet.java:119)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.tailMap(ImmutableSortedMap.java:161)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.tailMap(ImmutableSortedMap.java:181)
		assertNotNull(result);
	}

	/**
	 * Run the ImmutableSortedMap<Object, Object> tailMap(K,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testTailMap_2()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();
		boolean inclusive = false;

		ImmutableSortedMap<Object, Object> result = fixture.tailMap(null, inclusive);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.nebulae2us.electron.util.ImmutableList.binarySearch(ImmutableList.java:337)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.higherIndex(ImmutableSortedSet.java:141)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.tailMap(ImmutableSortedMap.java:161)
		assertNotNull(result);
	}

	/**
	 * Run the ImmutableSortedMap<Object, Object> tailMap(K,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testTailMap_3()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();
		boolean inclusive = true;

		ImmutableSortedMap<Object, Object> result = fixture.tailMap(null, inclusive);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.nebulae2us.electron.util.ImmutableList.binarySearch(ImmutableList.java:337)
		//       at org.nebulae2us.electron.util.ImmutableSortedSet.ceilingIndex(ImmutableSortedSet.java:119)
		//       at org.nebulae2us.electron.util.ImmutableSortedMap.tailMap(ImmutableSortedMap.java:161)
		assertNotNull(result);
	}

	/**
	 * Run the Collection<Object> values() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Test
	public void testValues_1()
		throws Exception {
		ImmutableSortedMap fixture = new ImmutableSortedMap();

		Collection<Object> result = fixture.values();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 4/17/12 11:20 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ImmutableSortedMapTest.class);
	}
}