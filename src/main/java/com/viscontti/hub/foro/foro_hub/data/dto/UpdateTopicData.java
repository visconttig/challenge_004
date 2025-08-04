package com.viscontti.hub.foro.foro_hub.data.dto;

import jakarta.validation.constraints.NotNull;

public record UpdateTopicData(
        @NotNull Long id,
        String title,
        String message,
        UserData author,
        Long courseId
) {
}
