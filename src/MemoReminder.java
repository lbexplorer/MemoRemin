import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        ArrayList<String> text=new ArrayList<>();
        int[] number=new int[5];
        float f=0.0f;
        int i=0;
        System.out.println("请输入数字3个");
        while(scan.hasNextInt()){

            number[i++]=scan.nextInt();
            System.out.println(number[i-1]);
        }

        int Max=number[0];
        int y=1;
        for( y=1;y<number.length;y++){
            if(number[y]>Max){
                Max=number[y];
            }
        }
        System.out.println("最大值："+Max);

        //获取三个数的最大值

        System.out.println();
    }
}