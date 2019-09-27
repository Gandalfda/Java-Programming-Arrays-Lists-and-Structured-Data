import java.util.*;
import edu.duke.*;
class GladLibMap
{
    private ArrayList<String> tracker;
    private HashMap <String,ArrayList<String>>myMap;
    private ArrayList<String> usedLabels ;
    
    private Random myRandom;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    private int counter=0;
    
    public GladLibMap(){
        myRandom = new Random();
        myMap= new HashMap <String,ArrayList<String>>();
        tracker=new ArrayList<String>();
        usedLabels = new ArrayList<String>();
        initializeFromSource(dataSourceDirectory);
    }
    
    public GladLibMap(String source){
        myRandom = new Random();
        myMap= new HashMap <String,ArrayList<String>>();
        tracker=new ArrayList<String>();
        usedLabels = new ArrayList<String>();
        initializeFromSource(source);
    }
    
    private void initializeFromSource(String source) {
        String label[] = {"adjective","noun","color","country",
            "name","animal","timeframe","verb","fruit"};
        for(String s : label)
        {
            ArrayList currList = readIt(source+"/"+s+".txt");
            myMap.put(s,currList);
        }
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        addUsedLabel(label);
        if(myMap.containsKey(label))
        {
            return randomFrom(myMap.get(label));
        }
        return "**UNKNOWN**";
    }
    
    private void addUsedLabel(String label)
    {
        if(!usedLabels.contains(label))
            usedLabels.add(label);
    }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        while(tracker.indexOf(sub)!=-1)
        {
            sub=getSubstitute(w.substring(first+1,last));
        }
        tracker.add(sub);
        counter++;
        return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
        System.out.print("\nThe number of words replaced are "+counter);
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    private int totalWordsInMap()
    {
        int sum=0;
        for(String s : myMap.keySet())
        {
            ArrayList list = myMap.get(s);
            sum+=list.size();
        }
        return sum;
    }
    
    private int totalWordsConsidered()
    {
        int sum=0;
        for(String s : usedLabels)
        {
            ArrayList<String> list = myMap.get(s);
            sum+=list.size();
        }
        return sum;
    }
    
    public void makeStory(){
        tracker.clear();
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate2.txt");
        printOut(story, 60);
        int wordsInMap = totalWordsInMap();
        int wordsConsidered = totalWordsConsidered();
        System.out.println("\nTotal words in the map were "+wordsInMap+
        "\nTotal words considered for replacement were "+wordsConsidered+
        "\nand the labels considered were" );
        for(String s : usedLabels)
        {
            System.out.println(s);
        }
    }
    
}