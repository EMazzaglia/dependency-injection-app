package factory;

public interface ObjectFactory<T> {
    T getObject(Class T) throws Exception;
    Class<?> getObjectType();
}
