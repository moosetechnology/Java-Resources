package parametric;

import java.util.List;

public class TypeParameterOwningExamples<T> {

    // Non-parametric entity typing. T is the declared type of these entities.

        // Variable

    T t; // owner of T is TypeParameterOwningExamples.

        // Parameter of a method

    public void nonParametricMethod(T Param) {} // owner of T is TypeParameterOwningExamples.

    public <P> void parametricMethod(P param) {} // owner of P is parametricMethod()

    public <T> void parametricMethodWithSameParameterName(T param) {} // owner of T is parametricMethodWithSameParameterName(). Local T is shadowing T from TypeParameterOwningExamples.

    public <P> void parametricMethodWithTypeParameterNotShadowing(T param) {} // owner of T is TypeParameterOwningExamples. This is just to show that the name is important

        // Method 
    
    public T nonParametricMethod() {return null; } // owner of T is TypeParameterOwningExamples.

// ---------------------------------------------------------------------------------------------

    // Parametric Entity Typing
    
        // Variable

    List<T> myList; // owner of T is TypeParameterOwningExamples.

        // Parameter of a method
    
    public <P> void methodWithParametricParameter(List<P> param) {} // Owner of P is methodWithParametricParameter()

    public void nonParamerticMethodWithParametricParameter(List<T> param) {} // Owner of T is TypeParameterOwningExamples.

        // Method

    public <B> B typedMethod() { // owner of B is returningMethod()
        return (B) "Hello"; // Don't do that
    }

    public <T> T typedMethodWithSameName() { // owner of T is typedMethodWithSameName(). Local T is shadowing T from TypeParameterOwningExamples.
        return (T) "Hello"; // Don't do that
    }


// ---------------------------------------------------------------------------------------------

    // Parametric Inheritance (idem for Implementation)

    private class MySubclass extends SuperGenericClass<T> {} // owner of T is TypeParameterOwningExamples.

    private class MyParametricSubclass<B> extends SuperGenericClass<B> {} // owner of B is MyParametricSubclas.

    private class MySubclassWithSameParameterName<T> extends SuperGenericClass<T> {} // owner of T is MySubclassWithSameParameterName. Local T is shadowing T from TypeParameterOwningExamples.


// ---------------------------------------------------------------------------------------------

    // Parametric Invocation

        // From the type of the method parameter

    public void invokingMethod() {
        parametricMethod("Hello world"); // Parametric invocation. Concrete type is String.
    }

    public <M extends Object> void invokingParametricMethod(M m) {
        parametricMethod(m); // Parametric invocation. Concretization with concrete type = M. owner of M is invokingParametricMethod().
    }

    public void invokingParametricMethod() {
        parametricMethod(t); // Parametric invocation. Concretization with concrete type = T. owner of T is TypeParameterOwningExamples.
    }

        // From the expected return type

    T result = this.typedMethod(); // Parametric invocation. Concretization with concrete type = T. owner of T is TypeParameterOwningExamples.


// ---------------------------------------------------------------------------------------------

    // Method as owner & all parents

    public <K> void owingMethod() {
        final class MethodOwnedClass extends SuperGenericClass<K> { // Owner of K is owningMethod().
            T localvar; // Owner of T is TypeParameterOwningExamples. This means we have to check all parents.
        }
    }

}