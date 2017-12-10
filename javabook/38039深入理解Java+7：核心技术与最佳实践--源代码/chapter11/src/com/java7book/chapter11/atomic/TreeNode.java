package com.java7book.chapter11.atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class TreeNode {
    private volatile TreeNode parent;
    private static final AtomicReferenceFieldUpdater<TreeNode, TreeNode> parentUpdater = AtomicReferenceFieldUpdater.newUpdater(TreeNode.class, TreeNode.class, "parent");
    public boolean compareAndSetParent(TreeNode expect, TreeNode update) {
        return parentUpdater.compareAndSet(this, expect, update);
    }
}
