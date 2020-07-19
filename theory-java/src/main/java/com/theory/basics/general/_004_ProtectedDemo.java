package com.theory.basics.general;

import com.theory.support.ParentWithProtectedVariable;

class ChildUsingProtected extends ParentWithProtectedVariable {

	public void showProtected() {
		System.out.println("Protected Variable X of Parent Class : " + X); // Accessible
																			// in
																			// subclass
																			// of
																			// different
																			// package
																			// as
																			// "X"
																			// is
																			// marked
																			// protected
	}

	public void protectedPrintFromChild() {
		protectedPrintOfParent();
	}
}

public class _004_ProtectedDemo {
	public static void main(String args[]) {
		ChildUsingProtected childUsingProtected = new ChildUsingProtected();
		childUsingProtected.showProtected();

		 //System.out.println(childUsingProtected.X);

		// DOES NOT COMPILE AS Once the subclass-outside-the-package inherits
		// the protected member, that member (as inherited by the subclass)
		// becomes private to any code outside the subclass, with the exception
		// of subclasses of the subclass.

		System.out.println("Public Variable Y of Parent class : " + childUsingProtected.Y); // compiles
																							// as
																							// "Y"
																							// is
																							// public
																							// in
																							// parent

		childUsingProtected.protectedPrintFromChild();

		 //childUsingProtected.protectedPrintOfParent();
		
		// DOES NOT COMPILE AS same rule applies to methods as to variables
	}
}
