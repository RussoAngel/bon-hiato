/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scm;

/**
 *
 * @author yonay
 */
public class IdentificadorPlan {
    private int id;
    
    public IdentificadorPlan(int id){
        this.id=id;
    }
    public int getId(){
        id++;
        return id;
    }
}
