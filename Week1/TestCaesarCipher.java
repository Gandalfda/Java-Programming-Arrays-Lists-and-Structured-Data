import edu.duke.*;
class TestCaesarCipher
{
    int[] countLetters(String s)
    {
        int arr[]=new int[26];
        String alpha="abcdefghijklmnopqrstuvwxyz";    
        for(int i =0;i<s.length();i++)
        {
            char ch=Character.toLowerCase(s.charAt(i));
            if(alpha.indexOf(ch)!=-1)
                {//System.out.println(alpha.indexOf(ch));
                    arr[alpha.indexOf(ch)]++;
            }
        }
        return arr;
    }
    int maxIndex(int arr[])
    {
        int max=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>arr[max])
                max=i;
        }
        return max;
    }
    void simpleTests()
    {
        FileResource fr= new FileResource();
        int key=2;
        CaesarCipher cc1= new CaesarCipher(key);
        System.out.println("Encrypted string is "+cc1.encrypt(fr.asString()));
        System.out.println("Decrypted string is "+breakCaesarCipher(cc1.encrypt(fr.asString())));
    }
    String breakCaesarCipher(String input)
    {
        int arr[]=countLetters(input);
        int max=maxIndex(arr);
        int key=max-4;
        if(max<4)
            key=26-(4-max);
        CaesarCipher cc = new CaesarCipher(26-key);
        return cc.encrypt(input);
    }
}