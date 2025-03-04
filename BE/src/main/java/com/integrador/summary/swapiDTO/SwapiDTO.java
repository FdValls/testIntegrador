package com.integrador.summary.swapiDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SwapiDTO {

    private Long id;
    private String name;
    private String gender;
    private String birth_year;

}
