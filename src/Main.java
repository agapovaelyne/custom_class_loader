import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ClassLoader customClassLoader = new CustomClassLoader();
        Object uploadedClass = customClassLoader.loadClass("ExternalClassToLoad")
                .getDeclaredConstructor()
                .newInstance();
        Arrays.stream(uploadedClass.getClass().getDeclaredMethods())
                .forEach(
                        method -> {
                            try {
                                method.invoke(uploadedClass);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                );
    }
}
