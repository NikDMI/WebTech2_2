package by.bsuir.lab2.presentation;

import by.bsuir.lab2.presentation.impl.ConsoleView;
import by.bsuir.lab2.presentation.inter.View;

public class ViewFactory {

	public static View getConsoleView() {
		return new ConsoleView();
	}
}
