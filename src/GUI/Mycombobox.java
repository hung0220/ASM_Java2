/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author ADMIN
 */
public class Mycombobox {
        Object value;   //Chứa mã loại
    Object text;    //Chứa tên loại

    public Mycombobox(Object value, Object text) {
        this.value = value;
        this.text = text;
    }
    
    @Override
    public String toString(){
        return text.toString();
    }
    
    //Hàm lấy value kiểu int
    public int MaInt(){
        return Integer.parseInt(value.toString());
    }    
    //Hàm lấy value kiểu String
    public String MaString(){
        return value.toString();
    }
    
}
