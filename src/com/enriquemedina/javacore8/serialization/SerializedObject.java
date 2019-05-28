package com.enriquemedina.javacore8.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializedObject  {
	public static void main(String[] args) {
		Employee e = new Employee();
		e.name = "Enrique Medina";
		e.address = "Aguascalientes, Ags";
		e.SSN  = 1;
		e.number = 101;
		
		try {
			FileOutputStream fileOut = new FileOutputStream("tmp\\employee.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in /tmp/employee.ser");
		}catch(IOException i){i.printStackTrace();  }
	}
}

class Employee implements Serializable{
	public String name;
	public String address;
	public transient int SSN;
	public int number;
	
	public void mailCheck() {
		System.out.println("Mailing a check to " + name + " " + address);
	}
}