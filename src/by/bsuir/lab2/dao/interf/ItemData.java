package by.bsuir.lab2.dao.interf;

import by.bsuir.lab2.bean.*;
import java.util.*;
import by.bsuir.lab2.dao.exception.*;

public interface ItemData {
	
	public void writeData(ITransferData data) throws DaoException;
	
	public void writeData(ArrayList<ITransferData> data) throws DaoException;
	
	public ArrayList<ITransferData> readData() throws DaoException;
}
