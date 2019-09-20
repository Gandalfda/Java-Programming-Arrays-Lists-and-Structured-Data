import edu.duke.*;
class TestCaesarCipherTwo
{
    String alpha="abcdefghijklmnopqrstuvwxyz"; 
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
    String halfOfString(String message,int start)
    {
        String half="";
        for(int i=0;i<(message.length()-start);i+=2)
        {
            half=half+message.charAt(start+i);
        }
        return half;
    }
    void simpleTests()
    {
        FileResource fr= new FileResource();
        CaesarCipherTwo cct= new CaesarCipherTwo(17,3);
        //String encrypted = cct.encrypt(fr.asString());
        //System.out.println("Encrypted String is "+encrypted);
        String decrypted = breakCaesarCipher(fr.asString());
        System.out.println("Decrypted String is "+decrypted);
    }
    String breakCaesarCipher(String input)
    {
        String firstHalf=halfOfString(input,0);
        String secondHalf=halfOfString(input,1);
        int arr1[]=countLetters(firstHalf);
        int max1=maxIndex(arr1);
        int arr2[]=countLetters(secondHalf);
        int max2=maxIndex(arr2);
        int key1=max1-4;
        if(max1<4)
            key1=26-(4-max1);
        int key2=max2-4;
        if(max2<4)
            key2=26-(4-max2);
        CaesarCipherTwo cct=new CaesarCipherTwo(key1,key2);
        System.out.println("keys are "+key1+" "+key2);
        return cct.decrypt(input);
    }
}