package model;

import exceptions.NegativeAmountException;
import exceptions.NotAValidAmountException;

public class StudentBudgetSummer extends StudentBudget {

    //EFFECTS: Constructs a student budget for the summertime with a name and amount of funds to spend
    public StudentBudgetSummer(String name, int income) {
        super(name, income);
    }

    //MODIFIES: budgetCategories
    //EFFECTS: creates new budget categories specific to the StudentBudgetSummer type of Budget
    @Override
    public void setBudgetCategories() {
        super.setBudgetCategories();
        categoriesManager.createCategory("Travel");
    }

    //MODIFIES: budgetCategories
    //EFFECTS: adds user inputted funds to Travel category
    public void addToTravelCategory(int funds) throws NegativeAmountException, NotAValidAmountException {
        addToCategoryFunds("Travel", funds);
    }
}
