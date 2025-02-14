package parametric;

import resources.Building;
import resources.City;

public class Invocations {

    private class House extends Building {
        public House(String newAdress) {
            this.adress = newAdress;
        };
    }

    public void testParametricInvocation() {
        
        GenericMethodsExample ex = new GenericMethodsExample();
        
        House h = new House("here");
        City<House> town = new City<>();
        town.addBuilding(h);

        House result;
        String resultAdress;
       
        result = ex.genericMethodDeclaredTypeAndTypeOfTheParameter(h); // Parametric invocation. The concrete type is House. Inferred by the type of the parameter h and the returned type (the type of result).
        //result = ex.genericMethodDeclaredTypeAndTypeOfTheParameter(new Building()); // INCORRECT parametric invocation: Type mismatch. Concrete type inferred by return type (result) is different from the one inferred from the type of the parameter.

        result = ex.genericMethodDeclaredTypeAndTypeParameterOfTheTypeOfTheParameter(town); // Parametric invocation. The concrete type is House. Inferred by the concrete type parameter of town and from the return type (the type of result).

        resultAdress = ex.genericMethodTypeOfTheParameter(h); // PArametric invocation. The concrete type is House. Inferred by the type of the parameter.

        result = ex.genericMethodDeclaredType("There"); // Parametric invocation. The concrete type is House. Inferred by the return type (result).

        resultAdress = ex.genericMethodTypeOfTheLocalVariable(); // Parametric invocation??. If so, what is the concrete type? B? Building?
        resultAdress = ex.<House>genericMethodTypeOfTheLocalVariable();  // Parametric invocation. Explicitely declaring the concrete type.

        result = ex.genericMethodDeclaredTypeAndTypeOfTheLocalVariable(); // Parametric invocation. The concrete parameter is House. Inferred by the return type.
        result = ex.<House>genericMethodDeclaredTypeAndTypeOfTheLocalVariable(); // Same as above but explicitely but explicitely declaring the concrete type.

        resultAdress = ex.genericMethodCastType();

        resultAdress = ex.genericMethodUnusedTypeParameterNoBound();

        ex.genericMethodCastTypeNoBound(); // 


    }

    
}
