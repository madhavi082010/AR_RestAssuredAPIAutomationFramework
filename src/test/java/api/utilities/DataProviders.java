package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="AllData")
	public String [][] AllDataProvider() //This Method will return a String Multi Dimensional Array
	{
		//For Filename, we will create a String variable below and store value in fName variable
		
		String fName = System.getProperty("user.dir")+"//TestData//TestData.xlsx";
		
		//We need Total Rows and COlumns for that we will create a variable below
		int ttlRowCnt = ReadExcelFile.getRowCount(fName, "Sheet1");
		int ttlColCnt = ReadExcelFile.getColCount(fName, "Sheet1");
		
		//We need to Create a String Array with the Dimension(Size) - Size will be the Total no of rows and columns count
		String userData[][] = new String[ttlRowCnt-1][ttlColCnt]; //Total Row is 4 and Total Column is 7
		
		for(int rowNo = 1; rowNo<ttlRowCnt; rowNo++)
		{
			for(int colNo = 0; colNo<ttlColCnt; colNo++)
			{
				userData[rowNo-1][colNo] = ReadExcelFile.getCellValue(fName, "Sheet1", rowNo, colNo);
			}
		}		
		return userData;
	}
	
	//We will create another DataProvider Method only for Username, which is needed for Get/Delete EndPoints
	
	
	@DataProvider(name="UserNamesData")
	public String[] UserNamesDataProvider() //This Method will return a String Single Array
	{
		//For Filename, we will create a String variable below and store value in fName variable
		
		String fName = System.getProperty("user.dir")+"//TestData//TestData.xlsx";
		
		//We need Total Rows and COlumns for that we will create a variable below
		int ttlRowCnt = ReadExcelFile.getRowCount(fName, "Sheet1");
		//int ttlColCnt = ReadExcelFile.getColCount(fName, "TestData");
		
		//We need to Create a String Array with the Dimension(Size) - Size will be the Total no of rows and columns count
		String userNamesData[] = new String[ttlRowCnt-1]; //Total Row is 4 and Total Column is 7
		
		for(int rowNo = 1; rowNo<ttlRowCnt; rowNo++)
		{
			userNamesData[rowNo-1] = ReadExcelFile.getCellValue(fName, "Sheet1", rowNo, 1);
		}		
		return userNamesData;
	}	

}
