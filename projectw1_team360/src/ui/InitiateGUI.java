package ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.*;

import java.util.HashMap;
import java.util.Optional;

//used code from https://stackoverflow.com/questions/44147595/get-more-than-two-inputs-in-a-javafx-dialog for
//  dialog box
//used code from https://docs.oracle.com/javafx/2/charts/pie-chart.htm for pie chart
//used code from https://stackoverflow.com/questions/8309981/how-to-create-and-show-common-dialog-error-
// warning-confirmation-in-javafx-2 for warning popups

public class InitiateGUI extends Application {
    private BudgetSetUp budgetSetUp;
    private Budget selectedBudget;
    private String name;
    private BudgetType kindBudget;
    private int income;
    private CategoriesSetUp catSetUp;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new Group());
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);

        Dialog<BudgetSetUp> dialog = new Dialog<>();
        dialog.setTitle("Create a new budget");
        dialog.setHeaderText("Let's get started and create a budget...");
        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.getButtonTypes().addAll(ButtonType.APPLY, ButtonType.CANCEL);
        final TextField nameField = new TextField("Budget Name");

        ObservableList<BudgetType> options =
                FXCollections.observableArrayList(
                        BudgetType.Retiree,
                        BudgetType.RetireeStudent,
                        BudgetType.StudentSchool,
                        BudgetType.StudentSummer
                );

        final ComboBox<BudgetType> comboBox = new ComboBox<>(options);
        comboBox.getSelectionModel().selectFirst();
        final TextField incomeField = new TextField("Budget Income");
        dialogPane.setContent(new VBox(8, comboBox, nameField, incomeField));
        Platform.runLater(nameField::requestFocus);
        dialog.setResultConverter((ButtonType button) -> {
                if (button == ButtonType.APPLY) {
                    if(Integer.parseInt(incomeField.getText())<0 || Integer.parseInt(incomeField.getText())==0) {
                        Alert alert = new Alert(Alert.AlertType.WARNING,
                                "Your inputted income per month was invalid", ButtonType.OK);
                        alert.showAndWait();
                        if (alert.getResult() == ButtonType.OK) {
                            System.exit(0);
                        }
                    }
                    else {
                        budgetSetUp = new BudgetSetUp(nameField.getText(), comboBox.getValue(), incomeField.getText());
                        dialog.close();
                    }
                } return null;
        });

        Optional<BudgetSetUp> optionalResult = dialog.showAndWait();
        optionalResult.ifPresent((BudgetSetUp results) -> {
            System.out.println("");
        });

        income = budgetSetUp.income;
        name = budgetSetUp.name;
        kindBudget = budgetSetUp.kind;

        //TODO: need exception for if invalid input for categories
        if(kindBudget.equals(BudgetType.Retiree) || kindBudget.equals(BudgetType.StudentSummer)) {
            Dialog<CategoriesSetUp> dialog1 = new Dialog<>();
            dialog1.setTitle("Set up your budget's categories");
            dialog1.setHeaderText("Now let's set up your spending categories...");
            DialogPane dialogPane1 = dialog1.getDialogPane();
            dialogPane1.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
            TextField groceriesField = new TextField("Groceries amount per month");
            TextField travelField = new TextField("Travel amount per month");
            dialogPane1.setContent(new VBox(8, groceriesField, travelField));
            Platform.runLater(groceriesField::requestFocus);
            dialog1.setResultConverter((ButtonType button) -> {
                if(button == ButtonType.OK) {
                    if(Integer.parseInt(groceriesField.getText())<0 || Integer.parseInt(groceriesField.getText())==0 ||
                            Integer.parseInt(travelField.getText())<0 || Integer.parseInt(travelField.getText())==0 ||
                            Integer.parseInt(travelField.getText()) +Integer.parseInt(groceriesField.getText()) >
                                    income) {
                        Alert alert = new Alert(Alert.AlertType.WARNING,
                                "One of your category amounts was invalid.", ButtonType.OK);
                        alert.showAndWait();
                        if (alert.getResult() == ButtonType.OK) {
                            System.exit(0);
                        }
                    }
                    HashMap<String, String> categoriesMap = new HashMap<>();
                    categoriesMap.put("Groceries", groceriesField.getText());
                    categoriesMap.put("Travel", travelField.getText());
                    return catSetUp = new CategoriesSetUp(name, income, categoriesMap, kindBudget);
                } return  null;
            });
            Optional<CategoriesSetUp> optionalCategoriesSetUp = dialog1.showAndWait();
            optionalCategoriesSetUp.ifPresent((CategoriesSetUp setup) -> {
                System.out.println("");
            });
        }

        if(kindBudget.equals(BudgetType.StudentSchool)) {
            Dialog<CategoriesSetUp> dialog1 = new Dialog<>();
            dialog1.setTitle("Set up your budget's categories");
            dialog1.setHeaderText("Now let's set up your spending categories...");
            DialogPane dialogPane1 = dialog1.getDialogPane();
            dialogPane1.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
            TextField groceriesField = new TextField("Groceries amount per month");
            TextField textbooksField = new TextField("Textbooks amount per month");
            dialogPane1.setContent(new VBox(8, groceriesField, textbooksField));
            Platform.runLater(groceriesField::requestFocus);
            dialog1.setResultConverter((ButtonType button) -> {
                if(button == ButtonType.OK) {
                    if(Integer.parseInt(groceriesField.getText())<0 || Integer.parseInt(groceriesField.getText())==0 ||
                            Integer.parseInt(textbooksField.getText())<0 || Integer.parseInt(textbooksField.getText())==0 ||
                            Integer.parseInt(textbooksField.getText()) +Integer.parseInt(groceriesField.getText()) >
                                    income) {
                        Alert alert = new Alert(Alert.AlertType.WARNING,
                                "One of your category amounts was invalid.", ButtonType.OK);
                        alert.showAndWait();
                        if (alert.getResult() == ButtonType.OK) {
                            System.exit(0);
                        }
                    }
                    HashMap<String, String> categoriesMap = new HashMap<>();
                    categoriesMap.put("Groceries", groceriesField.getText());
                    categoriesMap.put("Textbooks", textbooksField.getText());
                    return catSetUp = new CategoriesSetUp(name, income, categoriesMap, kindBudget);

                } return  null;
            });
            Optional<CategoriesSetUp> optionalCategoriesSetUp = dialog1.showAndWait();
            optionalCategoriesSetUp.ifPresent((CategoriesSetUp setup) -> {
                System.out.println("");
            });
        }

        if(kindBudget.equals(BudgetType.RetireeStudent)) {
            Dialog<CategoriesSetUp> dialog1 = new Dialog<>();
            dialog1.setTitle("Set up your budget's categories");
            dialog1.setHeaderText("Now let's set up your spending categories...");
            DialogPane dialogPane1 = dialog1.getDialogPane();
            dialogPane1.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
            TextField groceriesField = new TextField("Groceries amount per month");
            TextField travelField = new TextField("Travel amount per month");
            TextField textbooksField = new TextField("Textbooks amount per month");
            dialogPane1.setContent(new VBox(8, groceriesField, travelField, textbooksField));
            Platform.runLater(groceriesField::requestFocus);
            dialog1.setResultConverter((ButtonType button) -> {
                if(button == ButtonType.OK) {
                    if(Integer.parseInt(groceriesField.getText())<0 || Integer.parseInt(groceriesField.getText())==0 ||
                            Integer.parseInt(travelField.getText())<0 || Integer.parseInt(travelField.getText())==0 ||
                            Integer.parseInt(travelField.getText())<0 || Integer.parseInt(travelField.getText())==0 ||
                    Integer.parseInt(travelField.getText()) +Integer.parseInt(groceriesField.getText()) +
                            Integer.parseInt(textbooksField.getText()) >
                                    income) {
                        Alert alert = new Alert(Alert.AlertType.WARNING,
                                "One of your category amounts was invalid.", ButtonType.OK);
                        alert.showAndWait();
                        if (alert.getResult() == ButtonType.OK) {
                            System.exit(0);
                        }
                    }
                    HashMap<String, String> categoriesMap = new HashMap<>();
                    categoriesMap.put("Groceries", groceriesField.getText());
                    categoriesMap.put("Travel", travelField.getText());
                    categoriesMap.put("Textbooks", textbooksField.getText());
                    return catSetUp = new CategoriesSetUp(name, income, categoriesMap, kindBudget);
                } return  null;
            });
            Optional<CategoriesSetUp> optionalCategoriesSetUp = dialog1.showAndWait();
            optionalCategoriesSetUp.ifPresent((CategoriesSetUp setup) -> {
                System.out.println("");
            });
        }


        selectedBudget = catSetUp.getBudget();


        if(kindBudget.equals(BudgetType.Retiree) || kindBudget.equals(BudgetType.StudentSummer)) {
            int remainingIncome = income - selectedBudget.getCategoriesManager().getCategoryFunds("Groceries") -
                    selectedBudget.getCategoriesManager().getCategoryFunds("Travel");
            ObservableList<javafx.scene.chart.PieChart.Data> pieChartData =
                    FXCollections.observableArrayList(
                            new javafx.scene.chart.PieChart.Data("Travel", selectedBudget.
                                    getCategoriesManager().getCategoryFunds("Travel")),
                            new javafx.scene.chart.PieChart.Data("Groceries", selectedBudget.
                                    getCategoriesManager().getCategoryFunds("Groceries")),
                            new javafx.scene.chart.PieChart.Data("Remaining Income", remainingIncome));
            final javafx.scene.chart.PieChart chart = new javafx.scene.chart.PieChart(pieChartData);
            chart.setTitle(selectedBudget.getBudgetName());
            ((Group) scene.getRoot()).getChildren().add(chart);
        }

        if(kindBudget.equals(BudgetType.StudentSchool)) {
            int remainingIncome = income - selectedBudget.getCategoriesManager().getCategoryFunds("Groceries") -
                    selectedBudget.getCategoriesManager().getCategoryFunds("Textbooks");
            ObservableList<javafx.scene.chart.PieChart.Data > pieChartData =
                    FXCollections.observableArrayList(
                            new javafx.scene.chart.PieChart.Data("Textbooks", selectedBudget.
                                    getCategoriesManager().getCategoryFunds("Textbooks")),
                            new javafx.scene.chart.PieChart.Data("Groceries", selectedBudget.
                                    getCategoriesManager().getCategoryFunds("Groceries")),
                            new javafx.scene.chart.PieChart.Data("Remaining Income", remainingIncome));
            final javafx.scene.chart.PieChart chart = new javafx.scene.chart.PieChart(pieChartData);
            chart.setTitle(selectedBudget.getBudgetName());
            ((Group) scene.getRoot()).getChildren().add(chart);
        }

        if(kindBudget.equals(BudgetType.RetireeStudent)) {
            int remainingIncome = income - selectedBudget.getCategoriesManager().getCategoryFunds("Groceries") -
                    selectedBudget.getCategoriesManager().getCategoryFunds("Textbooks") -
                    selectedBudget.getCategoriesManager().getCategoryFunds("Travel");
            ObservableList<javafx.scene.chart.PieChart.Data> pieChartData =
                    FXCollections.observableArrayList(
                            new javafx.scene.chart.PieChart.Data("Textbooks", selectedBudget.
                                    getCategoriesManager().getCategoryFunds("Textbooks")),
                            new javafx.scene.chart.PieChart.Data("Travel", selectedBudget.
                                    getCategoriesManager().getCategoryFunds("Travel")),
                            new javafx.scene.chart.PieChart.Data("Groceries", selectedBudget.
                                    getCategoriesManager().getCategoryFunds("Groceries")),
                            new javafx.scene.chart.PieChart.Data("Remaining Income", remainingIncome));
            final javafx.scene.chart.PieChart chart = new javafx.scene.chart.PieChart(pieChartData);
            chart.setTitle(selectedBudget.getBudgetName());
            ((Group) scene.getRoot()).getChildren().add(chart);
        }


        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    private static enum BudgetType{Retiree, RetireeStudent, StudentSchool, StudentSummer}

    private static class BudgetSetUp {
        String name;
        int income;
        BudgetType kind;

        public BudgetSetUp(String name, BudgetType kind, String income) {
            this.name = name;
            this.income = Integer.parseInt(income);
            this.kind = kind;
        }

        public String getName() {
            return name;
        }

        public int getIncome() {
            return income;
        }

        public BudgetType getKind() {
            return kind;
        }
    }

    private class CategoriesSetUp {

        String name;
        int income;
        HashMap<String, String> categoriesMap;
        int travelAmount;
        int groceriesAmount;
        int textbooksAmount;
        BudgetType kind;
        Budget budget;

        public CategoriesSetUp(String name, int income, HashMap<String, String> categoriesMap, BudgetType kind) {
            this.name = name;
            this.income = income;
            this.categoriesMap = categoriesMap;
            this.kind = kind;

            //TODO: figure out what to do with exceptions
            if(kind.equals(BudgetType.Retiree)) {
                groceriesAmount = Integer.parseInt(categoriesMap.get("Groceries"));
                travelAmount = Integer.parseInt(categoriesMap.get("Travel"));
                budget = new RetirementBudget(name, income);
                budget.addToCategoryFunds("Groceries", groceriesAmount);
                budget.addToCategoryFunds("Travel", travelAmount);
            }

            if(kind.equals(BudgetType.StudentSchool)) {
                budget = new StudentBudgetSchool(name, income);
                groceriesAmount = Integer.parseInt(categoriesMap.get("Groceries"));
                textbooksAmount = Integer.parseInt(categoriesMap.get("Textbooks"));

                budget.addToCategoryFunds("Textbooks", textbooksAmount);
                budget.addToCategoryFunds("Groceries", groceriesAmount);
            }

            if(kind.equals(BudgetType.RetireeStudent)) {
                groceriesAmount = Integer.parseInt(categoriesMap.get("Groceries"));
                travelAmount = Integer.parseInt(categoriesMap.get("Travel"));
                textbooksAmount = Integer.parseInt(categoriesMap.get("Textbooks"));
                budget = new RetirementSchoolBudget(name, income);
                budget.addToCategoryFunds("Groceries", groceriesAmount);
                budget.addToCategoryFunds("Travel", travelAmount);
                budget.addToCategoryFunds("Textbooks", textbooksAmount);
            }

            if(kind.equals(BudgetType.StudentSummer)) {
                groceriesAmount = Integer.parseInt(categoriesMap.get("Groceries"));
                travelAmount = Integer.parseInt(categoriesMap.get("Travel"));
                budget = new StudentBudgetSummer(name, income);
                budget.addToCategoryFunds("Travel", travelAmount);
                budget.addToCategoryFunds("Groceries", groceriesAmount);
            }
        }

        public Budget getBudget() {
            return budget;
        }
    }

}
