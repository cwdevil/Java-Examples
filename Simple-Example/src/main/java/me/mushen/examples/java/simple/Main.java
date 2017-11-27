package me.mushen.examples.java.simple;

import me.mushen.examples.java.simple.convert.DataConvert;

import java.util.Arrays;
import java.util.Date;

/**
 * @Desc
 * @Author Remilia
 * @Create 2017-11-24
 */
public class Main {

    public static void main(String[] args){
        Object[] resultObjs = new Object[10];
        // char
        resultObjs[0] = DataConvert.convert("A", Character.class);
        resultObjs[1] = DataConvert.convert("1", Byte.class);
        resultObjs[2] = DataConvert.convert("9", Short.class);
        resultObjs[3] = DataConvert.convert("500", Integer.class);
        resultObjs[4] = DataConvert.convert("1008766", Long.class);
        resultObjs[5] = DataConvert.convert("17.36", Float.class);
        resultObjs[6] = DataConvert.convert("28.22", Double.class);
        resultObjs[7] = DataConvert.convert("Remilia's Place", String.class);
        resultObjs[8] = DataConvert.convert("2017-11-24 18:00:00", Date.class);
        resultObjs[9] = DataConvert.convert("true", Boolean.class);


        System.out.println(Arrays.asList(resultObjs));
    }
}
