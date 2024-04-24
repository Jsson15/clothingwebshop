package com.example.klader.Business;

import java.util.concurrent.atomic.AtomicInteger;

public class Customer extends BusinessObject {

    private String adress;
    private String eMail;
    private AtomicInteger idCount = new AtomicInteger(0);

    public Customer() {
        setId(idCount.incrementAndGet());
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }
}

