package by.bsuir.lab2.presentation.impl;

import by.bsuir.lab2.presentation.inter.View;

public class ConsoleView implements View {
	
	public void printMessage(String message) {
		System.out.println(message);
	}
}
