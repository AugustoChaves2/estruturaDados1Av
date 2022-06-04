package Lista;

import javax.swing.*;
import java.awt.*;
import java.io.Console;

public class ListaVaziaException extends Throwable {

    static {

        JOptionPane.showMessageDialog(null,
                "Não foi posssivél remover o elemento desejado \n\n Lista sem elementos ", //mensagem
                "ListaVaziaException", // titulo da janela
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

}
