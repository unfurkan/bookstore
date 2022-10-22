package com.getir.bookstore.common.response;

import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationMessageResponse {

    private String messageTypeCode;

    private String message;

}
