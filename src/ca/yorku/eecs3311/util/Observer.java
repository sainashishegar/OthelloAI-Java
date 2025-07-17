package ca.yorku.eecs3311.util;

/**
 * Implement a modification of the Observer/Observable 
 * Design Pattern. See https://www.oodesign.com/observer-pattern.html 
 *
 * @author student
 *
 */
public interface Observer {

	/**
	 * Whenever an Observable object to which this Observer is attached updates, this method is called.
	 * @param o: the corresponding Observable object
	 */
	public void update(Observable o);
}
