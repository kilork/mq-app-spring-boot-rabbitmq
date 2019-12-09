package com.github.kilork.mqapppublish;

public class MqAppPublishMessage {
    public String to;
    public String from;
    public String text;

    @Override
    public String toString() {
        return "MqAppPublishMessage{" +
                "to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
