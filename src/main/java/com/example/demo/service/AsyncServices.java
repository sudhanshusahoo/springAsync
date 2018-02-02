package com.example.demo.service;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class AsyncServices {
	
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Async
    public Future<String> process() throws InterruptedException {
		log.info("###Start Processing with Thread id: " + Thread.currentThread().getId());
		
		// Sleep 3s for simulating the processing
		Thread.sleep(3000);
		
		String processInfo = String.format("Processing is Done with Thread id = %d", Thread.currentThread().getId());
        return new AsyncResult<>(processInfo);
    }
	@Async
    public Future<Long> processInt() throws InterruptedException {
		log.info("###Start Processing with Thread id: " + Thread.currentThread().getId());
		
		// Sleep 3s for simulating the processing
		Thread.sleep(3000);
		
        return new AsyncResult<>(Thread.currentThread().getId());
    }

}
