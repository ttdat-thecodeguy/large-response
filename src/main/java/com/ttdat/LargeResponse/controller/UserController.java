package com.ttdat.LargeResponse.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttdat.LargeResponse.dto.Rule;
import com.ttdat.LargeResponse.dto.UserSerialize;
import com.ttdat.LargeResponse.dto.Users;
import com.ttdat.LargeResponse.dto.usersShorter;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.*;

@RestController
public class UserController {
    @GetMapping("/users")
    public ResponseEntity getUsers(
            @RequestParam(required = false) List<String> rules,
            @RequestParam(required = false, name = "strategy") STRATEGIES strategies) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = ResourceUtils.getFile("classpath:users.json");
        if (strategies == null) strategies = STRATEGIES.NORMAL;
        switch (strategies) {
            case NORMAL -> {
                List<Users> users = objectMapper.readValue(file, new TypeReference<>() {});
                return ResponseEntity.ok(users);
            }
            case SHORTER_BY_FIELD_NAME -> {
                List<usersShorter> users = objectMapper.readValue(file, new TypeReference<>() {});
                return ResponseEntity.ok(users);
            }
            case SERIALIZE -> {
                List<String> defaultRules = Arrays.asList("first_name","last_name","street","city","country","phone_number","email");
                rules = rules == null ? defaultRules : rules;
                List<List<String>> datas = new ArrayList<>();
                UserSerialize userSerialize = new UserSerialize();
                userSerialize.setRules(rules);

                JsonNode root = objectMapper.readTree(file);
                for (JsonNode node : root) {
                    List<String> data = new ArrayList<>();

                    String firstName = node.get("first_name").asText();
                    addData(data, rules, firstName, "first_name");

                    String lastName = node.get("last_name").asText();
                    addData(data, rules, lastName, "last_name");

                    String street = node.get("street").asText();
                    addData(data, rules, street, "street");

                    String city = node.get("city").asText();
                    addData(data, rules, city, "city");

                    String country = node.get("country").asText();
                    addData(data, rules, country, "country");

                    String phoneNumber = node.get("phone_number").asText();
                    addData(data, rules, phoneNumber, "phone_number");

                    String email = node.get("email").asText();
                    addData(data, rules, email, "email");
                    datas.add(data);
                }
                userSerialize.setDatas(datas);
                return ResponseEntity.ok(userSerialize);
            }
        }
        return ResponseEntity.noContent().build();
    }

    private void addData(List<String> data, List<String> rules, String dataAppend, String columnName) {
        //search firstName in rules
        int idx = rules.indexOf(columnName);
        if (idx != -1) {
            data.add(dataAppend);
        }
    }
}

enum STRATEGIES {
    NORMAL,
    SHORTER_BY_FIELD_NAME,
    SERIALIZE
}
