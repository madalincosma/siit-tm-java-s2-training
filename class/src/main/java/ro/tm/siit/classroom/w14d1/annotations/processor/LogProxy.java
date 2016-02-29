package ro.tm.siit.classroom.w14d1.annotations.processor;

import java.lang.reflect.Proxy;

public class LogProxy {

	public static Object getNewProxy(Object proxied, Class<?> interfaze) {
		Object proxy = Proxy.newProxyInstance(LogInvocationHandler.class.getClassLoader(), new Class[] { interfaze },
				new LogInvocationHandler(proxied));
		return proxy;
	}

}
