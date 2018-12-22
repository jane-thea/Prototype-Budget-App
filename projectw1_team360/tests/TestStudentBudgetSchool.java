//import exceptions.NegativeAmountException;
//import exceptions.NotAValidAmountException;
//import model.StudentBudgetSchool;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class TestStudentBudgetSchool {
//
//    protected StudentBudgetSchool testBudget;
//
//    @BeforeEach
//    public void setup() throws NegativeAmountException, NotAValidAmountException {
//        testBudget = new StudentBudgetSchool("Student Budget for School Year", 100);
//    }
//
//    @Test
//    public void testSetUpCategories() {
//        testBudget.setBudgetCategories();
//        assertTrue(testBudget.getCategoriesManager().getBudgetCategories().size() == 2);
//    }
//
//    @Test
//    public void testAddToGroceriesCategory() throws NegativeAmountException, NotAValidAmountException {
//        testBudget.setBudgetCategories();
//        testBudget.addToGroceriesCategory(10);
//        assertTrue(testBudget.getCategoriesManager().getCategoryFunds("Groceries") == 10);
//    }
//
//    @Test
//    public void testAddToTextbooksCategory() throws NegativeAmountException, NotAValidAmountException {
//        testBudget.setBudgetCategories();
//        testBudget.addToTextbooksCategory(10);
//        assertTrue(testBudget.getCategoriesManager().getCategoryFunds("Textbooks") == 10);
//    }
//}
