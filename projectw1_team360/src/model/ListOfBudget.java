package model;

import exceptions.NegativeAmountException;
import exceptions.NotAValidAmountException;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class ListOfBudget implements Saveable{

    private List<Budget> listOfBudgets = new ArrayList<>();

    public void addBudget(Budget budget) {
        listOfBudgets.add(budget);
    }

    public void save(String textFile) throws IOException {
        PrintWriter writer = new PrintWriter(textFile, "UTF-8");

        for(Budget b : listOfBudgets) {
            if(b instanceof StudentBudget) {
                printInSaveFile(writer, "Student", textFile, b);
            } else {
                printInSaveFile(writer,"Retirement", textFile, b);
            }
        }
        writer.close();
    }

    //EFFECTS: prints in writer the type of the budget, the name and its income
    public void printInSaveFile(PrintWriter writer, String budgetType, String textFile, Budget b) {
        writer.println(budgetType+"/"+b.getBudgetName()+"/"+b.getIncomePerMonth() + b.getCategoriesManager());
    }

    public void load(String textFile) throws IOException, NegativeAmountException, NotAValidAmountException {
        List<String> previousBudgetInfo = readAllLines(Paths.get(textFile));
        for(String s : previousBudgetInfo) {
            String[] parts = s.split("/");
            if (parts[0].equals("Student")) {
                StudentBudget newStudentBudget = new StudentBudget(parts[1], Integer.parseInt(parts[2]));
                listOfBudgets.add(newStudentBudget);
            }
            else {
                RetirementBudget newRetirementBudget = new RetirementBudget(parts[1], Integer.parseInt(parts[2]));
                listOfBudgets.add(newRetirementBudget);
            }
        }
    }

    public String toString() {
        String stringOfBudgets = "";
        for(Budget b : listOfBudgets) {
            stringOfBudgets = stringOfBudgets + b.toString();
        }
        return stringOfBudgets;
    }
}
