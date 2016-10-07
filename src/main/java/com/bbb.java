package com;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class bbb {
	public static void main(String[] args) {
		bbb streamTest = new bbb();
		System.out.println("test brance");
        //arraysStream();

       // collectionStream();

        //generate();

        //iterateStream();
        
        //populaStream();
        
    	streamTest.testLimitAndSkip();
    	String a = "aaa";
    	String b = "bbb";
    	String c = "ccc";
    }

    //From Arrays
    public static void arraysStream() {
        String[] arr = {"program", "creek", "program", "creek", "java", "web",
            "program"};
        Stream<String> stream = Stream.of(arr);
        System.out.println(Arrays.toString(arr));

    }

    //From Collections
    public static void collectionStream() {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("python");
        list.add("c++");
        list.add("c");
        list.add("lisp");

        Stream<String> stream = list.stream().filter(p -> p.length() > 3);
        String[] arr = stream.toArray(String[]::new);
        System.out.println(Arrays.toString(arr));
    }

    //Use Stream.generate()
    public static void generate() {
        Stream<String> stream = Stream.generate(() -> "test").limit(10);
        String[] strArr = stream.toArray(String[]::new);
        System.out.println(Arrays.toString(strArr));
    }

    //Use Stream.iterate()
    public static void iterateStream() {
        Stream<BigInteger> bigIntStream = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.TEN)).limit(10);
        BigInteger[] bigIntArr = bigIntStream.toArray(BigInteger[]::new);
        System.out.println(Arrays.toString(bigIntArr));
    }
    // From Popular APIs
    public static void populaStream() {
        String sentence = "Program creek is a Java site.";
        Stream<String> wordStream = Pattern.compile("\\W").splitAsStream(sentence);
        String[] wordArr = wordStream.toArray(String[]::new);
        System.out.println(Arrays.toString(wordArr));
    }
    
    public void testLimitAndSkip() {  
        List<Person> persons = new ArrayList();  
        for (int i = 1; i <= 10000; i++) {  
            Person person = new Person(i, "name" + i);  
            persons.add(person);  
        }  
        List<String> personList2 = persons.stream().map(Person::getName)  
                .limit(10).skip(3).collect(Collectors.toList());
        System.out.println(persons.stream().map(Person::getName).collect(Collectors.toList()));  
        System.out.println(personList2);  
    }  
    private class Person {  
        public int no;  
        private String name;  
  
        public Person(int no, String name) {  
            this.no = no;  
            this.name = name;  
        }  
  
        public String getName() {  
            //System.out.println(name);  
            return name;  
        }  
    }  
}
