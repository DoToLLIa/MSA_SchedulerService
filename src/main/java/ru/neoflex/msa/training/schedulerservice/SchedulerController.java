package ru.neoflex.msa.training.schedulerservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SchedulerController {
    private static final int INTERVAL = 5000;

    @Value("${application.scheduler.invoke.url}")
    private String URL;

    @Scheduled(fixedRate = INTERVAL)
    public void invokeService() {
        RestTemplate restTemplate = new RestTemplate();
        Object object = restTemplate.getForObject("http://" + URL, Object.class);
    }
}
