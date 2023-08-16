package com.example.orderfoodapi.Response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterMessage {
    String message;
    Boolean status;
    @Override
    public String toString() {
        return "LoginMesage{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
