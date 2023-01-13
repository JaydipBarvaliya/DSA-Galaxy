package com.datastructures.mustDoInterviewQuestions.tree;

import com.datastructures.tree.binaryTree.BinaryTreeUtil;

/**
 * Created by jaydip on 28/07/17.
 */
public class DiagonalOrderTraversal {

    public static void main(String[] args) {
        BinaryTreeUtil util = new BinaryTreeUtil();
        util = util.getVerticalOrderSampleData();
        util.diagonalOrderTraversal(util.root);
    }
}
