package com.elas.test;

public class JsonTest {
    static final String MAPPINGS_TYPE = "{\n" +
            " \"mappings\": {\n" +
            "   \"properties\": {\n" +
            "     \"info\":{\n" +
            "       \"type\": \"text\"\n" +
            "       , \"analyzer\": \"ik_smart\"\n" +
            "     },\n" +
            "     \"email\":{\n" +
            "       \"type\": \"keyword\",\n" +
            "       \"index\":false\n" +
            "     },\n" +
            "     \"name\":{\n" +
            "       \"type\": \"object\", \n" +
            "       \"properties\": {\n" +
            "         \"firstName\": {\n" +
            "           \"type\":\"keyword\"\n" +
            "         },\n" +
            "         \"lastName\":{\n" +
            "           \"type\":\"keyword\"\n" +
            "         }\n" +
            "       }\n" +
            "     }\n" +
            "   }\n" +
            " } \n" +
            "}";
}
