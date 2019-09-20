import edu.duke.*;
class CaesarCipher
{
    private String alphabet,shiftedAlphabet;
    private int mainKey;
    public CaesarCipher(int key)
    {
        alphabet="abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet=alphabet.substring(key)+alphabet.substring(0,key);
        mainKey=key;
    }
    String encrypt(String input)
    {
        StringBuilder str = new StringBuilder(input);
        for (int i=0;i<input.length();i++)
        {
            char ch=Character.toLowerCase(input.charAt(i));
            if(alphabet.indexOf(ch)!=-1)
                str.setCharAt(i,shiftedAlphabet.charAt(alphabet.indexOf(ch)));
        }
        return str.toString();
    }
    String decrypt (String input)
    {
        CaesarCipher cc = new CaesarCipher(26-mainKey);
        return cc.encrypt(input);
    }
}