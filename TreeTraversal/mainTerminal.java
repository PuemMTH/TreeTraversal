package TreeTraversal;
import java.util.Scanner;

public class mainTerminal {
    private String args;
    private Scanner sc;
    int count = 0;

    public mainTerminal() {
        while(true) {
            BinaryTree tree = null;
            tree = new BinaryTree();
            sc = new Scanner(System.in);
            System.out.println("=========================>"+count+"<=========================");
            count++;
            System.out.print("Input Tree: ");
            args = sc.nextLine();
            if(args.equalsIgnoreCase("q")) {
                System.out.println("Bye!");
                break;
            }
            // T:a,TL:b,TLR:e,TLL:d,TLLR:h,TR:c,TRL:f,TRR:g
            tree.isOrder(tree, args);
            System.out.println("Postorder : " + tree.postorder(tree.root));
            System.out.println("Inorder   : " + tree.inorder(tree.root));
            System.out.println("Preorder  : " + tree.preorder(tree.root));
        }
    }
}