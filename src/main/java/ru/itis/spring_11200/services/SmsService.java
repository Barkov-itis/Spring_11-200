package ru.itis.spring_11200.services;

public interface SmsService {
    void sendSms(String phone, String text);
}
