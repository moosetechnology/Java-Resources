package parametric;

public class ParametricInterfaceAsBound {

    /* 
     * B is the type parameter of the parametric method someMethod.
     * The upper bound of the type parameter B is a parametric interface.
     * Do we need a parametric association for bounds?
     * If we do this, considering the current logic, the upper bound would be ParametricInterface<T>
     * and the parametric bound association would be linked to the concretization of T by String.
     */
    public <B extends ParametricInterface<String>> String someMethod() {
        InnerClass inst = new InnerClass();
        return inst.computeSmthg();
    }

    public <B extends ParametricInterface<String>> String someMethodUsingGenericInnerClass() {
        GenericInnerClass<String> inst = new GenericInnerClass<>();
        return inst.computeSmthg();
    }

    public <B extends ParametricInterface<String>> String someMethodNotUsingTheBound() {
        return null;
    }


    // The following inner classes are here as resources in the methods above
    
    private class InnerClass implements ParametricInterface<String> {

        private String name = "";

        @Override
        public String computeSmthg() {
            return "Hello" + this.name;
        }

        @Override
        public void add(String smthg) {
            this.name = this.name + smthg;
        }
    }

    private class GenericInnerClass<T> implements ParametricInterface<T> {

        private T innerIvar;

        @Override
        public T computeSmthg() {
            return this.innerIvar;
        }

        @Override
        public void add(T smthg) {
            this.innerIvar = smthg;
        }
    }
}
