package parametric;

public class ClientForParametrics<T> {

    /*
     * Type declaration: standard.
     * Invocation: standard.
     */
    private ConcreteSubclass cs = new ConcreteSubclass();

    /*
     * Typde declaration: parametric. The generic parameter  type is the generic parameter of GenericSubclass and the concrete parameter type is String.
     * Invocation: The generic parameter type is the generic parameter of GenericSubclass and the concrete parameter type is String (inferred).
     */
    private GenericSubclass<String> gs = new GenericSubclass<>();

    /*
     * Typde declaration: parametric. The generic parameter type is the generic parameter of GenericSubclass and the concrete parameter type is the generic parameter of ClientForParameterics.
     * Invocation: parametric. The generic parameter type is the generic parameter of GenericSubclass and the concrete parameter type is the generic parameter of ClientForParameterics (inferred).
     */
    private GenericSubclass<T> gts = new GenericSubclass<>();


    public ConcreteSubclass getCs() { return cs; } // Method type declaration: standard.
    public void setCs(ConcreteSubclass cs) { this.cs = cs; } // Parameter type declaration: standard.

    public GenericSubclass<String> getGs() { return gs; } // Method type declaration: parametric. The generic parameter type is the generic parameter of GenericSubclass and the concrete parameter type is String.
    public void setGs(GenericSubclass<String> gs) { this.gs = gs; } // Parameter type declaration: parametric. The generic parameter type is the generic parameter of GenericSubclass and the concrete parameter type is String.

    public GenericSubclass<T> getGts() { return gts; } // Method type declaration: parametric. The generic parameter type is the generic parameter of GenericSubclass and the concrete parameter type is the generic parameter of ClientForParameterics.
    public void setGts(GenericSubclass<T> gts) { this.gts = gts; } // Parameter type declaration: parametric. The generic parameter type is the generic parameter of GenericSubclass and the concrete parameter type is the generic parameter of ClientForParameterics.

}