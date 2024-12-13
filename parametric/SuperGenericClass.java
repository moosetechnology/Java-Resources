package parametric;

import java.util.ArrayList;

/* 
 * This class is generic.
 * Would any inheritance would be a parametric inheritance or only if we concretize the parameter?
 */
public class SuperGenericClass<T> {

    public SuperGenericClass() {
    }

    public T getAT() {
        ArrayList<T> list = new ArrayList<>();
        return list.get(0);
    }

}