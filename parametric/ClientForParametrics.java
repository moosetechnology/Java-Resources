package parametric;

import java.util.ArrayList;

public class ClientForParametrics<T> {

    /*
     * Type declaration: standard.
     * Invocation: standard.
     */
    private ConcreteSubclass cs = new ConcreteSubclass();

    /*
     * Typde declaration: parametric. The generic type parameter is the generic parameter of GenericSubclass and the concrete type parameter is String.
     * Invocation: The generic parameter type is the generic parameter of GenericSubclass and the concrete parameter type is String (inferred).
     */
    private GenericSubclass<String> gs = new GenericSubclass<>();

    /*
     * Type declaration: parametric. The generic type parameter is the generic parameter of GenericSubclass and the concrete type parameter is the generic parameter of ClientForParameterics.
     * Invocation: parametric. The generic type parameter is the generic parameter of GenericSubclass and the concrete type parameter is the generic parameter of ClientForParameterics (inferred).
     */
    private GenericSubclass<T> gts = new GenericSubclass<>();

    /*
     * ArrayList<GenericSubclass<String>> is a ParametricType.
     * Its parameter is GenericSubclass<String>, which is also a ParametricType.
     */
    private ArrayList<GenericSubclass<String>> intricateParametricTypesVar = new ArrayList<>();


    public ConcreteSubclass getCs() { return cs; } // Method type declaration: standard.
    public void setCs(ConcreteSubclass cs) { this.cs = cs; } // Parameter type declaration: standard.

    public GenericSubclass<String> getGs() { return gs; } // Method type declaration: parametric. The generic type parameter is the generic parameter of GenericSubclass and the concrete type parameter is String.
    public void setGs(GenericSubclass<String> gs) { this.gs = gs; } // Parameter type declaration: parametric. The generic type parameter is the generic parameter of GenericSubclass and the concrete type parameter is String.

    public GenericSubclass<T> getGts() { return gts; } // Method type declaration: parametric. The generic type parameter is the generic parameter of GenericSubclass and the concrete type parameter is the generic parameter of ClientForParameterics.
    public void setGts(GenericSubclass<T> gts) { this.gts = gts; } // Parameter type declaration: parametric. The generic type parameter is the generic parameter of GenericSubclass and the concrete type parameter is the generic parameter of ClientForParameterics.

}