package com.user.dao;

import com.user.model.User;

import java.util.HashMap;

public class UserDao {
 private HashMap<String,User>  BD;

  {  BD = new HashMap<>();
     BD.put("adm", new User("adm", "adm"));
     BD.put("user", new User("user", "user"));
    }

    public HashMap<String, User> getBD() {
        return BD;
    }
}
