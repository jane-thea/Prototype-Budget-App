package model;

import exceptions.NegativeAmountException;
import exceptions.NotAValidAmountException;
import model.observer.Subject;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Budget extends Subject {

    protected String name;
    protected int incomePerMonth;
    protected HashMap<String, ArrayList<Budget>> usersBudgets;
    protected CategoriesManager categoriesManager;

    //EFFECTS: constructs a budget with a name
    public Budget(String name, int income)  {
        this.name = name;
//        if (income < 0)
//            throw new NegativeAmountException();
//        if (income == 0)
//            throw new NotAValidAmountException();
//        else {
            this.incomePerMonth = income;
//        }
        usersBudgets = new HashMap<>();
        categoriesManager = new CategoriesManager();
        setBudgetCategories();
    }

    //EFFECTS: adds a new budget category with specified key
    public abstract void setBudgetCategories();

    //MODIFIES: budgetCategories
    //EFFECTS: prompts user for how much money they would like to add to a given budget category and adds funds
    // to existing
    public void addToCategoryFunds(String key, int funds)  {
        categoriesManager.addToCategoryFunds(key, funds);
    }

    public CategoriesManager getCategoriesManager() {
        return categoriesManager;
    }

    //EFFECTS: returns the name of the budget
    public String getBudgetName() {
        return name;
    }

    //EFFECTS: returns incomePerMonth
    public int getIncomePerMonth() {
        return incomePerMonth;
    }

    //MODIFIES: incomePerMonth
    //EFFECTS: adds given income to incomePerMonth
    public void addToIncomePerMonth(int income) throws NotAValidAmountException, NegativeAmountException {
//         if (income < 0) {
//            throw new NegativeAmountException();
//        } if (income == 0) {
//            throw new NotAValidAmountException();
//        }
        incomePerMonth = incomePerMonth + income;
        notifyObservers(name);
    }

    //EFFECTS: returns usersBudgets
    public HashMap<String, ArrayList<Budget>> getUsersBudgets() {
        return  usersBudgets;
    }

    public abstract String toString();

}
