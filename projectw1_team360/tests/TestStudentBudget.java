//import exceptions.NegativeAmountException;
//import exceptions.NotAValidAmountException;
//import model.Budget;
//import model.StudentBudget;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class TestStudentBudget {
//
//    private Budget testStudentBudget;
//
//    @BeforeEach
//    public void setup() throws NegativeAmountException, NotAValidAmountException {
//        testStudentBudget = new StudentBudget("Test Budget", 100);
//    }
//
//    @Test
//    public void testMakeValidStudentBudget() {
//        try {
//            new StudentBudget("Test Budget", 90);
//            assertTrue(true);
//        } catch (NegativeAmountException e){
//            fail("Negative amount excepted");
//        }
//        catch (NotAValidAmountException e) {
//            fail("Not valid amount excepted");
//        }
//    }
//    @Test
//    public void testMakeBudgetWithNegativeIncome() {
//        try {
//            new StudentBudget("Negative Income Budget", -1000);
//            fail("No exception");
//        } catch (NegativeAmountException e) {
//            assertTrue(true);
//        }
//        catch (NotAValidAmountException e) {
//            System.out.println("not valid amount excepted");
//        }
//    }
//
//    @Test
//    public void testMakeBudgetWithNoIncome() {
//        try {
//            new StudentBudget("No Income Budget", 0);
//            fail("No exception");
//        } catch (NegativeAmountException e) {
//            fail("Shouldn't have excepted");
//        } catch (NotAValidAmountException e) {
//            assertTrue(true);
//        }
//    }
//
//    @Test
//    public void testGetName() {
//        assertEquals(testStudentBudget.getBudgetName(), "Test Budget");
//    }
//
//    @Test
//    public void testGetIncomePerMonth() {
//       assertEquals(testStudentBudget.getIncomePerMonth(), 100);
//    }
//
//    @Test
//    public void testAddToIncomePerMonth() throws NotAValidAmountException, NegativeAmountException {
//        testStudentBudget.addToIncomePerMonth(100);
//        assertEquals(testStudentBudget.getIncomePerMonth(), 200);
//    }
//
//    @Test
//    public void testSetBudgetCategories() {
//        testStudentBudget.setBudgetCategories();
//        assertTrue(testStudentBudget.getCategoriesManager().getBudgetCategories().size() == 1);
//    }
//
//}
