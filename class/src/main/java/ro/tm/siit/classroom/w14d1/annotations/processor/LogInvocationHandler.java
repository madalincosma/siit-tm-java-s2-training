package ro.tm.siit.classroom.w14d1.annotations.processor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import ro.tm.siit.classroom.w14d1.annotations.Log;

public class LogInvocationHandler implements InvocationHandler {
	private Object proxied;

	public LogInvocationHandler(Object proxied) {
		this.proxied = proxied;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Method m = proxied.getClass().getMethod(method.getName(), method.getParameterTypes());
		if (m.isAnnotationPresent(Log.class)) {
			System.out.println(m.getAnnotation(Log.class).text());
		}
		return method.invoke(proxied, args);
	}
}
