package week20;

import java.util.*;

public class Process_Scheduleing {
	public static String[] solution(String[] arr, String[] processes) {

        List<String> list = new ArrayList();

        PriorityQueue<String[]>  waitQueue =  new PriorityQueue<>((o1, o2) ->  Integer.parseInt( o1[1]) - Integer.parseInt(o2[1]));
        PriorityQueue<String[]>  workQueue =  new PriorityQueue<>((o1, o2) -> {
            if ( ( o1[0].equals("read") && o2[0].equals("read")  ) ) {
                return Integer.parseInt( o1[1]) - Integer.parseInt(o2[1]);
            } else if (o1[0].equals("read") && o2[0].equals("write")) {
                return 1;
            } else if (o1[0].equals("write") && o2[0].equals("read")) {
                return -1;
            } else{
                return Integer.parseInt(o1[1]) - Integer.parseInt( o2[1])  ;
            }
        });

        for(String job: processes){
            String[] jobArr = job.split(" ");
            waitQueue.add(jobArr);
        }

        int totalWorkTime = 0;
        int currentTime = 0;

        while( !waitQueue.isEmpty() || !workQueue.isEmpty()) {
            if ( workQueue.isEmpty()) {
                currentTime = Integer.parseInt( waitQueue.peek()[1]);
            }else {
                if(workQueue.peek()[0].equals("read")){
                    int longWorkTime = 0;
                    while(!workQueue.isEmpty()){
                        String[] job = workQueue.poll();
                        if( Integer.parseInt(job[2]) > longWorkTime ) {
                            longWorkTime = Integer.parseInt(job[2]);
                        }
                        int start = Integer.parseInt(job[3]);
                        int end = Integer.parseInt(job[4]);

                        StringBuilder stringBuilder = new StringBuilder();
                        for(int i =start; i<=end; i++){
                            stringBuilder.append( arr[i]);
                        }
                        list.add(stringBuilder.toString());
                    }

                    //동시실행.
                    while(!waitQueue.isEmpty() &&  Integer.parseInt(waitQueue.peek()[1]) <= currentTime+longWorkTime && waitQueue.peek()[0].equals("read")){
                        String[] job2 = waitQueue.poll();

                        int start = Integer.parseInt(job2[3]);
                        int end = Integer.parseInt(job2[4]);
                        StringBuilder stringBuilder = new StringBuilder();
                        for(int i =start; i<=end; i++){
                            stringBuilder.append( arr[i]);
                        }
                        list.add(stringBuilder.toString());
                        
                        if(currentTime+longWorkTime < Integer.parseInt(job2[1]) + Integer.parseInt(job2[2])){
                            longWorkTime = Integer.parseInt(job2[1])-currentTime +Integer.parseInt(job2[2]);
                        }
                    }
                    currentTime += longWorkTime;
                    totalWorkTime += longWorkTime;

                }else{ // write 의 경우

                    String[] job = workQueue.poll();
                    currentTime += Integer.parseInt( job[2]);
                    totalWorkTime += Integer.parseInt( job[2]);

                    int start = Integer.parseInt(job[3]);
                    int end = Integer.parseInt(job[4]);

                    for(int i =start; i<=end; i++){
                        arr[i] = job[5];
                    }
                }
            }

            while ( !waitQueue.isEmpty() &&  Integer.parseInt(waitQueue.peek()[1]) <= currentTime) {
                String [] job = waitQueue.poll();
                workQueue.offer(job);
            }
        }

        list.add( String.valueOf(totalWorkTime));
        String[] answer = list.toArray(new String[0]);

        return answer;
    }
}
