import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinForm extends JFrame {
    public WinForm() {
        initField();
    }
    private void initField() {
        setBounds(1000, 500, 1000, 300);
        setTitle("VK to Evernote");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel VKPanel = new JPanel();
        JButton getNotesButton = new JButton("Получить список заметок");
//        newGameButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                emptyField();
//            }
//        });

        VKPanel.setLayout(new BoxLayout(VKPanel, BoxLayout.Y_AXIS));
        VKPanel.add(getNotesButton);
        VKPanel.setSize(500, 150);

        JPanel EverPanel = new JPanel();
        JButton getENotebooksButton = new JButton("Получить список блокнотов");
        EverPanel.setLayout(new BoxLayout(EverPanel, BoxLayout.Y_AXIS));
        EverPanel.add(getENotebooksButton);
        EverPanel.setSize(500, 150);

//        EverPanel.setLayout(new GridLayout(dimension, dimension));
//        EverPanel.setSize(cellSize*dimension, cellSize * dimension);
//
//        gameField = new char[dimension][dimension];
//        gameButtons = new GameButton[dimension * dimension];
//
//        // Инициализация поля
//        for (int i=0;i<(dimension * dimension);i++) {
//            GameButton fieldButton = new GameButton(i, this);
//            gameFieldPanel.add(fieldButton);
//            gameButtons[i] = fieldButton;
//        }

        getContentPane().add(VKPanel, BorderLayout.WEST);
        getContentPane().add(EverPanel, BorderLayout.EAST);

        setVisible(true);
    }
}
