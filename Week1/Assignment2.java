import edu.duke.*;
class Assignment2
{
    String encrypt(String input,int key)
    {
        int flag=0;
        String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String crypt=alpha.substring(key)+alpha.substring(0,key);
        StringBuilder str=new StringBuilder(input);
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(Character.isUpperCase(ch)) 
                flag=1;
            ch=Character.toUpperCase(ch);
            if(crypt.indexOf(ch)!=-1)
            {
                int xr=alpha.indexOf(ch);
                if(flag==0)
                    str.setCharAt(i,Character.toLowerCase(crypt.charAt(xr)));
                else 
                    str.setCharAt(i,crypt.charAt(xr));
            }
            flag=0;
        }
            return str.toString();
    }
    void testCaesar()
    {
        int key=25;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
    }
    String encryptTwoKeys(String input,int key1,int key2)
    {
        String str="";
        String encrypted="";
        for(int i=0;i<input.length();i++)
        {
            if(i%2==0)
                encrypted=encrypt(input.substring(i,i+1),key1);
            else
                encrypted=encrypt(input.substring(i,i+1),key2);
            str=str+encrypted;            
        }
        return str;
    }
    String encryptTwoKeysSB(String input,int key1,int key2)
    {
        int flag=0;
        StringBuilder str=new StringBuilder(input);
        String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String crypt1=alpha.substring(key1)+alpha.substring(0,key1);
        String crypt2=alpha.substring(key2)+alpha.substring(0,key2);
        for(int i=0;i<str.length();i+=2)
        {
            char ch=str.charAt(i);
            if(Character.isUpperCase(ch)) 
                flag=1;
            ch=Character.toUpperCase(ch);
            if(crypt1.indexOf(ch)!=-1)
            {
                int xr=alpha.indexOf(ch);
                if(flag==0)
                    str.setCharAt(i,Character.toLowerCase(crypt1.charAt(xr)));
                else 
                    str.setCharAt(i,crypt1.charAt(xr));
            }
            flag=0;
        }
        for(int i=1;i<str.length();i+=2)
        {
            char ch=str.charAt(i);
            if(Character.isUpperCase(ch)) 
                flag=1;
            ch=Character.toUpperCase(ch);
            if(crypt2.indexOf(ch)!=-1)
            {
                int xr=alpha.indexOf(ch);
                if(flag==0)
                    str.setCharAt(i,Character.toLowerCase(crypt2.charAt(xr)));
                else 
                    str.setCharAt(i,crypt2.charAt(xr));
            }
            flag=0;
        }
        return str.toString();
    }
}
