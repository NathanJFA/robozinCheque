import java.awt.Robot;
import java.util.ArrayList;
//import java.util.List;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.awt.AWTException;

public class Robo {
    public static void main (final String[] args) throws AWTException {
        final Robo classRobo = new Robo();
        final Robot robozin = new Robot();
        final ArrayList <Cheque> listaCheque = new ArrayList<>();
        final int _VALOR = 70;
        final String _DATA = "24/09/2020";
        final int _CONTA = 1;
        final int nx = Integer.parseInt(JOptionPane.showInputDialog("Quantos cheques quer descontar?"));
        final int digitos = Integer.parseInt(JOptionPane.showInputDialog("Desses cheques que irá inserir, tem quantos digitos no geral?"));
        
        for(int k = 0; k < nx; k++){
            final String chequeUnitario = JOptionPane.showInputDialog("Qual o numero do Cheque?");
            final Cheque c  = new Cheque (chequeUnitario);
            listaCheque.add(c);
        }


        for(final Cheque c : listaCheque){
            final ArrayList<Integer> pegandoNumArray = Robo.dividindoNumero(digitos, c);

            robozin.mouseMove(412, 147);
            robozin.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            // PEGANDO AS KEYS DO CHEQUE
            for (final int i : pegandoNumArray) {
                final int pegandoNum = transformandoNumeroEmKey(i);
                // CLICANDO NA CAIXA CHEQUE
                robozin.keyPress(KeyEvent.VK_BACK_SPACE);
                robozin.delay(4000);
                robozin.keyRelease(KeyEvent.VK_BACK_SPACE);
                robozin.keyPress(pegandoNum);
                robozin.keyRelease(pegandoNum);
            }
            // CLICANDO NA CAIXA (DESCONTAR "SIM")
            robozin.mouseMove(219, 285);
            robozin.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            robozin.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            // CLICANDO NA DATA 290,345
            robozin.mouseMove(290, 345);
            robozin.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            robozin.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            robozin.keyPress(KeyEvent.VK_BACK_SPACE);
            robozin.keyPress(KeyEvent.VK_DELETE);
            robozin.keyPress(KeyEvent.VK_DELETE);

            // LEMBRAR DE COPIAR A DATA
            robozin.keyPress(KeyEvent.VK_CONTROL);
            robozin.keyPress(KeyEvent.VK_V);
            robozin.keyRelease(KeyEvent.VK_CONTROL);
            robozin.keyRelease(KeyEvent.VK_V);
        }
        JOptionPane.showMessageDialog(null, "teste");
    }

    public static int transformandoNumeroEmKey(final int varMomento) {

        if (varMomento == 0) {
            return 48;
        } else if (varMomento == 1) {
            return 49;
        } else if (varMomento == 2) {
            return 50;
        } else if (varMomento == 3) {
            return 51;
        } else if (varMomento == 4) {
            return 52;
        } else if (varMomento == 5) {
            return 53;
        } else if (varMomento == 6) {
            return 54;
        } else if (varMomento == 7) {
            return 55;
        } else if (varMomento == 8) {
            return 56;
        } else if (varMomento == 9) {
            return 57;
        } else {
            return 1;
        }
    }

    public static ArrayList<Integer> dividindoNumero(final int digitos, final Cheque c) {
        final ArrayList<Integer> lista_Separada = new ArrayList <> ();
        if(digitos == 6){
            final String varNumInteiro = c.getNumero();
            final int var1 = Integer.parseInt(varNumInteiro.substring(0));
            final int var2 = Integer.parseInt(varNumInteiro.substring(1));
            final int var3 = Integer.parseInt(varNumInteiro.substring(2));
            final int var4 = Integer.parseInt(varNumInteiro.substring(3));
            final int var5 = Integer.parseInt(varNumInteiro.substring(4));
            final int var6 = Integer.parseInt(varNumInteiro.substring(5));

            lista_Separada.clear();
            lista_Separada.add(var1, var2);
            lista_Separada.add(var3, var4);
            lista_Separada.add(var5, var6);
            return lista_Separada;

        }else if(digitos == 4){
            final String varNumInteiro = c.getNumero();
            final int var1 = Integer.parseInt(varNumInteiro.substring(0));
            final int var2 = Integer.parseInt(varNumInteiro.substring(1));
            final int var3 = Integer.parseInt(varNumInteiro.substring(2));
            final int var4 = Integer.parseInt(varNumInteiro.substring(3));
            lista_Separada.clear();
            lista_Separada.add(var1, var2);
            lista_Separada.add(var3, var4);
            return lista_Separada;
        }else{
            return lista_Separada;
        }
    }
}