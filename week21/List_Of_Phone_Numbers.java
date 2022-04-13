package week21;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 220413 review (프로그래머스 - 해시)
 * 2. 전화번호 목록
 * 
 * 
 */

public class List_Of_Phone_Numbers {
    public boolean solution(String[] phone_book) {
       
        boolean answer = true;
        Arrays.sort(phone_book);
       
        Map<Integer, String> phone = new HashMap<>();
       
        int x = 0;
        for(String str : phone_book){
            phone.put(x, str);
            x++;
        }
       
        for(int i = 0; i < phone.size(); i++){
           
            String phoneNumber = phone.get(i);
           
            for(String str : phone_book){
               
                if(phoneNumber == str){
                    continue;   //  pass
                }
                 

                // if(phone.get(i).length() < str.length()
                //     && phone.get(i) == str.substring(0,phone.get(i).length())){
                //       answer = false;
                //       break;
                //  }
               
                if(phoneNumber.length() < str.length()){  
                    if(phoneNumber == str.substring(0,phoneNumber.length())){
                        answer = false;
                        break;
                    }
                    else{
                        System.out.println("phoneNumber : " + phoneNumber +
                                           ", str.substring(0,phone.get(i).length()) : "
                                           + str.substring(0,phoneNumber.length()));
                    }
                }
                   
           
            }
        }    
       
        return answer;
    }
}