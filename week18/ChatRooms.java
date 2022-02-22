package week18;

import java.util.*;

public class ChatRooms {
    
    // record : 닉네임을 변경한 기록이 담긴 문자열 배열
    // 명령어 - Enter : 톡방 입장 / Leave : 퇴장 / Change : 닉변경
    // 각 명령어를 띄어쓰기 기준 3단어로 나누고, 각 내역을 다른 배열에 저장?
    
    public String[] solution(String[] record) {
        
        ArrayList<String> OrderLog = new ArrayList<>();
        ArrayList<String> IdLog = new ArrayList<>();
        ArrayList<String> chatLog = new ArrayList<>();
        HashMap<String, String> nicknameMap = new HashMap<>();  
        
        String Order = "";
        String Id = "";
        String Nickname = "";
        
        for(String s : record){
            
            String[] perRecord = s.split(" ");
            
            Order = perRecord[0];
            Id = perRecord[1];     
            
            if(Order.equals("Leave")){
            //    System.out.println("Leave");  
            //    System.out.println(Arrays.toString(perRecord));
                Nickname = nicknameMap.get(Id);
            }
            else{
            //    System.out.println("not Leave");
            //    System.out.println(Arrays.toString(perRecord));
                Nickname = perRecord[2];
            }
                
            // System.out.println(Order + ", " + Id + ", " + Nickname);    
            
            if(Order.equals("Enter")){
            //    System.out.println("id & nick : " + Id + ", " + Nickname);
                nicknameMap.put(Id, Nickname);  //  id별 닉네임 input
                OrderLog.add(Order);
                IdLog.add(Id);
            //    chatLog.add(Nickname + "님이 들어왔습니다.");
            }
            else if(Order.equals("Change")){
            //    System.out.println("id & nick : " + Id + ", " + Nickname);   
                OrderLog.add(Order);
                IdLog.add(Id);
                nicknameMap.put(Id, Nickname);  //  새로운 닉네임 change
            }
            else{   //  Leave
            //    chatLog.add(Nickname + "님이 나갔습니다.");
                OrderLog.add(Order);
                IdLog.add(Id);
                nicknameMap.remove(Id);
            }
            
        }
        
     //   System.out.println("IdLog : " + IdLog);
     //   System.out.println("OrderLog : " + OrderLog);
        
        for(int i = 0; i < IdLog.size(); i++){
            String FinalNickname = nicknameMap.get(IdLog.get(i));
            
            if(OrderLog.get(i).equals("Change")){
                continue;
            }
            else if(OrderLog.get(i).equals("Enter")){
                chatLog.add(FinalNickname + "님이 들어왔습니다.");
            }
            else{   //  Leave
                chatLog.add(FinalNickname + "님이 나갔습니다.");
            }
            
        }
    //    System.out.println(chatLog);
        
        String[] answer = chatLog.toArray(new String[0]);
        
        return answer;
    }
}