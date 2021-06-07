package factory;

import computadora.Computadora;

public class Factory implements ObjectFactory<Computadora> {

    @Override
    public Computadora getObject(Class c) throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
