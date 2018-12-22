package model;

import exceptions.NegativeAmountException;
import exceptions.NotAValidAmountException;

public class StudentBudget extends Budget {

    //EFFECTS: Constructs a budget with a name and monthly funds available for budget
    public StudentBudget(String name, int income) {
        super(name, income);
    }

    //MODIFIES: budgetCategories
    //EFFECTS: creates new budget categories specific to the StudentBudget type of Budget
    @Override
    public void setBudgetCategories() {
        categoriesManager.createCategory("Groceries");
    }

    //MODIFIES: budgetCategories
    //EFFECTS: add given funds to groceries category funds
    public void addToGroceriesFunds(int funds) throws NegativeAmountException, NotAValidAmountException {
       addToCategoryFunds("Groceries", funds);
    }

    //EFFECTS: converts retirement budget into a string to be printed out from loaded file for user
    @Override
    public String toString() {
        return "Student Budget: " + name + " " + "Income: " + incomePerMonth+ "\n";
    }
}
