import edu.duke.*;
class CaesarCipherTwo
{
    private String alphabet,shiftedAlphabet1,shiftedAlphabet2;
    private int mainKey1,mainKey2;
    public CaesarCipherTwo(int key1,int key2)
    {
        alphabet="abcdefghijklmnopqrstuvwxyz";
        mainKey1=key1;
        mainKey2=key2;
        shiftedAlphabet1=alphabet.substring(key1)+alphabet.substring(0,key1);
        shiftedAlphabet2=alphabet.substring(key2)+alphabet.substring(0,key2);        
    }
    String encrypt(String input)
    {
        StringBuilder str = new StringBuilder(input);
        int flag=0;
        for(int i=0;i<str.length();i+=2)
        {
            char ch=str.charAt(i);
            if(Character.isUpperCase(ch)) 
                flag=1;
            ch=Character.toLowerCase(ch);
            if(shiftedAlphabet1.indexOf(ch)!=-1)
            {
                int xr=alphabet.indexOf(ch);
                if(flag==0)
                    str.setCharAt(i,shiftedAlphabet1.charAt(xr));
                else 
                    str.setCharAt(i,Character.toUpperCase(shiftedAlphabet1.charAt(xr)));
            }
            flag=0;
        }
        for(int i=1;i<str.length();i+=2)
        {
            char ch=str.charAt(i);
            if(Character.isUpperCase(ch)) 
                flag=1;
            ch=Character.toLowerCase(ch);
            if(shiftedAlphabet2.indexOf(ch)!=-1)
            {
                int xr=alphabet.indexOf(ch);
                if(flag==0)
                    str.setCharAt(i,shiftedAlphabet2.charAt(xr));
                else 
                    str.setCharAt(i,Character.toUpperCase(shiftedAlphabet2.charAt(xr)));
            }
            flag=0;
        }
        return str.toString();
    }
    String decrypt(String input)
    {
        CaesarCipherTwo ccp= new CaesarCipherTwo(26-mainKey1,26-mainKey2);
        return ccp.encrypt(input);        
    }
}