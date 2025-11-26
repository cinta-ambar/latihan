package com.codeanapp.project.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DataTableResponse<T> {
    String result ;
    String detail ;
    String path  ;
    String date ;
    int code ;
    String version ;
    PageDataResponse<T> data;
}
