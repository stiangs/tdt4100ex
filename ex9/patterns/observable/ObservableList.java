package patterns.observable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class ObservableList {

	protected List<Object> elements;
	protected Collection<ObservableListListener> listeners = new ArrayList<ObservableListListener>();
	
	public ObservableList() {
		elements = new ArrayList<Object>();
	}
	
	public int size(){
		return elements.size();
	}
	
	public Object getElement(int i){
		return elements.get(i);
	}
	
	public abstract boolean acceptsElement(Object o);
	
	public void addElement(int i, Object o){
		if(acceptsElement(o)){
			if(i<elements.size()){
				elements.set(i,o);
			}
			else{
				throw new IndexOutOfBoundsException("The index is wrong");
			}
		}
		else{
			throw new IllegalArgumentException("The object " + o.getClass() + " is not supported in this observable list");
		}
	}
	
	public void addElement(Object o){
		if(acceptsElement(o)){
			elements.add(o);
		}
		else
			throw new IllegalArgumentException("The object is not supported in this list");
	}
	
	public void removeElement(int i){
		
	}
	
	public void addObservableListListener(ObservableListListener listener){
		if(!listeners.contains(listener)){
			listeners.add(listener);
		}
	}
	
	public void removeObservableListListener(ObservableListListener listener){
		if(listeners.contains(listener)){
			listeners.remove(listener);
		}
	}
}
