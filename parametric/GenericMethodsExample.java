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
     * This method is parametric.
     * Its declared type is its type parameter.
     * It is also the declared type of the parameter.
     */
    public <T extends Building> T genericMethodDeclaredTypeAndTypeOfTheParameter(T someBuilding) {
        return someBuilding;
    }

    /*
     * This method is parametric.
     * Its declared type is its type parameter.
     * The declared type of the parameter is a parametric class that is generic and
     * which parameter type is the same as the declared type of the method.
     */
    public <T extends Building> T genericMethodDeclaredTypeAndTypeParameterOfTheTypeOfTheParameter(City<T> city) {
        return city.getBuildings().get(0);
    }

    /*
     * This method is parametric.
     * Its declared type is a class.
     * The declared type of the parameter is the type paramter of the method.
     */
    public <B extends Building> String genericMethodTypeOfTheParameter(B building) {
        return building.getAdress();
    }

    /*
     * This method is parametric.
     * Its declared type is its type parameter.
     * The declared type of the parameter is a class.
     */
    public <B extends Building> B genericMethodDeclaredType(String adress) {
        return ((B) new Building(adress));
    }

    /*
     * This method is parametric.
     * Its type parameter is not used as declared type in the method declaration.
     * It is the declared type of the local variable in the method.
     */
    public <B extends Building> String genericMethodTypeOfTheLocalVariable() {
        B building = (B) new Building();
        return building.getAdress();
    }

    /*
     * This method is parametric.
     * Its declared type is its type parameter.
     * It is also the type of the local variable.
     */
    public <B extends Building> B genericMethodDeclaredTypeAndTypeOfTheLocalVariable() {
        B building = (B) new Building("ici");
        return building;
    }

    /*
     * This method is parametric.
     * Its type parameter is not used as declared type in the method declaration.
     * It is used to cast the result of a sub-expression.
     */
    public <B extends Building> String genericMethodCastType() {
        return ((B) new Building("ici")).getAdress();
    }

    public <B extends Building> B genericMethodCastTypeSimple() {
        Building b = new Building();
        System.out.println(b);
        B local = (B) b;
        System.out.println(local);
        return local;
    }

    /*
     * This method is parametric.
     * Its type parameter is not used.
     */
    public <B extends Building> String genericMethodUnusedTypeParameter() {
        return "Nothing here";
    }

    public <B > String genericMethodUnusedTypeParameterNoBound() {
        return "Nothing here";
    }

    public <B > B genericMethodNoBoundDeclaredTypeAndCast(Building b) { 
        return (B) b; // Implicitly, B is a bound for Building??
    }

    public <B > B genericMethodNoBoundDeclaredTypeAndTypeOfTheParameter(B b) { 
        return b; // Why not.
    }

    public <B> void genericMethodCastTypeNoBound() {
        B localVar = (B) new Building();
    }

    public <B extends Building> void genericMethodCastTypeNoBoundVoid() {
        B localVar = (B) new Building();
    }

    /*
     * Error: The method getAdress() is undefined for the type B.
     
    public <B > B genericMethodNoBoundDeclaredTypeAndTypeOfTheParameterUsedInMethod(B b) {
        String address = b.getAdress(); // That's why type parameters are bounded.
        return b; // Why not.
    }
     */

    public static void main(String[] args) {
        final class House extends Building {
            public House(String newAdress) {
                this.adress = newAdress;
            };
        }

        GenericMethodsExample ex = new GenericMethodsExample();
        
        House h = new House("here");
        City<House> town = new City<>();
        town.addBuilding(h);

        House result;
        String resultAdress;
       
        result = ex.genericMethodDeclaredTypeAndTypeOfTheParameter(h); // Parametric invocation. The concrete type is House. Inferred by the type of the parameter h and the returned type (the type of result).
        // result = ex.genericMethodDeclaredTypeAndTypeOfTheParameter(new Building()); // INCORRECT parametric invocation: Type mismatch. Concrete type inferred by return type (result) is different from the one inferred from the type of the parameter.

        result = ex.genericMethodDeclaredTypeAndTypeParameterOfTheTypeOfTheParameter(town); // Parametric invocation. The concrete type is House. Inferred by the concrete type parameter of town and from the return type (the type of result).

        resultAdress = ex.genericMethodTypeOfTheParameter(h); // Parametric invocation. The concrete type is House. Inferred by the type of the parameter.


        resultAdress = ex.genericMethodTypeOfTheLocalVariable(); // Parametric invocation??. If so, what is the concrete type? B? Building?
        resultAdress = ex.<House>genericMethodTypeOfTheLocalVariable();  // Parametric invocation. Explicitely declaring the concrete type.
 
        /* 
         * Incorrect: the build is failing because Building cannot be cast into a parametric type.
         */
        // result = ex.genericMethodDeclaredType("There");
        // result = ex.<House>genericMethodDeclaredType("There");
        Building bresult = ex.<Building>genericMethodDeclaredType("There");
        // result = (ex.<House>genericMethodDeclaredType("There")); // Failure because the returned object is a Building (??)
        ex.<House>genericMethodDeclaredType("There"); // Success (??)
        // result = ex.genericMethodDeclaredTypeAndTypeOfTheLocalVariable();
        // result = ex.<House>genericMethodDeclaredTypeAndTypeOfTheLocalVariable();

        resultAdress = ex.genericMethodCastType();
        resultAdress = ex.<Building>genericMethodCastType();
        resultAdress = ex.<House>genericMethodCastType();
        ex.genericMethodCastTypeSimple(); // This returns a Building for some reason.b 

        resultAdress = ex.genericMethodUnusedTypeParameterNoBound();

        ex.genericMethodCastTypeNoBound(); // This works.
        ex.genericMethodCastTypeNoBoundVoid(); // This works.

    }

}