import java.awt.Robot;
import java.util.ArrayList;
//import java.util.List;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.awt.AWTException;

public class Robo {
    public static void main (final String[] args) throws Exception {

        final Robot robozin = new Robot();
        final ArrayList <Cheque> listaCheque = new ArrayList<>();

        
        //RECEBE A DATA E MIGRA NUM ARRAY
        String data = JOptionPane.showInputDialog("Digite a data a descontar.. ( com barras / )");
        if(data.length() < 9 ) { 
            JOptionPane.showMessageDialog(null, "Erro na data, o sistema fechará automaticamente!!");
            System.exit(1);
        String [] arrayData = new String[data.length()];
        for(int d = 0; d < data.length(); d++){
            Object object =  data.charAt(d);
            arrayData[d] = object.toString();
            
        }
        final int nx = Integer.parseInt(JOptionPane.showInputDialog("Quantos cheques quer descontar?"));
        final int digitos = Integer.parseInt(JOptionPane.showInputDialog("Desses cheques que irá inserir, tem quantos digitos no geral?"));
        //PEGANDO O NUMERO DO CHEQUE
        for(int k = 0; k < nx; k++){

            final String chequeUnitario = JOptionPane.showInputDialog("Qual o numero do " + ( k+1 ) + " Cheque?");
            if(chequeUnitario == null || chequeUnitario.equals(""))   { System.exit(1);  } 
            final Cheque c  = new Cheque (chequeUnitario);
            listaCheque.add(c);
        }
        JOptionPane.showMessageDialog(null, "Mude sua tela");
        robozin.delay(4000);
        //FAZ A OPERAÇÃO COMPLETA DE UM DESCONTO DE CHEQUE
        for(final Cheque c : listaCheque){
            robozin.delay(600);
           
            //CLICA NA CAIXA DO CHEQUE
            robozin.mouseMove(412, 147);
            robozin.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            robozin.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

            //DANDO UM CLEAR NA CAIXA DO CHEQUE
            int w = 0;
            while(w < digitos){
                robozin.keyPress(KeyEvent.VK_BACK_SPACE);
                robozin.keyRelease(KeyEvent.VK_BACK_SPACE);
                robozin.delay(400);
                w++;
            }
            //PEGA O CHEQUE E SEPARA NUMERO A NUMERO DENTRO DO ARRAY.
            int[] arrayN = new int[c.getNumero().length()];
            int k = 0;
            while(k < c.getNumero().length()){
                arrayN[k] = Character.getNumericValue(c.getNumero().charAt(k));
                k++;
            }
            //DIGITANDO AS KEYS DO CHEQUE
            for(int i : arrayN){
                //JOptionPane.showMessageDialog(null, i);
                if(i == 0){
                    robozin.keyPress(KeyEvent.VK_0);
                    robozin.keyRelease(KeyEvent.VK_0);
                }else if(i == 1){
                    robozin.keyPress(KeyEvent.VK_1);
                    robozin.keyRelease(KeyEvent.VK_1);
                }else if(i == 2){
                    robozin.keyPress(KeyEvent.VK_2);
                    robozin.keyRelease(KeyEvent.VK_2);
                }else if(i == 3){
                    robozin.keyPress(KeyEvent.VK_3);
                    robozin.keyRelease(KeyEvent.VK_3);
                }else if(i == 4){
                    robozin.keyPress(KeyEvent.VK_4);
                    robozin.keyRelease(KeyEvent.VK_4);
                }else if(i == 5){
                    robozin.keyPress(KeyEvent.VK_5);
                    robozin.keyRelease(KeyEvent.VK_5);
                }else if(i == 6){
                    robozin.keyPress(KeyEvent.VK_6);
                    robozin.keyRelease(KeyEvent.VK_6);
                }else if(i == 7){
                    robozin.keyPress(KeyEvent.VK_7);
                    robozin.keyRelease(KeyEvent.VK_7);
                }else if(i == 8){
                    robozin.keyPress(KeyEvent.VK_8);
                    robozin.keyRelease(KeyEvent.VK_8);
                }else if(i == 9){
                    robozin.keyPress(KeyEvent.VK_9);
                    robozin.keyRelease(KeyEvent.VK_9);
                }
                robozin.delay(500);
            }
            robozin.keyPress(KeyEvent.VK_ENTER);
            robozin.keyRelease(KeyEvent.VK_ENTER);
            robozin.delay(1000);
            //699, 421
            robozin.mouseMove(699, 421);
            robozin.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            robozin.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            

            

            
            // CLICANDO NA CAIXA (DESCONTAR "SIM")
            robozin.mouseMove(219, 285);
            robozin.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            robozin.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            robozin.delay(1000);
            robozin.keyPress(KeyEvent.VK_ENTER);
            robozin.keyRelease(KeyEvent.VK_ENTER);  
            robozin.delay(1000);
            //718,415
            robozin.mouseMove(718, 415);
            robozin.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            robozin.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            robozin.mouseMove(699, 421);
            robozin.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            robozin.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            // CLICANDO NA DATA 
            //290,345
            robozin.mouseMove(290, 345);
            robozin.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            robozin.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            robozin.delay(1000);

            int digitosData = 10;
            for(int i = 0; i < digitosData; i++){
                robozin.keyPress(KeyEvent.VK_BACK_SPACE);
                robozin.keyRelease(KeyEvent.VK_BACK_SPACE);
                robozin.delay(500);
            
            }for(int i = 0; i < digitosData; i++) {
                robozin.keyPress(KeyEvent.VK_DELETE);
                robozin.keyPress(KeyEvent.VK_DELETE);
                robozin.delay(500);
                
            }
               

            // LEMBRAR DE COPIAR A DATA
            robozin.delay(150);
            robozin.keyPress(KeyEvent.VK_CONTROL);
            robozin.keyPress(KeyEvent.VK_V);
            robozin.keyRelease(KeyEvent.VK_CONTROL);
            robozin.keyRelease(KeyEvent.VK_V);
            
            robozin.delay(1000);
            robozin.keyPress(KeyEvent.VK_F12);
            robozin.delay(400);
            robozin.keyRelease(KeyEvent.VK_F12);
            robozin.delay(700);

            robozin.keyPress(KeyEvent.VK_ENTER);
            robozin.delay(700);
            robozin.keyRelease(KeyEvent.VK_ENTER);



            
        }JOptionPane.showMessageDialog(null,"FIM..");
    }
}