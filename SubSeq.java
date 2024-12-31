package Recursion;

import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
        //subseq("","abc");
        //skip("","baccad");
        //subseqAscii("","abc");
        System.out.println(subseqAsciiRet("","abc"));
    }
    static void subseq(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        //two recursion call  you can add it or ignore it
        subseq(p+ch, up.substring(1));
        subseq(p,up.substring(1));
    }
    // subsequence return using arraylist
    static ArrayList<String> subseqRet(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        //two recursion call - you can add it or ignore it
        ArrayList<String> left = subseqRet(p+ch, up.substring(1));
        ArrayList<String> right = subseqRet(p,up.substring(1));

        left.addAll(right);
        return left; // you can return left or right because both will return same after adding
    }
    static void subseqAscii(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        //two recursion call  you can add it or ignore it
        subseqAscii(p+ch, up.substring(1));
        subseqAscii(p,up.substring(1));
        subseqAscii(p + (ch+0),up.substring(1));
    }
    static ArrayList<String> subseqAsciiRet(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        //two recursion call - you can add it or ignore it
        ArrayList<String> first = subseqAsciiRet(p+ch, up.substring(1));
        ArrayList<String> second = subseqAsciiRet(p,up.substring(1));
        ArrayList<String> third = subseqAsciiRet(p+(ch+0), up.substring(1));

        first.addAll(second);
        first.addAll(third);
        return first; // you can return first,second,third because all will return same after adding
    }

    // q) str="baccad , remove character 'a' from string using recursion
      static void skip(String p , String up){
            if(up.isEmpty()){
                System.out.println(p);
                return;
            }
            char ch = up.charAt(0);
            if(ch == 'a'){
                skip(p, up.substring(1));
            } else {
                skip(p+ch, up.substring(1));
            }
      }
}
