/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db;

/**
 *
 * @author forsell
 */
public class Param {
    private Type type;
    private Object value;

    public Param(Type type, Object value) {
        this.type = type;
        this.value = value;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Object value) {
        this.value = value;
    }
    
}
