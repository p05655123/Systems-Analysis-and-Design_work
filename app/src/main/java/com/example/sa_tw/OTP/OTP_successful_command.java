package com.example.sa_tw.OTP;


import com.example.sa_tw.Mediator.Mediator;

public abstract class OTP_successful_command {
    Mediator mediator = Mediator.getInstance();
    abstract public void check_banlance();
    abstract protected void process();
}
