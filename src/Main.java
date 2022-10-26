import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] gr_loc;   //������ġ
        double[] gr_wei;   //���差

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
        double INT = Int;   //�� �ɷ�ġ ���� ����


        System.out.printf("%d %d %d %d \n", HP, (int) STR, (int) DEX, (int) INT); //�ʱ� �ɷ�ġ ���


        int N = scanner.nextInt();  //ĭ �� �Է�
        gr_loc = new double[N];
        gr_wei = new double[N];

        int pit_num = 0;
        int ore_num = 0;
        int total_pit_num = 0;  //�� ������ �� Ƚ��
        int total_ore_num = 0;  //�� ���� �� Ƚ��
        int total_mon = 0;  //���� �Ǹ� �ݾ�


        for (int i = 0; i < N; i++) {                      //���ı�
            gr_loc[i] = scanner.nextInt();
            gr_wei[i] = scanner.nextInt();

            if (gr_loc[i] > 1000 || gr_wei[i] > 1000) {
                System.out.print("\n");
                System.out.println("-1(1km �Ǵ� 1t�ʰ� )" + i + "°");
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
                System.out.println("-1(HP 0 ����)" + i + "��");
                System.exit(-1);
            } // HP�� �����Ϸ� �������� Ż��


        }


        System.out.println(HP + " " + (int) STR + " " + (int) DEX + " " + (int) INT);
        System.out.println((int) (STR + DEX + INT) + " " + total_pit_num + " " + total_ore_num);
        System.out.println(total_mon);


    }
}