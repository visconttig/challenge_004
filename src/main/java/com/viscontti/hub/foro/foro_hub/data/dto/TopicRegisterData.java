package com.viscontti.hub.foro.foro_hub.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicRegisterData(
        @NotBlank String title,
        @NotBlank String message,
        @NotNull Integer authorId,
        @NotNull Integer courseId
) {
}
