package parametric;
/* 
 * This class is generic and inherits from a generic class
 * This is a parametric inheritance.
 * The concrete parameter type is T. It is concrete in that it is resolved by the inheritance.
 * The generic parameter is the generic parameter of the superclass.
 * 
 * The subclass also has a generic parameter that is not involved in the inherirance.
 */
public class GenericSubclass<T> extends SuperGenericClass<T> {

    public GenericSubclass() {}
    
}
