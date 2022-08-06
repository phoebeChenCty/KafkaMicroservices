package net.mymicroservices.basedomains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebinfoEvent {
    private String message;
    private String status;
    private Webinfo webinfo;
}
