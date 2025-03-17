package parametric;

public class Bounds {
    
    // Type parameter can have multiple upper bounds.
    public <T extends Object & CharSequence > void methodWithTypeParameter(Iterable<T> it) {
    }

    //Wildcards can have 1 upper bound
    public void methodWithWildCardUpperBound(Iterable<? extends CharSequence> it) {
    }

    //Wildcards can have 1 lower bound
    public void methodWithWildcardLowerBound(Iterable<? super CharSequence> it) {
    }

}
