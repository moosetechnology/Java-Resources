package parametric;
public class ShadowingExamples<T> {

    T x;

    public ShadowingExamples(T x) {
        this.x = x;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public int otherX() {
        int x = 3;
        return x;
    }

    private class InnerClass {

        String x;

        public InnerClass(String x) {
            this.x = x;
        }

        public String getX() {
            return x;
        }
    }

    public String getInnerXString(String s) {
        InnerClass inner = new InnerClass(s);
        return inner.getX();
    }

    private class InnerGenericClass<U> {

        U x;

        public InnerGenericClass(U x) {
            this.x = x;
        }

        public U getX() {
            return x;
        }
    }

    public <U> void printInnerGenericX(U u) {
        InnerGenericClass<U> inner = new InnerGenericClass<>(u);
        System.out.println(inner.getX());
    }

    public T getInnerGenericX(T i) {
        InnerGenericClass<T> inner = new InnerGenericClass<>(i);
        return inner.getX();
    }

    private class InnerGenericShadowingClass<T> { // Inner class parameter type is shadowing the parameter type of the outer class.
        T x;

        public InnerGenericShadowingClass(T x) {
            this.x = x;
        }

        public T getX() {
            return x;
        }
    }

    public <U> void printInnerShadowingGenericX(U u) {
        InnerGenericShadowingClass<U> inner = new InnerGenericShadowingClass<>(u);
        System.out.println(inner.getX());
    }

    public T getInnerShadowingGenericX(T i) {
        InnerGenericShadowingClass<T> inner = new InnerGenericShadowingClass<>(i);
        return inner.getX();
    }

    /* T for inner class is differentFrom T from this class */
    public String getInnerShadowingGenericXAsString(String i) {
        InnerGenericShadowingClass<String> inner = new InnerGenericShadowingClass<>(i);
        return inner.getX();
    }

    public static void main(String[] args) {
        ShadowingExamples<Integer> r = new ShadowingExamples<>(2);
        System.out.println(r.getX());
        System.out.println(r.otherX());
        System.out.println(r.getX());

        System.out.println(r.getInnerXString("Two"));

        r.printInnerGenericX(2);
        System.out.println(r.getInnerGenericX(2));

        r.printInnerShadowingGenericX(3);
        System.out.println(r.getInnerShadowingGenericX(3));
        System.out.println(r.getInnerShadowingGenericXAsString("42"));

    }

}
