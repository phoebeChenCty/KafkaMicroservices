package net.mymicroservices.basedomains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Webinfo {
    private String id;
    private String time;
    private String page;
    private String info;
}
