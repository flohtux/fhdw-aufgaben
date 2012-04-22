import view.CounterObserver;


public class Starter {

	public static void main(String[] args) {
		final int InitialMargin = 50;
		final int MarginDelta = 100;
		int currentMargin = InitialMargin;
		CounterObserver observer1 = CounterObserver.createCounterObserver();
		observer1.setLocation(currentMargin, currentMargin);
		observer1.setVisible(true);
		currentMargin = currentMargin + MarginDelta;
		CounterObserver observer2 = CounterObserver.createCounterObserver();
		observer2.setLocation(currentMargin, currentMargin);
		observer2.setVisible(true);
		currentMargin = currentMargin + MarginDelta;
		CounterObserver observer3 = CounterObserver.createCounterObserver();
		observer3.setLocation(currentMargin, currentMargin);
		observer3.setVisible(true);
	}

}
