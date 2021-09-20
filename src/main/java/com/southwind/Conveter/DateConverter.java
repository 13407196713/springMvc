package com.southwind.Conveter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {

    private String pattern;

    public DateConverter(String pattern){
        this.pattern = pattern;
    }
    @Override
    public Date convert(String source) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.pattern);
        Date date = null;
        try{
            date = simpleDateFormat.parse(source);//parse 解析
        }catch (ParseException e){
            e.printStackTrace();
        }
        return date;
    }
}
