package InterviewPrep;

import java.util.*;
import java.security.*;
import java.lang.*;
//import java.lang.reflect.*;

public class InterviewQuestions {
    public char[] reverse(char[] word) {
        if (0 == word.length % 2)
        {
            for (int c = 0; c < (word.length / 2); c++)
            {
                char letter = word[c];
                word[c] = word[(word.length - 1) - c];
                word[(word.length - 1) - c] = letter;
            }
            return word;
        }
        else
        {
            for (int c = 0; c < (word.length / 2); c++)
            {
                char letter = word[c];
                word[c] = word[(word.length - 1) - c];
                word[(word.length - 1) - c] = letter;
            }
            return word;
        }
    }

    // this might need some work, shame I just can't reuse this.
    public String reverse(String word) {
    	char[] testing = reverse(word.toCharArray());
    	return new String(testing);
    }

    public char[] SelectChars(char[] source, int indexStart, int indexEnd)
    {
        if (null == source) { return "".toCharArray(); }

        char[] desired = new char[indexEnd - indexStart];
        for (int c = 0; c < (indexEnd - indexStart); c++)
        {
            desired[c] = source[(indexStart + c)];
        }
        return desired;
    }

    public char[] reverseWords(char[] words)
    {
        if ((null == words) || (0 == words.length))
        {
            return "".toCharArray();
        }
        else
        {
        	String ww = new String(words);
            if (!ww.contains(" ")) { return "".toCharArray(); }

            int spaceCount = 0;
            List<Integer> spaces = new ArrayList<Integer>();
            for (int n = 0; n < words.length; n++)
            {
                if (' ' == words[n])
                {
                    spaceCount++;
                    spaces.add(n); // not sure about this...
                }
            }

            char[][] cWords = new char[spaceCount + 1][];
            for (int c = 0; c <= spaceCount; c++)
            {
                if (spaceCount > 1)
                {

                    if (0 == c)
                    {
                        cWords[c] = SelectChars(words, c, spaces.get(c));
                    }
                    else
                    {
                        if (c < spaceCount)
                        {
                            cWords[c] = SelectChars(words, spaces.get(c - 1) + 1, spaces.get(c));
                        }
                        else
                        {
                            cWords[c] = SelectChars(words, spaces.get(c - 1) + 1, words.length);
                        }
                    }
                }
                else
                {
                    cWords[c] = SelectChars(words, spaces.get(c) + 1, words.length); // off by 1?
                }
            }

            int w = 0;
            char[] reversed = new char[words.length];
            for (int x = spaceCount; (x >= 0) && (w < words.length); x--)
            {
                if (x > 0)// && (x - 1 > 0))
                {
                    for (int r = 0, y = w; r < cWords[x].length; r++, w++)
                    {
                        reversed[r + y] = cWords[x][r];
                    }
                    reversed[w] = ' ';
                    w++;
                }
                else
                {
                    for (int t = 0, y = w; t < cWords[x].length; t++, w++)
                    {
                        reversed[t + y] = cWords[x][t];
                    }
                }
            }
            return reversed;
        }
    }

    public char[] GetHalf(char[] word)
    {
        int start = 0;
        char[] half = new char[word.length / 2];
        if (0 == (word.length % 2))
        {
            for (int c = (word.length / 2); c < word.length; c++, start++)
            {
                half[start] = word[c];
            }
            return half;
        }
        else
        {
            for (int c = (word.length / 2) + 1; c < word.length; c++, start++)
            {
                half[start] = word[c];
            }
            return half;
        }
    }

    public Boolean Palidrome(char[] word)
    {
        char[] front = GetHalf(word);        
        char[] back = GetHalf(reverse(word)); // technically there's an optimization here, if it is a palindrome.       

        for (int c = 0; c < front.length; c++)
        {
    		if (front[c] != back[c]) {
    			return false;
    		}
        }
        return true;
    }

    public int factorial(int f)
    {
        if ((f - 1) >= 1)
        {
            return f * factorial(f - 1);
        }
        else
        {
            return f;
        }
    }

    public int gcd(int a, int b)
    {
        if (a == b)
        {
            return a;
        }
        else if (a > b)
        {
            return gcd(a - b, b);
        }
        else
        {
            return gcd(a, b - a);
        }
    }

    public Boolean isEven(int check)
    {
        if (0 == (check % 2))
        {
            return true;
        }
        return false;
    }
    
