package com.descomplica.FrameBlog.clients;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TodosServiceClient {
    // classe de consumo da fake API
    public Object[] getAllTodos() {
        RestTemplate restTemplate = new RestTemplate();

        String fakeApiUrl = "https://jsonplaceholder.typicode.com/todos";
        return restTemplate.getForObject(fakeApiUrl, Object[].class);
    }
}

