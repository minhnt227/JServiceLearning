package MODEL;

import java.io.*;
import java.text.*;
import java.util.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class fileExcel {
    public fileExcel(){}
    
    
    
    public static ArrayList<SinhVien> inpSV(ArrayList<SinhVien> list, String filePath) throws FileNotFoundException, IOException{
        FileInputStream inputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            // Bỏ qua header row
            if (row.getRowNum() == 0) continue;

            SinhVien sinhVien = new SinhVien(
                row.getCell(0).getStringCellValue(), 
                row.getCell(1).getStringCellValue(), 
                row.getCell(2).getStringCellValue(), 
                row.getCell(3).getStringCellValue()
            );
            list.add(sinhVien);
        }

        inputStream.close();
        return list;
    }
    
    public static ArrayList<Khoa> inpKhoa(ArrayList<Khoa> list, String filePath) throws FileNotFoundException, IOException, ParseException{
        FileInputStream inputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            // Bỏ qua header row
            if (row.getRowNum() == 0) continue;
            Khoa khoa = new Khoa(
                row.getCell(0).getStringCellValue(),
                row.getCell(1).getStringCellValue(), 
                row.getCell(2).getStringCellValue(), 
                row.getCell(3).getStringCellValue(), 
                new SimpleDateFormat("dd/MM/yyyy").parse(row.getCell(4).getStringCellValue())
            );
            list.add(khoa);
        }

        inputStream.close();
        return list;
    }
    
    public static ArrayList<HOAT_DONG> inpHoatDong(ArrayList<HOAT_DONG> list, String filePath) throws FileNotFoundException, IOException, ParseException{
        FileInputStream inputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            // Bỏ qua header row
            if (row.getRowNum() == 0) continue;
            HOAT_DONG hd = new HOAT_DONG(
                Integer.parseInt(row.getCell(0).getStringCellValue()),
                row.getCell(1).getStringCellValue(), 
                row.getCell(2).getStringCellValue(), 
                new SimpleDateFormat("dd/MM/yyyy").parse(row.getCell(3).getStringCellValue()), 
                new SimpleDateFormat("dd/MM/yyyy").parse(row.getCell(4).getStringCellValue()),
                false,
                new SimpleDateFormat("dd/MM/yyyy").parse(row.getCell(5).getStringCellValue())    
            );
            list.add(hd);
        }

        inputStream.close();
        return list;
    }
    
    public static ArrayList<DoiTac> inpDoiTac(ArrayList<DoiTac> list, String filePath) throws FileNotFoundException, IOException{
        FileInputStream inputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            // Bỏ qua header row
            if (row.getRowNum() == 0) continue;

            DoiTac dt = new DoiTac(
                Integer.parseInt(row.getCell(0).getStringCellValue()), 
                row.getCell(1).getStringCellValue(), 
                row.getCell(2).getStringCellValue(), 
                row.getCell(3).getStringCellValue(),
                row.getCell(4).getStringCellValue(),
                row.getCell(5).getStringCellValue()
            );
            list.add(dt);
        }

        inputStream.close();
        return list;
    }
    
    public static ArrayList<GiangVien> inpGiangVien(ArrayList<GiangVien> list, String filePath) throws FileNotFoundException, IOException{
        FileInputStream inputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            // Bỏ qua header row
            if (row.getRowNum() == 0) continue;

            GiangVien gv = new GiangVien( 
                row.getCell(0).getStringCellValue(), 
                row.getCell(1).getStringCellValue(), 
                row.getCell(2).getStringCellValue(),
                row.getCell(4).getStringCellValue()
            );
            list.add(gv);
        }

        inputStream.close();
        return list;
    }
    
    public static ArrayList<TaiTro> inpTaiTro(ArrayList<TaiTro> list, String filePath) throws FileNotFoundException, IOException{
        FileInputStream inputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            // Bỏ qua header row
            if (row.getRowNum() == 0) continue;

            TaiTro dt = new TaiTro(
                Integer.parseInt(row.getCell(0).getStringCellValue()), 
                row.getCell(1).getStringCellValue(), 
                row.getCell(2).getStringCellValue(), 
                row.getCell(3).getStringCellValue(),
                row.getCell(4).getStringCellValue(),
                row.getCell(5).getStringCellValue()
            );
            list.add(dt);
        }

        inputStream.close();
        return list;
    }
    
    public static void printSV(ArrayList<SinhVien> list, String filePath) throws FileNotFoundException, IOException{
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("SinhVien");

        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("MSSV");
        headerRow.createCell(1).setCellValue("HỌ TÊN");
        headerRow.createCell(2).setCellValue("MÃ KHOA");
        headerRow.createCell(3).setCellValue("KHOA");
        int rowIndex = 1;
        for (SinhVien sinhVien : list) {
            XSSFRow dataRow = sheet.createRow(rowIndex++);
            dataRow.createCell(0).setCellValue(sinhVien.getId());
            dataRow.createCell(1).setCellValue(sinhVien.getName());
            dataRow.createCell(2).setCellValue(sinhVien.getIdKhoa());
            dataRow.createCell(3).setCellValue(sinhVien.getNameKhoa());
        }
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
    
    public static void printKhoa(ArrayList<Khoa> list, String filePath) throws FileNotFoundException, IOException{
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Khoa");

        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Mã Khoa");
        headerRow.createCell(1).setCellValue("Khoa");
        headerRow.createCell(2).setCellValue("Số Điện Thoại");
        headerRow.createCell(3).setCellValue("Email");
        headerRow.createCell(4).setCellValue("Ngày Thành Lập");

        int rowIndex = 1;
        for (Khoa khoa : list) {
            XSSFRow dataRow = sheet.createRow(rowIndex++);
            dataRow.createCell(0).setCellValue(khoa.getId());
            dataRow.createCell(1).setCellValue(khoa.getName());
            dataRow.createCell(2).setCellValue(khoa.getPhone());
            dataRow.createCell(3).setCellValue(khoa.getEmail());
            dataRow.createCell(4).setCellValue(khoa.getDate());
        }

        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
    
    public static void printHoatDong(ArrayList<HOAT_DONG> list, String filePath) throws FileNotFoundException, IOException{
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Hoạt Động");

        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Mã Hoạt Động");
        headerRow.createCell(1).setCellValue("Tên Hoạt Động");
        headerRow.createCell(2).setCellValue("Loại");
        headerRow.createCell(3).setCellValue("Ngày Bắt Đầu");
        headerRow.createCell(4).setCellValue("Ngày Kết Thúc");
        headerRow.createCell(5).setCellValue("Ngày Tạo Lập");
        

        int rowIndex = 1;
        for (HOAT_DONG hd : list) {
            XSSFRow dataRow = sheet.createRow(rowIndex++);
            dataRow.createCell(0).setCellValue(hd.getMaHD());
            dataRow.createCell(1).setCellValue(hd.getTenHD());
            dataRow.createCell(2).setCellValue(hd.getLoai());
            dataRow.createCell(3).setCellValue(hd.getNgayBD());
            dataRow.createCell(4).setCellValue(hd.getNgayKT());
            dataRow.createCell(5).setCellValue(hd.getCreatedDate());
        }

        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
    
    public static void printDoiTac(ArrayList<DoiTac> list, String filePath) throws FileNotFoundException, IOException{
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Đối Tác");

        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Mã");
        headerRow.createCell(1).setCellValue("Tên Đối Tác");
        headerRow.createCell(2).setCellValue("Tên Người Đại Diện");
        headerRow.createCell(3).setCellValue("Số Điện Thoại");
        headerRow.createCell(4).setCellValue("Email");
        headerRow.createCell(5).setCellValue("Nội dung");
        

        int rowIndex = 1;
        for (DoiTac hd : list) {
            XSSFRow dataRow = sheet.createRow(rowIndex++);
            dataRow.createCell(0).setCellValue(hd.getDtID());
            dataRow.createCell(1).setCellValue(hd.getName());
            dataRow.createCell(2).setCellValue(hd.getNameHost());
            dataRow.createCell(3).setCellValue(hd.getPhone());
            dataRow.createCell(4).setCellValue(hd.getEmail());
            dataRow.createCell(5).setCellValue(hd.getNoiDung());
        }

        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
    
    public static void printGiangVien(ArrayList<GiangVien> list, String filePath) throws FileNotFoundException, IOException{
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Giảng Viên");

        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Mã");
        headerRow.createCell(1).setCellValue("Họ");
        headerRow.createCell(2).setCellValue("Tên");
        headerRow.createCell(3).setCellValue("Mã Khoa");
        headerRow.createCell(4).setCellValue("Khoa");
        

        int rowIndex = 1;
        for (GiangVien hd : list) {
            XSSFRow dataRow = sheet.createRow(rowIndex++);
            dataRow.createCell(0).setCellValue(hd.getId());
            dataRow.createCell(1).setCellValue(hd.getFirtName());
            dataRow.createCell(2).setCellValue(hd.getLastName());
            dataRow.createCell(3).setCellValue(hd.getIdKhoa());
            dataRow.createCell(4).setCellValue(hd.getNameKhoa());
        }

        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
    
    public static void printTaiTro(ArrayList<TaiTro> list, String filePath) throws FileNotFoundException, IOException{
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Đối Tác");

        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Mã");
        headerRow.createCell(1).setCellValue("Tên Đối Tác");
        headerRow.createCell(2).setCellValue("Tên Người Đại Diện");
        headerRow.createCell(3).setCellValue("Số Điện Thoại");
        headerRow.createCell(4).setCellValue("Email");
        headerRow.createCell(5).setCellValue("Nội dung");
        

        int rowIndex = 1;
        for (TaiTro hd : list) {
            XSSFRow dataRow = sheet.createRow(rowIndex++);
            dataRow.createCell(0).setCellValue(hd.getId());
            dataRow.createCell(1).setCellValue(hd.getName());
            dataRow.createCell(2).setCellValue(hd.getNameHost());
            dataRow.createCell(3).setCellValue(hd.getPhone());
            dataRow.createCell(4).setCellValue(hd.getEmail());
            dataRow.createCell(5).setCellValue(hd.getNoiDung());
        }

        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
    
    
}
