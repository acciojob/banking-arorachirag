package com.driver;

import java.util.Map;
import java.util.TreeMap;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId = tradeLicenseId;
        if(balance<5000) throw new Exception("Insufficient Balance");

    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        String input = this.tradeLicenseId;

        boolean possible = validate(input);

        String res = "";
        if(!possible){
            res = arrange(tradeLicenseId);
            if(res==""){
                throw new Exception("Valid License can not be generated");
            }

            tradeLicenseId = res;
        }

    }

    public boolean validate(String input){
        for(int i=0;i<input.length()-1;i++){
            if(input.charAt(i)==input.charAt(i+1)) return false;
        }
        return true;
    }

    public String arrange(String s){
        char[] c1 = s.toCharArray();
        int n = c1.length;
        String res = "";
        TreeMap<Character,Integer> map = new TreeMap<>();

        for(char c : c1){
                map.put(c, map.getOrDefault(c,0)+1);
        }

        int max = 0;
//        for(Map.Entry map1 : map.entrySet()){
//            max = Math.max((int)map1.getValue(),max);
//            System.out.println(map1.getKey()+" "+map1.getValue());
//        }

        if(max>(n+1)/2){
            return "";
        } else {
            while(res.length()!=n) {
                for (Map.Entry map1 : map.entrySet()) {
                    if(res.length()==n) break;
                    res += (char) map1.getKey();
                }
            }
        }
        //System.out.println(max);
        return res;
    }

    public String getTradeLicenseId(){
        return this.tradeLicenseId;
    }

}
