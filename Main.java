import TreeTraversal.*;
public class Main {
    public static void main(String[] args) {
        new _mainUI(true);
    }
}

class _mainUI {
    public _mainUI(boolean isShow) {
        if(isShow == true){
            new mainTree();
        }else if(isShow == false){
            new mainTerminal();
        }
    }
}

// del *.class && cd TreeTraversal && del *.class && cd .. && javac Main.java && java Main