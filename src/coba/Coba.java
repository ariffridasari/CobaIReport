/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coba;

import java.io.File;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author KHAIRUL MUNA
 */
public class Coba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        printreport("report1", 100);
    }

    public static void printreport(String file, int id) {
        DBConnection connection = new DBConnection();

        try {
            String source = "src/coba/" + file + ".jasper";
            File report = new File(source);
            JasperReport jr = (JasperReport) JRLoader.loadObject(report);
            HashMap parameter = new HashMap();
//            parameter.get(id);
            parameter.put("EMPLOYEE_ID", id);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameter, connection.getConnection());
            JasperViewer.viewReport(jp);
            //Jasper
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal");
        }
    }
    }
    

