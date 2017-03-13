package cciLibrary;

import java.util.LinkedList;

public class Vertice {
    int data;
    LinkedList<Vertice> neighbours;

    public Vertice(int data, LinkedList<Vertice> neighbours) {
        this.data = data;
        this.neighbours = neighbours;
    }
}
