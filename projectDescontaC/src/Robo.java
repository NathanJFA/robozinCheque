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
        final int _VALOR = 70;
        final String _DATA = "24/09/2020";
        final int _CONTA = 1;
        final int nx = Integer.parseInt(JOptionPane.showInputDialog("Quantos cheques quer descontar?"));
        final int digitos = Integer.parseInt(JOptionPane.showInputDialog("Desses cheques que irá inserir, tem quantos digitos no geral?"));
        
        //PEGANDO O NUMERO DO CHEQUE
        for(int k = 0; k < nx; k++){
            final String chequeUnitario = JOptionPane.showInputDialog("Qual o numero do Cheque?");
            final Cheque c  = new Cheque (chequeUnitario);
            listaCheque.add(c);
        }
        JOptionPane.showMessageDialog(null, "Mude sua tela");
        robozin.delay(4000);
        //FAZ A OPERAÇÃO COMPLETA DE UM DESCONTO DE CHEQUE
        for(final Cheque c : listaCheque){
           
            //CLICA NA CAIXA DO CHEQUE
            robozin.mouseMove(412, 147);
            robozin.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            robozin.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

           //final ArrayList<Integer> pegandoNumArray = dividindoNumero(digitos, c);
            //DANDO UM CLEAR NA CAIXA DO CHEQUE
            int w = 0;
            while(w < digitos){
                robozin.keyPress(KeyEvent.VK_BACK_SPACE);
                robozin.keyRelease(KeyEvent.VK_BACK_SPACE);
                robozin.delay(100);
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
                }else if(i == 8){
                    robozin.keyPress(KeyEvent.VK_9);
                    robozin.keyRelease(KeyEvent.VK_9);
                }
            }
            
            // CLICANDO NA CAIXA (DESCONTAR "SIM")
            robozin.mouseMove(219, 285);
            robozin.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            robozin.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

            // CLICANDO NA DATA 
            //290,345
            robozin.mouseMove(290, 345);
            robozin.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            robozin.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            robozin.keyPress(KeyEvent.VK_BACK_SPACE);
            robozin.delay(3000);
            robozin.keyRelease(KeyEvent.VK_BACK_SPACE);
            robozin.keyPress(KeyEvent.VK_DELETE);
            robozin.delay(3000);
            robozin.keyPress(KeyEvent.VK_DELETE);

            // LEMBRAR DE COPIAR A DATA
            robozin.keyPress(KeyEvent.VK_CONTROL);
            robozin.keyPress(KeyEvent.VK_V);
            robozin.keyRelease(KeyEvent.VK_CONTROL);
            robozin.keyRelease(KeyEvent.VK_V);

            
        }JOptionPane.showMessageDialog(null,"FIM..");
    }

    //FUNÇÃO PRA RECEBER O CHEQUE COMO STRING E SUBDIVIDIR EM UMA LISTA (COMO INT)
    public static ArrayList<Integer> dividindoNumero(final int digitos, final Cheque c) throws Exception {
        final ArrayList<Integer> lista_Separada = new ArrayList <> ();
        try{
            if(digitos == 6){
                final String varNumInteiro = c.getNumero();
                final Integer var1 = Integer.parseInt(varNumInteiro.substring(0));
                final Integer var2 = Integer.parseInt(varNumInteiro.substring(1));
                final Integer var3 = Integer.parseInt(varNumInteiro.substring(2));
                final Integer var4 = Integer.parseInt(varNumInteiro.substring(3));
                final Integer var5 = Integer.parseInt(varNumInteiro.substring(4));
                final Integer var6 = Integer.parseInt(varNumInteiro.substring(5));

                lista_Separada.clear();
                lista_Separada.add(var1, var2);
                lista_Separada.add(var3, var4);
                lista_Separada.add(var5, var6);

            }if(digitos == 4){
                final String varNumInteiro = c.getNumero();
                final Integer var1 = Integer.parseInt(varNumInteiro.substring(0));
                final Integer var2 = Integer.parseInt(varNumInteiro.substring(1));
                final Integer var3 = Integer.parseInt(varNumInteiro.substring(2));
                final Integer var4 = Integer.parseInt(varNumInteiro.substring(3));
                lista_Separada.clear();
                lista_Separada.add(var1, var2);
                lista_Separada.add(var3, var4);
            }
        }
        catch (final Exception e) {
                System.out.println("Erro na Subdivisão dos Números" + e);
        }
        return lista_Separada;
    }
}