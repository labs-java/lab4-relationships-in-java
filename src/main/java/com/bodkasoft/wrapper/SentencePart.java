package com.bodkasoft.wrapper;

/**
 * The {@code SentencePart} interface represents a generic component of a sentence.
 * <p>
 * In a sentence, different elements such as words, punctuation marks, or other components
 * are often treated as parts of the sentence. The {@code SentencePart} interface serves as a
 * marker for such components, allowing for more general handling of sentence structures
 * in classes like {@link Sentence}.
 * <p>
 * Implementations of this interface could represent various types of sentence elements,
 * such as words ({@link Word}) or punctuation marks ({@link Punctuation}).
 *
 * <p>For example:
 * <ul>
 *   <li>{@link Word}: Represents an individual word in a sentence.</li>
 *   <li>{@link Punctuation}: Represents punctuation marks (e.g., periods, commas) in a sentence.</li>
 * </ul>
 *
 * This interface does not specify any methods, serving primarily as a common type
 * for all sentence parts.
 */
public interface SentencePart {

}
