import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Jf implements ActionListener {
    JFrame window;
    JButton btn,btn1;
    Jf() {
        window =new JFrame("Compressor Decompressor");
        window.setSize(500,400);
        window.setVisible(true);
        window.setLocation(200,100);
        window.setLayout(null);
        btn = new JButton("Compress the file");
        btn.addActionListener(this);
        btn.setSize(150,50);
        btn.setLocation(30,30);
        window.add(btn);
        btn1 =new JButton("Decompress the file");
        btn1.addActionListener(this);
        btn1.setSize(150,50);
        btn1.setLocation(210,30);
        window.add(btn1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn){
            window.getContentPane().setBackground(Color.green);
            JFileChooser fileChooser =new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response==JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Compressor.method(file);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,ex.toString());
                }
            }
        }
        if(e.getSource()==btn1){
            window.getContentPane().setBackground(Color.red);
            JFileChooser fileChooser2 =new JFileChooser();
            int response = fileChooser2.showSaveDialog(null);
            if (response==JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser2.getSelectedFile().getAbsolutePath());
                System.out.print (file);
                try{
                    Decompressor.method(file);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,ex.toString());
                }
        }
    }}
}

