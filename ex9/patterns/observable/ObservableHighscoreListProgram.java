package patterns.observable;

import java.util.Scanner;

public class ObservableHighscoreListProgram implements ObservableListListener {

	ObservableHighscoreList list;
	
	public void init(){
		list = new ObservableHighscoreList(5);
		list.addObservableListListener(this);
		
	}
	
	public void run(){
		System.out.println("Place new score");
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()){
			list.addResult(sc.nextInt());
		}
		sc.close();
	}
	
	@Override
	public void listChanged(ObservableList results, int place) {
		System.out.println("New score added: " + list.getElement(place) + " at pos: " + place);
		System.out.println(list);
	}

	public static void main(String[] args) {
		ObservableHighscoreListProgram program = new ObservableHighscoreListProgram();
		program.init();
		program.run();
	}
}
