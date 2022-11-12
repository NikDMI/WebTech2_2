package by.bsuir.lab2.controller;

import by.bsuir.lab2.controller.interf.Controller;

public class ControllerFactory {

	public static Controller getController() {
		return new by.bsuir.lab2.controller.impl.Controller();
	}
}
