import edu.duke.*;
import java.util.ArrayList;
class CharactersInPlay
{
    private ArrayList<String> names;
    private ArrayList<Integer> freq;
    
    public CharactersInPlay()
    {
        names=new ArrayList<String>();
        freq=new ArrayList<Integer>();
    }
    
    private void update(String person)
    {
        int n,index=names.indexOf(person);
        if(index==-1)
            {
                names.add(person);
                freq.add(1);
            }
        else
        {
            n=freq.get(index);
            freq.set(index,++n);
        }
    }
    
    private void findAllCharacters()
    {
        FileResource fr= new FileResource();
        int index;
        for(String str: fr.lines())
        {
            index=str.indexOf('.');
            if(index!=-1)
            {
                str=str.substring(0,index);
                update(str);
            }
        }
    }
    
    public void tester()
    {
        findAllCharacters();
        charactersWithNumParts(10,15);
        int maxIndex=findMax();
        System.out.println("The character with most speaking parts: "+names.get(maxIndex)
        +"\t"+freq.get(maxIndex));
    }
    
    private int findMax()
    {
        int maxIndex=0;
        for(int i=0;i<names.size();i++)
        {
            if(freq.get(i)>freq.get(maxIndex))
                maxIndex=i;
        }
        return maxIndex;
    }
    
    private void charactersWithNumParts(int num1, int num2)
    {
        System.out.println("Characters with the between"+num1+" & "+num2);
        for(int i=0;i<names.size();i++)
            if(freq.get(i)>=num1 && freq.get(i)<=num2)
                System.out.println(names.get(i)+"\t"+freq.get(i));
    }
}