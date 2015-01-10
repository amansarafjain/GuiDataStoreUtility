/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import static com.MainGui.EditExistingButtonClicked;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Aman
 */
public class FuntionLibrary {
boolean testEmail, testMob;
Pattern patternEmail, patternMob;
Matcher matcherEmail, matcherMob;
public static final String sheetName = "Sheet1";//name of sheet
private static final String MOBILE_PATTERN = "\\d{10}";
private static final  String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
public static final String excelFileName = System.getProperty("user.dir")+ "\\DataBase.xlsx";
public static Boolean Pflag = false;
public static Boolean Eflag = false;
public static Boolean Mflag = false;
public static Boolean isDataAvailable = false;
public static Boolean Boo = false;
    
public String validatePassword(String Password){
try 
    {
        if (Password.equalsIgnoreCase(""))
        {
              JOptionPane.showMessageDialog(null, "Password field is mandatory");
         }
        else
        {
            Pflag = true;
            return Password;
        }
}
catch (Exception e)
{
    JOptionPane.showMessageDialog(null, e.getMessage());
    return null;
}
    return null;
}

public String validateMobileNO(String MobileNO, XSSFSheet sheet){
    isDataAvailable = false;
         if(MainGui.SaveEditedButtonClicked==true){
        return MobileNO;
        }
    else
     {
try 
    {
        patternMob = Pattern.compile(MOBILE_PATTERN);
        matcherMob = patternMob.matcher(MobileNO);
        File file = new File(excelFileName);
     
        if ((!file.exists())== true ||MobileNO == null){
        isDataAvailable = false;
        }
        else {
        isDataAvailable = isCellContentPresent(sheet, MobileNO);  
        }
        if (EditExistingButtonClicked==false)
        {
            if (!(MobileNO.equalsIgnoreCase("")) && matcherMob.matches() == true && isDataAvailable == false ) 
            {
                Mflag = true;
                return MobileNO;
            }
            else if (isDataAvailable == true)
            {
                JOptionPane.showMessageDialog(null, "Mobile Number already exists !", "Failure", JOptionPane.ERROR_MESSAGE);
                throw new Exception("Mobile Number already exists !");
            }
              else 
            {
                JOptionPane.showMessageDialog(null, "Please fill correct Mobile Number", "Failure", JOptionPane.ERROR_MESSAGE);
                throw new Exception("Please fill correct Mobile Number");
            }
        }
}
    catch(Exception e){
    JOptionPane.showMessageDialog(null,"Please try again  -  "+e.getMessage());
    System.out.println("Please try again !!");
    return null;
    }
        return null;
     }
        
    }
public String validateEmail(String Email,XSSFSheet sheet){
    isDataAvailable=false;
     if(MainGui.SaveEditedButtonClicked==true){
        return Email;
        }
    else
     {
    try{
       patternEmail = Pattern.compile(EMAIL_PATTERN);
       matcherEmail = patternEmail.matcher(Email);
       File file = new File(excelFileName);
          if ((!file.exists())==true || Email == null )
          {
            isDataAvailable = false;
          }
          
          else
          {
              isDataAvailable = isCellContentPresent(sheet, Email);
          }
        if (EditExistingButtonClicked==false)
        {
            if (matcherEmail.matches()==true && isDataAvailable == false)
            {  
                Eflag = true;
                return Email;
            }
            else if(isDataAvailable==true)
            {
                JOptionPane.showMessageDialog(null, "Email id Already Exists !", "Failure", JOptionPane.ERROR_MESSAGE);
                throw new Exception("Please fill correct Mail Id");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wrong Mail Id Please enter correct emailID", "Failure", JOptionPane.ERROR_MESSAGE);
                throw new Exception("Wrong Mail Id Please enter correct emailID");
            }
        }
    }
    
    catch(Exception e){
    JOptionPane.showMessageDialog(null,"Please try again  -  "+e.getMessage());
    System.out.println("Error - Please try again !!");
    return null;
    }
     return null;
   }     
    }
     public void writetoExcel(String Name,String EmailId,String Password, String MobileNo,XSSFSheet sheet,String MailPaswd) throws InvalidFormatException, IOException
 {
     try {
         //String excelFileName = "";//name of excel file
        
         int r = sheet.getLastRowNum();
         XSSFRow r1 = sheet.createRow(0);
         XSSFCell Srnocell = r1.createCell(0);
         Srnocell.setCellValue("Name");
         XSSFCell actioncell = r1.createCell(1);
         actioncell.setCellValue("EmailId");
         XSSFCell loccell = r1.createCell(2);
         loccell.setCellValue("Password");
         XSSFCell valuecell = r1.createCell(3);
         valuecell.setCellValue("Mobile Number");
         XSSFCell EmailPassword = r1.createCell(4);
         EmailPassword.setCellValue("Email Password");
         XSSFRow row = sheet.createRow(r + 1);

         //iterating c number of columns
         XSSFCell cell = row.createCell(0);
         cell.setCellValue(Name);         
         System.out.println(Name);
         
         XSSFCell cell1 = row.createCell(1);
         cell1.setCellValue(EmailId);         
         System.out.println(EmailId);
         
         XSSFCell cell2 = row.createCell(2);
         cell2.setCellValue(Password);         
         System.out.println(Password);
         
         XSSFCell cell3 = row.createCell(3);
         cell3.setCellValue(MobileNo);
         System.out.println(MobileNo);
         
         XSSFCell cell4 = row.createCell(4);
         cell4.setCellValue(MailPaswd);
         System.out.println(MailPaswd);
         
     } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Oops Something Went wrong Error - > "+ e.getMessage());
     } 
}
     public static String[] getData(int r,XSSFSheet sheet){
           String [] str = new String[6];
           XSSFRow row = sheet.getRow(r);
           int i = 0;
        for (Cell cell : row)
            {
               str[i] = cell.getRichStringCellValue().getString().trim();
               i++;
               if (i==6) break;
            }   
    return str;
     }
      public static void updateExcel(int r,XSSFSheet sheet,String Name,String EmailId,String Password, String MobileNo,String MailPassswd)
     {
            
            XSSFRow row = sheet.getRow(r);
            
          //iterating c number of columns
          XSSFCell cell = row.getCell(0);
          
            cell.setCellValue(Name); 
                System.out.println(Name);

          XSSFCell cell1 = row.getCell(1);
            cell1.setCellValue(EmailId); 
          System.out.println(EmailId);

          XSSFCell cell2 = row.getCell(2);
          cell2.setCellValue(Password); 
          System.out.println(Password);

          XSSFCell cell3 = row.getCell(3);
          cell3.setCellValue(MobileNo);
          System.out.println(MobileNo);
          
            XSSFCell cell4 = row.getCell(4);
          cell4.setCellValue(MailPassswd);
          System.out.println(MailPassswd);
     }
     public static int findRow(XSSFSheet sheet, String cellContent) {
         try {
             for (Row row : sheet) {
                 for (Cell cell : row) {
                     if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                         if (cell.getRichStringCellValue().getString().trim().equals(cellContent)) {
                             return row.getRowNum();                             
                         }
                     }
                     else 
                     {
                        JOptionPane.showMessageDialog(null, cellContent + " is not a valid Please try again !");
                     }
                 }
             }             
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, cellContent + " is not a valid Please try again !");
         }
              
    return 0;
}
     public Boolean isCellContentPresent (XSSFSheet sheet,String content)
     { Boo = false;
         try {
              String CellContent = null;
             // Get iterator to all the rows in current sheet
             Iterator<Row> rowIterator = sheet.iterator();
             // Traversing over each row of XLSX file
             while (rowIterator.hasNext()) {
                 if (Boo == true) break;
                 Row row = rowIterator.next();
                 // For each row, iterate through each columns
                 Iterator<Cell> cellIterator = row.cellIterator();
                 while (cellIterator.hasNext()) {
                         if (Boo == true) break;
                     Cell cell = cellIterator.next();
                     
                     switch (cell.getCellType()) {
                         case Cell.CELL_TYPE_STRING:
                             System.out.print(cell.getStringCellValue() + "\t");
                             CellContent = cell.getStringCellValue();
                             break;
                         case Cell.CELL_TYPE_NUMERIC:
                             System.out.print(cell.getNumericCellValue() + "\t");
                             CellContent = cell.getStringCellValue();
                             break;
                         case Cell.CELL_TYPE_BOOLEAN:
                             System.out.print(cell.getBooleanCellValue() + "\t");
                             CellContent = cell.getStringCellValue();
                             break;
                         default:
                         //CellContent = null;
                     }
                     if (CellContent.equalsIgnoreCase(content)) {
                         if (MainGui.EditExistingButtonClicked==true)
                         {
                             break;
                           
                         } 
                        Boo = true;
                        break;
                         //else {
//                         throw new Exception("Data Already exists");
//                            }
                     } else {
                         Boo = false;
                     }
                 }
                 System.out.println("");
                  if (MainGui.EditExistingButtonClicked==true && CellContent.equalsIgnoreCase(content))
                         {
                             break;
                         } 
             }
            
         } catch (Exception e) {
              JOptionPane.showMessageDialog(null, e.getMessage());
         }
         return Boo;
     }



}//class ends
