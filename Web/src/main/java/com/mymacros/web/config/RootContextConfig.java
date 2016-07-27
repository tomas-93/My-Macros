package com.mymacros.web.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Controller;

import java.util.concurrent.Executor;

/**
 * Created by Tomas on 23/07/2016.
 */
@Configuration
@EnableAsync(proxyTargetClass = true)
@EnableScheduling
@ComponentScan(
        basePackages = {
                "com.mymacros.web",
                "com.mymacros.services",
                "com.mymacros.repository"
        },
        excludeFilters = @ComponentScan.Filter(Controller.class)
)

public class RootContextConfig implements AsyncConfigurer, SchedulingConfigurer
{
     public static final Logger message = LogManager.getLogger();
     public static final Logger schedulingLogger = LogManager.getLogger();

     @Bean
     public ObjectMapper objectMapper()
     {
          ObjectMapper mapper = new ObjectMapper();
          mapper.findAndRegisterModules();
          mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
          mapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false);
          return mapper;
     }

     @Bean
     public Jaxb2Marshaller jaxb2Marshaller()
     {
          Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
          marshaller.setPackagesToScan(new String[] { "com.mymacros.web" });
          return marshaller;
     }

     @Bean
     public ThreadPoolTaskScheduler taskScheduler()
     {
          message.info("Setting up thread pool task scheduler with 20 threads.");
          ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
          scheduler.setPoolSize(20);
          scheduler.setThreadNamePrefix("task-");
          scheduler.setAwaitTerminationSeconds(60);
          scheduler.setWaitForTasksToCompleteOnShutdown(true);
          scheduler.setErrorHandler(t -> schedulingLogger.error(
                  "Unknown error occurred while executing task.", t
          ));
          scheduler.setRejectedExecutionHandler(
                  (r, e) -> schedulingLogger.error(
                          "Execution of task {} was rejected for unknown reasons.", r
                  )
          );
          return scheduler;
     }

     @Override
     public Executor getAsyncExecutor()
     {
          Executor executor = this.taskScheduler();
          message.info("Configuring asynchronous method executor {}.", executor);
          return executor;
     }

     @Override
     public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler()
     {
          return null;
     }

     @Override
     public void configureTasks(ScheduledTaskRegistrar registrar)
     {
          TaskScheduler scheduler = this.taskScheduler();
          message.info("Configuring scheduled method executor {}.", scheduler);
          registrar.setTaskScheduler(scheduler);
     }
}
