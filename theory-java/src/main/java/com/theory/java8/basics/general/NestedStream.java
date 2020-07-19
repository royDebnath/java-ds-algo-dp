package com.theory.java8.basics.general;

import java.util.Arrays;

import java.util.List;

class TypeA {
	String aField1;
	String aField2;

	public TypeA(String aField1, String field2) {
		this.aField1 = aField1;
		this.aField2 = field2;
	}

	public String getAField1() {
		return aField1;
	}

	public void setAField1(String field1) {
		this.aField1 = field1;
	}

	public String getAField2() {
		return aField2;
	}

	public void setAField2(String field2) {
		this.aField2 = field2;
	}

	@Override
	public String toString() {
		return "TypeA [aField1=" + aField1 + ", aField2=" + aField2 + "]";
	}
}

class TypeB {
	String bField1;
	String bField2;

	public TypeB(String bField1, String bField2) {
		this.bField1 = bField1;
		this.bField2 = bField2;
	}

	public String getBField1() {
		return bField1;
	}

	public void setBField1(String field1) {
		this.bField1 = field1;
	}

	public String getBField2() {
		return bField2;
	}

	public void setBField2(String field2) {
		this.bField2 = field2;
	}

	@Override
	public String toString() {
		return "TypeB [bField1=" + bField1 + ", bField2=" + bField2 + "]";
	}
}

public class NestedStream {

	public static void main(String agrs[]) {
		List<TypeA> listTypeA = Arrays.asList(new TypeA("a", "b"), new TypeA("c", "d"), new TypeA("e", "f"));
		List<TypeB> listTypeB = Arrays.asList(new TypeB("a", ""), new TypeB("c", ""), new TypeB("e", ""));

		// for (TypeA a : listTypeA) {
		// for (TypeB b : listTypeB) {
		// if (a.getAField1().equals(b.getBField1())) {
		// b.setBField2(a.getAField2());
		// break;
		// }
		//
		// }
		//
		// }

                   listTypeB.forEach(b -> System.out.println(b.toString()));
                   System.out.println("============================");

                   listTypeB
                   .forEach(                            
                            b -> listTypeA.stream()
                                                   .filter(
                                                            a -> a.getAField1().equals(b.getBField1())
                                                           )
                                                           .forEach(
                                                                    a -> b.setBField2(a.getAField2())
                                                                    )
                            );  
                   
                   listTypeB.forEach(b -> System.out.println(b.toString()));            
      }
}