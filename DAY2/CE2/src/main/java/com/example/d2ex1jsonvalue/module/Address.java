package com.example.d2ex1jsonvalue.module;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
@Configuration
public class Address {
    @Value("${my.property}")
    public String property;
    @Value("${my.abi}")
    public String abi;

    public String getProperty() {
        return property;
    }
    public void setProperty(String property) {
        this.property = property;
    }
    public String getAbi() {
        return abi;
    }
    public void setAbi(String abi) {
        this.abi = abi;
    }
    
    
}
