package InterviewPrep;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;


@RunWith(Suite.class)
@SuiteClasses({})
public class InterviewQuestionsTest {
	private InterviewQuestions questions = new InterviewQuestions();
	
    @Test
    public void ReverseTest() {
        String word = "dictionary"; // 10 letters
        String word2 = "testing"; // 7 letters

        char[] reversed = questions.reverse(word.toCharArray());
        char[] reversed2 = questions.reverse(word2.toCharArray());
        String foo = new String(reversed);
        String bar = new String(reversed2);
        
        assertTrue(foo.matches("yranoitcid"), "Reverse did not work properly on even numbered inputs!");
        assertTrue(bar.matches("gnitset"), "Reverse did not work properly on odd numbered inputs!");
    }

    @Test
    public void ReverseWordsTest()
    {
        char[] sentence = "The swift brown fox jumped over the lazy dog".toCharArray();
        char[] testing = questions.reverseWords(sentence);
        String result = new String(testing);         

        assertTrue(result.matches("dog lazy the over jumped fox brown swift The"), "Reversing jumping fox test failed!");
    }
    
    @Test
    public void PalindromePozOddNumTest()
    {
        String palindrome = "Do Geese See God".replace(" ", "").toLowerCase();       
        assertTrue(questions.Palidrome(palindrome.toCharArray()), "Palindrome Not Detected As Expected!");
    }

    @Test
    public void PalindromePozEvenNumTest()
    {
        String anna = "anaana";
        assertTrue(questions.Palidrome(anna.toCharArray()), "Even Numbered Palindrome Failure!");
    }

    @Test
    public void PalindromeNegEvenNumTest()
    {
        String anna = "anaani";

        assertFalse(questions.Palidrome(anna.toCharArray()), "Even Numbered Palindrome Failure!");
    }

    @Test
    public void PalindromeNegOddNumTest()
    {
        String notpalindrome = "Do Geese See Gid".replace(" ", "").toLowerCase();
        assertFalse(questions.Palidrome(notpalindrome.toCharArray()), "NonPalindrome Not Refuted As Expected!");
    }

    @Test
    public void FactorialTest()
    {
        int foo = 5;
        int bar = questions.factorial(foo);
        assertTrue(bar == 120, "Factorial() Did Not Return Expected Result!");
    }

    @Test
    public void AnagramTestPoz()
    {
        String test = "this is a test";
        String experimental = questions.reverse(test.toCharArray()).toString();

        assertTrue(questions.anagram(test, experimental), "Anagram Not Detected!?");
    }

    @Test
    public void AnagramTestNeg()
    {
        String test = "this is a test";
        String experimental = "tset a si sitt";

        assertFalse(questions.anagram(test, experimental), "Anagram Not Detected!?");
    }
    
    @Test
    public void EvenTestPoz() {
    	int even = 24;
    	assertTrue(questions.isEven(even), "Even value verified!");
    }
    
    @Test
    public void EvenTestNeg() {
    	int odd = 23;
    	assertFalse(questions.isEven(odd), "Odd value verified!");
    }
    
    @Test public void CountDuplicateWords() {
    	String snowing = "It’s snowing right now. Grab your gear and hit the mountain. Snow accumulation could be up to 8-10 inches. now come here and enjoy the snow.";
    	HashMap<String, Integer> words = new HashMap<String, Integer>();
    	
    	words = questions.CountDuplicateWords(snowing);    	
    	assertTrue(words.get("snow") == 2, "Count achieved!");
    }
    
    @Test
    public void GCDTestPoz() {
    	int first = 54;
    	int second = 24;
    	assertTrue(questions.gcd(first,  second) == 6, "GCD Test Completed!");
    }
    
    @Test
    public void CDWEmptyString() {
    	String snowing = "";
  
    	assertThrows(IllegalArgumentException.class,
                ()->{
                //do whatever you want to do here
                	HashMap<String, Integer> words = questions.CountDuplicateWords(snowing);
                });
    }
    
