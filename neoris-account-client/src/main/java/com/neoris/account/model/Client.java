package com.neoris.account.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class Client
{
    private Long clientId;
    private String password;
    private Person person;
}
