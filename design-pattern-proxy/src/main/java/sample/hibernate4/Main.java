package sample.hibernate4;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
    	
		IVehicle carProxy = (IVehicle)Proxy.newProxyInstance(
    			IVehicle.class.getClassLoader(),
    			new Class[]{IVehicle.class}, 
    			new ProxyHander(new Car())
    		);
        
		carProxy.start();
		carProxy.stop();
		carProxy.forward();
		carProxy.reverse();
    }
}
