package com.tujuhsembilan.tokomadura.dto;

import java.io.Serial;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUtil79 implements Serializable {
    @Serial
    private static final long serialVersionUID = -984788644437988L;

    private String errorCode;

    private String message;

    private Object result;
}
