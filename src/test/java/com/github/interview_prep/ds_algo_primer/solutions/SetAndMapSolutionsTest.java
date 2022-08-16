package com.github.interview_prep.ds_algo_primer.solutions;
/*
 *   Title: SetAndMapSolutions
 *
 *   This file contains the test cases for the Set and Map exercises in
 *   the DS & Algos Primer. If you have not already attempted these exercises,
 *   we highly recommend you complete them before reviewing the solutions here.
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class SetAndMapSolutionsTest {

    @Test
    public void hashSetImplementation() {
        SetAndMapSolutions.MyHashSet s = new SetAndMapSolutions.MyHashSet(10);
        s.add("abc");
        s.add("bcd");
        assertEquals(true, s.contains("abc"));
        s.remove("abc");
        assertEquals(false, s.contains("abc"));
        s.add("bcd");
        s.add("cde");
        assertIterableEquals(Arrays.asList("cde", "bcd"), s.toList());
        s.resize(100);
        assertIterableEquals(Arrays.asList("cde", "bcd"), s.toList());
    }

    @Test
    public void hashMapImplementation() {
        SetAndMapSolutions.MyHashMap m = new SetAndMapSolutions.MyHashMap(10);
        m.put("abc", "bcd");
        m.put("123", "234");
        m.put("xyz", "abc");
        m.put("abc", "xyz");
        assertEquals(true, m.containsKey("abc"));
        assertEquals("xyz", m.get("abc"));
        m.remove("abc");
        assertEquals(false, m.containsKey("abc"));
        // System.out.println(m.get("abc"));
        assertEquals(null, m.get("abc"));
        m.resize(100);
        assertEquals(true, m.containsKey("xyz"));
        assertEquals("abc", m.get("xyz"));
    }

    @Test
    public void flattenDictionary() {
        Map<String, Object> expected =
                new HashMap<String, Object>() {
                    {
                        put("key1", "1");
                        put("key2.b", "3");
                        put("key2.c.d", "3");
                        put("key2.a", "2");
                        put("key2.c.e", "1");
                    }
                };

        // Map<String, Object> expected = Map.of(
        //     "key1", "1",
        //     "key2.b", "3",
        //     "key2.c.d", "3",
        //     "key2.a", "2",
        //     "key2.c.e ", "1"
        // );

        HashMap<String, Object> dict = new HashMap<>();
        dict.put("key1", "1");
        HashMap<String, Object> c = new HashMap<String, Object>();
        c.put("d", "3");
        c.put("e", "1");
        HashMap<String, Object> key2 = new HashMap<String, Object>();
        key2.put("a", "2");
        key2.put("b", "3");
        key2.put("c", c);
        dict.put("key2", key2);

        Map<String, Object> actual = SetAndMapSolutions.flattenDictionary(dict);

        expected =
                expected.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .collect(
                                Collectors.toMap(
                                        Map.Entry::getKey,
                                        Map.Entry::getValue,
                                        (oldValue, newValue) -> oldValue,
                                        LinkedHashMap::new));

        actual =
                actual.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .collect(
                                Collectors.toMap(
                                        Map.Entry::getKey,
                                        Map.Entry::getValue,
                                        (oldValue, newValue) -> oldValue,
                                        LinkedHashMap::new));

        assertEquals(expected, actual);
    }
}
