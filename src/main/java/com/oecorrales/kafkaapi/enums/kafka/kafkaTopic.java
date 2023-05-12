package com.oecorrales.kafkaapi.enums.kafka;

public enum kafkaTopic {
    FIRST_TOPIC,
    SECOND_TOPIC,
    RECORDS,
    ANOTHER_TEST;

    public static boolean isTopic(String searchString) {
        for (kafkaTopic topic : values()) {
            if (topic.name().equalsIgnoreCase(searchString)) {
                return true;
            }
        }

        return false;
    }
}
