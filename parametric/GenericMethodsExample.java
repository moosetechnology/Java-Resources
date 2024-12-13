package parametric;
import java.util.ArrayList;
import java.util.List;

import resources.*;

@SuppressWarnings("unchecked") // We know, unchecked casts are bad. We do not care.
public class GenericMethodsExample {

    /*
     * This method is NOT parametric.
     * Method and parameter happen to have the same declared type.
     * 
     * The type declarations are parametric.
     * The generic parameter type is the generic parameter type of ArrayList.
     * The concrete parameter type is Object.
     */
    public List<Object> testMethod1(List<Object> l) {
        return l;
    }

    /*
     * This method is NOT parametric.
     * 
     * The type declaration of the method is parametric.
     * The generic parameter type is the generic parameter type of ArrayList.
     * The concrete parameter type is Object.
     */
    public List<Object> testMethod2() {
        return new ArrayList<Object>();
    }

    /*
     * This method is NOT parametric.
     * 
     * The type declaration of the parameter is parametric.
     * The generic parameter type is the generic parameter type of ArrayList.
     * The concrete parameter type is Object.
     */
    public Object[] testMethod3(List<Object> l) {
        return l.toArray();
    }

    /*
     * Inner class:
     * - Pas parametric: T continue d'exister
     * - Autre type parametric : T continue d'exister
     * - Type parametric T -> SHADOW
     */
    class InnerDummy<T> {
        /*
         * This method is NOT parametric.
         * 
         * The type declaration of the method is parametric.
         * The generic parameter type is the generic parameter type of ArrayList.
         * The concrete parameter type is the generic parameter type of the class.
         */
        public List<T> testMethod4() {
            return new ArrayList<T>();
        }
    }

    /*
     * This method is generic.
     * The parameter has the same declared type as the method.
     */
    public <T extends Building> T genericMethod1(T someBuilding) {
        return someBuilding;
    }

    /*
     * This method is generic.
     * Its declared type is its parameter type.
     * The declared type of the parameter is a parametric class that is generic and
     * which parameter type is the same as the declared type of the method.
     */
    public <T extends Building> T genericMethod2(City<T> city) {
        return city.getBuildings()[0];
    }

    /*
     * This method is generic.
     * Its declared type is a class.
     * The declared type of the parameter is the paramter type of the method.
     */
    public <B extends Building> String genericMethod3(B building) {
        return building.getAdress();
    }

    /*
     * This method is generic.
     * Its declared type is its parameter type.
     * The declared type of the parameter is a class.
     */
    public <B extends Building> B genericMethod4(String adress) {
        return (B) new Building(adress);
    }

    /*
     * This method is generic.
     * Its parameter type is not used as declared type in the method declaration.
     * It is the declared type of the local variable in the method.
     */
    public <B extends Building> String genericMethod5() {
        B building = (B) new Building("ici");
        return building.getAdress();
    }

    /*
     * This method is generic.
     * Its parameter type is not used as declared type in the method declaration.
     * It is used to cast the result of a subexpression.
     */
    public <B extends Building> String genericMethod6() {
        return ((B) new Building("ici")).getAdress();
    }

    /*
     * This method is generic.
     * Its parameter type is not used.
     */
    public <B extends Building> String genericMethod7() {
        return "Nothing here";
    }
}