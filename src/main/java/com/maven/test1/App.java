package com.maven.test1;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //模拟部分数据
        List<WorkSheetDetail> detail = new ArrayList<WorkSheetDetail>();

        WorkSheetDetail d1 =new WorkSheetDetail("23",23f,43,34,243f,54f,"34");
        WorkSheetDetail d2 =new WorkSheetDetail("23",23f,43,34,243f,54f,"34");
        WorkSheetDetail d3 =new WorkSheetDetail("23",23f,43,34,243f,54f,"34");
        WorkSheetDetail d4 =new WorkSheetDetail("23",23f,43,34,243f,54f,"34");
        WorkSheetDetail d5 =new WorkSheetDetail("23",23f,43,34,243f,54f,"34");
//        detail.add(d1);
//        detail.add(d2);
//        detail.add(d3);
//        detail.add(d4);
//        detail.add(d5);
        try
        {
            FileOutputStream fout = new FileOutputStream("D:/students.xls");
            new ExportExcel().getValue(detail, fout);
            fout.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

