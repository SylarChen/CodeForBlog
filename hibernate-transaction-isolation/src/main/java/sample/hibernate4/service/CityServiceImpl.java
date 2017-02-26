package sample.hibernate4.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import sample.hibernate4.domain.City;

@Component("cityService")
@Transactional(isolation=Isolation.READ_UNCOMMITTED)
class SampleServiceImpl implements SampleService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void request_1() {
		
		Session session = sessionFactory.getCurrentSession();
		
		City city = (City) session.get(City.class, 1L);
		System.out.println(city);
	
		session.clear();
		
		city = (City) session.get(City.class, 1L);
		System.out.println(city);
		
	}

	@Override
	public void request_2() {
		Session session = sessionFactory.getCurrentSession();
		
		City city = (City) session.get(City.class, 1L);
		city.setName("ShangHai");
		city.setCountry("China");
		
		session.flush();
		System.out.println(city);
	}
	
	@Override
	public void request_3() {
		
		Session session = sessionFactory.getCurrentSession();
		
//		; .createCriteria(City.class).list();
		List<City> cityList = session.createQuery("select city from City city where id > 2").list();
		
		System.out.println("=========First Time=========");
		for(City city : cityList){
			System.out.println(city.toString());
		}
		System.out.println("============================");
		
		session.clear();
		
//		cityList = session.createCriteria(City.class).list();
		
		cityList = session.createQuery("select city from City city where id > 2").list();
		
		City c = (City) session.get(City.class, 5L);
		
		System.out.println("=========Second Time=========");
		for(City city : cityList){
			System.out.println(city.toString());
		}
		System.out.println("============================");
		
	}
	
	@Override
	public void request_4() {
		
		Session session = sessionFactory.getCurrentSession();
		
		City city = new City("BeiJing", "China");
		
		session.save(city);
		
	}
	
}
