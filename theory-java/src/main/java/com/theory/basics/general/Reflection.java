package com.theory.basics.general;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

class Secret {
	private String secretCode = "It's a secret";

	private String getSecretCode() {
		return secretCode;
	}
}

public class Reflection {

	private static final Object[] EMPTY = {};

	public void reflect() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Secret instance = new Secret();
		Class<?> secretClass = instance.getClass();

		// Print all the method names & execution result
		Method methods[] = secretClass.getDeclaredMethods();
		System.out.println("Access all the methods");
		for (Method method : methods) {
			System.out.println("Method Name: " + method.getName());
			System.out.println("Return type: " + method.getReturnType());
			method.setAccessible(true);
			System.out.println(method.invoke(instance, EMPTY) + "\n");
		}

		// Print all the field names & values
		Field fields[] = secretClass.getDeclaredFields();
		System.out.println("Access all the fields");
		for (Field field : fields) {
			System.out.println("Field Name: " + field.getName());
			field.setAccessible(true);
			System.out.println(field.get(instance) + "\n");
		}
	}

	public static void main(String[] args) {
		Reflection newHacker = new Reflection();

		try {
			newHacker.reflect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Knowledge {
	private static final Integer ANSWER = 42;

	public String askQuestion(String question) {
		return "The answer to '" + question + "' is: " + ANSWER;
	}
}

class KnowledgeTest {
	@Test
	public void testAskQuestion() throws Exception {
		Knowledge knowledge = new Knowledge();
		String answer = knowledge.askQuestion("question?");
		// assertThat(answer, is("The answer to 'question?' is: 42"));
		setFinalStaticField(Knowledge.class, "ANSWER", 41);
		answer = knowledge.askQuestion("question?");
		// assertThat(answer, is("The answer to 'question?' is: 41"));
	}

	private static void setFinalStaticField(Class<?> clazz, String fieldName, Object value)
			throws ReflectiveOperationException {
		Field field = clazz.getDeclaredField(fieldName);
		field.setAccessible(true);
		Field modifiers = Field.class.getDeclaredField("modifiers");
		modifiers.setAccessible(true);
		modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);
		field.set(null, value);
	}
}
