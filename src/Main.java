import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] gr_loc;   //광석위치
        double[] gr_wei;   //매장량

        int Hp = 100;
        int Str = 25;
        int Dex = 25;
        int Int = 25;   // 값 초기화

        if (args.length != 0) {
            Hp = Integer.parseInt(args[0]);
            Str = Integer.parseInt(args[1]);
            Dex = Integer.parseInt(args[2]);
            Int = Integer.parseInt(args[3]);        // arg에 값이 있을경우 삽입
        }


        int HP = Hp;
        double STR = Str;
        double DEX = Dex;
        double INT = Int;   //각 능력치 최종 정리


        System.out.printf("%d %d %d %d \n", HP, (int) STR, (int) DEX, (int) INT); //초기 능력치 출력


        int N = scanner.nextInt();  //칸 수 입력
        gr_loc = new double[N];
        gr_wei = new double[N];

        int pit_num = 0;
        int ore_num = 0;
        int total_pit_num = 0;  //총 구덩이 판 횟수
        int total_ore_num = 0;  //총 광석 판 횟수
        int total_mon = 0;  //광석 판매 금액


        for (int i = 0; i < N; i++) {                      //땅파기
            gr_loc[i] = scanner.nextInt();
            gr_wei[i] = scanner.nextInt();

            if (gr_loc[i] > 1000 || gr_wei[i] > 1000) {
                System.out.print("\n");
                System.out.println("-1(1km 또는 1t초과 )" + i + "째");
                System.exit(-1);
            }   //1km, 1톤 초과시 탈출


            pit_num = (int) Math.ceil(gr_loc[i] / DEX);
            ore_num = (int) Math.ceil(gr_wei[i] / STR);

            total_pit_num += pit_num; // i번 구덩이를 몇번 팠는지 += 전체합
            total_ore_num += ore_num; // i번 광석을 몇번 캤는지  += 전체합
            total_mon += gr_wei[i] * 1000;

            HP -= (pit_num + ore_num) * (100 / INT);

            if (HP <= 0) {
                System.out.print("\n");
                System.out.println("-1(HP 0 이하)" + i + "번");
                System.exit(-1);
            } // HP가 영이하로 내려가면 탈출


        }


        System.out.println(HP + " " + (int) STR + " " + (int) DEX + " " + (int) INT);
        System.out.println((int) (STR + DEX + INT) + " " + total_pit_num + " " + total_ore_num);
        System.out.println(total_mon);


    }
}