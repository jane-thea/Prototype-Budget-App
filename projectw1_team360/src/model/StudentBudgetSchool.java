package model;

import exceptions.NegativeAmountException;
import exceptions.NotAValidAmountException;

public class StudentBudgetSchool extends StudentBudget {

    //EFFECTS: Constructs a student budget for during the school year with a name and monthly available amount
    //         of money and a textbooks budget category
    public StudentBudgetSchool(String name, int income)  {
        super(name, income);
    }

    //MODIFIES: budgetCategories
    //EFFECTS: creates new budget categories specific to the StudentBudgetSchool type of Budget
    @Override
    public void setBudgetCategories() {
        super.setBudgetCategories();
        categoriesManager.createCategory("Textbooks");
    }

    //MODIFIES: budgetCategories
    //EFFECTS: adds user inputted funds to Textbooks category
    public void addToTextbooksCategory(int funds) throws NegativeAmountException, NotAValidAmountException {
        addToCategoryFunds("Textbooks", funds);
    }

    public void addToGroceriesCategory(int funds) throws NegativeAmountException, NotAValidAmountException {
        super.addToGroceriesFunds(funds);
    }
}
