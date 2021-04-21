package java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {

		public static void main(String args[]) { 
		    List<Integer> numbers = Arrays.asList(2,3,4,5,2); 
		    List<String> names = Arrays.asList("Reflection","Collection","Stream"); 
		  
			/*Streams - Stream API is used to process collections of objects
					  - Streams don’t store the data and don't change the original data structure, they only provide the result as per the pipelined methods.
					  - All intermediate operations are lazy. 
			*/		    
		    //Streams Creation >>
		    //stream() - new stream method to the Collection interface
		    Stream<String> stringStream1 = names.stream();
		    System.out.println(stringStream1.collect(Collectors.toList()));//[Collection, Reflection, Stream]
		    
		    //of() - using this we can create a stream from individual objects
		    Stream<List<String>> stringStream2 = Stream.of(names);
		    System.out.println(stringStream2.collect(Collectors.toList()));//[Collection, Reflection, Stream]
		    
		    //builder()
		    Stream.Builder<String> stringStreamBuilder = Stream.builder();
		    stringStreamBuilder.accept(names.get(0));
		    stringStreamBuilder.accept(names.get(1));
		    Stream<String> stringStream = stringStreamBuilder.build();
		    System.out.println(stringStream.collect(Collectors.toList()));//[Collection, Reflection]

		    //Stream Operations >>
		    //map() - is used to map the items in the collection to other objects according to the Predicate passed as argument.
		    List<Integer> square = numbers.stream().map(x -> x*x).collect(Collectors.toList()); 
		    System.out.println(square); //[4, 9, 16, 25, 4]
		
		    //filter() - is used to select elements as per the Predicate passed as argument. 
		    List<String> result = names.stream().filter(s->s.startsWith("S")).collect(Collectors.toList()); 
		    System.out.println(result); //[Stream]
		  
		    //sorted() - is used to sort the stream. 
		    List<String> show = names.stream().sorted().collect(Collectors.toList()); 
		    System.out.println(show); //[Collection, Reflection, Stream]
		  
		    //collect() - is used to return the result of the intermediate operations performed on the stream.
		    Set<Integer> squareSet = numbers.stream().map(x->x*x).collect(Collectors.toSet()); 
		    System.out.println(squareSet); //[16, 4, 9, 25]
		  
		    //forEach() - is used to iterate through every element of the stream
		    numbers.stream().map(x->x*x).forEach(y->System.out.println(y)); //4 9 16 25 4
		  
		    //reduce() -  is used to reduce the elements of a stream to a single value.
		    int even = numbers.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i); 
		    System.out.println(even); //8
		    
		    //flatMap -A stream can hold complex data structures like Stream<List<String>>. In cases like this, flatMap() helps us to flatten the data structure to simplify further operations.
		    List<List<String>> namesNested = Arrays.asList(Arrays.asList("Jeff", "Bezos"),Arrays.asList("Mark", "Zuckerberg"));
		    List<String> namesFlatStream = namesNested.stream().flatMap(Collection::stream).collect(Collectors.toList());
		    System.out.println(namesFlatStream); //[Jeff, Bezos, Mark, Zuckerberg]
		    
			// Lamda expression >>
			/*
			 * Lambda expressions basically express instances of functional interfaces (An
			 * interface with single abstract method is called functional interface. An
			 * example is java.lang.Runnable). lambda expressions implement the only
			 * abstract function and therefore implement functional interfaces
			 * 
			 *  - (arguments) -> body of lamda expression
			 * 
			 */
			FuncInterface fobj = (int x) -> System.out.println(2 * x); // The target type of this expression must be a functional interface.
			fobj.abstractFun(5);// This calls above lambda expression and prints 10.
			fobj.normalFun();// Hello
			
			// Add or multiply two numbers using lambda expression 
			FuncInter1 add = (int x, int y) -> x + y;
			FuncInter1 multiply = (int x, int y) -> x * y; 

			StreamsTest testJdk8 = new StreamsTest();
			System.out.println("Addition is " + testJdk8.operate(6, 3, add)); //9
			System.out.println("Multiplication is " + testJdk8.operate(6, 3, multiply)); //18	 

	        }
		
		  	private int operate(int a, int b, FuncInter1 fobj) 
		    { 
		        return fobj.operation(a, b); 
		    } 
	}

	// A sample functional interface (An interface with single abstract method)
	interface FuncInterface {
		void abstractFun(int x);

		// A non-abstract (or default) function
		default void normalFun() {
			System.out.println("Hello");
		}
	}

	interface FuncInter1{
		int operation(int x, int y);
	}

