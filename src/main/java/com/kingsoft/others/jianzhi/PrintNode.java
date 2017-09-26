package com.kingsoft.others.jianzhi;


import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * Created by BZD on 2017/8/22.
 */
public class PrintNode {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Stack<ListNode> stack = new Stack<ListNode>();
        if (listNode != null){
            if (listNode.nextNode != null){
                while (listNode.nextNode != null){
                    stack.push(listNode);
                    listNode = listNode.nextNode;
                }
                for (int i = 0;i < stack.size(); i++){
                    arrayList.add(stack.pop().value);
                }
            }else {
                arrayList.add(listNode.value);
            }

        }
        return arrayList;
    }

    /**
     * 形成链表
     */
    public ListNode addNode(ArrayList<Integer> arrayList){
        ListNode listNode = null;

        if (arrayList.size() > 1){
            listNode = new ListNode(arrayList.get(0));
            listNode.nextNode.value = arrayList.get(1);
            ListNode nextNode = new ListNode();
            nextNode = listNode.nextNode;
            if (arrayList.size() > 2){
                int i = 1;
                while ( i < arrayList.size() ){
                    nextNode.value =arrayList.get(i + 1);
                    nextNode = nextNode.nextNode;
                    i ++ ;
                }
            }
        }

        if (arrayList.size() == 1){
            listNode.value = arrayList.get(0);
        }

        return listNode;

    }


}

class ListNode{
    int value;
    ListNode nextNode;
    ListNode(int value){
        this.value = value;
        this.nextNode = null;
    }
    ListNode(){}





}