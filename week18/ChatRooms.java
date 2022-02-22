package week18;

import java.util.*;

public class ChatRooms {
    
    // record : �г����� ������ ����� ��� ���ڿ� �迭
    // ��ɾ� - Enter : ��� ���� / Leave : ���� / Change : �к���
    // �� ��ɾ ���� ���� 3�ܾ�� ������, �� ������ �ٸ� �迭�� ����?
    
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
                nicknameMap.put(Id, Nickname);  //  id�� �г��� input
                OrderLog.add(Order);
                IdLog.add(Id);
            //    chatLog.add(Nickname + "���� ���Խ��ϴ�.");
            }
            else if(Order.equals("Change")){
            //    System.out.println("id & nick : " + Id + ", " + Nickname);   
                OrderLog.add(Order);
                IdLog.add(Id);
                nicknameMap.put(Id, Nickname);  //  ���ο� �г��� change
            }
            else{   //  Leave
            //    chatLog.add(Nickname + "���� �������ϴ�.");
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
                chatLog.add(FinalNickname + "���� ���Խ��ϴ�.");
            }
            else{   //  Leave
                chatLog.add(FinalNickname + "���� �������ϴ�.");
            }
            
        }
    //    System.out.println(chatLog);
        
        String[] answer = chatLog.toArray(new String[0]);
        
        return answer;
    }
}