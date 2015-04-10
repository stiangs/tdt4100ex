package inheritance;

import java.util.ArrayList;
import java.util.Collection;


public class Train {

	private Collection<TrainCar> train = new ArrayList<TrainCar>();
	
	public void addTrainCar(TrainCar trainCar){
		if(!train.contains(trainCar)){
			train.add(trainCar);
		}
	}
	
	public boolean contains(TrainCar trainCar){
		return train.contains(trainCar);
	}
	
	public int getTotalWeight(){
		int totalWeight = 0;
		for(TrainCar trainCar: train){
			totalWeight += trainCar.getTotalWeight();
		}
		return totalWeight;
	}
	
	public int getPassengerCount(){
		int passengerCount = 0;
		for(TrainCar trainCar: train){
			if(trainCar instanceof PassengerCar){
				passengerCount += ((PassengerCar) trainCar).getPassengerCount();
			}
		}
		return passengerCount;
	}
	
	public int getCargoWeight(){
		int cargoWeight = 0;
		for(TrainCar trainCar: train){
			if(trainCar instanceof CargoCar){
				cargoWeight += ((CargoCar) trainCar).getCargoWeight();
			}
		}
		return cargoWeight;
	}
	
	@Override
	public String toString() {
		String trainToString = "";
		int carNumber = 1;
		for(TrainCar trainCar: train){
			trainToString += carNumber++ + trainCar.toString();
		}
		
		return trainToString;
	}
}
