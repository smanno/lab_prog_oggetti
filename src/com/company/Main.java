package com.company;

import api_OperatoreTelefonico.CallData;

import java.time.Duration;

public class Main {

    public static void main(String[] args) {
        Duration durata = null;
        CallData data1 = new CallData("1234567890", durata , true);
        data1.setNumber("0987654321");
        data1.toString();
    }
}
