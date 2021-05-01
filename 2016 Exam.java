//Question 1

public class RandomStringChooser{
	
	private ArrayList<String> wordsList = new ArrayList<String>();
	
	public RandomStringChooser(String[] wordArr){
		for(String w : wordArr){
			wordsList.add(w);
		}
	}
	
	public String getNext(){
		if(wordsList.size > 0) return wordsList.remove((int) (Math.random() * wordsList.size());
		return "NONE";
	}

}



public RandomLetterChooser(String str){
	super(getSingleLetters(str));
}

//Question 2

public LogMessage(String message){
	machineId = message.substring(0, message.indexOf(":"));
	description = message.substring(message.indexOf(":") + 1);
}

public boolean containsWord(String keyword){
	if(description.indexOf(keyword) != -1){
		if(description.equals(keyword)) return true;
		if(description.indexOf(" " + keyword + " ") != -1) return true;
		if(description.indexOf(keyword + " ") == 0) return true;
		if(keyword.length() < description.length){
			if(description.indexOf(" " + keyword) == description.length() - keyword.length() - 1);
		}
	}
	return false;
}

public List<LogMessage> removeMessages(String keyword){
	ArrayList<LogMessage> ret = new ArrayList<LogMessage>();
	for(int i = 0; i < messageList.size(); i++){
		if(messageList.get(i).containsWord(keyword)){
			ret.add(messageList.remove(i));
			i--;
		}
	}
	return ret;
}

//Question 3

private boolean toBeLabeled(int r, int c, boolean[][] blackSquares){
	if(blackSquares[r][c] == true) return false;
	if(r == 0 || c == 0) return true;
	else{
		if(blackSquares[r-1][c] == true || blackSquares[r][c-1] == true) return true;
	}
	return false;
}

public Crossword(boolean[][] blackSquares){
	puzzle = new Square[blackSquares.length][blackSquares[0].length];
	int count = 1;
	for(int r = 0; r < blackSquares.length; r++){
		for(int c = 0; c < blackSquares[0].length; c++){
			if(blackSquares[r][c]) puzzle[r][c] = new Square(true, 0);
			else if(toBeLabeled(r,c,blackSquares)){
				puzzle[r][c] = new Square(false, index);
				index++;
			}
			else if(!toBeLabeled(r,c,blackSquares)) puzzle[r][c] = new Square(false, 0);
		}
	}
}


//Question 4

public static int totalLetters(List<String> wordList){
	int sum = 0;
	for(String s : wordList){
		sum += s.length();
	}
	return sum;
}

public static int basicGapWidth(List<String> wordList, int formattedLen){
	int words = totalLetters(wordList);
	return (fomattedLen - words) / (wordList.size()-1);
}

public static String format(List<String> wordList, int formattedLen){
	int left = leftoverSpaces(wordList, fomattedLen);
	int gap = basicGapWidth(wordList, fomattedLen);
	String ret = "";
	for(int i = 0; i < wordList.size()-1; i++){
		ret += wordList.get(i);
		for(int g = 0; g < gap; g++){
			ret += " ";
		}
		if(left > 0){
			ret += " ";
			left--;
		}
	}
	ret += wordList.get(wordList.size()-1);
	return ret;
}