package com.example.simple_board.common;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Pagination {

    private Integer page;

    private Integer size;

    private Integer currentElement;

    private Integer totalPage;

    private Long totalElement;
}
