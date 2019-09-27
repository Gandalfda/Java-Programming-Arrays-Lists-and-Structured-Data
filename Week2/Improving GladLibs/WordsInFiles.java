import java.util.*;
import java.io.*;
import edu.duke.*;

class WordsInFiles
{
    private HashMap <String,ArrayList<String>> map;
    
    public WordsInFiles()
    {
        map=new HashMap <String,ArrayList<String>>();
    }
    
    private void addWordsFromFile(File file)
    {
        FileResource fr = new FileResource(file);
        String fileName = file.getName();
            for (String word : fr.words()) 
            {
            if (!map.containsKey(word)) 
            {
                ArrayList<String> newList = new ArrayList<String>();
                newList.add(fileName);
                map.put(word, newList);
            } 
            else if (map.containsKey(word)
                    && !map.get(word).contains(fileName)) 
                    {
                ArrayList<String> currentList = map.get(word);
                currentList.add(fileName);
                map.put(word, currentList);
            }
        }
    }
    
    private void buildWordFileMap()
    {
        map.clear();
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
            addWordsFromFile(f);
        }
    }
    
    private int maxNumber()
    {
        int max=0,currSize=0;
        for(String s : map.keySet())
        {
            ArrayList<String> list = map.get(s);
            currSize= list.size();
            if(currSize>max)
                max=currSize;
        }
        return max;
    }
    
    private int maxAppearance(int n)
    {
        int counter=0,currSize=0;
        for(String s : map.keySet())
        {
            ArrayList<String> list = map.get(s);
            currSize= list.size();
            if(currSize==n)
                counter++;
        }
        return counter;
    }
    
    private void totalWords()
    {
        int total=0;
        for(String s : map.keySet())
        {
            ArrayList <String> list = map.get(s);
            total+=list.size();
        }
        System.out.println("Total Words in the files were "+total);
    }
    
    private ArrayList wordsInNumFiles(int number)
    {
        ArrayList<String> name = new ArrayList<String>();
        int counter=0;
        for(String s : map.keySet())
        {
            ArrayList list = map.get(s);
            int currSize = list.size();
            if(currSize == number)
            {
                name.add(s);
                counter++;
            }
        }
        System.out.println("Words that appear in "+number+" files are"
        +counter);
        return name;
    }
    
    private void printFilesIn (String word)
    {
        ArrayList<String> fileNames = map.get(word);
        for (int index = 0; index < fileNames.size(); index++) 
        {
            System.out.println(fileNames.get(index));
        }
    }
    
    public void tester ()
    {
        buildWordFileMap();
        int max= maxNumber();
        totalWords();
        /**int count = maxAppearance(4);
        ArrayList <String> list = wordsInNumFiles(count);
        System.out.println("Number of appearance were "+count);
        for(String s : list)
        {
            printFilesIn(s);
        }**/
        ArrayList <String> list2 = wordsInNumFiles(max);
        System.out.println("The maximum time of occurence was of "+max);
        for(String s : list2)
        {
            System.out.print("The word "+s+ " was found in the following files");
            printFilesIn(s);
        }
    }
}