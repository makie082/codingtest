import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int lineN = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i=0; i<lineN; i++){
            String strArr = br.readLine();
            StringTokenizer st = new StringTokenizer(strArr, " ");

            if (strArr.contains("push")) {
                String s = st.nextToken();
                queue.add(Integer.parseInt(st.nextToken()));
            }
            if (strArr.contains("top")){
                if (queue.isEmpty()){
                    bw.write(-1+"\n");
                }else {
                    bw.write(queue.getLast()+"\n");
                }
                //bw.write(queue.toString()+"\n");
            }
            else if(strArr.contains("size")){
                bw.write(queue.size()+"\n");
                //bw.write(queue.toString()+"\n");
            }else if(strArr.contains("empty")){
                if (queue.isEmpty()){
                    bw.write("1\n");
                }else{
                    bw.write("0\n");
                }
                //bw.write(queue.toString()+"\n");

            }else if(strArr.contains("pop")){
                if (queue.isEmpty()){
                    bw.write("-1\n");
                }else {
                    bw.write(queue.removeLast().toString()+"\n");
                }
                //bw.write(queue.toString()+"\n");
            }



        }
        bw.flush();

    }
}