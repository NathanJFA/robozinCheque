import java.awt.Robot;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

import java.awt.AWTException;

public class Robo {
    public static void main (final String[] args) {
    
        ArrayList <Cheque> listaCheque = new ArrayList<>();
        int _VALOR = 70;
        String _DATA = "22/09/2020";
        int _CONTA = 1;
        int nx = Integer.parseInt(JOptionPane.showInputDialog("Quantos cheques quer descontar?"));
        int digitos = Integer.parseInt(JOptionPane.showInputDialog("Desses cheques que irá inserir, tem quantos digitos no geral?"));
        for(int k = 0; k < nx; k++){
            String chequeUnitario = JOptionPane.showInputDialog("Qual o numero do Cheque?");
            Cheque c  = new Cheque (chequeUnitario);
            listaCheque.add(c);
            try {
                final Robot robozin = new Robot();
                robozin.delay(5000);
                for(Cheque e: listaCheque){
                    robozin.mouseMove(60, 218);
                    robozin.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
                    /*robozin.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
                    robozin.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
                    robozin.mouseMove(5,59);
                    robozin.keyPress(KeyEvent.VK_CONTROL);
                    robozin.keyPress(KeyEvent.VK_C);
                    robozin.keyRelease(KeyEvent.VK_CONTROL);
                    robozin.keyRelease(KeyEvent.VK_C); */
                    //robozin.keyPress(KeyEvent.VK_SHIFT);
    
                    robozin.keyRelease(KeyEvent.VK_SHIFT);
                    robozin.keyPress(KeyEvent.VK_CONTROL);
                    robozin.keyPress(KeyEvent.VK_C);
                    robozin.keyRelease(KeyEvent.VK_CONTROL);
                    robozin.keyRelease(KeyEvent.VK_C);
                    for(int b = 0; b < digitos; b++){
                        robozin.keyPress(KeyEvent.VK_DOWN);
                        robozin.keyPress(KeyEvent.VK_DOWN);
                    }
    
    
                    robozin.mouseMove(726,60);
                    robozin.KeyPress(KeyEvent.VK_CONTROL);
                    robozin.keyPress(KeyEvent.VK_V);
                    robozin.keyRelease(KeyEvent.VK_CONTROL);
                    robozin.keyRelease(KeyEvent.VK_V);
    
    
    
                }
    
                    
    
    
            } catch (final AWTException e) {
                    e.printStackTrace();
            }
        } 
    }
}
