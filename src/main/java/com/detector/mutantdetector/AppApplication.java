package com.detector.mutantdetector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.detector.mutantdetector.entiry.Dna;
import com.detector.mutantdetector.service.DnaService;

@SpringBootApplication
@Configuration
@EnableScheduling
public class AppApplication {

	@Autowired
	DnaService<Dna> dnaService;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	public TaskExecutor executorRepository() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5);
		executor.setMaxPoolSize(20);
		executor.setQueueCapacity(99999);
		executor.setThreadNamePrefix("mongodb_concurrency");
		executor.initialize();
		return executor;
	}

	@Scheduled(fixedDelay = 2000)
	public void scheduleFixedDelayTask() {
		while (Data.getListDna().size() > 0) {
			dnaService.bulkSave();
		}
	}

}
