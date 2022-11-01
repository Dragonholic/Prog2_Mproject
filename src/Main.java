
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;




public class Main {








    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] gr_loc;   //광석위치
        double[] gr_wei;   //매장량
        int[] item; // 아이템 가격 배열
        String[] item_name; //아이템 가격 배열
        boolean[] check_item; // 아이템 재고 확인;





        item = new int[8];
        check_item = new boolean[8];
        item_name = new String[8];



        item[0] = 15000;    //좋은곡괭이 STR MAX
        item[1] = 14000;    //좋은신발  DEX MAX
        item[2] = 8000;     //좋은책   INT MAX
        item[3] = 5000;     //좋은빵   HP +50
        item[4] = 1800;     //곡괭이   STR +10
        item[5] = 1500;     //신발     DEX +10
        item[6] = 1200;     //빵       HP +10
        item[7] = 900;      //책       INT +10

        item_name[0] =  "좋은곡괭이/G G";
        item_name[1] =  "좋은신발/G S";
        item_name[2] =  "좋은책/G B";
        item_name[3] =  "좋은빵/G Br";
        item_name[4] =  "곡괭이?G";
        item_name[5] =  "신발/S";
        item_name[6] =  "빵/Br";
        item_name[7] =  "책/B";




        for (int t=0; t<=7; t++){
            check_item[t] =  true;
        }



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
        double INT = Int;   //입력값으로 재설정


        System.out.printf("%d %d %d %d \n", HP, (int) STR, (int) DEX, (int) INT); //초기 능력치 출력


        int N = scanner.nextInt();  //칸 수 입력
        gr_loc = new double[N];
        gr_wei = new double[N];

        int pit_num = 0;
        int ore_num = 0;
        int total_pit_num = 0;  //총 구덩이 판 횟수
        int total_ore_num = 0;  //총 광석 판 횟수
        int total_mon = 0;      //광석 판매 금액
        int total_spend = 0;    //총 지출금액


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



            for (int j=0; j<=7; j++) {
                if (check_item[j]) {

                    if (total_mon >= item[j]){


                        switch (j) {                // 능력치 조정
                            case 0 -> { //좋은곡괭이 STR MAX

                                STR = 100;
                                total_mon -= item[j];       // 지출
                                total_spend += item[j];     // 지출합
                                check_item[j] = false;      // 팔림
                                System.out.println(" 0팔림");
                                break;
                            }
                            case 1 -> { //좋은신발  DEX MAX

                                DEX = 100;
                                total_mon -= item[j];       // 지출
                                total_spend += item[j];     // 지출합
                                check_item[j] = false;      // 팔림
                                System.out.println(" 1팔림");

                                break;
                            }
                            case 2 -> { //좋은책   INT MAX
                                INT = 100;
                                total_mon -= item[j];       // 지출
                                total_spend += item[j];     // 지출합
                                check_item[j] = false;      // 팔림
                                System.out.println(" 2팔림");
                                break;
                            }
                            case 3 -> { //좋은빵   HP +50
                                if(HP != 100) {
                                    HP += 50;
                                    if (HP >=100){
                                        HP = 100;
                                    }
                                    total_mon -= item[j];       // 지출
                                    total_spend += item[j];     // 지출합
                                    check_item[j] = false;      // 팔림
                                    System.out.println(" 3팔림");
                                }
                                break;
                            }
                            case 4 -> { //곡괭이   STR +10
                                if(STR !=100){
                                    STR += 10;
                                    total_mon -= item[j];       // 지출
                                    total_spend += item[j];     // 지출합
                                    check_item[j] = false;      // 팔림
                                    System.out.println(" 4팔림");
                                }
                                break;
                            }
                            case 5 -> { //신발     DEX +10
                                if(DEX != 100){
                                    DEX += 10;
                                    total_mon -= item[j];       // 지출
                                    total_spend += item[j];     // 지출합
                                    check_item[j] = false;      // 팔림
                                    System.out.println(" 5팔림");
                                }
                                break;
                            }
                            case 6 -> { //빵       HP +10
                                if(HP != 100){
                                    HP += 10;
                                    if (HP >=100){
                                        HP = 100;
                                    }
                                    total_mon -= item[j];       // 지출
                                    total_spend += item[j];     // 지출합
                                    check_item[j] = false;      // 팔림
                                    System.out.println(" 6팔림");
                                }
                                break;
                            }
                            case 7 -> { //책       INT +10
                                if(INT != 100){
                                    INT += 10;
                                    total_mon -= item[j];       // 지출
                                    total_spend += item[j];     // 지출합
                                    check_item[j] = false;      // 팔림
                                    System.out.println(" 7팔림");
                                }
                                break;
                            }
                        }


                    }

                }
            }



        }

        System.out.println(total_mon+total_spend);

        for (int i=0; i<=7; i++){
            if (!check_item[i]){
                System.out.print(item_name[i]+" ");
            }
        }

        System.out.print(total_spend+"\n");
        System.out.println(HP + " " + (int) STR + " " + (int) DEX + " " + (int) INT);
        System.out.print((int) (STR + DEX + INT) );
        System.out.print(" +("+ (int)(STR+DEX+INT-Str-Dex-Int) +")");
        System.out.print(" " + total_pit_num + " " + total_ore_num+"\n");
        System.out.println(total_mon);


    }



}