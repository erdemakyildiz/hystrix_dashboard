package com.hytrix_dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Erdem Akyıldız on 22.02.2019.
 */
@RestController
public class UserServiceRestController {

    @Autowired
    private UserServiceDelegate userServiceDelegate;

    @GetMapping(path = "user")
    public String getUsers() {
        return userServiceDelegate.callUserServiceAndGetData();
    }

    /**
     * loader.io için token
     * @return
     */
    @GetMapping(path = "loaderio-b38cef9ea988006f59b4c2fcf18053d2")
    public String loaderIo(){
        return "loaderio-b38cef9ea988006f59b4c2fcf18053d2";
    }

}
