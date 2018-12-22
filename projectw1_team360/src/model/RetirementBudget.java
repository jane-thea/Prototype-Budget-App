package model;

import exceptions.NegativeAmountException;
import exceptions.NotAValidAmountException;

public class RetirementBudget extends Budget {

    private int pensionPerMonth = 800; //Can change pension amounts later in project


    //EFFECTS: constructs a RetirementBudget with a name and a set amount of income per month
    public RetirementBudget(String name, int income)  {
        super(name, income);
        incomePerMonth = getIncomePerMonth() + pensionPerMonth;
    }

    //EFFECTS: creates categories specific to RetirementBudget
    @Override
    public void setBudgetCategories() {
        categoriesManager.createCategory("Groceries");
        categoriesManager.createCategory("Travel");
    }

    //MODIFIES: budgetCategories
    //EFFECTS: add given funds to groceries category funds
    public void addToGroceriesCategory(int funds) throws NegativeAmountException, NotAValidAmountException {
        addToCategoryFunds("Groceries", funds);
    }

    //MODIFIES: budgetCategories
    //EFFECTS: add given funds to travel category funds
    public void addToTravelCategory(int funds) throws NegativeAmountException, NotAValidAmountException {
        addToCategoryFunds("Travel", funds);
    }

    //EFFECTS: converts retirement budget into a string to be printed out from loaded file for user
    @Override
    public String toString() {
        return "Retirement Budget: " + name + " " + "Income: "
                + incomePerMonth+ "\n";
    }
}
