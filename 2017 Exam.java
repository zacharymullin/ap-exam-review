//Question 1

public Digits(int num){
	digitList = new ArrayList<Integer>();
	if(num == 0) digitList.add(num);
	else{
		int i = num;
		while(i > 0){
			digitList.add(i % 10);
			i = i / 10;
		}
	}
}

public boolean isStrictlyIncreasing(){
	if(digitList.size() == 1) return true;
	int prevTerm = digitList.get(0);
	for(int i = 1; i < digitList.size(); i++){
		if(digitList.get(i) <= prevTerm) return false;
		prevTerm = digitList.get(i);
	}
	return true;
}

//Question 2

public class MultPractice{
	
	private int first, second;
	
	public MultPractice(int f, int s){
		first = f;
		second = f;
	}
	
	public String getProblem(){
		return first + " TIMES " + second;
	}
	
	public void nextProblem(){
		second++;
	}
}

//Question 3

public void replaceNthOccurrence (String str, int n, String repl){
	if(findNthOccurence(str, n) != -1){
		int index = findNthOccurence(str, n);
		currentPhrase = currentPhrase.substring(0,index) + repl + currentPhrase.substring(index+currentPhrase.length());
	}
}

public int findLastOccurrence(String str){
	int i = 0;
	int index = 0;
	while(index != -1){
		i++;
		index = findNthOccurence(str, i);
	}
	return findNthOccurence(str, i-1);
}

//Question 4

public static Position findPosition(int num, int[][] intArr){
	Position ret;
	for(int r = 0; r < intArr.length; r++){
		for(int c = 0; c < intArr[r].length; c++){
			if(intArr[r][c] == num){
				ret = new Position(r, c);
				return ret;
			}
		}
	}
	return null;
}

public static Position[][] getSuccessorArray(int[][] intArr){
	Position[][] ret = new Position[intArr.length][intArr[0].length];
	for(int r = 0; r < intArr.length; r++){
		for(int c = 0; c < intArr.length; c++){
			ret[r][c] = findPosition(intArr[r][c] + 1, intArr);
		}
	}
	return ret;
}