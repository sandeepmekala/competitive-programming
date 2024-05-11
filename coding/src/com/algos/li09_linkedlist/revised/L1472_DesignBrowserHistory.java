package com.algos.li09_linkedlist.revised;

public class L1472_DesignBrowserHistory {
    public static void main(String[] args) {
        L1472_DesignBrowserHistory obj = new L1472_DesignBrowserHistory();
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        System.out.println(browserHistory.back(1));
    }
}

class BrowserHistory {

    ListNode curr;
    public BrowserHistory(String homepage) {
        curr = new ListNode(homepage);
    }
    
    public void visit(String url) {
        ListNode newNode = new ListNode(url);
        curr.next = newNode;
        newNode.prev = curr;
        curr = curr.next;
    }
    
    public String back(int steps) {
        while(steps > 0){
            if(curr.prev == null) break;
            curr = curr.prev;
            steps--;
        }

        return curr.url;
    }
    
    public String forward(int steps) {
        while(steps > 0){
            if(curr.next == null) break;
            curr = curr.next;
            steps--;
        }
        
        return curr.url;
    }
}

class ListNode{
    String url;
    ListNode next;
    ListNode prev;

    ListNode(String url){
        this.url = url;
    }
}