import java.util.ArrayList;
import edu.duke.*;
class MostFrequencies
{
    private ArrayList<String> myWords;
    private ArrayList<Integer>myFreqs;
    public MostFrequencies()
    {
        myWords=new ArrayList<String>();
        myFreqs=new ArrayList<Integer>();
    }
    private void findUnique()
    {
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        int index,n;
        for(String str:fr.words())
        {
            index=myWords.indexOf(str.toLowerCase());
            if(index==-1)
            {
                myWords.add(str.toLowerCase());
                myFreqs.add(1);
            }
            else
            {
                n=myFreqs.get(index);
                myFreqs.set(index,++n);
            }
        }
    }
    public void tester()
    {
        findUnique();
        System.out.println("Number of unique words are "+myWords.size());
        for(int i =0;i<myWords.size();i++)
            System.out.println(myWords.get(i)+"\t"+myFreqs.get(i));
        int maxIndex=findIndexOfMax();
        System.out.println("The most frequent word is "+myWords.get(maxIndex)+" and the frequency is "+myFreqs.get(maxIndex));
    }
    private int findIndexOfMax()
    {
        int maxIndex=0;
        for(int i=0;i<myWords.size();i++)
        {
            if(myFreqs.get(i)>myFreqs.get(maxIndex))
                maxIndex=i;
        }
        return maxIndex;
    }
}