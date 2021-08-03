package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


class XLSWorkbookReader {
	public FileInputStream fi=null;
	public FileOutputStream fo = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet worksheet = null;
	public String filePath = null;
	private XSSFRow Row = null;
	private XSSFCell Cell = null;

	public XLSWorkbookReader(String filePath) {
		this.filePath=filePath;

		try {
			fi = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fi);
			worksheet = workbook.getSheetAt(0);
			fi.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//rowcount of the sheet
	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1) {
			return -1;
		}
		else {
			worksheet = workbook.getSheetAt(index);
			return worksheet.getLastRowNum()+1;
		}

	}
	
	//get Column Count
	public int getColumnCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1) {
			return -1;
		}
		else {
			worksheet = workbook.getSheetAt(index);
			Row = worksheet.getRow(0);
			if(Row==null) {
				return -1;
			}
			return Row.getLastCellNum();
		}
		
	}
	//getColumnIndex
	public int getColumnIndex(String sheetName, String columnName) {
		worksheet = workbook.getSheet(sheetName);

		int TotalCols = worksheet.getRow(0).getLastCellNum();
		Row = worksheet.getRow(0);
		int index = -1;

		for(int i=0;i<TotalCols;i++) {
			if(Row.getCell(i).getStringCellValue().equals(columnName)) {
				index = i;
				break;
			}
		}
		return index;
	}
	//getRow

	//getCellData
	public String getCellData(String sheetName,int colNum,int rowNum) {
		try {
			int index = workbook.getSheetIndex(sheetName);
			worksheet = workbook.getSheetAt(index);

			if(worksheet==null) {
				System.out.println("There is no sheet with given name "+ sheetName);
				return "";
			}

			Row = worksheet.getRow(rowNum-1);
			if(Row==null) return "";
			Cell = Row.getCell(colNum);
			if(Cell==null) return "";

			String cellType = Cell.getCellType().name();
			if(cellType.equals("STRING")){

				return Cell.getStringCellValue();
			}
			else if(cellType.equals("NUMERIC") || cellType.equals("FORMULA")) {

				String cellText = String.valueOf(Cell.getNumericCellValue());

				if(HSSFDateUtil.isCellDateFormatted(Cell)){
					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(Cell.getNumericCellValue()));
					String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
					String month = String.valueOf(cal.get(Calendar.MONTH)+1);
					String year = String.valueOf(cal.get(Calendar.YEAR));
					cellText = day+"/"+month+"/"+year;
				}
				return cellText;
			}
			else if(Cell.getCellType().BLANK !=null){
				return "";
			}else {
				return String.valueOf(Cell.getBooleanCellValue());
			}
		}catch(Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public boolean SetCellData(String sheetName, String columnName, int rowNum, String strData) {

		try {

			if(rowNum<1)
				return false;
			//getColIndex
			int colIndex = getColumnIndex(sheetName, columnName);

			if(colIndex==-1) return false;

			//initiate worksheet actions
			worksheet = workbook.getSheet(sheetName);
			Row = worksheet.getRow(rowNum-1);

			if(Row==null) {
				worksheet.createRow(rowNum-1);
			}
			Cell = Row.getCell(colIndex);

			if(Cell==null) {
				Cell = Row.createCell(colIndex);
			}

			Cell.setCellValue(strData);

			FileOutputStream fo = new FileOutputStream(filePath);
			workbook.write(fo);
			fo.close();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	//Add New sheet

	public boolean addNewSheet(String sheetName) {
		try {
			workbook.createSheet(sheetName);
			FileOutputStream fo = new FileOutputStream(filePath);
			workbook.write(fo);
			fo.close();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	//Remove Sheet

	public boolean removeSheet(String sheetName) {
		try {
			int index = workbook.getSheetIndex(sheetName);
			if(index<0) {
				return false;
			}
			workbook.removeSheetAt(index);
			FileOutputStream fo = new FileOutputStream(filePath);
			workbook.write(fo);
			fo.close();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//Add new column

	public boolean addnewColumn(String sheetName,String colName) {
		try {
			if(workbook.getSheetIndex(sheetName)<0) {
				return false;
			}
			worksheet = workbook.getSheetAt(workbook.getSheetIndex(sheetName));
			Row = worksheet.getRow(0);
			if(Row==null) {
				Row = worksheet.createRow(0);
			}
			if(Cell==null) {
				Cell = Row.createCell(0);
			}
			else {
				int totalCols = Row.getLastCellNum();				
				Cell = Row.createCell(totalCols);
			}

			XSSFCellStyle style = workbook.createCellStyle();
			Cell.setCellValue(colName);
			Cell.setCellStyle(style);

			FileOutputStream fo = new FileOutputStream(filePath);
			workbook.write(fo);
			fo.close();

		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	//Remove a column
	public boolean removeColumn(String sheetName, String colName) {
		try {
			int index = workbook.getSheetIndex(sheetName);
			if(index<0) return false;

			worksheet = workbook.getSheetAt(index);

			int colIndex = getColumnIndex(sheetName, colName);
			if(colIndex<0) return false;

			XSSFCellStyle style = workbook.createCellStyle();
			int iRows = worksheet.getLastRowNum();
			if(iRows<0) return false;

			for(int i=0;i<=iRows;i++) {

				Row = worksheet.getRow(i);
				if(Row!=null) {
					for(int j=colIndex;j<=Row.getLastCellNum();j++) {
						Cell = Row.getCell(j);
						if(Cell!=null) Row.removeCell(Cell);

						XSSFCell nextcell = Row.getCell(j+1);
						if(nextcell!=null) {
							XSSFCell oldCell = Row.createCell(j,nextcell.getCellType());
							CloneCell(oldCell,nextcell);
						}
					}
				}
			}
			FileOutputStream fo = new FileOutputStream(filePath);
			workbook.write(fo);
			fo.close();

		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void CloneCell(XSSFCell oldCell, XSSFCell NewCell) {
		oldCell.setCellComment(NewCell.getCellComment());
		oldCell.setCellStyle(NewCell.getCellStyle());
		String cellType = NewCell.getCellType().name();
		
		if(cellType.equals("STRING")) {
			
			oldCell.setCellValue(NewCell.getStringCellValue());
			
		}
		else if(cellType.equals("NUMERIC")){
			oldCell.setCellValue(NewCell.getNumericCellValue());
			
		}
		else if(cellType.equals("ERROR")){
			oldCell.setCellErrorValue(NewCell.getErrorCellValue());
			
		}
		else if(cellType.equals("FORMULA")){
			oldCell.setCellFormula(NewCell.getCellFormula());
			
		}
		else{
			oldCell.setCellValue(NewCell.getBooleanCellValue());
			

		}
	}
}
