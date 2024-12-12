package com.ust.traineapp.dto;

import java.time.LocalDateTime;

public record ErrorResponseDTO(LocalDateTime timestamp,int status,String error,String path,String requestURI) {
}
