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

            final ArrayList<Integer> pegandoNumArray = dividindoNumero(digitos, c);
            //DANDO UM CLEAR NA CAIXA DO CHEQUE
            int w = 0;
            while(w < digitos){
                robozin.keyPress(KeyEvent.VK_BACK_SPACE);
                robozin.keyRelease(KeyEvent.VK_BACK_SPACE);
                robozin.delay(100);
                w++;
            }
            int f = 0;
            while(f < digitos) {
                //DIGITANDO AS KEYS DO CHEQUE
                //debugar
                final int pegandoNum = transformandoNumeroEmKey(Integer.parseInt(c.getNumero());  
                robozin.keyPress(pegandoNum);
                robozin.keyRelease(pegandoNum);
                f++;
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
    //FUNÇÃO PRA RETORNAR OS KEYSCODES
    public static int transformandoNumeroEmKey(final int varMomento) {

        if (varMomento == 0) {
            return 96;
        } else if (varMomento == 1) {
            return 97;
        } else if (varMomento == 2) {
            return 98;
        } else if (varMomento == 3) {
            return 99;
        } else if (varMomento == 4) {
            return 100;
        } else if (varMomento == 5) {
            return 101;
        } else if (varMomento == 6) {
            return 102;
        } else if (varMomento == 7) {
            return 103;
        } else if (varMomento == 8) {
            return 104;
        } else if (varMomento == 9) {
            return 105;
        } else {
            return 1;
        }
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