    public int min(int[] numbers) {
    	// add input validation here!
    	int currentMin = numbers[0];
    	
    	for (int i = 0; i < numbers.length; i++) {
    		if (numbers[i] <= currentMin) {
    			currentMin = numbers[i];
    		}
    	}    	
    	return currentMin;
    }
    
    public int max(int[] numbers) {
    	// add input validation here!
    	int currentMax = numbers[0];
    	
    	for (int i = 0; i < numbers.length; i++) {
    		if (numbers[i] > currentMax) {
    			currentMax = numbers[i];
    		}
    	}    	
    	return currentMax;
    }

    /*
     abcbbc, cabbbc, True
     abbc, abc, False
     ab, "", false
     ab, df, false

     bbb, bb, false
     */
    public Boolean anagram(String first, String second)
    {
        Hashtable<Character, Integer> charactersFirst = new Hashtable<Character, Integer>();
        Hashtable<Character, Integer> charactersSecond = new Hashtable<Character, Integer>();
        char[] charsF = first.toCharArray();
        char[] charsS = second.toCharArray();

        // input validation
        if (null == first || null == second ) //|| Strings.isNullOrEmpty(first))
        {
            return false;
        }

        if (first.length() != second.length() ) // not certain this is the correct check!
        {
            return false;
        }

        for (int xF = 0; xF < charsF.length; xF++)
        {
            if (!charactersFirst.containsKey((charsF[xF])))
            {
                charactersFirst.put(charsF[xF], 1);
            }
            else
            {
                // this is why we can't have nice things.
                Integer r = charactersFirst.get(charsF[xF]);
                charactersFirst.replace(charsF[xF], r, r += 1);
            }
        }

        for (int xS = 0; xS < charsS.length; xS++)
        {
            if (!charactersSecond.containsKey(charsS[xS]))
            {
                charactersSecond.put(charsS[xS], 1);
            }
            else
            {
                // this is why we can't have nice things.
                Integer s = charactersSecond.get(charsS[xS]);
                charactersSecond.replace(charsS[xS], s, s += 1);
            }
        }

        // where the magic happens or it would, but apparently in java, maybe I can do this another way?
        Set<Character> keys = charactersFirst.keySet();
        Iterator<Character> it = keys.iterator();
        while (it.hasNext()) {
            Character c = it.next();

            if (!charactersSecond.containsKey(c)) {
                return false;
            }

            if (charactersSecond.get(c) != charactersFirst.get(c)) {
                return false;
            }
        }
        return true;
    }
    
    public int Fibonacci(int i) {
    	if (i <= 1) {
    		return i;
    	}
    	else {
    		return Fibonacci(i - 1) + Fibonacci(i - 2);
    	}
    }
    
    public HashMap<String, Integer> CountDuplicateWords(String words) {
    	String[] wordsArray;
    	HashMap<String, Integer> counts = new HashMap<String, Integer>();
    	
    	if (words.length() == 0) {
    		throw new IllegalArgumentException("String param empty? Check again?");
    	}
    	    	
    	if (words.contains(" ")) {
    		// we can debate on whether we should strip out non-alpha characters.
    		wordsArray = words.replaceAll("[^A-Za-z0-9 ]", "").toLowerCase().split(" ");
    		if (wordsArray.length == 0) {
        		throw new IllegalArgumentException("String contains only spaces? Check again?");
        	}
    	}
    	else {
    		wordsArray = new String[1];
    		//wordsArray[0] = words.replaceAll("[^A-Za-z0-9 ]", "").toLowerCase();
    		wordsArray[0] = words.toLowerCase();
    	}
    	
    	for(int i = 0; i < wordsArray.length; i++){
            if (counts.containsKey(wordsArray[i])) {
            	int temp = counts.get(wordsArray[i]);
            	counts.replace(wordsArray[i], temp, temp + 1);
            }
            else {
            	counts.put(wordsArray[i],  1);
            }
    	}    
    	return counts;
    }
    
    public List<String> SelectUniques(String words) {
    	List<String> uniques = new ArrayList<String>();
    	
    	if (words.length() == 0) {
    		throw new IllegalArgumentException("String empty?");
    	}
    	
    	HashMap<String, Integer> check = CountDuplicateWords(words);
    	for (Map.Entry<String, Integer> entry : check.entrySet()) {
    		if (entry.getValue() < 2) {
    			uniques.add(entry.getKey());
    		}
    	}
    	return uniques;
    }
    
