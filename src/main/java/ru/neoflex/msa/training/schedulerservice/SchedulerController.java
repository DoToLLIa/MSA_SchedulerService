package ru.neoflex.msa.training.schedulerservice;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SchedulerController {
    private static final Long INTERVAL = 5000L;

    private static final String HOST = "10.20.30.11";
    private static final String PORT = "8080";
    private static final String PATH = "";

    @Scheduled(fixedRate = 5000)
    public void invokeService() {
        RestTemplate restTemplate = new RestTemplate();
        BankAccount bankAccount = restTemplate.getForObject("http://" + HOST + ":" + PORT + PATH  + "/", BankAccount.class);
        System.out.println(bankAccount);
    }
}
