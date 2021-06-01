package de.wilfert.testproject;

public class LinkedList {

    ListElement root = null;

    public void add(int data) {
        if (root == null) {
            root = new ListElement(data);
        } else {
            root.add(data);
        }
    }

    public boolean remove(int data) {
        if (root == null) {
            return false;
        } else if (root.data == data) {
            root = root.next;
            return true;
        } else {
            return root.remove(data);
        }
    }

    //return Integer.MIN_VALUE if no element found
    public int findBiggest() {
        return root != null ? root.findBiggest(0) : Integer.MIN_VALUE;
    }

    public int sum() {
        return root != null ? root.sum() : 0;
    }

    @Override
    public String toString() {
        return root != null ? root.toString() : "List empty!";
    }

    public class ListElement {
        int data;
        ListElement next;

        public ListElement(int data) {
            this.data = data;
            next = null;
        }

        public void add(int data) {
            if (next == null) {
                next = new ListElement(data);
            } else {
                next.add(data);
            }
        }

        public boolean remove(int data) {
            if (next != null && next.data == data) {
                this.next = this.next.next;
                return true;
            } else if (next == null) {
                return false;
            } else {
                return next.remove(data);
            }
        }

        public int findBiggest(int previousBiggest) {
            if (next != null) {
                return previousBiggest < data ? next.findBiggest(data) : next.findBiggest(previousBiggest);
            } else {
                return Math.max(previousBiggest, data);
            }
        }

        public int sum() {
            return (next != null) ? data : data;
        }

        @Override
        public String toString() {
            return next != null ? String.format("->[%d]%s", data, next) : String.format("->[%d]", data);
        }
    }

}