    public List<String> SelectRange(String words, int min, int max) {
    	List<String> range = new ArrayList<String>();
    	
    	if (words.length() == 0) {
    		throw new IllegalArgumentException("String empty?");
    	}
    	
		// There is an argument to be made about having an exclusive range selection be allowed. Where we want occurrences of just N times.
    	// For this implementation I am going to allow min & max to be the same, max not requiring to be larger than min. Thus N instances 
    	// are able to be returned not just a span.
    	if (min < 1 || max < 1) {
    		throw new IllegalArgumentException("Min and Max values must be greater than zero.");
    	}
    	
    	HashMap<String, Integer> check = CountDuplicateWords(words);
    	for (Map.Entry<String, Integer> entry : check.entrySet()) {
    		if (entry.getValue() <= max && entry.getValue() >= min) {
    			range.add(entry.getKey());
    		}
    	}
    	return range;
    }
    
    public void Bubblesort(int[] numbers) {
    	for (int c = 0; c < numbers.length - 1; c++) {
    		for (int j = 0; j < numbers.length - c - 1; j++) {
	    		if (numbers[j] > numbers[j + 1]) {
	    			int tmp = numbers[j];
	    			numbers[j] = numbers[j + 1];
	    			numbers[j + 1] = tmp;
	    		}
    		}
    	}
    }
    
    // Quicksort. We could do a fancy pivot selection mechanism. I hear the ninther() is good. 
    // But let's go for a vanilla implementation first. Officially this is a "Lumuto partition scheme"
    
    private int partition(int[] numbers, int low, int high) {
    	int pivot = numbers[high];
    	int i = low - 1;
    	
    	//for (int j = low; j <= high - 1; j++) {
    	for (int j = low; j < high; j++) {
    		if (numbers[j] <= pivot) {
    			i++;
    			int temp = numbers[i];
    			numbers[i] = numbers[j];
    			numbers[j] = temp;
    		}
    	}
    	int swap = numbers[i + 1];
    	numbers[i + 1] = numbers[high];
    	numbers[high] = swap;
    	
    	return i + 1;
    }
    
    public void Quicksort(int[] numbers, int low, int high) {
    	if (low < high) {
	    	int p = partition(numbers, low, high);
	    	Quicksort(numbers, low, p - 1 );
	    	Quicksort(numbers, p + 1, high);
    	}
    }
    
