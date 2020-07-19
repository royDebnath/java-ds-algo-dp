package com.theory.basics.general;

/*
 *   An anonymous inner class is a local inner class that does not have a name.
 *  It is declared and instantiated all in one statement using the new keyword.
 *  Anonymous inner classes are required to extend an existing class or implement an existing interface. 
 *  They are useful when you have a short implementation that will not be used anywhere else. 
 *  
 */
public class _013_AnonymousInnerClass {
	abstract class SaleTodayOnly {
		abstract int dollarsOff();
	}

	interface SaleTodayOnlyInterface {
		int dollarsOff();
	}

	public int admission(int basePrice) {
		SaleTodayOnly sale = new SaleTodayOnly() {/*
													 * Anonymous class
													 * instantiation
													 * implementing methods of
													 * abstract class
													 * 
													 */
			int dollarsOff() {
				return 3;
			}
		};
		return basePrice - sale.dollarsOff();
	}

	public int admissionI(int basePrice) {
		SaleTodayOnlyInterface sale = new SaleTodayOnlyInterface() {/*
																	 * Anonymous
																	 * class
																	 * instantiation
																	 * implementing
																	 * methods
																	 * of
																	 * interface
																	 * 
																	 */
			public int dollarsOff() {
				return 3;
			}
		};
		return basePrice - sale.dollarsOff();
	}

}
