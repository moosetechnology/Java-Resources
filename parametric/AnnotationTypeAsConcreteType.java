package parametric;

@interface AnnotationTypeAsConcreteType {}
class GenericClass<T> {
    static {
        new GenericClass<AnnotationTypeAsConcreteType>();
    }
}