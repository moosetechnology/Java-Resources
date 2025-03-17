package parametric;
import java.util.ArrayList;

/*
 * This class is generic.
 * The interface implementation is parametric.
 * The generic parameter type is the generic parameter type of the interface
 * The concrete parameter type is the generic parameter type of the class
 */
public class ClassUsingInteface<T> implements ParametricInterface<T> {

    /*
     * This type declaration is parametric.
     * The declared type is the parametric class ArrayList.
     * The generic parameter type is the generit parameter type of ArrayList.
     * The concrete parameter type is the generic parameter type of ClassUsingInterface.
     * 
     * The invocation of the ArrayList() constructor is also parametric (inferred) with the same generic and concrete parameter types.
     */
    ArrayList<T> list = new ArrayList<>();


    /*
    * The type declaration of this method is not parametric but the declared type is the generic parameter type of ClassUsingInterface. 
    */
    @Override
    public T computeSmthg() {
        return list.get(0);
    }


    /*
    * The type declaration of this method is not parametric but the declared type is the generic parameter type of ClassUsingInterface.
    */
    @Override
    public void add(T smthg) {
        list.add(smthg);
    }
}