    public void Shellsort(int[] numbers) {
    	// input validation goes here
		int n = numbers.length;
		for (int gap = n/2; gap > 0; gap /= 2)
			for (int i = gap; i < n; i += 1) {
				int temp = numbers[i];
				int j;
				for (j = i; j >= gap && numbers[j - gap] > temp; j -= gap) {
					numbers[j] = numbers[j - gap];
				}
				
	        numbers[j] = temp;
		}
	}
    
    
    public enum Color
    {
        Red,
        Black
    }
    
//    public class RedBlackBST<Key, Value>
//    {
//    	public RedBlackBST() {
//    	}
//    	
//    	private Node root;
//    	
//        private class Node {
//    	public Node(int val, Key key, Color color, int size) {
//            this.setValue(val);
//            this.setColor(color);
//            this.setSize(size);    		
//    	}        
//
//        private Key key;
//        private int value;
//        private int size;
//        private Color color;
//        private Node parent; // not sure if needed, I might be confusing myself.
//        private Node right;
//        private Node left;
//        
//        //public Node Parent { get; set; }
//        public Key getKey() {
//        	return this.key;
//        }
//        public void setKey(Key k) { 
//        	this.key = k; 
//    	}
//        public Node getRight() { 
//        	return this.right;
//        }
//        public void setRight(Node r) {
//        	this.right = r;
//        }
//        public Node getLeft() { 
//        	return this.left;
//        }
//        public void setLeft(Node l) {
//        	this.left = l;
//        }
//        public int getValue() {
//        	return this.value;
//        }
//        public void setValue(int val) { 
//        	this.value = val; 
//    	}       
//        public int getSize() {
//        	return this.size;
//        }
//        public void setSize(int s) {
//        	this.size = s;
//        }
//        public Color getColor() {
//        	return this.color;
//        }
//        public void setColor(Color c) {
//        	this.color = c;        	
//        }
//        
//
//        public Node AddNode(Node n)
//        {
//            if (null != n)
//            {
//                if (n.getValue() >= this.getValue())
//                {
//                    if (null == this.getRight())
//                    {
//                        this.setRight(n);
//                        // I STOPPED HERE. CONTINUE PORTING THIS AFTER THE PHONE SCREEN!!
//                        this.setRight.Parent = this;
//                        this.Right.Color = this.Color ? false : true;
//                    }
//                    else
//                    {
//                        this.Right.AddNode(n);
//                    }
//                }
//                else
//                {
//                    if (null == this.Left)
//                    {                        
//                        this.Left = n;
//                        this.Left.Parent = this;
//                        this.Left.Color = this.Color ? false : true;
//                    }
//                    else
//                    {
//                        this.Left.AddNode(n);
//                    }
//                }
//                return this;
//            }
//            else
//            {
//                return null;
//            }
//        }
//
//        public Node GetNode(int valSeek)
//        {
//            if (this.Value == valSeek)
//            {
//                return this;
//            }
//            else
//            {
//                #region Right
//                if (valSeek > this.Value)
//                {
//                    if (null != this.Right)
//                    {
//                        return this.Right.GetNode(valSeek);
//                    }
//                    else
//                    {
//                        if (null != this.Left)
//                        {
//                            return this.Left.GetNode(valSeek);
//                        }
//                        else
//                        {
//                            return null;
//                        }
//                    }
//                }
//                #endregion
//                #region Left
//                else
//                {
//                    if (null != this.Left)
//                    {
//                        return this.Left.GetNode(valSeek);
//                    }
//                    else
//                    {
//                        if (null != this.Right)
//                        {
//                            return this.Right.GetNode(valSeek);
//                        }
//                        else
//                        {
//                            return null;
//                        }
//                    }
//                }
//                #endregion
//            }
//        }
//
//        // Fixed. But not 100% fully vetted, good enough for now additional tests and such needed. Base functionality works. Children need to be preserved.
//        public Node RemoveNode(int valDelete)
//        {
//            if (null == this.GetNode(valDelete))
//            {
//                return null;
//            }
//            else
//            {
//                /*#region DANGEROUS-IN-FLUX!!
//                if (this.Value == valDelete)
//                {
//                    Node parent = GetParent(valDelete);
//                    Node left = this.Left;
//                    Node right = this.Right;
//
//                    if (parent.Value < valDelete)
//                    {
//                        if (null == this.Left)
//                        {
//                            parent.Left = left;
//                        }
//                        else
//                        {
//                            parent.Left.AddNode(left);
//                        }
//                    }
//                    else // greater than parent val, goes right
//                    {
//                        if (null == this.Right)
//                        {
//                            parent.Right = right;
//                        }
//                        else
//                        {
//                            parent.Right.AddNode(right);
//                        }
//                    }
//                }
//                #endregion
//                else */
//                if (valDelete >= this.Value)//if (valDelete >= this.Value)
//                {
//                    #region NeedingVerification
//                    // this needs to be verified.
//                    if (valDelete == this.Value)
//                    {
//                        if (null == this.Parent)
//                        {
//                            if (null == this.Right && null == this.Left)
//                            {
//                                return null;
//                            }
//                            if (null != this.Right || null != this.Left)                            
//                            {
//                                if (null != this.Right && null != this.Left)
//                                {
//                                    this.Right.Left = this.Right.Left.AddNode(this.Left);
//                                    return this.Right;
//                                }
//                                else
//                                {
//                                    if (null != this.Right)
//                                    {
//                                        this.Right.Left = this.Right.Left.AddNode(this.Left);
//                                        return this.Right;
//                                    }
//                                    else
//                                    {
//                                        //this.Left = this.Right.Left.AddNode(this.Left);
//                                        return this.Left; // Not confident about this.
//                                    }
//                                }
//                            }
//
//
//                            else
//                            {
//                                return this.Left;
//                            }
//                        }
//                        else
//                        {
//                            this.Parent.Left = this.Parent.Left.AddNode(this.Left);
//                            this.Parent.Right = this.Parent.Right.AddNode(this.Right);
//                        }
//
//                    }
//                    #endregion
//                    else if (null != this.Right)
//                    {
//                        if (this.Right.Value == valDelete)
//                        {
//                            Node left = this.Right.Left;
//                            Node right = this.Right.Right;
//
//                            if (null != this.Right.Right)
//                            {
//                                this.Right = this.AddNode(right);
//                            }
//                            if (null != this.Right.Left)
//                            {
//                                this.Right.Left = this.AddNode(left);
//                            }
//                            this.Right = null; // Removing it properly after copying any subtrees?
//                        }
//                        else
//                        {
//                            if (this.Value == valDelete)
//                            {
//                                if (null == GetParent(valDelete)) // okay so it is the root Node? Well fuck.
//                                {
//
//                                }
//                            }
//                            else
//                            {
//                                return this.Right.RemoveNode(valDelete);
//                            }
//                        }
//                    }
//                    else
//                    {
//                        return this.RemoveNode(valDelete);
//                    }
//                }
//                else
//                {
//                    if (null != this.Left)
//                    {
//                        if (this.Left.Value == valDelete)
//                        {
//                            #region dont care
//                            //this.Left = this.AddNode(this.Left.Left);
//                            //if ((null != this.Right) && (null != this.Left.Right))
//                            //{
//                            //    this.Right = this.Right.AddNode(this.Left.Right);
//                            //}
//                            #endregion
//                            Node left = this.Left.Left;
//                            Node right = this.Left.Right;
//
//                            if (null != this.Left.Right)
//                            {
//                                this.Left.Right = this.AddNode(right);
//                            }
//                            if (null != this.Left.Left)
//                            {
//                                this.Left = this.Left.AddNode(left); // reassign parent relationship here
//                            }
//                        }
//                        else
//                        {
//                            return this.Left.RemoveNode(valDelete);
//                        }
//                    }
//                    else
//                    {
//                        return this.RemoveNode(valDelete);
//                    }
//                }
//                return this;
//            }
//        }
//
//        //TODO: Implement RemoveFirst(), RemoveLast(), Remove(T node)
//
//        public void InOrderDisplay(Node current)
//        {
//            if (current != null)
//            {
//                InOrderDisplay(current.Left);
//                Console.Write("({0}) ", current.Value);
//                InOrderDisplay(current.Right);
//            }
//        }
//
//        public Node GetRootNode()
//        {
//            if (null != this.Parent)
//            {
//                return this.Parent.GetRootNode();
//            }
//            else { return this; }
//        }
//
//        #region Suspicious
//        public Node GetParent(int val)
//        {
//            if ((this.Right == null) && (this.Left == null))
//            {
//                return null;
//            }
//            else if ((null != this.Right) && (val > this.Value))
//            {
//                if (this.Right.Value == val)
//                {
//                    return this;
//                }
//                else
//                {
//                    return this.Right.GetParent(val);
//                }
//            }
//            else
//            {
//                if ((null != this.Left) && (this.Left.Value == val))
//                {
//                    return this;
//                }
//                else
//                {
//                    return this.Left.GetParent(val);
//                }
//            }
//        }
//
//        public int GetMin()
//        {
//            return this.Min(this);
//        }
//
//        private int Min(Node m)
//        {
//            Node current = m;
//
//            while (null != current.Left)
//            {
//                current = current.Left;
//            }
//            return current.Value;
//        }
//
//        public int GetMax()
//        {
//            return this.Max(this);
//        }
//
//        private int Max(Node m)
//        {
//            Node current = m;
//
//            while (null != current.Right)
//            {
//                current = current.Right;
//            }
//            return current.Value;
//        }
//        #endregion
//
//        private int count_node_recursively(Node n)
//        {
//            int c = 1;
//            if (null == n)
//            {
//                return c;
//            }
//
//            if (n.Left != null)
//            {
//                c += count_node_recursively(n.Left);
//            }
//            if (n.Right != null)
//            {
//                c += count_node_recursively(n.Right);
//            }
//            return c;
//        }
//
//        public int Count(Node begining)
//        {
//            int c = 0;
//            if (null == begining)
//            {
//                return c;
//            }
//
//            if (begining.Parent != null)
//            {
//                c = count_node_recursively(begining.Parent);
//            }
//            else
//            {
//                c = count_node_recursively(begining);
//            }
//
//            #region returns
//            if (c == 0)
//            {
//                return 0;
//            }
//            else if (c == 1)
//            {
//                return 1;
//            }
//            else
//            {
//                return (c - 1);
//            }
//            #endregion
//        }
//
//        // http://stackoverflow.com/questions/33701317/recursive-search-binary-tree-c-sharp
//        public bool isValidBST(Node root)
//        {
//            return isValid(root, Int64.MinValue, Int64.MaxValue);
//        }
//
//        private bool isValid(Node node, Int64 MIN, Int64 MAX)
//        {
//            if (null == node)
//            {
//                return true;
//            }
//
//            if (node.Value <= MIN || node.Value >= MAX)
//            {
//                return false;
//            }
//
//            return isValid(node.Left, MIN, node.Value) && isValid(node.Right, node.Value, MAX);        
//        }
//
//        // Implement this!
//        public Node FoldL(Node source, Func<Node, Node> funct)
//        {
//            throw new NotImplementedException("this needs to be written first!");
//            //return new Node();
//        }
//        #endregion
//    }

}