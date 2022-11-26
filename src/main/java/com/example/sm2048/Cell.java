package com.example.sm2048;


import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
*
*This class is used for creating, modifying text and colours of the numbers "boxes" in the game, 
*
*/
public class Cell {
    private Rectangle rectangle;
    private Group root;
    private Text textClass;
    private boolean modify = false;

    public void setModify(boolean modify) {
        this.modify = modify;
    }

    public boolean getModify() {
        return modify;
    }

    /**
    *
    * This method is used for
    *
    *@param x it is used to set the value of x in this method
    *@param y used to set the value of y 
    *@param scale set the size of the number "boxes"
    *@param root root of the scenes
    *
    */
    public Cell(double x, double y, double scale, Group root) {
        rectangle = new Rectangle();
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setHeight(scale);
        rectangle.setWidth(scale);
        this.root = root;
        rectangle.setFill(Color.rgb(224, 226, 226, 0.5));
        this.textClass = TextMaker.getSingleInstance().madeText("0", x, y, root);
        root.getChildren().add(rectangle);
    }

    public void setTextClass(Text textClass) {
        this.textClass = textClass;
    }

     /**
    *
    * This method is used for merging 2 number "boxes", and one of the merged "boxed" will be deleted
    *
    *@param cell
    *
    */
    public void changeCell(Cell cell) {
        TextMaker.changeTwoText(textClass, cell.getTextClass());
        root.getChildren().remove(cell.getTextClass());
        root.getChildren().remove(textClass);

        if (!cell.getTextClass().getText().equals("0")) {
            root.getChildren().add(cell.getTextClass());
        }
        if (!textClass.getText().equals("0")) {
            root.getChildren().add(textClass);
        }
        setColorByNumber(getNumber());
        cell.setColorByNumber(cell.getNumber());
    }
    
    /**
    *
    * This method is used for generating new number "boxes" in the game
    *
    *@param cell
    *
    */
    public void adder(Cell cell) {
        cell.getTextClass().setText((cell.getNumber() + this.getNumber()) + "");
        textClass.setText("0");
        root.getChildren().remove(textClass);
        cell.setColorByNumber(cell.getNumber());
        setColorByNumber(getNumber());
    }

    public void setColorByNumber(int number) {
        switch (number) {
            case 0:
                rectangle.setFill(Color.rgb(224, 226, 226, 0.5));
                break;
            case 2:
                rectangle.setFill(Color.rgb(100, 185, 255, 0.5));
                break;
            case 4:
                rectangle.setFill(Color.rgb(50, 168, 232, 0.5));
                break;
            case 8:
                rectangle.setFill(Color.rgb(44, 119, 232, 0.5));
                break;
            case 16:
                rectangle.setFill(Color.rgb(44, 88, 232, 0.5));
                break;
            case 32:
                rectangle.setFill(Color.rgb(44, 76, 180, 0.5));
                break;
            case 64:
                rectangle.setFill(Color.rgb(53, 44, 180, 0.5));
                break;
            case 128:
                rectangle.setFill(Color.rgb(44, 67, 180, 0.5));
                break;
            case 256:
                rectangle.setFill(Color.rgb(73, 44, 180, 0.5));
                break;
            case 512:
                rectangle.setFill(Color.rgb(58, 30, 180, 0.5));
                break;
            case 1024:
                rectangle.setFill(Color.rgb(71, 0, 150, 0.5));
                break;
            case 2048:
                rectangle.setFill(Color.rgb(92,0,250,0.5));


        }

    }

    public double getX() {
        return rectangle.getX();
    }

    public double getY() {
        return rectangle.getY();
    }

    public int getNumber() {
        return Integer.parseInt(textClass.getText());
    }

    private Text getTextClass() {
        return textClass;
    }

}
