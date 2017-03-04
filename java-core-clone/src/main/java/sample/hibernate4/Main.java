package sample.hibernate4;

import sample.hibernate4.car.Car;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
    	
    	Car car = CarBuilder.buidFerrari();
    	
    	Car clonedCar = (Car) car.clone();
    	
    	String result = "使用Cloneable接口: " + (car.getCarMark() == clonedCar.getCarMark() ? "clone是浅拷贝的" : "clone是深拷贝的");
    	System.out.println(result);
    	System.out.println(car.getCarMark().toString());
    	System.out.println(clonedCar.getCarMark().toString());
    	System.out.println(car.getTireSet().toString());
    	System.out.println(clonedCar.getTireSet().toString());
    	
    	System.out.println("-------------------------------------------");
    	
    	Car deepClonedCar = CloneUtils.clone(car);
    	
    	result = "使用序列化方式: " + (car.getCarMark() == deepClonedCar.getCarMark() ? "clone是浅拷贝的" : "clone是深拷贝的");
    	System.out.println(result);
    	System.out.println(car.getCarMark().toString());
    	System.out.println(deepClonedCar.getCarMark().toString());
    	System.out.println(car.getTireSet().toString());
    	System.out.println(deepClonedCar.getTireSet().toString());
    	
    }
}
