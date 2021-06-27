package com.java8.op;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/* map.computeIfAbsent(key, k -> new Value(f(k)));
Or to implement a multi-value map, Map<K,Collection<V>>, supporting multiple values per key: 
 map.computeIfAbsent(key, k -> new HashSet<V>()).add(v);
 
Parameters:
key - key with which the specified value is to be associated
mappingFunction - the function to map a value : R apply(T t);
Returns:
the current (existing or computed) value associated with the specified key
*/
public class CollectorsEx {

	public static void main(String[] args) {
		StudentRepository stdRep = new StudentRepository();
				
		List<Student> students= stdRep.getAllStudents();

//1. student -> subjects mapping
		Map<String, List<SUBJECT>> studSubjectMap = new HashMap<>();
		Function<? super String, ? extends List<SUBJECT>> studSubjectsMappingFunction = x->new ArrayList<>();
		students.stream().forEach(s->{
			studSubjectMap.computeIfAbsent(s.getName(), studSubjectsMappingFunction).add(s.getSubject());
		});
		System.out.println(studSubjectMap);
		//{Robert=[LITERATURE], Sascha=[ENGLISH, MATH, SIENCE, LITERATURE], Davis=[MATH, SIENCE, GEOGRAPHY]}
		
//2. subject ->students mapping
		Map<SUBJECT, List<String>> SubjectStudMap = new HashMap<>();
		Function<? super SUBJECT, ? extends List<String>> subStudMappingFunction = x->new ArrayList<>();
		students.stream().forEach(s->{
			SubjectStudMap.computeIfAbsent(s.getSubject(), subStudMappingFunction).add(s.getName());
		});
		System.out.println(SubjectStudMap);
		//{MATH=[Davis, Sascha], GEOGRAPHY=[Davis], ENGLISH=[Sascha], SIENCE=[Davis, Sascha], LITERATURE=[Sascha, Robert]}
		
//3. Collectors groupingBY 
		students.stream().collect(Collectors.groupingBy(Student::getSubject)).entrySet().forEach(System.out::println);
		
//4. results multimap of student->(subject->mark)
		Map<String, Map<SUBJECT,List<Double>>> studSubjectMarksMap = new HashMap<>();
		students.stream().forEach(s->{
			studSubjectMarksMap
			.computeIfAbsent(s.getName(), x->new HashMap<>())
			.computeIfAbsent(s.getSubject(), y->new ArrayList<>())
			.add(s.getMarks());
		});
		
		System.out.println(studSubjectMarksMap);
		/*
		 * {Robert={LITERATURE=[12.0]}, Sascha={MATH=[80.0], ENGLISH=[85.0],
		 * SIENCE=[12.0], LITERATURE=[50.0]}, Davis={MATH=[35.0], GEOGRAPHY=[37.0],
		 * SIENCE=[12.9]}}
		 */

	}

}
