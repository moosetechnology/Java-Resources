package parametric;

class ThrowTypeParameter<T extends Exception, U> {

    /*
     * The following method throws T, a type parameter that can be thrown because it extends Throwable (via Exception).
     */
    public void throwingMethod() throws T {
    }

    /*
     * The following method is not correct because U is not bounded by Throwable: 
     * 
    public void impossibleThrowingMethod() throws U {
    }
     */

}