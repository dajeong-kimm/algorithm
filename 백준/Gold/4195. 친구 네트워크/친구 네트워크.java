import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    static HashMap<String, String> parent;
    static HashMap<String, Integer> num;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            parent = new HashMap<>();
            num = new HashMap<>();
            for (int j=0;j<N;j++){
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!parent.containsKey(a)){
                    parent.put(a,a);
                    num.put(a,1);
                }
                if (!parent.containsKey(b)){
                    parent.put(b,b);
                    num.put(b,1);
                }
                Union(a,b);


            }
        }

    }
    private static String find(String x){
        if (!x.equals(parent.get(x))) {
            parent.put (x, find(parent.get(x)));
        }
        return parent.get(x);
    }


    private static void Union(String a, String b){
        String Pa = find(a);
        String Pb = find(b);

        if (!Pa.equals(Pb)) {
            if (num.get(Pa)<num.get(Pb)){
                parent.put(Pa, Pb);
                num.put(Pb, num.get(Pa)+num.get(Pb));
            } else{
                parent.put(Pb,Pa);
                num.put(Pa, num.get(Pa)+num.get(Pb));
            }
        }
        System.out.println(num.get(find(a)));
    }
}