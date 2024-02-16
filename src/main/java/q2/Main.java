package q2;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();


        ArrayList<Character> arrayList=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            char c = (char) (rand.nextInt(26) + 'a');
            arrayList.add(c);
        }
        System.out.println(arrayList);

        ArrayList<Character> arrayList1=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            char ca = (char) (rand.nextInt(26) + 'a');
            arrayList1.add(ca);
        }
        System.out.println(arrayList1);
        System.out.println(unionArr(arrayList,arrayList1));
        System.out.println(subscriptionArr(arrayList,arrayList1));
    }
    public static ArrayList unionArr(ArrayList arrayList,ArrayList arrayList1){
        ArrayList<Character> arrayList2=new ArrayList<>();
        for (Object item:arrayList) {
            arrayList2.add((Character) item);
        }
        for (Object item:arrayList1) {
            arrayList2.add((Character) item);
        }
        return arrayList2;
    }
    public static ArrayList subscriptionArr(ArrayList arrayList,ArrayList arrayList1){
        ArrayList<Character> arrayList2=new ArrayList<>();
        for (Object item:arrayList) {
            for (Object item2:arrayList1) {
                if (item.equals(item2))
                    arrayList2.add((Character) item);
            }
        }
        return arrayList2;
    }
}
