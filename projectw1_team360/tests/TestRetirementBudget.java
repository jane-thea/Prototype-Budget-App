//import exceptions.NegativeAmountException;
//import exceptions.NotAValidAmountException;
//import model.RetirementBudget;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class TestRetirementBudget {
//
//    private RetirementBudget testRetirementBudget;
//
//    @BeforeEach
//    public void setup() throws NegativeAmountException, NotAValidAmountException {
//        testRetirementBudget = new RetirementBudget("Test Retirement Budget", 100);
//    }
//
//    @Test
//    public void testMakeValidBudget() {
//        try {
//            RetirementBudget test2 = new RetirementBudget("Test Budget", 10000);
//            assertTrue(test2.getCategoriesManager().budgetCategories.size() == 2);
//            assertTrue(true);
//        } catch (NegativeAmountException e) {
//            fail("Should not have been excepted");
//        }
//        catch (NotAValidAmountException e) {
//            fail("Should not have been excepted");
//        }
//    }
//
//    @Test
//    public void testMakeBudgetWithNegativeIncome() {
//        try {
//            new RetirementBudget("Test Budget", -666);
//            fail("Should have been excepted");
//        } catch (NegativeAmountException e) {
//            assertTrue(true);
//        } catch (NotAValidAmountException e) {
//            fail("should not have been excepted");
//        }
//    }
//
//    @Test
//    public void testMakeBudgetWithNoIncome() {
//        try {
//            new RetirementBudget("Test Budget", 0);
//            fail("Should have been excepted.");
//        } catch (NegativeAmountException e) {
//            fail("Excepted negative budget income");
//        }
//        catch (NotAValidAmountException e) {
//            assertTrue(true);
//        }
//    }
//
//
//    @Test
//    public void testGetName() {
//        assertEquals(testRetirementBudget.getBudgetName(),
//                "Test Retirement Budget");
//    }
//
//    @Test
//    public void testGetIncomePerMonth() {
//        assertEquals(testRetirementBudget.getIncomePerMonth(), 900);
//    }
//
//    @Test
//    public void testAddToIncomePerMonth() throws NotAValidAmountException, NegativeAmountException {
//        testRetirementBudget.addToIncomePerMonth(100);
//        assertEquals(testRetirementBudget.getIncomePerMonth(), 1000);
//    }
//
//    @Test
//    public void testAddToGroceriesFunds() throws NegativeAmountException, NotAValidAmountException {
//        testRetirementBudget.setBudgetCategories();
//        testRetirementBudget.addToGroceriesCategory(10);
//        assertTrue(testRetirementBudget.getCategoriesManager().getCategoryFunds("Groceries") == 10);
//    }
//
//    @Test
//    public void testAddToTravelFunds() throws NegativeAmountException, NotAValidAmountException {
//        testRetirementBudget.setBudgetCategories();
//        testRetirementBudget.addToTravelCategory(10);
//        assertTrue(testRetirementBudget.getCategoriesManager().getCategoryFunds("Travel") == 10);
//    }
//
//
//}
