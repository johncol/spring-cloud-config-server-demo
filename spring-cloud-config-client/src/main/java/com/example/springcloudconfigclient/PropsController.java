package com.example.springcloudconfigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RefreshScope
@RestController
@RequestMapping("/props")
public class PropsController {

    @Value("${prop1:not-found}")
    private String prop1;

    @Value("${prop2:not-found}")
    private String prop2;

    @Value("${prop3:not-found}")
    private String prop3;

    @Value("${prop4:not-found}")
    private String prop4;

    @Value("${prop5:not-found}")
    private String prop5;

    @Value("${prop6:not-found}")
    private String prop6;

    @Value("${prop-encrypted:not-found}")
    private String encryptedProp;

    @GetMapping
    public Map<String, List<String>> props() {
        HashMap<String, List<String>> map = new HashMap<>();
        map.put("props", Arrays.asList(prop1, prop2, prop3, prop4, prop5, prop6, encryptedProp));
        return map;
    }
}
