package ru.vegxer.shopsample.mailing.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailActivationMessage {
    private String email;
    private String activationLink;
}
