package com.restapi.demo.JSON_Demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Person alice = new Person();
        alice.setName("Alice");
        alice.setAge(20);

        ObjectMapper objectMapper = new ObjectMapper();

        //Serialization - Java Object to JSON String
        String jsonString = objectMapper.writeValueAsString(alice);
        System.out.println("String field JSON" + jsonString);

        //Deserialization - JSON String to Java Object
        String jsSting = "{\"name\":\"Aung\",\"age\":34}";
        Person person = objectMapper.readValue(jsSting, Person.class);
        System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());

        //Object Node
        ObjectNode jsonNode = (ObjectNode) objectMapper.readTree(jsSting);
        //Update Value
        jsonNode.put("name", "Bob");
        //Add new
        jsonNode.put("isStudent", true);

        String updatedJSONString = objectMapper.writeValueAsString(jsonNode);
        System.out.println("String field JSON" + updatedJSONString);
    }
}
