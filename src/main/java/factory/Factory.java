package factory;

import java.lang.reflect.Field;
import java.io.File;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Factory {

    static Boolean firstTime = true;
    static String packageToScan;

    public static void resetFactory(){
        firstTime = true;
    }

    // Comentarios realizados para el caso: Factory.getObject(FordFiesta.class);
    public static <T> T getObject(Class<?> c) throws Exception {

        if(firstTime){
            packageToScan = getPackageToScan();
        }

        firstTime = false;

        // Tira error si el paquete que tiene comp scan no existe.
        if(noCoincideConNingunPackage(packageToScan)){
            throw new Exception("El paquete especificado no existe en el proyecto.");
        }
        List<Class<?>> clasesDelPaquete = getClassesInPackage(packageToScan);

        // Generamos una nueva instancia de FordFiesta.class
        Object newObject = c.newInstance();

        // Iteramos sobre todos los campos de la clase FordFiesta
        for (Field field : c.getDeclaredFields()) {
            //agarramos solo los campos que tengasn la notacion de Injected
            if (field.isAnnotationPresent(Injected.class)) {

                // Field = motor
                // Obtenemos la anotación Injected del campo motor
                Injected injected = field.getAnnotation(Injected.class);

                // EN EL CASO DE QUE NO TENGO IMPLE ESPECIFICADA.
                Boolean noTieneImplementacionEspecificada = injected.implementation().getTypeName().equals(new Object().getClass().getTypeName());

                Class<?> classToInject =  noTieneImplementacionEspecificada ? buscarImplementacionValida(field,clasesDelPaquete) : injected.implementation();

                // Ponemos el campo accesible para poder modificarlo. field = motor
                field.setAccessible(true);

                //Verificamos si existe un campo q implemente una interface tipo Collection o una classe que implemente la misma
                if (Collection.class.isAssignableFrom(field.getType())){
                    Collection myArray = null;

                    //verifico se el campo es una interface
                    if (field.getType().isInterface()) {
                        myArray = new ArrayList();
                        // en caso de que sea interface
                        for (int j = 0; j < injected.count(); j++) {
                            myArray.add(getObject(classToInject));
                        }
                    } else {
                        myArray = (Collection) field.getType().newInstance();
                        for (int j = 0; j < injected.count(); j++) {
                            myArray.add(getObject(classToInject));
                        }
                    }
                    field.set(newObject, myArray);
                }else{
                    // Ahora seteamos el campo motor de nuestra instancia de FordFiest Con la instancia de Motor que creamo
                    // Es decir: Simulamos un newObject.motor = objToInject (new ToyotaMotor)
                    field.set(newObject, getObject(classToInject));
                }
                // Ponemos el campo en privado para no dejarlo publico.
                field.setAccessible(false);
            }
        }
        // Retornamos el objeto FordFiesta con un motor Toyota
        return (T) newObject;
    }

    private static Class<?> buscarImplementacionValida(Field field, List<Class<?>> clasesDelPaquete) throws Exception {
        List<Class<?>> implementaciones = clasesDelPaquete
                .stream()
                .filter( clase -> field.getType().isAssignableFrom(clase) && !clase.isInterface()).collect(Collectors.toList());
        if (implementaciones.size() != 1) {
            throw new Exception("Hay mas de una o ninguna implementacion valida para " + field.getName());
        }
        return implementaciones.get(0);
    }

    private static boolean noCoincideConNingunPackage(String packageToScan) {
        return Package.getPackage(packageToScan) == null;
    }

    private static String getPackageToScan() throws ClassNotFoundException {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        int ultimoElemento = elements.length - 1;
        String packageClass = elements[ultimoElemento].getClassName();
        ComponentScan componentScan = Class.forName(packageClass).getAnnotation(ComponentScan.class);
        return componentScan.value();
    }

    public static final List<Class<?>> getClassesInPackage(String packageName) {
        String path = packageName.replaceAll("\\.", File.separator);
        List<Class<?>> classes = new ArrayList<>();
        String[] classPathEntries = System.getProperty("java.class.path").split(
                System.getProperty("path.separator")
        );

        String name;
        for (String classpathEntry : classPathEntries) {
            try {
                File base = new File(classpathEntry + File.separatorChar + path);
                for (File file : base.listFiles()) {
                    name = file.getName();
                    if (name.endsWith(".class")) {
                        name = name.substring(0, name.length() - 6);
                        classes.add(Class.forName(packageName + "." + name));
                    }
                }
            } catch (Exception ex) {
                // Silence is gold
            }
        }
        return classes;
    }
}
