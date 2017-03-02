package sample.hibernate4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class ProxyHander implements InvocationHandler {
    private Object proxiedObject;

    public ProxyHander(Object proxiedObject) {
        this.proxiedObject = proxiedObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    	
    	//代理的逻辑，记录时间
    	System.out.println("Car " + method.getName() + " at " + new Date());
    	
    	//调用被代理类的方法
    	return method.invoke(proxiedObject, args);
    	
    }
}
