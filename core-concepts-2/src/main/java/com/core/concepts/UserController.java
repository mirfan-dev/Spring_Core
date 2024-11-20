package com.core.concepts;

public class UserController {

    UserService service;

    public void setService(UserService service) {
        this.service = service;
    }

    public UserService getService() {
        return service;
    }

    public void executeController(){
        service.executeService();
        System.out.println("User controller is executed");
    }


}
