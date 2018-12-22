//import exceptions.NegativeAmountException;
//import exceptions.NotAValidAmountException;
//import model.StudentBudgetSummer;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class TestStudentBudgetSummer {
//
//    private StudentBudgetSummer testBudget;
//
//    @BeforeEach
//    public void setup() throws NegativeAmountException, NotAValidAmountException {
//        testBudget = new StudentBudgetSummer("Student Summer Budget", 100);
//    }
//
//    @Test
//    public void testSetUpCategories() {
//        testBudget.setBudgetCategories();
//        assertTrue(testBudget.getCategoriesManager().getBudgetCategories().size() == 2);
//    }
//
//    @Test
//    public void testAddToTravelCategory() throws NegativeAmountException, NotAValidAmountException {
//        testBudget.setBudgetCategories();
//        testBudget.addToTravelCategory(10);
//        assertTrue(testBudget.getCategoriesManager().getCategoryFunds("Travel") == 10);
//    }
//}