    @Test
    public void CDWOnlySpaces() {
    	String snowing = "                                               ";

    	assertThrows(IllegalArgumentException.class,
                ()->{
                //do whatever you want to do here
                	HashMap<String, Integer> words = questions.CountDuplicateWords(snowing);
                });
    }
    
    @Test
    public void CDWMixedCase() {
    	String snowing = "There's SNOW outside right now. Grab your gear and hit the mountain. Snow accumulation could be up to 8-10 inches. now come here and enjoy the snow.";
    	HashMap<String, Integer> words = new HashMap<String, Integer>();
    	
    	words = questions.CountDuplicateWords(snowing);    	
    	assertTrue(words.get("snow") == 3, "Count achieved!");
    }
    
    @Test
    public void CDWIncrements() {
    	String snowing = "It’s snowing right now. Grab your gear and hit the mountain. Snow accumulation could be up to 8-10 inches. now come here and enjoy the snow.";
    	HashMap<String, Integer> words = new HashMap<String, Integer>();
    	
    	words = questions.CountDuplicateWords(snowing);    	
    	assertTrue(words.get("and") == 2, "Count achieved!");
    }
    
    @Test
    public void CDWSingleWord() {
    	String snowing = "testing";
    	HashMap<String, Integer> words = new HashMap<String, Integer>();
    	
    	words = questions.CountDuplicateWords(snowing);    	
    	assertTrue(words.get("testing") == 1, "Count achieved!");
    }
    
    @Test
    public void FibTest() {
    	int f = questions.Fibonacci(11);
    	assertTrue(f == 89, "Fibonacci fail?");
    }
    
    @Test
    public void SelectUniquesPoz() {
    	String sample = "apple banana banana orange strawberry";
    	List<String> verify = Arrays.asList("apple", "orange", "strawberry");
    	//List<String> doublecheck = questions.SelectUniques(sample);
    	
    	assertTrue(verify.containsAll(questions.SelectUniques(sample)), "Selecting uniques failed?");
    }
    
    @Test
    public void SelectUniquesAllUniquePoz() {
    	String sample = "apple banana orange strawberry";
    	List<String> verify = Arrays.asList("apple", "orange", "strawberry", "banana");
    	
    	assertTrue(verify.containsAll(questions.SelectUniques(sample)), "Selecting uniques failed?");
    }
    
    @Test
    public void SelectUniquesNoneUniquePoz() {
    	String sample = "apple banana apple orange banana strawberry orange strawberry";
    	List<String> verify = new ArrayList<String>();//Arrays.asList("apple", "orange", "strawberry");
    	
    	assertTrue(verify.containsAll(questions.SelectUniques(sample)), "Selecting uniques failed?");
    }
    
    @Test
    public void SelectUniquesNeg() {
    	String sample = "apple banana banana orange strawberry rhubarb rhubarb";
    	List<String> verify = Arrays.asList("banana", "rhubarb");
    	
    	assertFalse(verify.containsAll(questions.SelectUniques(sample)), "Selecting uniques failed?");
    }
    
    @Test
    public void SelectRangePoz() {
    	String sample = "apple banana apple orange banana strawberry strawberry strawberry";
    	List<String> verify = Arrays.asList("apple", "banana", "orange");
    	
    	assertTrue(verify.containsAll(questions.SelectRange(sample, 1, 2)), "Selecting uniques failed?");
    }
    
    @Test
    public void SelectRangeNeg() {
    	String sample = "apple strawberry apple banana orange banana orange orange apple strawberry banana strawberry";
    	//List<String> doublecheck = questions.SelectRange(sample, 3, 3);
    	
    	assertTrue(questions.SelectRange(sample, 1, 2).size() == 0, "Selecting uniques failed? None of that count?");
    }
    
