package ttt.Singleton;

import java.util.HashMap;
import java.util.Map;

public class SinGer {

    private static final SinGer instance = new SinGer();

    @SuppressWarnings("rawtypes")
    private Map<Class, Object> mapHolder = new HashMap<Class, Object>();

    private SinGer() {
    }

    @SuppressWarnings("unchecked")
    public static <T> T getInstance(Class<T> classOf) throws InstantiationException, IllegalAccessException {

        synchronized (instance) {
            if (!instance.mapHolder.containsKey(classOf)) {
                T obj = classOf.newInstance();
                instance.mapHolder.put(classOf, obj);
            }
            return (T) instance.mapHolder.get(classOf);
        }
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}

