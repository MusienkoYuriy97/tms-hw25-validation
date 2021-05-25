package com.teachmeskills.calc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long id;

    @NonNull
    @NotBlank
    private String username;

    @NonNull
    @NotBlank
    private String fname;

    @NonNull
    @NotBlank
    private String lname;

    @Min(12)
    @Max(130)
    private int age;

    @NonNull
    @NotBlank
    private String password;
}
