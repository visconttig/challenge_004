package com.viscontti.hub.foro.foro_hub.data.dto;

import jakarta.validation.constraints.NotNull;

public record UserData(
        @NotNull Long id,
        String name
) {
}
