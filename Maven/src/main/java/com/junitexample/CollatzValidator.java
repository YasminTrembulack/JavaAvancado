package com.junitexample;

public class CollatzValidator {
    public Boolean validate(int num) {
        if(num < 1)
            return false;
        int alter_num = num;
        while (alter_num > 1){
            if(alter_num % 2 == 0){
                alter_num = alter_num / 2;
            }
            else{
                alter_num = (alter_num * 3) + 1;
            }
        }
        if(alter_num == 1)
            return true;
        return false;
    }
}