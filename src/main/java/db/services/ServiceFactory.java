package db.services;

import java.lang.reflect.InvocationTargetException;

public class ServiceFactory {

    public static IService create(String serviceClass) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Object o = Class.forName(serviceClass).getDeclaredConstructor().newInstance();
        return (IService) o;
    }
}
