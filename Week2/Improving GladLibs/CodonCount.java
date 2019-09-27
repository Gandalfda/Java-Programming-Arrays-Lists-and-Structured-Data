import java.util.*;
import edu.duke.*;
class CodonCount
{
    private HashMap <String,Integer> map;
    
    public CodonCount()
    {
        map= new HashMap<String, Integer>();        
    }
    private void buildCodonMap(int start,String dna)
    {
        map.clear();
        for(int i=start;i+3<dna.length();i+=3)
        {
            String str = dna.substring(i,i+3);
            if(map.containsKey(str))
            {
                map.put(str,map.get(str)+1);
            }
            else
            {
                map.put(str,1);
            }
        }
    }
    private String getMostCommonCodon()
    {
        int max=0;
        String maxOccurence="";
        for(String s:map.keySet())
        {
            if(map.get(s)>max)
            {
                max=map.get(s);
                maxOccurence=s;
            }
        }
        return maxOccurence;
    }
    private void printCodonCounts(int start, int end)
    {
        for(String s:map.keySet())
        {
            if(map.get(s)>start && map.get(s)<end)
                System.out.println(s+"\t"+map.get(s));
        }
        System.out.println("Total codons were "+map.size());
    }
    public void tester()
    {
        FileResource fileResource = new FileResource();
        String dna = fileResource.asString();
        dna = dna.toUpperCase();
        for (int index = 0; index <= 2; index++) {
            System.out.println("\nTesting with start position " + index + ":\n");
            buildCodonMap(index, dna);
            String mostCommonCodon = getMostCommonCodon();
            System.out.println("Total unique codons found: " + map.size());
            System.out.println("\nMost common codon: " + mostCommonCodon
                    + "\t" + map.get(mostCommonCodon));
            printCodonCounts(4, 8);
        }
    }
}