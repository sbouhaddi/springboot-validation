package dev.sabri.validation;

import lombok.Builder;
import lombok.With;

@With
@Builder
public record ApiError(String message) {
}
