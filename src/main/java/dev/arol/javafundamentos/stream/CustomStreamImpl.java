package dev.arol.javafundamentos.stream;

import java.util.*;
import java.util.function.*;
import java.util.stream.IntStream;

/**
 * Implementation of CustomStream interface.
 * Students should complete the TODO sections to make the tests pass.
 */
public class CustomStreamImpl<T> implements CustomStream<T> {
    private final List<T> elements;
    
    public CustomStreamImpl(List<T> elements) {
        this.elements = new ArrayList<>(elements);
    }

    // Helper method for flatMap implementation
    List<T> getElements() {
        return elements;
    }


    @Override
    public List<T> toList() {
        // TODO: Implement toList method
        // Hint: Return a new List containing all elements
        // This is a terminal operation
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public long count() {
        // TODO: Implement count method
        // Hint: Return the number of elements in the stream
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void forEach(Consumer<T> action) {
        // TODO: Implement forEach method
        // Hint: Apply the action to each element
        // This is a terminal operation
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public <R> CustomStream<R> map(Function<T, R> mapper) {
        // TODO: Implement map method
        // Hint: Apply the mapper function to each element
        // Return a new CustomStreamImpl with the mapped elements
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public CustomStream<T> filter(Predicate<T> predicate) {
        // TODO: Implement filter method
        // Hint: Create a new list with elements that satisfy the predicate
        // Return a new CustomStreamImpl with the filtered elements
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public CustomStream<T> limit(long maxSize) {
        // TODO: Implement limit method
        // Hint: Take only the first maxSize elements
        // Hint: You can use an IntStream.range(…)
        // Handle edge cases like maxSize <= 0 or maxSize > elements.size()
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    @Override
    public boolean anyMatch(Predicate<T> predicate) {
        // TODO: Implement anyMatch method
        // Hint: Return true if any element satisfies the predicate
        // Short-circuit evaluation: return true as soon as you find a match
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    @Override
    public boolean allMatch(Predicate<T> predicate) {
        // TODO: Implement allMatch method
        // Hint: Return true if all elements satisfy the predicate
        // Short-circuit evaluation: return false as soon as you find a non-match
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    @Override
    public boolean noneMatch(Predicate<T> predicate) {
        // TODO: Implement noneMatch method
        // Hint: Return true if no elements satisfy the predicate
        // Hint: re-use another method from the same instance
        // Short-circuit evaluation: return false as soon as you find a match
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        // TODO: Implement reduce method without identity
        // Hint: If empty, return Optional.empty()
        // If one element, return Optional.of(element)
        // If multiple elements, apply accumulator function sequentially

        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public T reduce(T identity, BinaryOperator<T> accumulator) {
        // TODO: Implement reduce method with identity
        // Hint: Start with identity value and apply accumulator to each element
        // This always returns a value (never empty)
        throw new UnsupportedOperationException("Not yet implemented");
    }
}