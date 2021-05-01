//Question 1

public static int arraySum(int[] arr){
	int sum = 0;
	for(int i : arr){
		sum += i;
	}
	return sum;
}

public static int[] rowSums(int[][] arr2D){
	int[] ret = new int[arr2D.length];
	int i = 0;
	for(int[] arr : arr2D){
		ret[i] = arraySum(arr);
		i++;
	}
	return ret;
}

public static boolean isDiverse(int[][] arr2D){
	int[] vals = rowSums(arr2D);
	for(int i = 0; i < vals.length-1; i++){
		for(int x = i+1; x < vals.length; x++){
			if(vals[i] == vals[x]) return false;
		}
	}
	return true;
}

//Question 2

public class HiddenWord{
	
	private String word;

	public HiddenWord(String hiddenWord){
		word = hiddenWord;
	}
	
	public String getHint(String guess){
		if(guess.equals(word)) return guess;
		String ret = "";
		for(int i = 0; i < guess.length; i++){
			if(guess.substring(i,i+1).equals(word.substring(i,i+1))) ret = ret + guess.substring(i,i+1);
			else if(word.contains(guess.substring(i,i+1))) ret = ret + "+";
			else ret = ret + "*";
		}
		return ret;
	}
	
}

//Question 3

public int getValueAt(int row, int col){
	for(SparseArrayEntry i : entries){
		if(i.getRow() == row && i.getCol() == col) return i.getValue();
	}
	return 0;
}

public void removeColumn(int col){
	numCols--;
	for(int i = 0; i < entries.size(); i++){
		if(entries.get(i).getCol() == col){
			entries.remove(i);
			i--;
		}
		else if(entries.get(i).getCol() > col){
			SparseArrayEntry replace = new SparceArrayEntry(entries.get(i).getRow(), entries.get(i).getCol()-1, entries.get(i).getValue);
			entries.set(i, replace);
		}
	}
}