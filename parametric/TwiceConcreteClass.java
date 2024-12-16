package parametric;

/* 
 * This class is concrete.
 * The inheritance is parametric, linked to 2 concretizations.
 * First conretization:  from K (from TwiceGenericClass) to String.
 * Second concretization: from V (from TwiceGenericClass) to Integer.
 */
public class TwiceConcreteClass extends TwiceGenericClass<String,Integer> {
    
}
