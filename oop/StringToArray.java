package agh.ics.oop;

public class StringToArray {
    public String[] convert(String str){
        int l = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i)!=' '){
                l++;
            }
        }
        String[] result = new String[l];

        int j = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != ' '){
                result[j] = "" + str.charAt(i);
                j++;
            }
        }
        return result;
    }
}
