import java.lang.reflect.Method;

/**
 *
 * @author ouyangyufeng
 * @date 2019/4/12
 */
public class StartServer {

    public static void main(String[] args) throws Exception {

        Class clazz = JavaUtilsApplicationTests.class;
        Method methodMain = clazz.getMethod("main", String[].class);
        methodMain.invoke(null, (Object)new String[]{});

    }
}
