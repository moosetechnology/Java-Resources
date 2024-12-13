package parametric;

import java.util.ArrayList;

/*
 * Should we associated invocations with contretizations?
 */

public class ParametricInvocations {
    
    public String invocationWithConcretization() {
        GenericSubclass<String> gs = new GenericSubclass<>();
        return gs.getAT(); // Invocation could be linked to a concretization: T to String.
    }

    public void invocationsWithNoConcreteType() {
        ArrayList<GenericSubclass> list = new ArrayList<>(); // Warning but it works. We do not know the concrete type. 
        list.add(new GenericSubclass<>()); // We never concretize the parameter type of GenericSubclass
        for (GenericSubclass gs : list ) {
            gs.getAT(); // Invocation can't be linked to a concretization.
        }
    }

    public void invocationsWithDifferentConcreteTypes() {
        ArrayList<GenericSubclass> list = new ArrayList<>(); // Warning but it works. We do not know the concrete type. 
        list.add(new GenericSubclass<String>()); // We concretize the generic parameter type of GenericSubclass with two different concrete types
        list.add(new GenericSubclass<Integer>());
        for (GenericSubclass gs : list ) {
            gs.getAT(); // Invocation can't be linked to a concretization.
        }
    }

    public void invocationsWithWildcardAndNoConcreteType() {
        ArrayList<GenericSubclass<?>> list = new ArrayList<>(); // Concrete type is a wildcard
        list.add(new GenericSubclass<>()); // We never concretize the wildcard
        for (GenericSubclass<?> gs : list ) {
            gs.getAT(); // Invocation can be linked to a concretization where the concrete parameter is a wildcard.
        }
    }

    public void invocationsWithWildcardAndDifferenntConcreteTypes() {
        ArrayList<GenericSubclass<?>> list = new ArrayList<>(); // Concrete type is a wildcard
        list.add(new GenericSubclass<String>()); // We concretize the generic parameter type of GenericSubclass with two different concrete types
        list.add(new GenericSubclass<Integer>());
        for (GenericSubclass<?> gs : list ) {
            gs.getAT(); // Invocation could be linked to a concretization where the concrete type is a wildcard.
        }
    }
    
}
