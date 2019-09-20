import edu.duke.*;
class CaesarCipherTwoKeyDecrypt
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
    String decrypt(String encrypted)
    {
        int arr[]=countLetters(encrypted);        
        int max=maxIndex(arr);
        int key=max-4;
        if(max < 4)
            key=26-(4-max);
        CaesarCipher cc = new CaesarCipher();
        String message = cc.encrypt(encrypted, 26 - key);
        return message;
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
    int getKey(String s)
    {
        int arr[]=countLetters(s);
        int max=maxIndex(arr);
        System.out.println("Key calculated is "+max);
        int key=max-4;
        if(max<4)
            key=26-(4-max);
        return key;
    }
    void decryptTwoKeys(String encrypted)
    {
        String FirstHalf=halfOfString(encrypted,0);
        String SecondHalf=halfOfString(encrypted,1);
        int key1=getKey(FirstHalf);
        int key2=getKey(SecondHalf);
        System.out.println(FirstHalf+"\n"+SecondHalf);
        System.out.println("Two keys are"+key1+" & "+key2);
        CaesarCipher ob = new CaesarCipher();
        String result=ob.encryptTwoKeys(encrypted,26-key1,26-key2);
        System.out.println( result);
    }
    void misc()
    {
        String str="Xifqvximt tsdtlxzrx iijirvtl ek Uybi afvbw",result="";
        CaesarCipher ob =new CaesarCipher();
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<25;j++)
            System.out.println(i+" "+j+" "+ob.encryptTwoKeys(str,i,j));
        }
    }
    /*void test()
    {
        String str="Xifqvximt tsdtlxzrx iijirvtl ek Uybi afvbw yehvv xyi gfqdse iekmfrrpzdrxzse fj xyi jzich sw tsdtlxrxzseec xifqvxic, fjkie xmmie zr xyi trwk, xyek klv nsipu rvfyeh yj zw xyvvi-hzqvrjmfrrp eeh ulijxzsew lfa xymekj zr xymj nsipu iiceki xf vetl sklvv eii melvvvrkpp xifqvximt. Xrov dsmmek e tzees xyvfyxl e hfsi-wvrqv rru gprremek e jcmxlk-gekl xyek rzfmuw gfpcmjmfrj nmkl sklvv ezvgprrvw ej kaf vbrqgpvw. Zx wyslpu klvvvjfvv esk jyitimji xyek tsdtlxzrx gvftvvkmvw esslx xyiji kvsdikvzg xymekj rru klvmi zrkiietxzse rvv tsdqfr-tceti eeh mdtfvkeex. Nlzpv klzw mj jxzpc r mecmu rvxydiex, ni afych pzov ks edieh xyek dsjx sw klv xifqvximt hyvwkmfrj giftci gfrtiir xyidwvpmij nmkl lrzv ks hf nmkl lfa xymekj rvv tservgkiu. Mk zw mdtfvkeex xyek ymxlnepw eii wljwmtmvrkpp jxiezkyx eeh wdsfxy ks wltgsix xyi himmmek sw wejx grvj, flx eesklvv ijwvrkmrp tisgiixp, aymtl av lwlecpp kebi jfv kieexvh, zw xyek ymxlnepw eii gfrkmeyfyj, mehviu tservgkmek E xf S, eeh rfx nlwk rtgvfbzqrxvpp. Xyi gfviijtfrumek wlfwmvpu fj gfqgykekmfrrp kvsdikvp zw swxvr vvjvviiu ks ej tsdtlxrxzseec ksgscsxc. R xsfh tfvkmfr sw fyi vjwsixj dep si gcejwzjziu ks fvpfrx ks xymj jysjzich eeh eii himmie sc egtcmtekmfrj zr e zrvzikc sw fxyii wmvpuw, klv gvvhzgkmfr sw klv jxiytxlvv fj jfpuiu gvfxvmew eeh xyi vvgfrjxiytxzse fj llqrr sikrrj sizrx kaf. Xyi lrpcqrvb fj slv afvb zw jrwk rpxsimkldw xyek zqgpvqvrk deklvqrxzgrp qfhvpj ks swjvv mewzkyxj zrks eeh eewniiw xf jytl ulijxzsew.";
        String result=decryptTwoKeys(str);
        System.out.println(result);
    }*/
}