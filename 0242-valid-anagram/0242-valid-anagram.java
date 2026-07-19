class Solution {
    public boolean isAnagram(String s, String t) {
             boolean isAnagram=true;
        if(s.length()!=t.length()){
            return false;
        }
        int[]freq=new int[256];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)]++;
            freq[t.charAt(i)]--;
        }
        for(int i=0;i<256;i++){
            if(freq[i]!=0){
                isAnagram=false;
                break;
            }
        }
        if(isAnagram){
            return true;
        }else
            return false;
    }
}