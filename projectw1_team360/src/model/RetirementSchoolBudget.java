package model;

import exceptions.NegativeAmountException;
import exceptions.NotAValidAmountException;

public class RetirementSchoolBudget extends RetirementBudget {

    private int pensionPerMonth = 800;

    public RetirementSchoolBudget(String name, int income) {
        super(name, income);
        incomePerMonth = getIncomePerMonth() + pensionPerMonth;
    }

    @Override
    public void setBudgetCategories() {
        super.setBudgetCategories();
        categoriesManager.createCategory("Textbooks");
    }
}
