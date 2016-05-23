package instaBot;

public class Util {

    public static String generateId() {
        String str[] = {
                "a","A","1",
                "b","B","2",
                "c","C","3",
                "d","D","4",
                "e","E","5",
                "f","F","6",
                "g","G","7",
                "h","H","8",
                "i","I","9",
                "j","J","0",
                "k","K",
                "l","L",
                "m","M",
                "n","N",
                "o","O",
                "p","P",
                "r","R",
                "s","S",
                "t","T",
                "u","U",
                "v","V",
                "w","W",
                "x","X",
                "y","Y",
                "z","Z",
                "q","Q"};
    
    int i =0;
    String id="";
    while (i <8) {
        id = id + str[(int) Math.floor((str.length-1)*Math.random())];
        i++;
    }
return id;
}
}
