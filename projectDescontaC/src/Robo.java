import java.awt.Robot;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

import java.awt.AWTException;

public class Robo {
    public static void main (final String[] args) {
    
        final ArrayList <Cheque> listaCheque = new ArrayList<>();
        final int _VALOR = 70;
        final String _DATA = "22/09/2020";
        final int _CONTA = 1;
        final int nx = Integer.parseInt(JOptionPane.showInputDialog("Quantos cheques quer descontar?"));
        final int digitos = Integer.parseInt(JOptionPane.showInputDialog("Desses cheques que irá inserir, tem quantos digitos no geral?"));
        for(int k = 0; k < nx; k++){
            final String chequeUnitario = JOptionPane.showInputDialog("Qual o numero do Cheque?");
            final Cheque c  = new Cheque (chequeUnitario);
            listaCheque.add(c);
        }
        for(final Cheque c : listaCheque){
            exibirNumero(digitos, c);
        }

                final Robot robozin = new Robot();
                robozin.delay(5000);
                for(final Cheque e: listaCheque){
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
    
                    /*robozin.keyRelease(KeyEvent.VK_SHIFT);
                    robozin.keyPress(KeyEvent.VK_CONTROL);
                    robozin.keyPress(KeyEvent.VK_C);
                    robozin.keyRelease(KeyEvent.VK_CONTROL);
                    robozin.keyRelease(KeyEvent.VK_C);
                    for(int b = 0; b < digitos; b++){
                        robozin.keyPress(KeyEvent.VK_DOWN);
                        robozin.keyPress(KeyEvent.VK_DOWN);
                    }*/
    
    
                    /*robozin.mouseMove(726,60);
                    robozin.KeyPress(KeyEvent.VK_CONTROL);
                    robozin.keyPress(KeyEvent.VK_V);
                    robozin.keyRelease(KeyEvent.VK_CONTROL);
                    robozin.keyRelease(KeyEvent.VK_V);*/
    
    
    
                
    
                    
    
    
            } catch (final AWTException e) {
                    e.printStackTrace();
            }
        }

    }

    public static void exibirNumero(final int digitos, final Cheque c) {
        if(digitos == 6){
            final String varNumInteiro = c.getNumero();
            final String var1 = varNumInteiro.substring(0);
            final String var2 = varNumInteiro.substring(1);
            final String var3 = varNumInteiro.substring(2);
            final String var4 = varNumInteiro.substring(3);
            final String var5 = varNumInteiro.substring(4);
            final String var6 = varNumInteiro.substring(5);
        }else if(digitos == 4){
            final String varNumInteiro = c.getNumero();
            final String var1 = varNumInteiro.substring(0);
            final String var2 = varNumInteiro.substring(1);
            final String var3 = varNumInteiro.substring(2);
            final String var4 = varNumInteiro.substring(3);
        }
    public static String transformandoStringEmKey(String varMomento){   
        String keyNum0 = "VK_0";
        String keyNum1 = "VK_1";
        String keyNum2 = "VK_2";
        String keyNum3 = "VK_3";
        String keyNum4 = "VK_4";
        String keyNum5 = "VK_5";
        String keyNum6 = "VK_6";
        String keyNum7 = "VK_7";
        String keyNum8 = "VK_8";
        String keyNum9 = "VK_9";
        ArrayList <String> listaKeys = (keyNum0, keyNum1,keyNum2, keyNum3, keyNum4,keyNum5, keyNum6, keyNum7, keyNum8, keyNum9);
        for(String i: listaKeys){
            if(i.equalsIgnoreCase(varMomento){
                return i;
            }else{
                return "Deu pau no EXCEL";
            }

        }
        
        
        if(varMomento == keyNum0){
            //implementar
        }else if( varMomento == keyNum1){
            //implementar
        }else if( varMomento == keyNum2){
            //implementar
        }else if( varMomento == keyNum3){
            //implementar
        }else if( varMomento == keyNum4){
            //implementar
        }else if( varMomento == keyNum5){
            //implementar
        }





    }

    }
}
