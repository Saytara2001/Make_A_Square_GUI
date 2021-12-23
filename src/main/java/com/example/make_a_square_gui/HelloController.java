package com.example.make_a_square_gui;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.*;

public class HelloController implements Initializable {
    PiecesModel piecesModel;

    //start definition
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Button button10;
    @FXML
    private Button button11;
    @FXML
    private Button button12;
    @FXML
    private Button button13;
    @FXML
    private Button button14;
    @FXML
    private Button button15;
    @FXML
    private Button button16;

    @FXML
    private TextField textI;
    @FXML
    private TextField textJ;
    @FXML
    private TextField textL;
    @FXML
    private TextField textO;
    @FXML
    private TextField textS;
    @FXML
    private TextField textT;
    @FXML
    private TextField textZ;

    Button[][] array2DButton;
    ArrayList<Button> buttonArrayList;

    Map<Character,Integer> hashMap = new HashMap<>();

    //end definition

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        piecesModel = new PiecesModel();
        initButtons();
        //solveProblem();
    }
//    char[] arr = new char[]{'L','I','T','O','Z','J','S'};
    void setHashMap()
    {
        hashMap.put('L',Integer.parseInt(textL.getText()));
        hashMap.put('Z',Integer.parseInt(textZ.getText()));
        hashMap.put('I',Integer.parseInt(textI.getText()));
        hashMap.put('J',Integer.parseInt(textJ.getText()));
        hashMap.put('T',Integer.parseInt(textT.getText()));
        hashMap.put('S',Integer.parseInt(textS.getText()));
        hashMap.put('O',Integer.parseInt(textO.getText()));
    }

    //initialize buttons and put them in 2D Grid
    void initButtons()
    {
        buttonArrayList = new ArrayList<>();
        buttonArrayList.add(button1);
        buttonArrayList.add(button2);
        buttonArrayList.add(button3);
        buttonArrayList.add(button4);
        buttonArrayList.add(button5);
        buttonArrayList.add(button6);
        buttonArrayList.add(button7);
        buttonArrayList.add(button8);
        buttonArrayList.add(button9);
        buttonArrayList.add(button10);
        buttonArrayList.add(button11);
        buttonArrayList.add(button12);
        buttonArrayList.add(button13);
        buttonArrayList.add(button14);
        buttonArrayList.add(button15);
        buttonArrayList.add(button16);
        array2DButton = new Button[4][4];
        for(int i=0;i<4;i++) for(int j=0;j<4;j++) array2DButton[i][j]=buttonArrayList.get(i*4+j);
    }

    int [][] finalBoard;
    public void solveProblem()
    {
        setHashMap();
        HashMap<Integer, int[][]> sendPieces = new HashMap<>();
        int id=0;
        for (Map.Entry<Character, Integer> set : hashMap.entrySet()) {
            int cnt=set.getValue();
            while (cnt > 0)
            {
                sendPieces.put(id++,piecesModel.retrievePiece(set.getKey()));
                cnt--;
            }
        }
        try {
            finalBoard=MakeASquare.Square(sendPieces);
            if(finalBoard==null)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message Here...");
                alert.setHeaderText("Make A Square");
                alert.setContentText("No Solution Founded");
                alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {
                        System.out.println("Pressed OK.");
                    }
                });
            }else
            {
                paintButton();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //painting
    void paintButton()
    {
        ArrayList<String> arrColor = new ArrayList<>();
        arrColor.add("-fx-background-color: green;");
        arrColor.add("-fx-background-color: red;");
        arrColor.add("-fx-background-color: aqua;");
        arrColor.add("-fx-background-color: yellow;");
        arrColor.add("-fx-background-color: purple;");
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                array2DButton[i][j].setStyle(arrColor.get(finalBoard[i][j]));
            }
        }
    }
}