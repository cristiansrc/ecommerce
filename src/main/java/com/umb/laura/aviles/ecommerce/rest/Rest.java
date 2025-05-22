package com.umb.laura.aviles.ecommerce.rest;

import com.umb.laura.aviles.ecommerce.model.GeneralResponse;
import com.umb.laura.aviles.ecommerce.model.ResponseGeneric;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class Rest  {
    public <T> ResponseEntity<GeneralResponse<T>> generalResponse(T data, HttpStatus httpStatus, String msg) {
        GeneralResponse<T> response = new GeneralResponse<>();
        ResponseGeneric responseInfo = new ResponseGeneric();

        if(data != null) {
            response.setData(data);
        }

        responseInfo.setCode(httpStatus.value());
        responseInfo.setDetail(msg);

        response.setError(responseInfo);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
