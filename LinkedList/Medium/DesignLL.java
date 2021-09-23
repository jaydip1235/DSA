// https://leetcode.com/problems/design-linked-list/
import java.util.*;
public class DesignLL{

    class MyLinkedList {
    
        private class Node {
          int data = 0;
          Node prev = null;
          Node next = null;
    
          Node(int data) {
            this.data = data;
          }
    
        }
    
        private Node head = null;
        private Node tail = null;
        private int size = 0;
        
    
        /** Initialize your data structure here. */
        public MyLinkedList() {
            
        }
        
        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if(index<0 || index>=size || size==0){
                return -1;
            }
            Node temp = head;
            while(index>0){
                temp=temp.next;
                index--;
            }
            return temp.data;
        }
        
        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            Node nn = new Node(val);
            if(size==0){
                head=tail=nn;
            }
            else{
                nn.next=head;
                head.prev=nn;
                head=nn;
            }
            size++;
        }
        
        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            Node nn = new Node(val);
            if(size==0){
                head=tail=nn;
            }
            else{
                tail.next=nn;
                nn.prev=tail;
                tail=nn;
            }
            size++;
                
        }
        
        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        
        private void addAtFirst(int val, Node nn){
            if(size==0){
                head=tail=nn;
                size++;
                return;
            }
            nn.next = head;
            head.prev = nn;
            head = nn;
            size++;
        }
        
         private void addAtLast(int val, Node nn){
            if(size==0){
                head=tail=nn;
                size++;
                return;
            }
            nn.prev = tail;
            tail.next = nn;
            tail = nn;
            size++;
        }
        
        public void addAtIndex(int index, int val) {
            if(index<0 || index>size)return;
            Node nn = new Node(val);
            if(index==0){
                addAtFirst(val,nn);
                return;
            }
            if(index==size){
                addAtLast(val,nn);
                return;
            }
            Node temp = head;
            while(index>1){
                temp=temp.next;
                index--;
            }
            Node nn_next = temp.next;
            temp.next=nn;
            nn.prev=temp;
            nn.next= nn_next;   
            nn_next.prev=nn;   
            size++;
            
        }
        private void removeFirst(){
            if(size==0)return ;
            if(size==1){
                int value = head.data;
                head=tail=null;
                size--;
                return;
            }
            Node nn = head.next;
            head.next=null;
            nn.prev=null;
            head=nn;
            size--;
        }
        private void removeLast(){
            if(size==0)return ;
            if(size==1){
                int value = head.data;
                head=tail=null;
                size--;
                return ;
            }
            Node nn = tail.prev;
            tail.prev=null;
            nn.next=null;
            tail=nn;
            size--;
        }
        
        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if(index<0 || index>=size)return;
            if(index==0){
              removeFirst();
                return;
            }
            if(index==size-1){
               removeLast();
                return;
            }
            Node temp = head;
            while(index>1){
                temp=temp.next;
                index--;
            }
            Node after = temp.next.next;
            
            temp.next=after;
            after.prev=temp;
            size--;
        }
    }
    
    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */

}