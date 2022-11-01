

/*
�߰����� 3 Dig, Work, Sell, Buy
202001606, ����, Dragonholic
�ۼ���: 2022-11-01
*/



import java.util.Scanner;


public class Midproject {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] gr_loc;   //������ġ
        double[] gr_wei;   //���差
        int[] item; // ������ ���� �迭
        String[] item_name; //������ ���� �迭
        boolean[] check_item; // ������ ��� Ȯ��;





        item = new int[8];
        check_item = new boolean[8];
        item_name = new String[8];



        item[0] = 15000;    //������� STR MAX
        item[1] = 14000;    //�����Ź�  DEX MAX
        item[2] = 8000;     //����å   INT MAX
        item[3] = 5000;     //������   HP +50
        item[4] = 1800;     //���   STR +10
        item[5] = 1500;     //�Ź�     DEX +10
        item[6] = 1200;     //��       HP +10
        item[7] = 900;      //å       INT +10

        item_name[0] =  "�������";
        item_name[1] =  "�����Ź�";
        item_name[2] =  "����å";
        item_name[3] =  "������";
        item_name[4] =  "���";
        item_name[5] =  "�Ź�";
        item_name[6] =  "��";
        item_name[7] =  "å";




        for (int t=0; t<=7; t++){
            check_item[t] =  true;
        }



        int Hp = 100;
        int Str = 25;
        int Dex = 25;
        int Int = 25;   // �� �ʱ�ȭ


        if (args.length != 0) {
            Hp = Integer.parseInt(args[0]);
            Str = Integer.parseInt(args[1]);
            Dex = Integer.parseInt(args[2]);
            Int = Integer.parseInt(args[3]);        // arg�� ���� ������� ����
        }


        int HP = Hp;
        double STR = Str;
        double DEX = Dex;
        double INT = Int;   //�Է°����� �缳��


        System.out.printf("%d %d %d %d \n", HP, (int) STR, (int) DEX, (int) INT); //�ʱ� �ɷ�ġ ���


        int N = scanner.nextInt();  //ĭ �� �Է�
        gr_loc = new double[N];
        gr_wei = new double[N];

        int pit_num = 0;
        int ore_num = 0;
        int total_pit_num = 0;  //�� ������ �� Ƚ��
        int total_ore_num = 0;  //�� ���� �� Ƚ��
        int total_mon = 0;      //���� �Ǹ� �ݾ�
        int total_spend = 0;    //�� ����ݾ�


        for (int i = 0; i < N; i++) {                      //���ı�
            gr_loc[i] = scanner.nextInt();
            gr_wei[i] = scanner.nextInt();

            if (gr_loc[i] > 1000 || gr_wei[i] > 1000) {
                System.out.print("\n");
                System.out.println("-1" );
                System.exit(-1);
            }   //1km, 1�� �ʰ��� Ż��


            pit_num = (int) Math.ceil(gr_loc[i] / DEX);
            ore_num = (int) Math.ceil(gr_wei[i] / STR);

            total_pit_num += pit_num; // i�� �����̸� ��� �ʹ��� += ��ü��
            total_ore_num += ore_num; // i�� ������ ��� ĺ����  += ��ü��
            total_mon += gr_wei[i] * 1000;

            HP -= (pit_num + ore_num) * (100 / INT);

            if (HP <= 0) {
                System.out.print("\n");
                System.out.println("-1");
                System.exit(-1);
            } // HP�� �����Ϸ� �������� Ż��



            for (int j=0; j<=7; j++) {
                if (check_item[j]) {

                    if (total_mon >= item[j]){


                        switch (j) {                // �ɷ�ġ ����
                            case 0 -> { //������� STR MAX

                                STR = 100;
                                total_mon -= item[j];       // ����
                                total_spend += item[j];     // ������
                                check_item[j] = false;      // �ȸ�
                                break;
                            }
                            case 1 -> { //�����Ź�  DEX MAX

                                DEX = 100;
                                total_mon -= item[j];       // ����
                                total_spend += item[j];     // ������
                                check_item[j] = false;      // �ȸ�

                                break;
                            }
                            case 2 -> { //����å   INT MAX
                                INT = 100;
                                total_mon -= item[j];       // ����
                                total_spend += item[j];     // ������
                                check_item[j] = false;      // �ȸ�
                                break;
                            }
                            case 3 -> { //������   HP +50
                                if(HP != 100) {
                                    HP += 50;
                                    if (HP >=100){
                                        HP = 100;
                                    }
                                    total_mon -= item[j];       // ����
                                    total_spend += item[j];     // ������
                                    check_item[j] = false;      // �ȸ�
                                }
                                break;
                            }
                            case 4 -> { //���   STR +10
                                if(STR !=100){
                                    STR += 10;
                                    total_mon -= item[j];       // ����
                                    total_spend += item[j];     // ������
                                    check_item[j] = false;      // �ȸ�
                                }
                                break;
                            }
                            case 5 -> { //�Ź�     DEX +10
                                if(DEX != 100){
                                    DEX += 10;
                                    total_mon -= item[j];       // ����
                                    total_spend += item[j];     // ������
                                    check_item[j] = false;      // �ȸ�
                                }
                                break;
                            }
                            case 6 -> { //��       HP +10
                                if(HP != 100){
                                    HP += 10;
                                    if (HP >=100){
                                        HP = 100;
                                    }
                                    total_mon -= item[j];       // ����
                                    total_spend += item[j];     // ������
                                    check_item[j] = false;      // �ȸ�
                                }
                                break;
                            }
                            case 7 -> { //å       INT +10
                                if(INT != 100){
                                    INT += 10;
                                    total_mon -= item[j];       // ����
                                    total_spend += item[j];     // ������
                                    check_item[j] = false;      // �ȸ�
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