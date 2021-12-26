package com.example.springtutor.service;

import com.example.springtutor.exception.ServiceException;
import org.springframework.stereotype.Service;

@Service
public interface MailSender {
    void send(String emailTo, String subject, String message)throws ServiceException;
}
