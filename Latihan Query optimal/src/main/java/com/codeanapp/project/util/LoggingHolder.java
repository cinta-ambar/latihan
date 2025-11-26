package com.codeanapp.project.util;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoggingHolder {
    private String path;
    private String date;
    private String version;
}
