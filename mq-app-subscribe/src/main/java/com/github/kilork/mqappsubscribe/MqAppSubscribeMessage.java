package com.github.kilork.mqappsubscribe;

public class MqAppSubscribeMessage {
    public String to;
    public String from;
    public String text;

    @Override
    public String toString() {
        return "MqAppSubscribeMessage{" +
                "to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
