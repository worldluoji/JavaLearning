package com.reflection.beansutil.demo;

import com.reflection.model.User;
import org.springframework.beans.BeanUtils;
import java.util.Arrays;

public class BeanUtilsDemo {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setName("luoji");
        user1.setAge(28);
        user1.setGender((short)0);
        user1.setHobbies(Arrays.asList("piano","running"));
        System.out.println(user1);
        User user2 = new User();
        try {
            BeanUtils.copyProperties(user2, user1);
            System.out.println(user2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
