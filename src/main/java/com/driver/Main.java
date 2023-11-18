package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {
        SavingsAccount s1 = new SavingsAccount("Chirag",100000,30000,4);
        BankAccount b1 = new BankAccount("Chirag",1000,200);
        //CurrentAccount c1 = new CurrentAccount("Chirag",20000,"ABCD");

        // Get Simple Interest
        System.out.println(s1.getSimpleInterest(5));
        System.out.println(s1.getCompoundInterest(2,5));
        System.out.println(b1.generateAccountNumber(4,20));

        //System.out.println(c1.validateLicenseId());
    }
}