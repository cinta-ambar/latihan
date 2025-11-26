package com.codeanapp.project.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataResponse<T> {
    String result;
    String detail ;
    String path ;
    String date ;
    int code ;
    String version ;
    T data;
}
