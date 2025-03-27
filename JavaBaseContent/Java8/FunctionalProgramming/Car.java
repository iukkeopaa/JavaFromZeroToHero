

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
/**
 * ��������������
 * @author fengbin
 *
 */
public class Car {
	public static Car create( final Supplier< Car > supplier ) {
        return supplier.get();
    }              
 
    public static void collide( final Car car ) {
        System.out.println( "Collided " + car.toString() );
    }
 
    public void follow( final Car another ) {
        System.out.println( "Following the " + another.toString() );
    }
 
    public void repair() {
        System.out.println( "Repaired " + this.toString() );
    }
    
    public static void main(String[] args) {
    	/**
    	 * ��һ�ַ��������ǹ��췽�����ã��﷨�ǣ�Class::new ��
    	 * ���ڷ�����˵�﷨�ǣ�Class<T >::new����ע�⹹�췽��û�в���:
    	 */
    	final Car car = Car.create( Car::new );
    	final List< Car > cars = Arrays.asList( car );
    	
    	/**
    	 * �ڶ��ַ��������Ǿ�̬�������ã�
    	 * �﷨�ǣ�Class::static_method��ע�������̬����ֻ֧��һ������ΪCar�Ĳ�����
    	 */
    	cars.forEach(Car::collide);
    	
    	/**
    	 * �����ַ�����������ʵ���ķ������ã��﷨�ǣ�Class::method��ע�ⷽ��û�в�����
    	 */
    	cars.forEach(Car::repair);
    	
    	/**
    	 * ���һ�ַ�������������������ķ�����
    	 * �﷨�ǣ�instance::method����ע��ֻ����Car���͵�һ��������
    	 */
    	final Car police=Car.create(Car::new);
    	cars.forEach(police::follow);
	}
}