package com.example.midterm;

import java.util.Comparator;

public class AccountComparator implements Comparator<Account> {
    @Override
    public int compare(Account account, Account t1) {
        if (account.getId().charAt(0) > t1.getId().charAt(0)) {
            return 1;
        } else if (account.getId().charAt(0) > t1.getId().charAt(0)) {
            for (int i=1; i<account.getId().length(); i++) {
                if (account.getId().charAt(i) > t1.getId().charAt(i)) {
                    return 1;
                } else {
                    return -1;
                }
            }
        } else {
            return -1;
        }
        return 0;
    }
}
