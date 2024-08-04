// 1 -> combine the start and end (optional if we want to maintain sequence then add position) to new array
// 2 -> sort the new array based on end timings
import java.util.*;
class Meeting{
    int start;
    int end;
    Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }
}
class NMeetingsInOneRoom{
    public static int maxMeetings(int n, int[] start, int[] end){
        Meeting[] meetings = new Meeting[n];

        for(int i = 0; i < n; i++){
            meetings[i] = new Meeting(start[i], end[i]);
        }
        Arrays.sort(meetings, Comparator.comparingInt(x -> x.end));

        int count = 1;
        int lastEndTime = meetings[0].end;

        for(int i = 1; i < n; i++){
            if(meetings[i].start > lastEndTime){
                count++;
                lastEndTime = meetings[i].end;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++){
            start[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            end[i] = sc.nextInt();
        }
        System.out.println(maxMeetings(n, start, end));
    }
}