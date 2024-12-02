import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame implements ActionListener {
    //Atributos
    private JMenuBar barra;
    private JMenu menu1, menu2;
    private JMenuItem mi1;

    public Menu(){
        setLayout(null);
        barra = new JMenuBar();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
