class Solution {
    public boolean repeatedSubstringPattern(String s) {
          int n=s.length();
        for(int i=1;i<=n/2;i++){
            if(n%i==0){
                String sub=s.substring(0,i);
                String ans="";
                while(ans.length()<n){
                    ans+=sub;
                }
                if(ans.equals(s)){
                    return true;
                }
            }
        }
        return false;
    }
}