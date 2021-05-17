public boolean simulate(){
	int hops = 0;
	int frogPos = 0;
	if(frogPos = goalDistance) return true;
	while(hops < maxHops){
		frogPos += hopDistance();
		if(frogPos >= goalDistance) return true;
		if(frogPos < 0) return false;
		hops++;
	}
	return false;
}

public double runSimulations(int num){
	int trueReturns;
	for(int i = 0; i < num; i++){
		if(simulate()) trueReturns++;
	}
	return (double) trueReturns / (double) num;
}

//Question 2

public int nextTankToFill(int threshold){
	int lowestTank = filler.getCurrentIndex();
	int lowestLevel = threshold + 1;
	for(int i = 0; i < tanks.size(); i++){
		if(tanks.get(i).getFuelValue() < lowestLevel){
			lowestTank = i;
			lowestLevel = tanks.get(i).getFuelValue();
		}
	}
	return lowestTank;
}

public void moveToLocation(int locIndex){
	if(locIndex != filler.getCurrentIndex()){
		if(locIndex < filler.getCurrentIndex()){
			if(filler.isFacingRight()) filler.changeDirection();
			filler.moveForward(filler.getCurrentIndex() - locIndex);
		}
		else if(locIndex > filler.getCurrentIndex()){
			if(!filler.isFacingRight) filler.changeDirection();
			filler.moveForward(locIndex - filler.getCurrentIndex());
		}
	}
}
