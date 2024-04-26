package ru.itis.spring_11200.services;

public interface MailService {
    void sendEmailForConfirm(String email, String code);
}
