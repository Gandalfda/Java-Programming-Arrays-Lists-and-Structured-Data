class Assignment1
{
    boolean isVowel (char ch)
    {
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
            return true;
        return false;
    }
    String replaceVowels(String phrase,char ch)
    {
        StringBuilder str=new StringBuilder(phrase);
        for(int i=0;i<str.length();i++)
        {
            if(isVowel(phrase.charAt(i)))
                str.setCharAt(i,ch);
        }
        return str.toString();
    }
    String emphasize(String phrase,char ch)
    {
        StringBuilder str=new StringBuilder(phrase);
        for(int i=0;i<str.length();i++)
        {
            if(phrase.charAt(i)==ch)
            {
                if(i%2==0)
                    str.setCharAt(i,'*');
                else
                    str.setCharAt(i,'+');
            }
        }
        return str.toString();
    }
}