package com.java8.venkat.streams_sample6;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** 2.
 * Streamlining Iterations
 * External vs Internal iterators
 * Specialized functions
 * Function composition
 * Infinite stream
 * Lazy valuation
 * Intermediate function(just to accumulate op, no computation) vs Terminal function(actual computation is triggered)
 */
public class SqrootOf100Primes_2 {

	public static void main(String[] args) {
		/*List<Double> sqrtOff100Prime = new ArrayList<>();
		int index=1;
		while(sqrtOff100Prime.size()<100) {
			if(PrimeChecker.isPrime(index)) {
				sqrtOff100Prime.add(Math.sqrt(index));
			}
			index++;
		}*/
		List<Double> sqrtOff100Prime=	
		Stream.iterate(1, e->e+1)
		.filter(PrimeChecker::isPrime)
		.map(Math::sqrt)
		.limit(100)
		.collect(Collectors.toList());
		
		System.out.println(
				String.format("Computer %d values, first is %g, last is %g", 
						sqrtOff100Prime.size(),
						sqrtOff100Prime.get(0),
						sqrtOff100Prime.get(sqrtOff100Prime.size()-1)));
	}

}
