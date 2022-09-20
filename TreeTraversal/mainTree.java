package TreeTraversal;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class mainTree implements ActionListener, MouseListener{
    JFrame f;
    Container cp;
    JTextArea ShowTree,InputTree;
    JLabel InOrder,PreOrder,PostOrder;
    JLabel ButtonEdit,ButtonUpdate, OnClick_BTEdits, OnClick_BTUpdates;
    JLabel BTEdits,BTUpdates;
    JButton BTEdits_Button,BTUpdates_Button;
    // ImageIcon bg = new ImageIcon(".//img//Background.png");
    ImageIcon bg = new ImageIcon(getClass().getClassLoader().getResource("img/Background.png"));
    ImageIcon BTEdit = new ImageIcon(getClass().getClassLoader().getResource("img/BTEdit.png"));
    ImageIcon OnClick_BTEdit = new ImageIcon(getClass().getClassLoader().getResource("img/OnClick_BTEdit.png"));
    ImageIcon OnEntered_BTEdit = new ImageIcon(getClass().getClassLoader().getResource("img/OnEntered_BTEdit.png"));
    ImageIcon BTUpdate = new ImageIcon(getClass().getClassLoader().getResource("img/BTUpdate.png"));
    ImageIcon OnClick_BTUpdate = new ImageIcon(getClass().getClassLoader().getResource("img/OnClick_BTUpdate.png"));
    ImageIcon OnEntered_BTUpdate = new ImageIcon(getClass().getClassLoader().getResource("img/OnEntered_BTUpdate.png"));

    int count = 0;
    BinaryTree tree = null;

    public mainTree() {
        f = new JFrame();
        cp = f.getContentPane();
        cp.setLayout(null);

        BTEdit.setImage(BTEdit.getImage().getScaledInstance(BTEdit.getIconWidth()-550, BTEdit.getIconHeight()-550, Image.SCALE_REPLICATE));
        OnClick_BTEdit.setImage(OnClick_BTEdit.getImage().getScaledInstance(OnClick_BTEdit.getIconWidth()-550, OnClick_BTEdit.getIconHeight()-550, Image.SCALE_REPLICATE));
        OnEntered_BTEdit.setImage(OnEntered_BTEdit.getImage().getScaledInstance(OnEntered_BTEdit.getIconWidth()-550, OnEntered_BTEdit.getIconHeight()-550, Image.SCALE_REPLICATE));

        BTUpdate.setImage(BTUpdate.getImage().getScaledInstance(BTUpdate.getIconWidth()-550, BTUpdate.getIconHeight()-550, Image.SCALE_REPLICATE));
        OnClick_BTUpdate.setImage(OnClick_BTUpdate.getImage().getScaledInstance(OnClick_BTUpdate.getIconWidth()-550, OnClick_BTUpdate.getIconHeight()-550, Image.SCALE_REPLICATE));
        OnEntered_BTUpdate.setImage(OnEntered_BTUpdate.getImage().getScaledInstance(OnEntered_BTUpdate.getIconWidth()-550, OnEntered_BTUpdate.getIconHeight()-550, Image.SCALE_REPLICATE));

        // Button
        BTEdits_Button = new JButton(BTEdit);
        BTEdits_Button.setBounds(140,490,BTEdit.getIconWidth(),BTEdit.getIconHeight());
        BTEdits_Button.setBorder(null);
        BTEdits_Button.addActionListener(this);
        BTEdits_Button.addMouseListener(this);
        cp.add(BTEdits_Button);

        BTUpdates_Button = new JButton(BTUpdate);
        BTUpdates_Button.setBounds(340,490,BTUpdate.getIconWidth(),BTUpdate.getIconHeight());
        BTUpdates_Button.setBorder(null);
        BTUpdates_Button.addActionListener(this);
        BTUpdates_Button.addMouseListener(this);
        cp.add(BTUpdates_Button);

        InOrder = new JLabel("NULL");
        PreOrder = new JLabel("NULL");
        PostOrder = new JLabel("NULL");
        InOrder.setFont(new Font("Arial", Font.ITALIC, 15));
        PreOrder.setFont(new Font("Arial", Font.ITALIC, 15));
        PostOrder.setFont(new Font("Arial", Font.ITALIC, 15));
        InOrder.setBounds(255, 142, 300, 50);
        PreOrder.setBounds(255, 186, 300, 50);
        PostOrder.setBounds(255, 232, 300, 50);
        cp.add(InOrder);
        cp.add(PreOrder);
        cp.add(PostOrder);

        // TextArea
        InputTree = new JTextArea();
        InputTree.setBounds(62, 335, 455, 120);
        InputTree.append("T:a,TL:b,TLR:e,TLL:d,TLLR:h,TR:c,TRL:f,TRR:g");
        InputTree.setEditable(true);
        // InputTree.setFont(font.deriveFont(Font.ITALIC, 30f));
        InputTree.setFont(new Font("Arial", Font.ITALIC, 15));
        InputTree.setForeground(Color.BLACK);
        cp.add(InputTree);

        // Background
        bg.setImage(bg.getImage().getScaledInstance(590, 590, Image.SCALE_REPLICATE));
        JLabel Background = new JLabel(bg);
        Background.setBounds(-5,-20,bg.getIconWidth(),bg.getIconHeight());
        cp.add(Background);

        f.setIconImage(new ImageIcon(getClass().getResource("/img/Logo.png")).getImage());
        cp.setBackground(Color.gray);
        // f.setUndecorated(true);
        f.setTitle("Mochi");
        f.setSize(600, 600);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
    }

    String post = "",pre = "",in = "";

    public void getOrder(String args){
        count++;
        // Ex. args = T:a,TL:b,TLR:e,TLL:d,TLLR:h,TR:c,TRL:f,TRR:g
        System.out.println("=========================>"+count+"<=========================");
        tree = new BinaryTree();
        System.out.println(args);
        tree.isOrder(tree, args);
        pre = tree.preorder(tree.root);
        post = tree.postorder(tree.root);
        in = tree.inorder(tree.root);
        System.out.println("PostOrder : "+post+"\n"+"PreOrder  : "+pre+"\n"+"InOrder   : "+in);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == BTEdits_Button){
            InputTree.setEditable(true);
        }
        if(e.getSource() == BTUpdates_Button){
            InputTree.setEditable(false);
            BTEdits_Button.setIcon(OnClick_BTEdit);
            getOrder(InputTree.getText());
            InOrder.setText(in);
            PreOrder.setText(pre);
            PostOrder.setText(post);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == BTEdits_Button){
            BTEdits_Button.setIcon(OnClick_BTEdit);

        }
        if(e.getSource() == BTUpdates_Button){
            BTUpdates_Button.setIcon(OnClick_BTUpdate);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == BTEdits_Button){
            BTEdits_Button.setIcon(OnEntered_BTEdit);
        }
        if(e.getSource() == BTUpdates_Button){
            BTUpdates_Button.setIcon(OnEntered_BTUpdate);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == BTEdits_Button){
            BTEdits_Button.setIcon(OnEntered_BTEdit);
        }
        if(e.getSource() == BTUpdates_Button){
            BTUpdates_Button.setIcon(OnEntered_BTUpdate);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == BTEdits_Button){
            BTEdits_Button.setIcon(BTEdit);
        }
        if(e.getSource() == BTUpdates_Button){
            BTUpdates_Button.setIcon(BTUpdate);
        }
    }
}
