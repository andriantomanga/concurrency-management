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
package mg.facedev.concurrencymanagement.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import mg.facedev.concurrencymanagement.services.MyService;

/**
 * @author nabil andriantomanga
 */
@Service
public class ThreadTask {

	@Autowired
	private MyService service;

	@Async("nabilThreadPoolTaskExecutor")
	@Scheduled(fixedRate = 100)
	public void addingAData() {

		Runnable myRunnable = () -> {
			System.out.println("Executing : " + Thread.currentThread().getName());
			service.saveData("Language de programmation", "Java");
		};

		Thread thread1 = new Thread(myRunnable);
		Thread thread2 = new Thread(myRunnable);

		thread1.start();
		thread2.start();

	}

}
