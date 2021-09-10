public class GoatLatin {
    public String toGoatLatin(String sentence) {
        String[] all= sentence.split(" ");
        
        for(int i=0;i<all.length;i++){
            if(all[i].charAt(0)=='a'|| all[i].charAt(0)=='e'||all[i].charAt(0)=='i'||all[i].charAt(0)=='o'||all[i].charAt(0)=='u'
            ||all[i].charAt(0)=='A'||all[i].charAt(0)=='E'||all[i].charAt(0)=='I'||all[i].charAt(0)=='O'||all[i].charAt(0)=='U'
            )
            {
                    all[i]+="ma";
            }
            else{
                String temp = all[i].substring(1);
                all[i] = temp+all[i].charAt(0)+"ma";
            }
            int c=0;
            while(c<=i){
                all[i]+='a';
                c++;
            }
        }
        String ans="";
        for(int i=0;i<all.length;i++){
            if(i==all.length-1)
            ans+=all[i];
            else
            ans+=all[i]+" ";
        }
        return ans;
    }
}
