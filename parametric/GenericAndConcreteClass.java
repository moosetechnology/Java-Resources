package parametric;

/*
 * This class is generic.
 * The inheritance is parametric, linked to 2 concretizations.
 * First concretization: from K (from TwiceGenericClass) to String.
 * Second concretization from V (from TwiceGenericClass) to V (the generic parameter type from GenericAndConcreteClass).
 */
public class GenericAndConcreteClass<V> extends TwiceGenericClass<String,V> {
    
}
