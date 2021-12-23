package com.example.make_a_square_gui;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class MakeASquare {
    public static int[][] Square(HashMap<Integer, int[][]> sendPieces) throws InterruptedException {
        
        /*Scanner input = new Scanner(System.in);
        int numberOfPieces = input.nextInt();
        
        Map<Integer, int[][]> Pieces = new HashMap<>();
        for(int i = 0; i < numberOfPieces; i++){
            int rows = input.nextInt();
            int cols = input.nextInt();
            int [][]pieceGrid = new int[rows][cols];
            for(int x = 0; x < rows; x++){
                for(int y = 0; y < cols; y++){
                    pieceGrid[x][y] = input.nextInt();
                }
            }
            Pieces.put(i , pieceGrid);
        }
        */

        //pass pieces to the slaves area...
        Paralleling.allPieces = sendPieces;
        Paralleling.foundBoard = false;

        /*
        for(int i = 0; i < sendPieces.size(); i++){
            int rows = sendPieces.get(i).length;
            int cols = sendPieces.get(i)[0].length;
            int [][]pieceGrid = new int[rows][cols];
            for(int x = 0; x < rows; x++){
                for(int y = 0; y < cols; y++){
                    System.out.print(sendPieces.get(i)[x][y]+ " ");
                }
                System.out.println();
            }
        }*/
        
        //preparing the slaves.
        Paralleling masterSlave = new Paralleling();
        ArrayList<Thread> slaves = new ArrayList<Thread>();
        for(int i = 0; i < constants.numberOfThreads; i++){
            Thread tmp = new Thread(masterSlave , Integer.toString(i));
            slaves.add(tmp);
        }
        
        //go slaves....
        for(int i = 0; i < constants.numberOfThreads; i++){
            slaves.get(i).start();
        }
        //wait slaves to finish...
        for(int i = 0; i < constants.numberOfThreads; i++){
            slaves.get(i).join();
        }

        if(Paralleling.foundBoard) return Paralleling.finallyBoard;
        else return null;
        /*if(Paralleling.foundBoard){
            for(int i = 0; i < Paralleling.finallyBoard.length; i++){
                for(int j = 0; j < Paralleling.finallyBoard[0].length; j++){
                    System.out.print( (Paralleling.finallyBoard[i][j]+1) + " ");
                }
                System.out.println("");
            }
        } else {
            System.out.println("No Solution");
        }*/
        
    }
}