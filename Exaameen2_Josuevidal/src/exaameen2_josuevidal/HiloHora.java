package exaameen2_josuevidal;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author josue
 */
public class HiloHora extends Thread {

    private JLabel hora;

    public HiloHora(JLabel hora) {
        this.hora = hora;
    }

    @Override
    public void run() {
        while (true) {
            Date d = new Date();
            DateFormat df = new SimpleDateFormat("hh:mm:ss");
            hora.setText(df.format(d));
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }
    }
}
