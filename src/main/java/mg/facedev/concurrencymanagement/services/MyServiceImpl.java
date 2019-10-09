/**
 * Copyright 2019 andriantomanga
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mg.facedev.concurrencymanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mg.facedev.concurrencymanagement.entity.MyData;
import mg.facedev.concurrencymanagement.repositories.MyRepository;

/**
 * @author nabil andriantomanga
 */
@Service
public class MyServiceImpl implements MyService {

	@Autowired
	private MyRepository repository;

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public MyData saveData(String name, String value) {

		if (repository.findByNameAndValue(name, value).isPresent()) {
			return null;
		}

		MyData data = new MyData();
		data.setName(name);
		data.setValue(value);

		return repository.save(data);

	}

}
