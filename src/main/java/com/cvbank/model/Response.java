package com.cvbank.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
public class Response {

    private String timestamp;
    private String status;
    private String code;
    private String message;
    private String data;

    public void fillResponse(String statusR, String codeR,
                                 String messageR, String dataR)
    {
        timestamp = timeStamp();
        status = statusR;
        code = codeR;
        message = messageR;
        data = dataR;
    }

    private String timeStamp()
    {
        Date d1 = new Date();
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY HH:mm:ss");
        String formattedDate = df.format(d1);
        return formattedDate;
    }
}



