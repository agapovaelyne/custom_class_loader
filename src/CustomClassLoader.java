import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CustomClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            Path pathToSearch = Path.of("./".concat(name).concat(".class"));
            byte[] bytes = Files.readAllBytes(pathToSearch);
            return this.defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }
}
