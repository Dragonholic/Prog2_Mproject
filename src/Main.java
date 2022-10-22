import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] gr_loc;   //광석위치
        int[] gr_wei;   //매장량

        int HP = 100;
        int STR = 10;
        int DEX = 10;
        int INT = 10;   //각 능력치


        System.out.printf("%d %d %d %d" ,HP,STR,DEX,INT );


        int N = scanner.nextInt();  //칸 수 입력
        gr_loc = new int[N];
        gr_wei = new int[N];

        int total_len =0;
        int total_wei =0;
        int total_num = 0;
        int total_mon = 0;

        for (int i = 0; i<N; i++){
            gr_loc[i] = scanner.nextInt();
            gr_wei[i] = scanner.nextInt();

            if (gr_loc[i] > 1000 || gr_wei[i] > 1000 ){
                System.out.print("\n");
                System.out.println("-1");
                System.exit(-1);
            }   //1km, 1톤 초과시 탈출

            total_num +=
            total_mon += (gr_wei[i]*1000);
            total_len += gr_loc[i];
            total_wei += gr_wei[i];
        }





        System.out.print(total_len+" m "+total_wei+" kg "+total_num+" 번 "+total_mon+" won ");




    }
}