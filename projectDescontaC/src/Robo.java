import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
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
            ArrayList<String> pegandoNum = exibirNumero(digitos, c);
            int tamanho = pegandoNum.size();
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

    }

    public static ArrayList<String> exibirNumero(final int digitos, final Cheque c) {
        final ArrayList<String> lista_Separada = new ArrayList <String> ();
        if(digitos == 6){
            final String varNumInteiro = c.getNumero();
            final String var1 = varNumInteiro.substring(0);
            final String var2 = varNumInteiro.substring(1);
            final String var3 = varNumInteiro.substring(2);
            final String var4 = varNumInteiro.substring(3);
            final String var5 = varNumInteiro.substring(4);
            final String var6 = varNumInteiro.substring(5);
            lista_Separada.clear();
            lista_Separada.add(var1, var2, var3, var4, var5, var6);
            return lista_Separada;
        }else if(digitos == 4){
            final String varNumInteiro = c.getNumero();
            final String var1 = varNumInteiro.substring(0);
            final String var2 = varNumInteiro.substring(1);
            final String var3 = varNumInteiro.substring(2);
            final String var4 = varNumInteiro.substring(3);
            lista_Separada.clear();
            lista_Separada.add(var1, var2, var3, var4);
            return lista_Separada;
        }
    public static String transformandoStringEmKey(final String varMomento) {

        final String keyNum0 = "VK_0";
        final String keyNum1 = "VK_1";
        final String keyNum2 = "VK_2";
        final String keyNum3 = "VK_3";
        final String keyNum4 = "VK_4";
        final String keyNum5 = "VK_5";
        final String keyNum6 = "VK_6";
        final String keyNum7 = "VK_7";
        final String keyNum8 = "VK_8";
        final String keyNum9 = "VK_9";

        if(varMomento == "0"){
            return keyNum0;
        }else if(varMomento == "1"){
            return keyNum1;
        }else if(varMomento == "2"){
            return keyNum2;
        }else if(varMomento == "3"){
            return keyNum3;
        }else if(varMomento == "4"){
            return keyNum4;
        }else if(varMomento == "5"){
            return keyNum5;
        }else if(varMomento == "6"){
            return keyNum6;
        }else if(varMomento == "7"){
            return keyNum7;
        }else if(varMomento == "8"){
            return keyNum8;
        }else if(varMomento == "9"){
            return keyNum9;
        }else{
            return "DeuERROMoral.txt";
        }


        /*ArrayList <String> listaKeys = (keyNum0, keyNum1,keyNum2, keyNum3, keyNum4,keyNum5, keyNum6, keyNum7, keyNum8, keyNum9);
        for(String i: listaKeys){
            if(i.equalsIgnoreCase(varMomento){
                return i;
            }else{
                return "Deu pau no EXCEL";
            }

        }*/
    }
}
