package q3;

import java.util.ArrayList;

public class Main {
    public static void removeInteger(ArrayList<Integer> arrayList){
        for (int i=0;i< arrayList.size()-1; i+=2){
            if (arrayList.get(i)< arrayList.get(i+1)){
                arrayList.remove(1+i);
                arrayList.remove(i);
                i-=2;
            }
        }
        if (arrayList.size()%2 !=0){
            arrayList.remove(arrayList.size()-1);
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(3);
        arrayList.add(6);
        arrayList.add(5);
        arrayList.add(8);
        arrayList.add(5);
        arrayList.add(5);
        arrayList.add(2);
        arrayList.add(9);
        arrayList.add(7);
        arrayList.add(3);

        System.out.println(arrayList);
removeInteger(arrayList);
        System.out.println(arrayList);
    }


}
