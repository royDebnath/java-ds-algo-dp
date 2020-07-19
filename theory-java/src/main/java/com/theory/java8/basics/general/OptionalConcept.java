package com.theory.java8.basics.general;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

public class OptionalConcept {

	@Test
	public void whenCreatesEmptyOptional_thenCorrect() {
	    Optional<String> empty = Optional.empty();
	    assertFalse(empty.isPresent());
	}
	
	@Test
	public void givenNonNull_whenCreatesOptional_thenCorrect() {
	    String name = "baeldung";
	    Optional<String> opt = Optional.of(name);
	    assertEquals("Optional[baeldung]", opt.toString());
	}
	
	@Test
	public void givenNull_whenCreatesNullable_thenCorrect() {
	    String name = null;
	    Optional<String> opt = Optional.ofNullable(name);
	    assertEquals("Optional.empty", opt.toString());
	}
	
	@Test
	public void givenOptional_whenIsPresentWorks_thenCorrect() {
	    Optional<String> opt = Optional.of("Baeldung");
	    assertTrue(opt.isPresent());
	 
	    opt = Optional.ofNullable(null);
	    assertFalse(opt.isPresent());
	}
	
	@Test
	public void givenOptional_whenIfPresentWorks_thenCorrect() {
	    Optional<String> opt = Optional.of("baeldung");
	 
	    opt.ifPresent(name -> System.out.println(name.length()));
	}
	
	@Test
	public void whenOrElseWorks_thenCorrect() {
	    String nullName = null;
	    String name = Optional.ofNullable(nullName).orElse("john");
	    assertEquals("john", name);
	}
	
	@Test
	public void whenOrElseGetWorks_thenCorrect() {
	    String nullName = null;
	    String name = Optional.ofNullable(nullName).orElseGet(() -> "john");
	    assertEquals("john", name);
	}
	
}
