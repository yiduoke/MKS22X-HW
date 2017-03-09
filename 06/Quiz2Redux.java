import java.util.*;
public class Quiz2Redux{  

  public static ArrayList<String> combinations(String s){
      ArrayList<String>words = new ArrayList<String>();
      help(s, words, 0, "");
      Collections.sort(words);
      return words;
  }
  
    private static void help(String s, ArrayList<String> words, int index, String current) {
	if (index==s.length()){words.add(current);}
	else{
	    help(s,words,index+1,current+s.charAt(index));
	    help(s,words,index+1,current);
	}
  }
}

