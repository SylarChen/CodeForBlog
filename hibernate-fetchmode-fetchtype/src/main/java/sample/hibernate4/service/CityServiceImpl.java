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

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import sample.hibernate4.domain.City;

@Component("cityService")
@Transactional
class SampleServiceImpl implements SampleService {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public void n_plus_one_problem() {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(City.class);
		List<City> cityList = criteria.list();
		for(City city : cityList){
			System.out.println(city.getHotles().size());
		}
		
		transaction.commit();
		session.close();
		
	}

}
