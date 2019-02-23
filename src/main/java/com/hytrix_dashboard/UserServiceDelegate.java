package com.hytrix_dashboard;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * Created by Erdem Akyıldız on 22.02.2019.
 */
@Service
public class UserServiceDelegate {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "callUserServiceAndGetData_Fallback")
    public String callUserServiceAndGetData() {
        String response = restTemplate
                .exchange("http://localhost:8085/user"
                        , HttpMethod.GET
                        , null
                        , String.class).getBody();


        return response + " -  " + new Date();
    }

    private String callUserServiceAndGetData_Fallback() {
        return "Error - " + new Date();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
