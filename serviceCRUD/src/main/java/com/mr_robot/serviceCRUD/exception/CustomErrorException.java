package com.mr_robot.serviceCRUD.exception;

public class CustomErrorException extends RuntimeException{
    public CustomErrorException(String message){
        super(message);
    }
}
