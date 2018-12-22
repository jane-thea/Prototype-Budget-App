package model.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    List<BudgetObserver> observers = new ArrayList<>();
    public void addObserver(BudgetObserver o) {
        if(!observers.contains(o)) {
            observers.add(o);
        }
    }

    public void notifyObservers(String budgetName) {
        for(BudgetObserver o: observers) {
            o.update(budgetName);
        }
    }
}
