package com.maven.test1;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;
import java.io.IOException;

public class RebateExport {


    /**
     * @param values 要遍历的数据
     * @param fileOutputStream 要输出的文件
     * @param titleName 文件内首行字体
     * @param tagName 文件页底标签名称
     * @param title1 第一行的列标题
     * @param title2 第二行的列标题
     * @param totleColumn 总列数
     * @description 构建excel文件并且将文件上传到文件服务器，最后返回文件服务器的路径给前端供用户下载
     * @return
     */
    public String actUseExport(String [][]values, FileOutputStream fileOutputStream, String titleName, String tagName, String[] title1, String[] title2, int totleColumn) throws IOException {
        //1.创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //1.1创建合并单元格对象
//       excel文件首页名称
        CellRangeAddress titleRangeAddress = new CellRangeAddress(0,0,0,totleColumn);//起始行,结束行,起始列,结束列

//       表单头
//        序号
        CellRangeAddress tabelHeadRangeAddress1 = new CellRangeAddress(1,2,0,0);//起始行,结束行,起始列,结束列
//        账套名称
        CellRangeAddress tabelHeadRangeAddress2 = new CellRangeAddress(1,2,1,1);//起始行,结束行,起始列,结束列
//        部门名称
        CellRangeAddress tabelHeadRangeAddress3 = new CellRangeAddress(1,2,2,2);//起始行,结束行,起始列,结束列
//        客户编码
        CellRangeAddress tabelHeadRangeAddress4 = new CellRangeAddress(1,2,3,3);//起始行,结束行,起始列,结束列
//        客户名称
        CellRangeAddress tabelHeadRangeAddress5 = new CellRangeAddress(1,2,4,4);//起始行,结束行,起始列,结束列
//        客户结算方式
        CellRangeAddress tabelHeadRangeAddress6 = new CellRangeAddress(1,2,5,5);//起始行,结束行,起始列,结束列
//        年月
        CellRangeAddress tabelHeadRangeAddress7 = new CellRangeAddress(1,2,6,6);//起始行,结束行,起始列,结束列
//        销售政策
        CellRangeAddress tabelHeadRangeAddress8 = new CellRangeAddress(1,1,7,11);//起始行,结束行,起始列,结束列
//        费用上帐
        CellRangeAddress tabelHeadRangeAddress9 = new CellRangeAddress(1,1,12,totleColumn);//起始行,结束行,起始列,结束列


//        创建名称样式
        HSSFCellStyle titleStyle = createCellStyle(workbook,(short)13,true,true);
//        创建表头样式
        HSSFCellStyle tableStyle = createCellStyle(workbook,(short)10,true,true);
        //内容样式
        HSSFCellStyle cellStyle = createCellStyle(workbook,(short)10,false,true);

        //2.创建工作表
        HSSFSheet sheet = workbook.createSheet(tagName);

        //2.1加载合并单元格对象
        sheet.addMergedRegion(titleRangeAddress);
        sheet.addMergedRegion(tabelHeadRangeAddress1);
        sheet.addMergedRegion(tabelHeadRangeAddress2);
        sheet.addMergedRegion(tabelHeadRangeAddress3);
        sheet.addMergedRegion(tabelHeadRangeAddress4);
        sheet.addMergedRegion(tabelHeadRangeAddress5);
        sheet.addMergedRegion(tabelHeadRangeAddress6);
        sheet.addMergedRegion(tabelHeadRangeAddress7);
        sheet.addMergedRegion(tabelHeadRangeAddress8);
        sheet.addMergedRegion(tabelHeadRangeAddress9);

        //设置默认列宽
//        sheet.autoSizeColumn((short)0);
        sheet.setDefaultColumnWidth(15);

//      第一行
        HSSFRow titleRow = sheet.createRow(0);
        HSSFCell titleCell = titleRow.createCell(0);
        //加载单元格样式
        titleCell.setCellStyle(titleStyle);
        titleCell.setCellValue(titleName);

//      第二行列标题
        HSSFRow row2 = sheet.createRow(1);
        for(int i=0;i<title1.length;i++)
        {
            HSSFCell cell2 = row2.createCell(i);
            //加载单元格样式
            cell2.setCellStyle(tableStyle);
            cell2.setCellValue(title1[i]);
        }
//        第三行列标题
        HSSFRow row3 = sheet.createRow(2);
        for(int i=0;i<title2.length;i++)
        {
            HSSFCell cell2 = row3.createCell(i+7);
            //加载单元格样式
            cell2.setCellStyle(tableStyle);
            cell2.setCellValue(title2[i]);
        }
//        遍历二维数组取出内容
        for(int i = 0;i < values.length;i++){
            HSSFRow tempRow = sheet.createRow(i + 3);
            for(int j = 0; j < values[i].length;j++){
                HSSFCell tempCell = tempRow.createCell(j);
                tempCell.setCellValue(values[i][j]);
                tempCell.setCellStyle(cellStyle);
            }
        }

        //5.输出
        workbook.write(fileOutputStream);

        return null;

    }

    /**
     *
     * @param workbook
     * @param fontsize
     * @return 单元格样式
     */
    private static HSSFCellStyle createCellStyle(HSSFWorkbook workbook, short fontsize, boolean flag, boolean flag1) {
        // TODO Auto-generated method stub
        HSSFCellStyle style = workbook.createCellStyle();
        //是否水平居中
        if(flag1){
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
        }

        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
        //创建字体
        HSSFFont font = workbook.createFont();
        //是否加粗字体
        if(flag){
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        }
        font.setFontHeightInPoints(fontsize);
        //加载字体
        style.setFont(font);
        return style;
    }
}
