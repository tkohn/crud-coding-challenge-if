package de.torstenkohn.crud.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public final record User(
    @JsonProperty("forename") String forename,
    @JsonProperty("surname") String surname,
    @JsonProperty("email") String email
) {}
