public class BinaryTree {
    TreeNode root;

    public void addNode(int value){
        TreeNode newNode= new TreeNode(value);

        if(root==null){
            root = newNode;
        }
        else {
            TreeNode currentNode =root;

            TreeNode parent;

            while (true){
                parent=currentNode;

                if(value<currentNode.value){
                    currentNode=currentNode.leftChild;
                    if(currentNode==null){

                        parent.leftChild=newNode;
                        return;

                    }

                }
                else{
                    currentNode=currentNode.rightChild;
                    if(currentNode==null){
                        parent.rightChild=newNode;
                        return;
                    }
                }

            }

        }

    }




}
