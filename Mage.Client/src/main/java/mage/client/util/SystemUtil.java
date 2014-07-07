package mage.client.util;

import java.awt.*;
import java.lang.reflect.Method;

/**
 * @author noxx
 */
public class SystemUtil {

    public static final String OS_NAME = "os.name";
    public static final String MAC_OS_X = "Mac OS X";

    private SystemUtil() {
    }

    public static boolean isMacOSX() {
        return System.getProperty(OS_NAME).contains(MAC_OS_X);
    }

    public static void enableMacOSFullScreenMode(Window window) {
        String className = "com.apple.eawt.FullScreenUtilities";
        String methodName = "setWindowCanFullScreen";

        try {
            Class<?> clazz = Class.forName(className);
            Method method = clazz.getMethod(methodName, Window.class, boolean.class);
            method.invoke(null, window, true);
        } catch (Throwable t) {
            System.err.println("Full screen mode is not supported");
            t.printStackTrace();
        }
    }

    public static void main(String... args) {
        System.out.println(isMacOSX());
    }
}
