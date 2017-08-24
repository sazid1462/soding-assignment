package com.project.demo;

class Constants {
    static final String SWAGGER_JSON = "{\n" +
            "  \"swagger\": \"2.0\",\n" +
            "  \"info\": {\n" +
            "    \"version\": \"1.0.0\",\n" +
            "    \"title\": \"Soding Assignment\"\n" +
            "  },\n" +
            "  \"basePath\": \"/api\",\n" +
            "  \"schemes\": [\n" +
            "    \"http\"\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"name\": \"api\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"paths\": {\n" +
            "    \"/create\": {\n" +
            "      \"post\": {\n" +
            "        \"tags\": [\n" +
            "          \"api\"\n" +
            "        ],\n" +
            "        \"operationId\": \"createTask\",\n" +
            "        \"consumes\": [\n" +
            "          \"application/x-www-form-urlencoded\"\n" +
            "        ],\n" +
            "        \"produces\": [\n" +
            "          \"text/html\"\n" +
            "        ],\n" +
            "        \"parameters\": [\n" +
            "          {\n" +
            "            \"name\": \"id\",\n" +
            "            \"in\": \"formData\",\n" +
            "            \"required\": false,\n" +
            "            \"type\": \"string\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"name\",\n" +
            "            \"in\": \"formData\",\n" +
            "            \"required\": false,\n" +
            "            \"type\": \"string\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"assignee\",\n" +
            "            \"in\": \"formData\",\n" +
            "            \"required\": false,\n" +
            "            \"type\": \"string\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"reporter\",\n" +
            "            \"in\": \"formData\",\n" +
            "            \"required\": false,\n" +
            "            \"type\": \"string\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"responses\": {\n" +
            "          \"200\": {\n" +
            "            \"description\": \"successful operation\",\n" +
            "            \"schema\": {\n" +
            "              \"type\": \"string\"\n" +
            "            },\n" +
            "            \"headers\": {}\n" +
            "          }\n" +
            "        }\n" +
            "      }\n" +
            "    },\n" +
            "    \"/get\": {\n" +
            "      \"get\": {\n" +
            "        \"tags\": [\n" +
            "          \"api\"\n" +
            "        ],\n" +
            "        \"operationId\": \"getTask\",\n" +
            "        \"produces\": [\n" +
            "          \"application/json\"\n" +
            "        ],\n" +
            "        \"parameters\": [\n" +
            "          {\n" +
            "            \"name\": \"id\",\n" +
            "            \"in\": \"query\",\n" +
            "            \"required\": false,\n" +
            "            \"type\": \"string\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"responses\": {\n" +
            "          \"200\": {\n" +
            "            \"description\": \"successful operation\",\n" +
            "            \"schema\": {\n" +
            "              \"type\": \"string\"\n" +
            "            },\n" +
            "            \"headers\": {}\n" +
            "          }\n" +
            "        }\n" +
            "      }\n" +
            "    },\n" +
            "    \"/list\": {\n" +
            "      \"get\": {\n" +
            "        \"tags\": [\n" +
            "          \"api\"\n" +
            "        ],\n" +
            "        \"operationId\": \"listAll\",\n" +
            "        \"produces\": [\n" +
            "          \"application/json\"\n" +
            "        ],\n" +
            "        \"parameters\": [],\n" +
            "        \"responses\": {\n" +
            "          \"200\": {\n" +
            "            \"description\": \"successful operation\",\n" +
            "            \"schema\": {\n" +
            "              \"type\": \"string\"\n" +
            "            },\n" +
            "            \"headers\": {}\n" +
            "          }\n" +
            "        }\n" +
            "      }\n" +
            "    },\n" +
            "    \"/update\": {\n" +
            "      \"post\": {\n" +
            "        \"tags\": [\n" +
            "          \"api\"\n" +
            "        ],\n" +
            "        \"operationId\": \"updateTask\",\n" +
            "        \"consumes\": [\n" +
            "          \"application/x-www-form-urlencoded\"\n" +
            "        ],\n" +
            "        \"produces\": [\n" +
            "          \"text/html\"\n" +
            "        ],\n" +
            "        \"parameters\": [\n" +
            "          {\n" +
            "            \"name\": \"id\",\n" +
            "            \"in\": \"formData\",\n" +
            "            \"required\": false,\n" +
            "            \"type\": \"string\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"name\",\n" +
            "            \"in\": \"formData\",\n" +
            "            \"required\": false,\n" +
            "            \"type\": \"string\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"assignee\",\n" +
            "            \"in\": \"formData\",\n" +
            "            \"required\": false,\n" +
            "            \"type\": \"string\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"name\": \"reporter\",\n" +
            "            \"in\": \"formData\",\n" +
            "            \"required\": false,\n" +
            "            \"type\": \"string\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"responses\": {\n" +
            "          \"200\": {\n" +
            "            \"description\": \"successful operation\",\n" +
            "            \"schema\": {\n" +
            "              \"type\": \"string\"\n" +
            "            },\n" +
            "            \"headers\": {}\n" +
            "          }\n" +
            "        }\n" +
            "      }\n" +
            "    },\n" +
            "    \"/delete\": {\n" +
            "      \"get\": {\n" +
            "        \"tags\": [\n" +
            "          \"api\"\n" +
            "        ],\n" +
            "        \"operationId\": \"updateTask\",\n" +
            "        \"produces\": [\n" +
            "          \"text/html\"\n" +
            "        ],\n" +
            "        \"parameters\": [\n" +
            "          {\n" +
            "            \"name\": \"id\",\n" +
            "            \"in\": \"query\",\n" +
            "            \"required\": false,\n" +
            "            \"type\": \"string\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"responses\": {\n" +
            "          \"200\": {\n" +
            "            \"description\": \"successful operation\",\n" +
            "            \"schema\": {\n" +
            "              \"type\": \"string\"\n" +
            "            },\n" +
            "            \"headers\": {}\n" +
            "          }\n" +
            "        }\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "}";
}