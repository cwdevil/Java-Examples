package me.mushen.examples.java.simple.convert;

import java.util.Date;

/**
 * @Desc
 * @Author Remilia
 * @Create 2017-11-24
 */
@SuppressWarnings("unchecked")
public class DataConvert {
    
    public static Object convert(String beforeValue, Class afterValueType) {
        if(afterValueType.isAssignableFrom(Character.class) || afterValueType.isAssignableFrom(char.class)) { // char
            return beforeValue.charAt(0);
        }else if(afterValueType.isAssignableFrom(byte.class) || afterValueType.isAssignableFrom(Byte.class)) { // byte
            return Byte.parseByte(beforeValue);
        }else if(afterValueType.isAssignableFrom(short.class) || afterValueType.isAssignableFrom(Short.class)) { // short
            return Short.parseShort(beforeValue);
        }else if(afterValueType.isAssignableFrom(int.class) || afterValueType.isAssignableFrom(Integer.class)) { // int
            return Integer.parseInt(beforeValue);
        }else if(afterValueType.isAssignableFrom(long.class) || afterValueType.isAssignableFrom(Long.class)) { // long
            return Long.parseLong(beforeValue);
        }else if(afterValueType.isAssignableFrom(float.class) || afterValueType.isAssignableFrom(Float.class)) { // float
            return Float.parseFloat(beforeValue);
        }else if(afterValueType.isAssignableFrom(double.class) || afterValueType.isAssignableFrom(Double.class)) { // double
            return Double.parseDouble(beforeValue);
        }else if(afterValueType.isAssignableFrom(boolean.class) || afterValueType.isAssignableFrom(Boolean.class)) { // boolean
            return Boolean.parseBoolean(beforeValue);
        }else if(afterValueType.isAssignableFrom(String.class)) { // String
            return beforeValue;
        }else if(afterValueType.isAssignableFrom(Date.class)) { // Date
            return Dates.stringToDate(beforeValue);
        }else {
            return beforeValue;
        }
    }
}
