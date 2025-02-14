package parametric;

import java.util.ArrayList;

public class ParametricTypeDeclararion<T> {
    
    private ArrayList<String> attr;     // Parametric type declaration. DeclaredType: ArrayList<String>, a parametric type. Generic type: the one from ArrayList. Concrete type: String.
    private ArrayList<T> genericList;   // Parametric type declaration. DeclaredType: ArrayList<T>, a parametric type.      Generic type: the one from ArrayList. Concrete type: T, the parameter of this class.
    private T genericAttribute;         // NOT a parametric type declaration. DeclaredType: T, the parameter of this class.

public T typedMethod1() { // NOT a parametric type declaration. DeclaredType: T, the parameter of this class.
    return genericAttribute;
}

}
