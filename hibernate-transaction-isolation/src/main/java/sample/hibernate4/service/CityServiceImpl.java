/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.hibernate4.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import sample.hibernate4.domain.City;
import org.springframework.transaction.annotation.*;

@Component("cityService")
@Transactional(isolation=Isolation.REPEATABLE_READ)
class SampleServiceImpl implements SampleService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void request_1() {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		City city = (City) session.get(City.class, 1L);
		System.out.println(city);
	
		session.clear();
		
		city = (City) session.get(City.class, 1L);
		System.out.println(city);
		
		transaction.commit();
		session.close();
		
	}

	@Override
	public void request_2() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		City city = (City) session.get(City.class, 1L);
		System.out.println(city);
	
		city.setName("ShangHai");
		city.setCountry("China");
		
		session.flush();
		
		transaction.commit();
		session.close();
		
	}

}
