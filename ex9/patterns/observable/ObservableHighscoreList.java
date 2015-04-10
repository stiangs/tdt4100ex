package patterns.observable;

import java.util.Collections;
import java.util.List;

public class ObservableHighscoreList extends ObservableList{

	
	private int maxSize;
	
	public ObservableHighscoreList(int maxSize) {
		this.maxSize = maxSize;
	}
	
	@SuppressWarnings("unchecked")
	public void addResult(Integer score){
		elements.add(score);
		Collections.sort((List<Integer>)(Object) elements);
		if(elements.size() > maxSize){
			elements.remove(maxSize);
		}
		int pos = elements.indexOf(score);
		if(pos != -1){
			for(ObservableListListener listener: listeners){
				listener.listChanged(this, pos);
			}
		}
	}

	@Override
	public boolean acceptsElement(Object o) {
		return o instanceof Integer;
	}

	@Override
	public String toString() {
		return "ObservableHighscoreList [elements=" + elements + "]";
	}
	
	
	
	
//	private int maxSize;
//	private List<Integer> results = new ArrayList<Integer>();
//	private Collection<ObservableListListener> listeners = new ArrayList<ObservableListListener>();
//	
//	public ObservableHighscoreList(int maxSize) {
//		this.maxSize = maxSize;
//	}
//	
//	public int size(){
//		return results.size();
//	}
//	
//	public int getElement(int i){
//		return results.get(i);
//	}
//	
//	public void addResult(Integer score){
//		results.add(score);
//		Collections.sort(results);
//		if(results.size() > maxSize){
//			results.remove(maxSize);
//		}
//		int pos = -1;
//		for(int i = 0; i < results.size(); i++){
//			if(results.get(i) == score){
//				pos = 1;
//			}
//		}
//		if(pos != -1){
//			for(ObservableListListener listener: listeners){
//				listener.listChanged(this, pos);
//			}
//		}
//	}
//	
//	
//	public void addObservableListListener(ObservableListListener listener){
//		if(!listeners.contains(listener)){
//			listeners.add(listener);
//		}
//	}
//	
//	public void removeObservableListListener(ObservableListListener listener){
//		if(listeners.contains(listener)){
//			listeners.remove(listener);
//		}
//	}
//
//	@Override
//	public String toString() {
//		return "ObservableHighscoreList [maxSize=" + maxSize + ", results="
//				+ results + "]";
//	}
//	
//	
	
}
