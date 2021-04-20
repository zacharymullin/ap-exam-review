//Question 1

public static int numberOfLeapYears(int year1, int year2){
	int count = 0;
	for(int i = year1; i <= year2; i++){
		if(isLeapYear(i)) count++;
	}
	return count;
}

public static int dayOfWeek(int month, int day, int year){
	return (dayOfYear(month, day, year) + firstDayOfYear(year) - 1) % 7;
}

//Question 2

public class StepTracker{
	private int days = 0;
	private int daysActive = 0;
	private int totalSteps = 0;
	private int activeParam;
	
	public StepTracker(int p){
		activeParam = p;
	}
	
	public void addDailySteps(int n){
		totalSteps += n;
		days++;
		if(n >= activeParam) daysActive++;
	}
	
	public int activeDays(){
		return daysActive;
	}
	
	public double averageSteps(){
		if(days == 0) return 0.0;
		return (double) totalSteps / days;
	}
}

//Question 3

public ArrayList<String> getDelimitersList(String[] tokens){
	ArrayList<String> ret = new ArrayList<String>();
	for(int i = 0; i < tokens.size(); i++){
		if(tokens.get(i).equals(openDel) || tokens.get(i).equals(closeDel)) ret.add(tokens.get(i));
	}
	return ret;
}

public boolean isBalanced(ArrayList<String> delimiters){
	int numOpen = 0;
	int numClose = 0;
	for(int i = 0; i < delimiters.size(); i++){
		if(delimiters.get(i).equals(openDel)) numOpen++;
		else if(delimiters.get(i).equals(closeDel)) numClose++;
		if(numClose > numOpen) return false;
	}
	if(numClose != numOpen) return false;
	return true;
}

//Question 4

public LightBoard(int numRows, int numCols){
	lights = new boolean[numRows][numCols];
	for(int i = 0; i < numRows; i++){
		for(int j = 0; j < numCols; j++){
			if(Math.random() < 0.4) lights[i][j] = true;
			else lights[i][j] = false;
		}
	}
}

public boolean evaluteLight(int row, int col){
	int sum = 0;
	if(lights[row][col] == true){
		for(int i = 0; i < lights.length; i++){
			if(lights[i][col] == true) sum++
		}
		if(sum % 2 == 0) return false;
		else return lights[row][col];
	}
	else if(light[row][col] == false){
		for(int i = 0; i < lights.length; i++){
			if(lights[i][col] == true) sum++
		}
		if(sum % 3 == 0) return true;
		else return lights[row][col];
	}
}
