package model;

import java.util.HashMap;

public class CategoriesManager {

    public HashMap<String, Integer> budgetCategories;

    public CategoriesManager(){
        budgetCategories = new HashMap<>();
    }

    public HashMap<String, Integer> getBudgetCategories() {
        return budgetCategories;
    }

    //MODIFIES: this, budgetCategories
    //EFFECTS: creates a new budget category with the given key and a user inputted amount of funds
    public void createCategory(String key) {
        budgetCategories.put(key, 0);
    }

    //MODIFIES: budgetCategories
    //EFFECTS: prompts user for how much money they would like to add to a given budget category and adds funds
    // to existing
    public void addToCategoryFunds(String key, int funds) {
        int formerFunds = budgetCategories.get(key);
//        if(funds == 0) {
//            throw new NotAValidAmountException();
//        } if(funds < 0) {
//            throw new NegativeAmountException();
//        } else {
            budgetCategories.replace(key, formerFunds + funds);

    }

    public Integer getCategoryFunds(String key) {
        return budgetCategories.get(key);
    }
}
