package com.patterns.architectural.mvc.impl;

import com.patterns.architectural.mvc.controller.StudentController;
import com.patterns.architectural.mvc.model.Student;
import com.patterns.architectural.mvc.view.StudentView;

/*MVC Pattern stands for Model-View-Controller Pattern. This pattern is used to separate application's concerns.

Model - Model represents an object or JAVA POJO carrying data. It can also have logic to update controller if its data changes.

View - View represents the visualization of the data that model contains.

Controller - Controller acts on both model and view. 
			It controls the data flow into model object and updates the view 
			whenever data changes. It keeps view and model separate.

Implementation
We are going to create a Student object acting as a model.
StudentView will be a view class which can print student details on console and
StudentController is the controller class responsible to store data in Student 
object and update view StudentView accordingly.

MVCPatternDemo, our demo class, will use StudentController to demonstrate use of MVC pattern.
*/

public class MVCPatternDemo {
   public static void main(String[] args) {

      //fetch student record based on his roll no from the database
      Student model  = retriveStudentFromDatabase();

      //Create a view : to write student details on console
      StudentView view = new StudentView();

      StudentController controller = new StudentController(model, view);

      controller.updateView();

      //update model data
      controller.setStudentName("John");

      controller.updateView();
   }

   private static Student retriveStudentFromDatabase(){
      Student student = new Student();
      student.setName("Robert");
      student.setRollNo("10");
      return student;
   }
}