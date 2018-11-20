package com.maven.test1;

import java.io.FileOutputStream;

public class Test01 {

    public static void main(String[] args) {

        try
        {
            FileOutputStream fout = new FileOutputStream("D:/students.xls");
            RebateExport rebateExport = new RebateExport();
            String[][] values = new String[0][0];
//            由于合并了列，所以第二个合并的列需要输入多次才能实现出来
            String[] title1 = {"序号","账套名称","部门名称","客户编码","客户名称","客户结算方式","年月","销售政策","费用上帐","费用上帐","费用上帐","费用上帐","费用上帐"};
            String[] title2 = {"期初余额","本月已审核政策","已占用政策","已使用政策","可用政策","期初余额","本月已审核费用","已占用费用","已使用费用","可用费用"};
            rebateExport.actUseExport(values,fout,"返利单使用明细","返利单",title1,title2,16);
            fout.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
