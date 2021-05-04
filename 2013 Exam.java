//Question 1

public DownloadInfo getDownloadInfo(String title){
	for(DownloadInfo d : downloadList){
		if(d.getTitle().equals(title)) return d;
	}
	return null;
}

public void updateDownloads(List<String> titles){
	for(String t : titles){
		if(getDownloadInfo(t) != null) getDownloadInfo(t).incrementTimesDownloaded();
		else downloadList.add(new DownloadInfo(t));
	}
}

//Question 2

public TokenPass(int playerCount){
	board = new int[playerCount];
	for(int elem : board){
		elem = (int)(Math.random() * 10) + 1;
	}
	currentPlayer = (int)(Math.random()*playerCount);
}

public void distributeCurrentPlayerTokens(){
	int tokens = board[currentPlayer];
	board[currentPlayer] = 0;
	int index = currentPlayer;
	while(token > 0){
		if(currentPlayer == board.length - 1) index = 0;
		else index++;
		board[index]++;
		token--;
	}
}

//Question 3 - n/a, Gridworld

//Question 4

public SkyView(int numRows, int numCols, double[] scanned){
	view = new double[numRows][numCols];
	int c;
	boolean rtl;
	int index = 0;
	for(int r = 0; r < view.length; r++){
		rtl = r % 2 == 0;
		if(rtl) c = 0;
		else c = view[r].length - 1;
		while(c >= 0 && c < view[r].length){
			view[r][c] = scanned[index];
			index++;
			if(rtl) c++;
			else c--;
		}
	}
}

public double getAverage(int startRow, int endRow, int startCol, int endCol){
	double sum = 0.0;
	for(int r = startRow; r <= endRow; r++){
		for(int c = startCol; c <= endCol; c++){
			sum += views[r][c];
		}
	}
	return sum / ((endRow - startRow + 1) * (endCol - startCol + 1));
}