    @Test
    public void SelectRangePrecisePoz() {
    	String sample = "apple banana orange banana strawberry strawberry strawberry";
    	List<String> verify = Arrays.asList("banana");
    	//List<String> doublecheck = questions.SelectRange(sample, 2, 2);    	
    	
    	assertTrue(verify.containsAll(questions.SelectRange(sample, 2, 2)), "Selecting uniques failed?");
    }    

    @Test
    public void SelectRangePreciseNeg() {
    	String sample = "apple banana orange banana strawberry strawberry";
    	//List<String> doublecheck = questions.SelectRange(sample, 3, 3);
    	
    	assertTrue(questions.SelectRange(sample, 3, 3).size() == 0, "Selecting uniques failed? None of that count?");
    }
    
    @Test
    public void BubblesortPoz() {
    	int[] numbers = { 1, 4, 5, 6, 3, 2 };
    	int[] verify = { 1, 2, 3, 4, 5, 6 };
    	questions.Bubblesort(numbers);
    	
    	for (int x = 0; x < verify.length; x++) {
    		assertTrue(numbers[x] == verify[x], "Numbers not sorted?!");
    	}
    }
    
    @Test
    public void MinNumberTestPoz() {
    	int[] numbers = { 1, 4, 5, 6, 3, 2 };
    	int lowest = questions.min(numbers);
    	
    	assertTrue(lowest == 1, "Minimum value fail!");
    }
    
    @Test
    public void MaxNumberTestPoz() {
    	int[] numbers = { 1, 4, 5, 6, 3, 2 };
    	int highest = questions.max(numbers);
    	
    	assertTrue(highest == 6, "Minimum value fail!");
    }
    
    @Test
    public void QuicksortPoz() {
    	int[] numbers = { 100, 74, 3, 62, 13, 22, 101 };
    	int[] verify = { 3, 13, 22, 62, 74, 100, 101 };
    	//int[] numbers = { 10, 74, 3, 62, 101, 22, 13 };
    	//int[] verify = { 3, 10, 13, 22, 62, 74, 101 };
    	//int[] numbers = {42, 92, 72, 98, 12, 62, 50, 46, 51, 8, 28, 48, 34, 33, 64, 9, 41, 96, 5, 87, 23, 93, 37, 25, 74 };
    	//int[] verify = {5, 8, 9, 12, 23, 25, 28, 33, 34, 37, 41, 42, 46, 48, 50, 51, 62, 64, 72, 74, 87, 92, 93, 96, 98 };    
    	questions.Quicksort(numbers, 0, numbers.length - 1); //questions.min(numbers), questions.max(numbers));
    	
    	for (int x = 0; x < verify.length; x++) {
    		//System.out.print(numbers[x] + ", " + verify[x]);
    		assertTrue(numbers[x] == verify[x], "Numbers not sorted?! Index: " + x + " Numbers: " + numbers[x] + ", " + verify[x]);
    	}    	
    }
    
    @Test
    public void ShellsortPoz() {
    	int[] numbers = { 100, 74, 3, 62, 13, 22, 101 };
    	int[] verify = { 3, 13, 22, 62, 74, 100, 101 };
    	//int[] numbers = { 10, 74, 3, 62, 101, 22, 13 };
    	//int[] verify = { 3, 10, 13, 22, 62, 74, 101 };
    	//int[] numbers = {42, 92, 72, 98, 12, 62, 50, 46, 51, 8, 28, 48, 34, 33, 64, 9, 41, 96, 5, 87, 23, 93, 37, 25, 74 };
    	//int[] verify = {5, 8, 9, 12, 23, 25, 28, 33, 34, 37, 41, 42, 46, 48, 50, 51, 62, 64, 72, 74, 87, 92, 93, 96, 98 };    
    	questions.Shellsort(numbers); //questions.min(numbers), questions.max(numbers));
    	
    	for (int x = 0; x < verify.length; x++) {
    		//System.out.print(numbers[x] + ", " + verify[x]);
    		assertTrue(numbers[x] == verify[x], "Numbers not sorted?! Index: " + x + " Numbers: " + numbers[x] + ", " + verify[x]);
    	}    	
    }
}
