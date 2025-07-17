package dev.arol.javafundamentos.stream;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * Unit tests for CustomStream implementation.
 * Run these tests in order to guide your implementation.
 * Each test focuses on a specific method and provides clear expectations.
 */
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class CustomStreamTest {
    
    private List<Integer> numbers;
    private List<String> words;
    private List<String> fruits;
    
    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        words = Arrays.asList("hello", "world", "java", "stream", "functional", "programming");
        fruits = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
    }
    
    // Test 1: Basic stream creation and toList (implement toList first)
    @Test
    void test01_toList_shouldReturnAllElements() {
        List<Integer> result = CustomStream.of(numbers).toList();
        assertEquals(numbers, result);
        
        List<String> resultWords = CustomStream.of(words).toList();
        assertEquals(words, resultWords);
    }
    
    // Test 2: count method
    @Test
    void test02_count_shouldReturnNumberOfElements() {
        assertEquals(10, CustomStream.of(numbers).count());
        assertEquals(6, CustomStream.of(words).count());
        assertEquals(0, CustomStream.of(Collections.emptyList()).count());
    }
    
    // Test 3: forEach method
    @Test
    void test03_forEach_shouldApplyActionToAllElements() {
        List<Integer> collected = new ArrayList<>();
        CustomStream.of(numbers).forEach(collected::add);
        assertEquals(numbers, collected);
        
        StringBuilder sb = new StringBuilder();
        CustomStream.of(Arrays.asList("a", "b", "c")).forEach(sb::append);
        assertEquals("abc", sb.toString());
    }
    
    // Test 4: map method
    @Test
    void test04_map_shouldTransformElements() {
        List<Integer> squared = CustomStream.of(Arrays.asList(1, 2, 3, 4))
            .map(n -> n * n)
            .toList();
        assertEquals(Arrays.asList(1, 4, 9, 16), squared);
        
        List<String> upperCase = CustomStream.of(Arrays.asList("hello", "world"))
            .map(String::toUpperCase)
            .toList();
        assertEquals(Arrays.asList("HELLO", "WORLD"), upperCase);
        
        List<Integer> lengths = CustomStream.of(words)
            .map(String::length)
            .toList();
        assertEquals(Arrays.asList(5, 5, 4, 6, 10, 11), lengths);
    }

    // Test 5: filter method
    @Test
    void test05_filter_shouldKeepElementsMatchingPredicate() {
        List<Integer> evens = CustomStream.of(numbers)
                .filter(n -> n % 2 == 0)
                .toList();
        assertEquals(Arrays.asList(2, 4, 6, 8, 10), evens);

        List<String> longWords = CustomStream.of(words)
                .filter(w -> w.length() > 7)
                .toList();
        assertEquals(Arrays.asList("functional", "programming"), longWords);
    }
    
    // Test 6: limit method
    @Test
    void test06_limit_shouldTakeFirstNElements() {
        List<Integer> first3 = CustomStream.of(numbers)
            .limit(3)
            .toList();
        assertEquals(Arrays.asList(1, 2, 3), first3);
        
        List<String> first2Words = CustomStream.of(words)
            .limit(2)
            .toList();
        assertEquals(Arrays.asList("hello", "world"), first2Words);
        
        // Test edge cases
        List<Integer> limitZero = CustomStream.of(numbers).limit(0).toList();
        assertTrue(limitZero.isEmpty());
        
        List<Integer> limitMore = CustomStream.of(numbers).limit(20).toList();
        assertEquals(numbers, limitMore);
    }
    
    // Test 09: anyMatch method
    @Test
    void test09_anyMatch_shouldReturnTrueIfAnyElementMatches() {
        assertTrue(CustomStream.of(numbers).anyMatch(n -> n > 5));
        assertTrue(CustomStream.of(words).anyMatch(w -> w.startsWith("h")));
        
        assertFalse(CustomStream.of(numbers).anyMatch(n -> n > 10));
        assertFalse(CustomStream.of(words).anyMatch(w -> w.startsWith("z")));
        
        assertFalse(CustomStream.of(Collections.<Integer>emptyList()).anyMatch(n -> true));
    }
    
    // Test 10: allMatch method
    @Test
    void test10_allMatch_shouldReturnTrueIfAllElementsMatch() {
        assertTrue(CustomStream.of(numbers).allMatch(n -> n > 0));
        assertTrue(CustomStream.of(words).allMatch(w -> w.length() > 0));
        
        assertFalse(CustomStream.of(numbers).allMatch(n -> n < 5));
        assertFalse(CustomStream.of(words).allMatch(w -> w.startsWith("h")));
        
        assertTrue(CustomStream.of(Collections.<Integer>emptyList()).allMatch(n -> false));
    }
    
    // Test 11: noneMatch method
    @Test
    void test11_noneMatch_shouldReturnTrueIfNoElementsMatch() {
        assertTrue(CustomStream.of(numbers).noneMatch(n -> n > 10));
        assertTrue(CustomStream.of(words).noneMatch(w -> w.startsWith("z")));
        
        assertFalse(CustomStream.of(numbers).noneMatch(n -> n > 5));
        assertFalse(CustomStream.of(words).noneMatch(w -> w.startsWith("h")));
        
        assertTrue(CustomStream.of(Collections.<Integer>emptyList()).noneMatch(n -> true));
    }
    
    // Test 12: reduce without identity
    @Test
    void test12_reduce_shouldCombineElementsWithoutIdentity() {
        Optional<Integer> sum = CustomStream.of(Arrays.asList(1, 2, 3, 4))
            .reduce((accum, element) -> accum + element);
        assertTrue(sum.isPresent());
        assertEquals(10, sum.get());
        
        Optional<String> concat = CustomStream.of(Arrays.asList("a", "b", "c"))
            .reduce((a, b) -> a + b);
        assertTrue(concat.isPresent());
        assertEquals("abc", concat.get());
        
        Optional<Integer> empty = CustomStream.of(Collections.<Integer>emptyList())
            .reduce((a, b) -> a + b);
        assertFalse(empty.isPresent());
        
        Optional<Integer> single = CustomStream.of(Arrays.asList(42))
            .reduce((a, b) -> a + b);
        assertTrue(single.isPresent());
        assertEquals(42, single.get());
    }
    
    // Test 13: reduce with identity
    @Test
    void test13_reduce_shouldCombineElementsWithIdentity() {
        int sum = CustomStream.of(Arrays.asList(1, 2, 3, 4))
                .reduce(0, (a, b) -> a + b);
        assertEquals(10, sum);
        
        String concat = CustomStream.of(Arrays.asList("a", "b", "c"))
            .reduce("", (a, b) -> a + b);
        assertEquals("abc", concat);
        
        int emptySum = CustomStream.of(Collections.<Integer>emptyList())
            .reduce(100, (a, b) -> a + b);
        assertEquals(100, emptySum);
    }
    
    // Test 14: Chaining operations
    @Test
    void test14_chaining_shouldCombineMultipleOperations() {
        List<Integer> result = CustomStream.of(numbers)
            .filter(n -> n % 2 == 0)    // Keep even numbers: 2, 4, 6, 8, 10
            .map(n -> n * n)            // Square them: 4, 16, 36, 64, 100
            .limit(3)                   // Take first 3: 4, 16, 36
            .toList();
        
        assertEquals(Arrays.asList(4, 16, 36), result);
        
        List<String> wordResult = CustomStream.of(words)
            .filter(w -> w.length() > 5)    // Keep words longer than 4 chars
            .map(String::toUpperCase)       // Convert to uppercase
            .toList();
        
        assertEquals(Arrays.asList("STREAM", "FUNCTIONAL", "PROGRAMMING"), wordResult);
    }
}