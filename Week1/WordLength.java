import edu.duke.*;
import java.io.*;
class WordLength
{
    void countWordLength(FileResource resource,int counts[])
    {
        int length;
        for(String word:resource.words())
        {
            length=word.length();
            if(!(Character.isLetter(word.charAt(0))))
                length--;
            if(!(Character.isLetter(word.charAt(word.length()-1))))
                length--;
            if(length!=-1)
            {
                if(length<counts.length )
                counts[length]++;
            else
                counts[counts.length-1]++;
            }
        }
    }
    int indexOfMax(int values[])
    {
        int max=0;
        for(int i=0;i<values.length;i++)
        {
            if(values[i]>values[max])
                max=i;
        }
        return max;
    }
    void testCountWordLength()
    {
        FileResource fr=new FileResource();
        int counts[]=new int[31];
        countWordLength(fr,counts);
        for(int i =0;i<counts.length;i++)
        {
            if(counts[i]!=0)
                System.out.println("The length at "+i+" is "+counts[i]);
        }
        int max=indexOfMax(counts);
        System.out.println("The max occurence is of length "+max);
    }
}