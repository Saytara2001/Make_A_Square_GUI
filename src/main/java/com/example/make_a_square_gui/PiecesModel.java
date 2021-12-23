package com.example.make_a_square_gui;
public class PiecesModel {

    private int id;
    private int [][] matrix;
    private int count;
    private String textField;
    private static int [][][] pieces;
    //static
    public PiecesModel()
    {
        pieces = new int[7][][];
        pieces[0] = new int[][]{{1, 0}, {1, 0}, {1, 1}};
        pieces[1] = new int[][]{{1, 1, 0}, {0, 1, 1}};
        pieces[2] = new int[][]{{1}, {1}, {1}, {1}};
        pieces[3] = new int[][]{{0, 1}, {0, 1}, {1, 1}};
        pieces[4] = new int[][]{{1, 1, 1}, {0, 1, 0}, {0, 1, 0}};
        pieces[5] = new int[][]{{0, 1, 1}, {0, 1, 0}, {1, 1, 0}};
        pieces[6] = new int[][]{{1, 1}, {1, 1}};
    }
    int [][] retrievePiece(Character character)
    {
        if(character=='L') return pieces[0].clone();
        else  if(character=='Z') return pieces[1].clone();
        else  if(character=='I') return pieces[2].clone();
        else  if(character=='J') return pieces[3].clone();
        else  if(character=='T') return pieces[4].clone();
        else  if(character=='S') return pieces[5].clone();
        else  if(character=='O') return pieces[6].clone();
        throw new IndexOutOfBoundsException();
    }
}
