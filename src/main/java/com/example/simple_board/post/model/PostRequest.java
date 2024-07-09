package com.example.simple_board.post.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostRequest {

    private Long BoardId =1L;

    @NotBlank
    private String userName;

    @NotBlank
    @Size(min=4, max=4)
    private String password;

    @NotBlank
    @Email
    private String email;

    private String content;

    @NotBlank
    private String title;

}
